package com.example.hello.infrastructure.order

import com.example.hello.domain.order.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long> {
    fun findByOrderToken(orderToken: String): Order?
}
