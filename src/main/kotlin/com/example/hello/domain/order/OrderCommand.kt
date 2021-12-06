package com.example.hello.domain.order

import com.example.hello.domain.item.Item
import com.example.hello.domain.order.fragment.DeliveryFragment
import com.example.hello.domain.order.item.OrderItem
import com.example.hello.domain.order.item.OrderItemOption
import com.example.hello.domain.order.item.OrderItemOptionGroup
import com.example.hello.domain.order.payment.PayMethod

class OrderCommand {

    data class RegisterOrder(
        val userId: Long,
        val payMethod: String,
        val receiverName: String,
        val receiverPhone: String,
        val receiverZipcode: String,
        val receiverAddress1: String,
        val receiverAddress2: String,
        val etcMessage: String,
        val orderItemList: List<RegisterOrderItem>
    ) {
        fun toEntity(): Order {
            val deliveryFragment = DeliveryFragment(
                receiverName = receiverName,
                receiverPhone = receiverPhone,
                receiverZipcode = receiverZipcode,
                receiverAddress1 = receiverAddress1,
                receiverAddress2 = receiverAddress2,
                etcMessage = etcMessage,
            )
            return Order(
                userId = userId,
                payMethod = payMethod,
                deliveryFragment = deliveryFragment
            )
        }

    }

    data class RegisterOrderItem(
        val orderCount: Int,
        val itemToken: String,
        val itemName: String,
        val itemPrice: Long,
        val orderItemOptionGroupList: List<RegisterOrderItemOptionGroup>
    ) {
        fun toEntity(order: Order, item: Item): OrderItem {
            return OrderItem(
                order = order,
                orderCount = orderCount,
                partnerId = item.partnerId,
                itemId = item.id!!,
                itemToken = itemToken,
                itemName = itemName,
                itemPrice = itemPrice
            )
        }
    }

    data class RegisterOrderItemOptionGroup(
        val ordering: Int,
        val itemOptionGroupName: String,
        val orderItemOptionList: List<RegisterOrderItemOption>
    ) {
        fun toEntity(orderItem: OrderItem): OrderItemOptionGroup {
            return OrderItemOptionGroup(
                orderItem = orderItem,
                ordering = ordering,
                itemOptionGroupName = itemOptionGroupName
            )
        }
    }

    data class RegisterOrderItemOption(
        val ordering: Int,
        val itemOptionName: String,
        val itemOptionPrice: Long
    ) {
        fun toEntity(orderItemOptionGroup: OrderItemOptionGroup): OrderItemOption {
            return OrderItemOption(
                orderItemOptionGroup = orderItemOptionGroup,
                ordering = ordering,
                itemOptionName = itemOptionName,
                itemOptionPrice = itemOptionPrice
            )
        }
    }


    data class PaymentRequest(
        val orderToken: String,
        val amount: Long,
        val payMethod: PayMethod
    )

    data class UpdateReceiverInfoRequest(
        val receiverName: String,
        val receiverPhone: String,
        val receiverZipcode: String,
        val receiverAddress1: String,
        val receiverAddress2: String,
        val etcMessage: String
    )


}