package com.example.hello.infrastructure.item

import com.example.hello.common.exception.EntityNotFoundException
import com.example.hello.domain.item.Item
import com.example.hello.domain.item.ItemInfo
import com.example.hello.domain.item.ItemReader
import org.springframework.stereotype.Component

@Component
class ItemReaderImpl(
    private val itemRepository: ItemRepository
) : ItemReader {
    override fun getItemBy(itemToken: String): Item {
        return this.itemRepository.findByItemToken(itemToken) ?: throw EntityNotFoundException()
    }

    override fun getItemOptionSeries(item: Item): List<ItemInfo.ItemOptionGroupInfo> {
        val itemOptionGroupList = item.itemOptionGroupList;
        return itemOptionGroupList.map { itemOptionGroup ->
            val itemOptionList = itemOptionGroup.itemOptionList
            val itemOptionInfoList = itemOptionList.map { itemOption -> ItemInfo.ItemOptionInfo(itemOption) }
            ItemInfo.ItemOptionGroupInfo(
                itemOptionGroup=itemOptionGroup,
                itemOptionInfoList=itemOptionInfoList)
        }
    }
}