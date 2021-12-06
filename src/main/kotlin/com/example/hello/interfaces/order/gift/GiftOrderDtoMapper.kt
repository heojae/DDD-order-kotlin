package com.example.hello.interfaces.order.gift

import com.example.hello.domain.order.OrderCommand.*
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy


@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
interface GiftOrderDtoMapper {
    @Mapping(source = "buyerUserId", target = "userId")
    fun of(request: GiftOrderDto.RegisterOrderRequest): RegisterOrder
    fun of(request: GiftOrderDto.RegisterOrderItem): RegisterOrderItem
    fun of(request: GiftOrderDto.RegisterOrderItemOptionGroupRequest): RegisterOrderItemOptionGroup
    fun of(request: GiftOrderDto.RegisterOrderItemOptionRequest): RegisterOrderItemOption
    @Mapping(target = "copy", ignore = true)
    fun of(orderToken: String): GiftOrderDto.RegisterResponse
    fun of(request: GiftOrderDto.PaymentRequest): PaymentRequest
}