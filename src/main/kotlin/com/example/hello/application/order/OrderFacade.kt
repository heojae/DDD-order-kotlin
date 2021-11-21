package com.example.hello.application.order

import com.example.hello.domain.notification.NotificationService
import com.example.hello.domain.order.OrderCommand
import com.example.hello.domain.order.OrderInfo
import com.example.hello.domain.order.OrderService
import org.springframework.stereotype.Service

@Service
class OrderFacade(
    private val orderService: OrderService,
    private val notificationService: NotificationService
) {
    fun registerOrder(registerOrder: OrderCommand.RegisterOrder): String {
        val orderToken = orderService.registerOrder(registerOrder)
        notificationService.sendKakao("ORDER_COMPLETE", "content");
        return orderToken
    }

    fun retrieveOrder(orderToken: String): OrderInfo.Main {
        return orderService.retrieveOrder(orderToken)
    }

    fun paymentOrder(paymentRequest: OrderCommand.PaymentRequest) {
        orderService.paymentOrder(paymentRequest)
        notificationService.sendKakao("", "")
    }

}