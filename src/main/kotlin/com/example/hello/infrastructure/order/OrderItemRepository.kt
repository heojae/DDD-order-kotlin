package com.example.hello.infrastructure.order

import com.example.hello.domain.order.item.OrderItem
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository: JpaRepository<OrderItem, Long> {
}