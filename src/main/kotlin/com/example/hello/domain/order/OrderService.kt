package com.example.hello.domain.order

interface OrderService {
    fun registerOrder(registerOrder: OrderCommand.RegisterOrder): String;
    fun paymentOrder(paymentRequest: OrderCommand.PaymentRequest);
    fun retrieveOrder(orderToken: String): OrderInfo.Main;
}