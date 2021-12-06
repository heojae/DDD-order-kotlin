package com.example.hello.interfaces.order.gift

import com.example.hello.application.order.OrderFacade
import com.example.hello.application.order.gift.GiftFacade
import com.example.hello.common.response.CommonResponse
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/gift-orders")
class GiftOrderApiController(
    private val orderFacade: OrderFacade,
    private val giftFacade: GiftFacade,
    private val giftOrderDtoMapper: GiftOrderDtoMapper
) {

    @PostMapping("/init")
    fun registerOrder(@RequestBody @Valid request: GiftOrderDto.RegisterOrderRequest): CommonResponse<GiftOrderDto.RegisterResponse> {
        val orderCommand = giftOrderDtoMapper.of(request)
        val result = orderFacade.registerOrder(orderCommand)
        val response = giftOrderDtoMapper.of(result)
        return CommonResponse.success(response)
    }

    @PostMapping("/payment-order")
    fun paymentOrder(@RequestBody @Valid request: GiftOrderDto.PaymentRequest): CommonResponse<String> {
        val orderPaymentCommand = giftOrderDtoMapper.of(request)
        giftFacade.paymentOrder(orderPaymentCommand)
        return CommonResponse.success("OK")
    }

    @PostMapping("/{orderToken}/update-receiver-info")
    fun updateReceiverInfo(
        @PathVariable orderToken: String,
        @RequestBody @Valid request: GiftOrderDto.UpdateReceiverInfoReq
    ): CommonResponse<String> {
        val orderCommand = request.toCommand()
        orderFacade.updateReceiverInfo(orderToken, orderCommand)
        return CommonResponse.success("OK")


    }


}
