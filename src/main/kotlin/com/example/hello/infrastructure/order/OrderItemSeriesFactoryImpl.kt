package com.example.hello.infrastructure.order

import com.example.hello.domain.item.Item
import com.example.hello.domain.item.ItemReader
import com.example.hello.domain.order.Order
import com.example.hello.domain.order.OrderCommand
import com.example.hello.domain.order.OrderItemSeriesFactory
import com.example.hello.domain.order.OrderStore
import com.example.hello.domain.order.item.OrderItem
import org.springframework.stereotype.Component

@Component
class OrderItemSeriesFactoryImpl(
    private val itemReader: ItemReader,
    private val orderStore: OrderStore
) : OrderItemSeriesFactory {
    override fun store(order: Order, requestOrder: OrderCommand.RegisterOrder): List<OrderItem> {
        return requestOrder.orderItemList.map { orderItemRequest ->
            val item: Item = itemReader.getItemBy(orderItemRequest.itemToken)
            val initOrderItem: OrderItem = orderItemRequest.toEntity(order, item)
            val orderItem: OrderItem = orderStore.store(initOrderItem)

            orderItemRequest.orderItemOptionGroupList.forEach { orderItemOptionGroupRequest ->
                val initOrderItemOptionGroup = orderItemOptionGroupRequest.toEntity(orderItem)
                val orderItemOptionGroup = orderStore.store(initOrderItemOptionGroup)

                orderItemOptionGroupRequest.orderItemOptionList.forEach { orderItemOptionRequest ->
                    val initOrderItemOption = orderItemOptionRequest.toEntity(orderItemOptionGroup)
                    orderStore.store(initOrderItemOption)
                }
            }
            orderItem
        }

    }
}