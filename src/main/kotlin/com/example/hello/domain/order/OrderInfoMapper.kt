package com.example.hello.domain.order

import com.example.hello.domain.order.item.OrderItem
import com.example.hello.domain.order.item.OrderItemOption
import com.example.hello.domain.order.item.OrderItemOptionGroup
import org.mapstruct.*


@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
interface OrderInfoMapper {

    @Mappings(
        Mapping(source = "order.id", target = "orderId"),
        Mapping(source = "order.deliveryFragment", target = "deliveryInfo"),
        Mapping(target = "orderedAt", expression = "java(order.orderedAt)"),  // TODO heojae 이 부분, 왜 이러는 건지 확인.
        Mapping(expression = "java(order.calculateTotalAmount())", target = "totalAmount"),
        Mapping(expression = "java(order.getStatus().name())", target = "status"),
        Mapping(expression = "java(order.getStatus().getDescription())", target = "statusDescription")
    )
    fun of(order: Order, orderItemList: List<OrderItem>): OrderInfo.Main

    @Mappings(
        Mapping(expression = "java(orderItem.getDeliveryStatus().name())", target = "deliveryStatus"),
        Mapping(
            expression = "java(orderItem.getDeliveryStatus().getDescription())",
            target = "deliveryStatusDescription"
        ),
        Mapping(expression = "java(orderItem.calculateTotalAmount())", target = "totalAmount")
    )
    fun of(orderItem: OrderItem): OrderInfo.OrderItem
    fun of(orderItemOptionGroup: OrderItemOptionGroup): OrderInfo.OrderItemOptionGroup
    fun of(orderItemOption: OrderItemOption): OrderInfo.OrderItemOption
}