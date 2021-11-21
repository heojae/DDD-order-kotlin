package com.example.hello.domain.order.payment.validator

import com.example.hello.domain.order.Order
import com.example.hello.domain.order.OrderCommand

interface PaymentValidator {
    fun validate(order: Order, paymentRequest: OrderCommand.PaymentRequest)
}