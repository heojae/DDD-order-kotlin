package com.example.hello.domain.item

interface ItemStore {
    fun store(initItem: Item): Item
}