package com.example.hello.infrastructure.item

import com.example.hello.domain.item.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<Item, Long>{
    fun findByItemToken(itemToken: String): Item?
}