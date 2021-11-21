package com.example.hello.infrastructure.order.payment

import com.example.hello.domain.order.OrderCommand
import com.example.hello.domain.order.payment.PayMethod
import org.springframework.stereotype.Component

@Component
class NaverPayApiCaller : PaymentApiCaller {
    override fun support(payMethod: PayMethod): Boolean {
        return PayMethod.NAVER_PAY == payMethod
    }

    override fun pay(request: OrderCommand.PaymentRequest) {
        println("naver pay")
    }
}