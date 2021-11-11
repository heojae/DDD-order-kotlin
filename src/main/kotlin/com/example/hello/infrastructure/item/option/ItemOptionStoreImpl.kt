package com.example.hello.infrastructure.item.option

import com.example.hello.domain.item.option.ItemOption
import com.example.hello.domain.item.option.ItemOptionStore
import org.springframework.stereotype.Component

@Component
class ItemOptionStoreImpl(
    val itemOptionRepository: ItemOptionRepository
) : ItemOptionStore {
    override fun store(itemOption: ItemOption) {
        itemOptionRepository.save(itemOption)
    }
}
