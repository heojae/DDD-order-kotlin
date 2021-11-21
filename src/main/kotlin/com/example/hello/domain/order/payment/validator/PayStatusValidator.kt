package com.example.hello.domain.order.payment.validator

import com.example.hello.common.exception.InvalidParamException
import com.example.hello.domain.order.Order
import com.example.hello.domain.order.OrderCommand
import org.springframework.stereotype.Component

@org.springframework.core.annotation.Order(value = 3)
@Component
class PayStatusValidator : PaymentValidator {
    override fun validate(order: Order, paymentRequest: OrderCommand.PaymentRequest) {
        if (order.isAlreadyPaymentComplete()) throw InvalidParamException("이미 결제완료된 주문입니다");
    }
}
