package com.example.hello.interfaces.item

import com.example.hello.domain.item.Item
import javax.validation.constraints.NotBlank

class ItemDto {
    data class RegisterItemRequest(
        @field:NotBlank(message = "empty partnerToken")
        val partnerToken: String,
        @field:NotBlank(message = "empty itemName")
        val itemName: String,
        @field:NotBlank(message = "empty itemPrice")
        val itemPrice: Long,
        val itemOptionGroupList: List<RegisterItemOptionGroupRequest>
    )

    data class RegisterItemOptionGroupRequest(
        @field:NotBlank(message = "empty ordering")
        val ordering: Int,
        @field:NotBlank(message = "empty itemOptionGroupName")
        val itemOptionGroupName: String,
        val itemOptionList: List<RegisterItemOptionRequest>
    )

    data class RegisterItemOptionRequest(
        @field:NotBlank(message = "empty ordering")
        val ordering: Int,
        @field:NotBlank(message = "empty itemOptionName")
        val itemOptionName: String,
        @field:NotBlank(message = "empty itemOptionPrice")
        val itemOptionPrice: Long
    )

    data class RegisterResponse(
        @field:NotBlank(message = "empty itemToken")
        val itemToken: String
    )

    data class ChangeStatusItemRequest(
        @field:NotBlank(message = "empty itemToken")
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