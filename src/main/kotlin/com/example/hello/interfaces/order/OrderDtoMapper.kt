package com.example.hello.interfaces.order

import com.example.hello.domain.order.OrderCommand
import com.example.hello.domain.order.OrderCommand.RegisterOrder
import com.example.hello.domain.order.OrderCommand.RegisterOrderItemOption
import com.example.hello.domain.order.OrderInfo
import com.example.hello.interfaces.order.OrderDto.RegisterOrderRequest
import org.mapstruct.*


@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
interface OrderDtoMapper {

    @Mappings(Mapping(source = "orderedAt", target = "orderedAt", dateFormat = "yyyy-MM-dd HH:mm:ss"))
    fun of(mainResult: OrderInfo.Main): OrderDto.Main

    fun of(deliveryResult: OrderInfo.DeliveryInfo): OrderDto.DeliveryInfo

    fun of(orderItemResult: OrderInfo.OrderItem): OrderDto.OrderItem

    fun of(request: RegisterOrderRequest): RegisterOrder

    fun of(request: OrderDto.RegisterOrderItem): OrderCommand.RegisterOrderItem

    fun of(request: OrderDto.RegisterOrderItemOptionGroupRequest): OrderCommand.RegisterOrderItemOptionGroup

    fun of(request: OrderDto.RegisterOrderItemOptionRequest): RegisterOrderItemOption

    @Mapping(target = "copy", ignore = true)
    fun of(orderToken: String): OrderDto.RegisterResponse

    fun of(request: OrderDto.PaymentRequest): OrderCommand.PaymentRequest
}