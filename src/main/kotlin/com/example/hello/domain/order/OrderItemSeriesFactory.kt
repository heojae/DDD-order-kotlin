package com.example.hello.domain.order

import com.example.hello.domain.order.item.OrderItem

interface OrderItemSeriesFactory {
    fun store(order: Order, requestOrder: OrderCommand.RegisterOrder): List<OrderItem>
}