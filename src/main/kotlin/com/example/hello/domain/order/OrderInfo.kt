package com.example.hello.domain.order

import java.time.ZonedDateTime


class OrderInfo {

    class Main(
        val orderId: Long?,
        val orderToken: String,
        val userId: Long,
        val payMethod: String,
        val totalAmount: Long,
        val deliveryInfo: DeliveryInfo,
        val orderedAt: ZonedDateTime?,
        val status: String,
        val statusDescription: String,
        val orderItemList: List<OrderItem>
    )

    data class DeliveryInfo(
        val receiverName: String,
        val receiverPhone: String,
        val receiverZipcode: String,
        val receiverAddress1: String,
        val receiverAddress2: String,
        val etcMessage: String
    )


    data class OrderItem(
        val orderCount: Int,
        val partnerId: Long,
        val itemId: Long,
        val itemName: String,
        val totalAmount: Long,
        val itemPrice: Long,
        val deliveryStatus: String,
        val deliveryStatusDescription: String,
        val orderItemOptionGroupList: List<OrderItemOptionGroup>
    )


    data class OrderItemOptionGroup(
        val ordering: Int,
        val itemOptionGroupName: String,
        val orderItemOptionList: List<OrderItemOption>
    )

    data class OrderItemOption(
        val ordering: Int,
        val itemOptionName: String,
        val itemOptionPrice: Long
    )

}