package com.example.hello.domain.order.gift

interface GiftMessageChannelSender {
    fun paymentComplete(message: GiftPaymentCompleteMessage)
}
