package com.example.hello.domain.order

import com.example.hello.domain.order.item.OrderItem
import com.example.hello.domain.order.item.OrderItemOption
import com.example.hello.domain.order.item.OrderItemOptionGroup

interface OrderStore {
    fun store(order: Order): Order;
    fun store(orderItem: OrderItem): OrderItem;
    fun store(orderItemOption: OrderItemOption): OrderItemOption;
    fun store(orderItemOptionGroup: OrderItemOptionGroup): OrderItemOptionGroup;
}
