package com.example.hello.infrastructure.order

import com.example.hello.common.exception.EntityNotFoundException
import com.example.hello.domain.order.Order
import com.example.hello.domain.order.OrderReader
import org.springframework.stereotype.Component

@Component
class OrderReaderImpl(
    private val orderRepository: OrderRepository
) : OrderReader {
    override fun getOrder(orderToken: String): Order {
        return this.orderRepository.findByOrderToken(orderToken) ?: throw EntityNotFoundException()
    }
}
