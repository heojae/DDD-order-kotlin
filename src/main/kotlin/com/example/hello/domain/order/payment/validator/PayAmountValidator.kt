package com.example.hello.domain.order.payment.validator

import com.example.hello.common.exception.InvalidParamException
import com.example.hello.domain.order.Order
import com.example.hello.domain.order.OrderCommand
import org.springframework.stereotype.Component
import java.security.InvalidParameterException

@org.springframework.core.annotation.Order(value = 1)
@Component
class PayAmountValidator : PaymentValidator {
    override fun validate(order: Order, paymentRequest: OrderCommand.PaymentRequest) {
        if (order.calculateTotalAmount() != paymentRequest.amount) {
            throw InvalidParamException("주문가격이 불일치합니다");
        }
    }
}
