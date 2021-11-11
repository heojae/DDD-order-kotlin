package com.example.hello.interfaces.item

import com.example.hello.domain.item.Item

class ItemDto {
    data class RegisterItemRequest(
        var partnerToken: String,
        var itemName: String,
        var itemPrice: Long,
        var itemOptionGroupList: List<RegisterItemOptionGroupRequest>
    )

    data class RegisterItemOptionGroupRequest(
        val ordering: Int,
        val itemOptionGroupName: String,
        val itemOptionList: List<RegisterItemOptionRequest>
    )

    data class RegisterItemOptionRequest(
        val ordering: Int,
        val itemOptionName: String,
        val itemOptionPrice: Long
    )

    data class RegisterResponse(
        val itemToken: String
    )

    data class ChangeStatusItemRequest(
        val itemToken: String
    )

    data class Main(
        val itemToken: String,
        val partnerId: String,
        val itemName: String,
        val itemPrice: Long,
        val status: Item.Status,
        val itemOptionGroupList: List<ItemOptionGroupInfo>
    )

    data class ItemOptionGroupInfo(
        val ordering: Int,
        val itemOptionGroupName: String,
        val itemOptionList: List<ItemOptionInfo>
    )


    data class ItemOptionInfo(
        val ordering: Int,
        val itemOptionName: String,
        val itemOptionPrice: Long
    )


}