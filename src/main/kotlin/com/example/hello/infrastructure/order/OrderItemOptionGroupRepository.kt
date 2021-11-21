package com.example.hello.infrastructure.order

import com.example.hello.domain.order.item.OrderItemOptionGroup
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemOptionGroupRepository : JpaRepository<OrderItemOptionGroup, Long> {
}