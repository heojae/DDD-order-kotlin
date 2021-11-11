package com.example.hello.domain.item

import com.example.hello.domain.item.optiongroup.ItemOptionGroup

interface ItemOptionSeriesFactory {
    fun store(command: ItemCommand.RegisterItemRequest, item: Item): List<ItemOptionGroup>
}