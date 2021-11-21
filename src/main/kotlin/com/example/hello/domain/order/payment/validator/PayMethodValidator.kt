package com.example.hello.domain.order.payment.validator

import com.example.hello.common.exception.InvalidParamException
import com.example.hello.domain.order.Order
import com.example.hello.domain.order.OrderCommand
import org.springframework.stereotype.Component

@org.springframework.core.annotation.Order(value = 2)
@Component
class PayMethodValidator : PaymentValidator {
    override fun validate(order: Order, paymentRequest: OrderCommand.PaymentRequest) {
        if (order.payMethod != paymentRequest.payMethod.name) {
            throw InvalidParamException("주문 과정에서의 결제수단이 다릅니다.");
        }
    }
}
