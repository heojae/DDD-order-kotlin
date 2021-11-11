package com.example.hello.domain.item

import com.example.hello.domain.item.option.ItemOption
import com.example.hello.domain.item.optiongroup.ItemOptionGroup

class ItemCommand {

    data class RegisterItemRequest(
        val itemName: String,
        val itemPrice: Long,
        val itemOptionGroupRequestList: List<RegisterItemOptionGroupRequest>
    ) {
        fun toEntity(partnerId: Long): Item {
            return Item(
                partnerId = partnerId,
                itemName = itemName,
                itemPrice = itemPrice
            )
        }
    }

    data class RegisterItemOptionGroupRequest(
        val ordering: Int,
        val itemOptionGroupName: String,
        val itemOptionRequestList: List<RegisterItemOptionRequest>
    ) {
        fun toEntity(item: Item): ItemOptionGroup {
            return ItemOptionGroup(
                item = item,
                ordering = ordering,
                itemOptionGroupName = itemOptionGroupName
            )
        }
    }

    data class RegisterItemOptionRequest(
        val ordering: Int,
        val itemOptionName: String,
        val itemOptionPrice: Long
    ) {
        fun toEntity(itemOptionGroup: ItemOptionGroup): ItemOption {
            return ItemOption(
                ordering = ordering,
                itemOptionName = itemOptionName,
                itemOptionPrice = itemOptionPrice,
                itemOptionGroup = itemOptionGroup
            )
        }
    }
}
