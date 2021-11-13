package com.example.hello.interfaces.item

import com.example.hello.domain.item.Item
import kotlinx.serialization.Serializable
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class ItemDto {
    @Serializable
    data class RegisterItemRequest(
        @field:NotBlank(message = "empty partnerToken")
        val partnerToken: String,
        @field:NotBlank(message = "empty itemName")
        val itemName: String,
        val itemPrice: Long,
        val itemOptionGroupList: List<RegisterItemOptionGroupRequest>
    )

    @Serializable
    data class RegisterItemOptionGroupRequest(
        @field:NotBlank(message = "empty ordering")
        val ordering: Int,
        @field:NotBlank(message = "empty itemOptionGroupName")
        val itemOptionGroupName: String,
        val itemOptionList: List<RegisterItemOptionRequest>
    )

    @Serializable
    data class RegisterItemOptionRequest(
        @field:NotBlank(message = "empty ordering")
        val ordering: Int,
        @field:NotBlank(message = "empty itemOptionName")
        val itemOptionName: String,
        @field:NotBlank(message = "empty itemOptionPrice")
        val itemOptionPrice: Long
    )
    @Serializable
    data class RegisterResponse(
        @field:NotBlank(message = "empty itemToken")
        val itemToken: String
    )

    @Serializable
    data class ChangeStatusItemRequest(
        @field:NotBlank(message = "empty itemToken")
        val itemToken: String
    )

    @Serializable
    data class Main(
        val itemToken: String,
        val partnerId: String,
        val itemName: String,
        val itemPrice: Long,
        val status: Item.Status,
        val itemOptionGroupList: List<ItemOptionGroupInfo>
    )

    @Serializable
    data class ItemOptionGroupInfo(
        val ordering: Int,
        val itemOptionGroupName: String,
        val itemOptionList: List<ItemOptionInfo>
    )

    @Serializable
    data class ItemOptionInfo(
        val ordering: Int,
        val itemOptionName: String,
        val itemOptionPrice: Long
    )


}