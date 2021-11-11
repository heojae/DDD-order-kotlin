package com.example.hello.application.item

import com.example.hello.domain.item.ItemCommand
import com.example.hello.domain.item.ItemInfo
import com.example.hello.domain.item.ItemService
import com.example.hello.domain.notification.NotificationService
import org.springframework.stereotype.Service

@Service
class ItemFacade(
    private val itemService: ItemService,
    private val notificationService: NotificationService
) {
    fun registerItem(request: ItemCommand.RegisterItemRequest, partnerToken: String): String {
        val itemToken: String = itemService.registerItem(command = request, partnerToken = partnerToken);
        notificationService.sendEmail("", "", "");
        return itemToken
    }

    fun changeOnSaleItem(itemToken: String) {
        itemService.changeOnSale(itemToken)
    }

    fun changeEndOfSale(itemToken: String) {
        itemService.changeEndOfSale(itemToken)
    }

    fun retrieveItemInfo(itemToken: String): ItemInfo.Main {
        return itemService.retrieveItemInfo(itemToken)
    }


}