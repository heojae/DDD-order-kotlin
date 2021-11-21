package com.example.hello.domain.order

import com.example.hello.domain.order.payment.PaymentProcessor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderServiceImpl(
    private val orderStore: OrderStore,
    private val orderReader: OrderReader,
    private val orderItemSeriesFactory: OrderItemSeriesFactory,
    private val paymentProcessor: PaymentProcessor,
    private val orderInfoMapper: OrderInfoMapper
) : OrderService {

    @Transactional
    override fun registerOrder(registerOrder: OrderCommand.RegisterOrder): String {
        println("bbbb - 1 - a")
        println(registerOrder)
        val order = orderStore.store(registerOrder.toEntity())
        println("bbbb - 1 - b")
        orderItemSeriesFactory.store(order = order, requestOrder = registerOrder)
        println("bbbb - 1 - c")
        return order.orderToken
    }

    @Transactional
    override fun paymentOrder(paymentRequest: OrderCommand.PaymentRequest) {
        val orderToken = paymentRequest.orderToken
        val order = orderReader.getOrder(orderToken)
        paymentProcessor.pay(order, paymentRequest);
        order.orderComplete()
    }

    @Transactional(readOnly = true)
    override fun retrieveOrder(orderToken: String): OrderInfo.Main {
        val order = orderReader.getOrder(orderToken)
        val orderItemList = order.orderItemList;
        return orderInfoMapper.of(order, orderItemList)
    }
}