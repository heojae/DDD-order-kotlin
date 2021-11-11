package com.example.hello.infrastructure.item.optiongroup


import com.example.hello.domain.item.optiongroup.ItemOptionGroup
import com.example.hello.domain.item.optiongroup.ItemOptionGroupStore
import org.springframework.stereotype.Component

@Component
class ItemOptionGroupStoreImpl(
    private val itemOptionGroupRepository: ItemOptionGroupRepository
) : ItemOptionGroupStore {
    override fun store(itemOptionGroup: ItemOptionGroup): ItemOptionGroup {
        return itemOptionGroupRepository.save(itemOptionGroup)
    }
}