package com.example.hello.infrastructure.order

import com.example.hello.domain.order.item.OrderItemOption
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemOptionRepository: JpaRepository<OrderItemOption, Long> {
}