package com.example.hello.domain.item

interface ItemReader {
    fun getItemBy(itemToken: String): Item;
    fun getItemOptionSeries(item: Item): List<ItemInfo.ItemOptionGroupInfo>
}
