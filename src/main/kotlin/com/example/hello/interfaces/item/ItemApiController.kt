package com.example.hello.interfaces.item

import com.example.hello.application.item.ItemFacade
import com.example.hello.common.response.CommonResponse
import com.example.hello.domain.item.ItemCommand
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/items")
class ItemApiController(
    private val itemFacade: ItemFacade,
    private val itemDtoMapper: ItemDtoMapper
) {
    @PostMapping
    fun registerItem(@RequestBody @Valid request: ItemDto.RegisterItemRequest): CommonResponse<ItemDto.RegisterResponse> {
        val partnerToken: String = request.partnerToken
        val itemCommand: ItemCommand.RegisterItemRequest = itemDtoMapper.of(request)
        val itemToken = itemFacade.registerItem(request = itemCommand, partnerToken = partnerToken)
        val response = itemDtoMapper.of(itemToken)
        return CommonResponse.success(response)
    }

    @PostMapping("/change-on-sales")
    fun changeOnSale(@RequestBody @Valid request: ItemDto.ChangeStatusItemRequest): CommonResponse<String> {
        val itemToken = request.itemToken
        itemFacade.changeOnSaleItem(itemToken)
        return CommonResponse.success("OK")
    }

    @PostMapping("/change-end-of-sales")
    fun changeEndOfSale(@RequestBody @Valid request: ItemDto.ChangeStatusItemRequest): CommonResponse<String> {
        val itemToken = request.itemToken
        itemFacade.changeEndOfSale(itemToken)
        return CommonResponse.success("OK")
    }

    @GetMapping("/{itemToken}")
    fun retrieve(@PathVariable("itemToken") itemToken: String): CommonResponse<ItemDto.Main> {
        val itemInfo = itemFacade.retrieveItemInfo(itemToken)
        val response = itemDtoMapper.of(itemInfo)
        return CommonResponse.success(response)
    }
}