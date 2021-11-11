package com.example.hello.infrastructure.item

import com.example.hello.domain.item.Item
import com.example.hello.domain.item.ItemStore
import org.springframework.stereotype.Component

@Component
class ItemStoreImpl(
    private val itemRepository: ItemRepository
) : ItemStore {
    override fun store(initItem: Item): Item {
        return itemRepository.save(initItem)
    }
}
