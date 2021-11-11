package com.example.hello.infrastructure.item

import com.example.hello.domain.item.Item
import com.example.hello.domain.item.ItemCommand
import com.example.hello.domain.item.ItemOptionSeriesFactory
import com.example.hello.domain.item.option.ItemOptionStore
import com.example.hello.domain.item.optiongroup.ItemOptionGroup
import com.example.hello.domain.item.optiongroup.ItemOptionGroupStore
import org.springframework.stereotype.Component

import org.springframework.util.CollectionUtils;
import java.util.*

@Component
class ItemOptionSeriesFactoryImpl(
    private val itemOptionGroupStore: ItemOptionGroupStore,
    private val itemOptionStore: ItemOptionStore
) : ItemOptionSeriesFactory {
    override fun store(command: ItemCommand.RegisterItemRequest, item: Item): List<ItemOptionGroup> {
        val itemOptionGroupRequestList: List<ItemCommand.RegisterItemOptionGroupRequest> =
            command.itemOptionGroupRequestList
        if (CollectionUtils.isEmpty(itemOptionGroupRequestList)) return Collections.emptyList();

        val itemOptionGroupList: List<ItemOptionGroup> = itemOptionGroupRequestList.map {
            // itemOptionGroup store
            val initItemOptionGroup: ItemOptionGroup = it.toEntity(item);
            val itemOptionGroup = itemOptionGroupStore.store(initItemOptionGroup)

            // itemOption store
            for (requestItemOption in it.itemOptionRequestList) {
                val initItemOption = requestItemOption.toEntity(itemOptionGroup)
                itemOptionStore.store(initItemOption)
            }
            itemOptionGroup
        }
        return itemOptionGroupList
    }
}