package com.example.hello.domain.item

import com.example.hello.domain.item.option.ItemOption
import com.example.hello.domain.item.optiongroup.ItemOptionGroup

class ItemInfo {

    data class Main(
        val itemToken: String,
        val partnerId: Long,
        val itemName: String,
        val itemPrice: Long,
        val status: Item.Status,
        val itemOptionGroupList: List<ItemOptionGroupInfo>
    ) {
        constructor(item: Item, itemOptionGroupInfoList: List<ItemOptionGroupInfo>) : this(
            itemToken = item.itemToken,
            partnerId = item.partnerId,
            itemName = item.itemName,
            itemPrice = item.itemPrice,
            status = item.status,
            itemOptionGroupList = itemOptionGroupInfoList
        )
    }

    data class ItemOptionGroupInfo(
        val ordering: Int,
        val itemOptionGroupName: String,
        val itemOptionInfoList: List<ItemOptionInfo>
    ) {
        constructor(itemOptionGroup: ItemOptionGroup, itemOptionInfoList: List<ItemOptionInfo>) : this(
            ordering = itemOptionGroup.ordering,
            itemOptionGroupName = itemOptionGroup.itemOptionGroupName,
            itemOptionInfoList = itemOptionInfoList
        )
    }

    data class ItemOptionInfo(
        val ordering: Int,
        val itemOptionName: String,
        val itemOptionPrice: Long
    ) {
        constructor(itemOption: ItemOption) : this(
            ordering = itemOption.ordering,
            itemOptionName = itemOption.itemOptionName,
            itemOptionPrice = itemOption.itemOptionPrice
        )
    }
}