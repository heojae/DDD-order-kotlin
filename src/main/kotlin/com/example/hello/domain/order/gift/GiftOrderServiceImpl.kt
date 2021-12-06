package com.example.hello.domain.order.gift

import com.example.hello.domain.order.Order
import com.example.hello.domain.order.OrderCommand
import com.example.hello.domain.order.OrderReader
import com.example.hello.domain.order.payment.PaymentProcessor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class GiftOrderServiceImpl(
    private val orderReader: OrderReader,
    private val paymentProcessor: PaymentProcessor,
    private val giftMessageChannelSender: GiftMessageChannelSender
) : GiftOrderService {

    @Transactional
    override fun paymentOrder(paymentRequest: OrderCommand.PaymentRequest) {
        println("GiftOrderService.paymentOrder request = $paymentRequest")

        val order = orderReader.getOrder(paymentRequest.orderToken)
        val temp_value: Long = order.calculateTotalAmount()
        println("order.calculateTotalAmount() : $temp_value")

        // 아래 로직을 추가하면, paymentProcessor.pay 실행 이후의 보상 트랜잭션 발생을 막을 수 있다.
        if (order.status != Order.Status.INIT) throw IllegalStateException()

        paymentProcessor.pay(order, paymentRequest)
        order.orderComplete()

        giftMessageChannelSender.paymentComplete(
            message = GiftPaymentCompleteMessage(orderToken = order.orderToken)
        )
    }
}