package com.example.hello.application.order.gift

import com.example.hello.domain.order.OrderCommand
import com.example.hello.domain.order.gift.GiftOrderService
import org.springframework.stereotype.Service

@Service
class GiftFacade(
    private val giftOrderService: GiftOrderService
) {
    fun paymentOrder(request: OrderCommand.PaymentRequest) {
        this.giftOrderService.paymentOrder(request)
    }

}