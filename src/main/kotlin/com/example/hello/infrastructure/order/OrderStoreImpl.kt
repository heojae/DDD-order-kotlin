package com.example.hello.infrastructure.order

import com.example.hello.domain.order.Order
import com.example.hello.domain.order.OrderStore
import com.example.hello.domain.order.item.OrderItem
import com.example.hello.domain.order.item.OrderItemOption
import com.example.hello.domain.order.item.OrderItemOptionGroup
import org.springframework.stereotype.Component

@Component
class OrderStoreImpl(
    private val orderRepository: OrderRepository,
    private val orderItemRepository: OrderItemRepository,
    private val orderItemOptionGroupRepository: OrderItemOptionGroupRepository,
    private val orderItemOptionRepository: OrderItemOptionRepository
): OrderStore {
    override fun store(order: Order): Order {
        return this.orderRepository.save(order)
    }

    override fun store(orderItem: OrderItem): OrderItem {
        return this.orderItemRepository.save(orderItem)
    }

    override fun store(orderItemOption: OrderItemOption): OrderItemOption {
        return this.orderItemOptionRepository.save(orderItemOption)
    }

    override fun store(orderItemOptionGroup: OrderItemOptionGroup): OrderItemOptionGroup {
        return this.orderItemOptionGroupRepository.save(orderItemOptionGroup)
    }
}