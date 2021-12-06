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
        val order = orderStore.store(registerOrder.toEntity())
        orderItemSeriesFactory.store(order = order, requestOrder = registerOrder)
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

    @Transactional
    override fun updateReceiverInfo(orderToken: String, request: OrderCommand.UpdateReceiverInfoRequest) {
        val order = orderReader.getOrder(orderToken);
        order.updateDeliveryFragment(
            receiverName = request.receiverName,
            receiverPhone = request.receiverPhone,
            receiverZipcode = request.receiverZipcode,
            receiverAddress1 = request.receiverAddress1,
            receiverAddress2 = request.receiverAddress2,
            etcMessage = request.etcMessage
        )
        order.deliveryPrepare()
        this.orderStore.store(order)
    }
}