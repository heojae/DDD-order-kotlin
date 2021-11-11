package com.example.hello.infrastructure.item.optiongroup

import com.example.hello.domain.item.optiongroup.ItemOptionGroup
import org.springframework.data.jpa.repository.JpaRepository

interface ItemOptionGroupRepository : JpaRepository<ItemOptionGroup, Long>{
}