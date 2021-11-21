package com.example.hello.domain.order.payment

import com.example.hello.domain.order.Order
import com.example.hello.domain.order.OrderCommand

interface PaymentProcessor {
    fun pay(order: Order, paymentRequest: OrderCommand.PaymentRequest)
}