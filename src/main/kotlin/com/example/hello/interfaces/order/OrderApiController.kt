package com.example.hello.interfaces.order

import com.example.hello.application.order.OrderFacade
import com.example.hello.common.response.CommonResponse
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/orders")
class OrderApiController(
    private val orderFacade: OrderFacade,
    private val orderDtoMapper: OrderDtoMapper
) {

    @PostMapping("/init")
    fun registerOrder(@RequestBody @Valid request: OrderDto.RegisterOrderRequest): CommonResponse<OrderDto.RegisterResponse> {
        println("aaaaaaaaa")
        val orderCommand = orderDtoMapper.of(request)
        println("bbbbbbbbb")
        val orderToken = orderFacade.registerOrder(orderCommand)
        println("ccccccccc")
        val response = orderDtoMapper.of(orderToken)
        return CommonResponse.success(response)
    }

    @GetMapping("/{orderToken}")
    fun retrieveOrder(@PathVariable orderToken: String): CommonResponse<OrderDto.Main> {
        val orderResult = orderFacade.retrieveOrder(orderToken)
        val response = orderDtoMapper.of(orderResult)
        return CommonResponse.success(response)
    }

    @PostMapping("/payment-order")
    fun paymentOrder(@RequestBody @Valid paymentRequest: OrderDto.PaymentRequest): CommonResponse<String> {
        println("aaaaaaaaa")
        val paymentCommand = orderDtoMapper.of(paymentRequest)
        println("bbbbbbbbb")
        orderFacade.paymentOrder(paymentCommand)
        println("ccccccccc")
        return CommonResponse.success("OK")
    }


}

