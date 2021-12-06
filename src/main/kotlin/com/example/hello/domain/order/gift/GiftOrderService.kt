package com.example.hello.domain.order.gift

import com.example.hello.domain.order.OrderCommand

interface GiftOrderService {
    fun paymentOrder(paymentRequest: OrderCommand.PaymentRequest)
}
