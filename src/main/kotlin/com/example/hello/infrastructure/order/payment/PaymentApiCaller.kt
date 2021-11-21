package com.example.hello.infrastructure.order.payment

import com.example.hello.domain.order.OrderCommand
import com.example.hello.domain.order.payment.PayMethod

interface PaymentApiCaller {
    fun support(payMethod: PayMethod): Boolean;
    fun pay(request: OrderCommand.PaymentRequest);
}