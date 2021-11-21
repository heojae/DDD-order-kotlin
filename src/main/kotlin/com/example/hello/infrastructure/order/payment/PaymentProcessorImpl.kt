package com.example.hello.infrastructure.order.payment

import com.example.hello.common.exception.EntityNotFoundException
import com.example.hello.domain.order.Order
import com.example.hello.domain.order.OrderCommand
import com.example.hello.domain.order.payment.PaymentProcessor
import com.example.hello.domain.order.payment.validator.PaymentValidator
import org.springframework.stereotype.Component

@Component
class PaymentProcessorImpl(
    private val paymentValidatorList: List<PaymentValidator>,
    private val paymentApiCallerList: List<PaymentApiCaller>
) : PaymentProcessor {
    override fun pay(order: Order, paymentRequest: OrderCommand.PaymentRequest) {
        this.paymentValidatorList.forEach { it.validate(order = order, paymentRequest = paymentRequest) }
        val paymentApiCaller = routingApiCaller(paymentRequest)
        paymentApiCaller.pay(paymentRequest)
    }

    private fun routingApiCaller(request: OrderCommand.PaymentRequest): PaymentApiCaller {
        return paymentApiCallerList.firstOrNull { it -> it.support(request.payMethod) }
            ?: throw EntityNotFoundException()
    }
}