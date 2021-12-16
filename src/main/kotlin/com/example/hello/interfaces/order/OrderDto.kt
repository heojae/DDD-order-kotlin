package com.example.hello.interfaces.order

import com.example.hello.domain.order.payment.PayMethod
import kotlinx.serialization.Serializable
import javax.validation.constraints.NotNull


class OrderDto {

    @Serializable
    data class RegisterOrderRequest(
        @NotNull(message = "userId 는 필수값입니다")
        val userId: Long,
        @NotNull(message = "payMethod 는 필수값입니다")
        val payMethod: String,
        @NotNull(message = "receiverName 는 필수값입니다")
        val receiverName: String,
        @NotNull(message = "receiverPhone 는 필수값입니다")
        val receiverPhone: String,
        @NotNull(message = "receiverZipcode 는 필수값입니다")
        val receiverZipCode: String,
        @NotNull(message = "receiverAddress1 는 필수값입니다")
        val receiverAddress1: String,
        @NotNull(message = "receiverAddress2 는 필수값입니다")
        val receiverAddress2: String,
        @NotNull(message = "etcMessage 는 필수값입니다")
        val etcMessage: String,
        val orderItemList: List<RegisterOrderItem>,
    )

    @Serializable
    data class RegisterOrderItem(
        @NotNull(message = "orderCount 는 필수값입니다")
        val orderCount: Int,
        @NotNull(message = "itemToken 는 필수값입니다")
        val itemToken: String,
        @NotNull(message = "itemName 는 필수값입니다")
        val itemName: String,
        @NotNull(message = "itemPrice 는 필수값입니다")
        val itemPrice: Long,
        val orderItemOptionGroupList: List<RegisterOrderItemOptionGroupRequest>
    )

    @Serializable
    data class RegisterOrderItemOptionGroupRequest(
        @NotNull(message = "ordering 는 필수값입니다")
        val ordering: Int,
        @NotNull(message = "itemOptionName 는 필수값입니다")
        val itemOptionGroupName: String,
        val orderItemOptionList: List<RegisterOrderItemOptionRequest>
    )

    @Serializable
    data class RegisterOrderItemOptionRequest(
        @NotNull(message = "ordering 는 필수값입니다")
        val ordering: Int,
        @NotNull(message = "itemOptionName 는 필수값입니다")
        val itemOptionName: String,
        @NotNull(message = "itemOptionPrice 는 필수값입니다")
        val itemOptionPrice: Long
    )

    @Serializable
    data class RegisterResponse(
        val orderToken: String
    )

    @Serializable
    data class PaymentRequest(
        val orderToken: String,
        val payMethod: PayMethod,
        val amount: Long,
        val orderDescription: String
    )

    // 조회
    @Serializable
    data class Main(
        val orderToken: String,
        val userId: Long,
        val payMethod: String,
        val totalAmount: Long,
        val deliveryInfo: DeliveryInfo,
        val orderedAt: String,
        val status: String,
        val statusDescription: String,
        val orderItemList: List<OrderItem>,
    )

    @Serializable
    data class DeliveryInfo(
        val receiverName: String,
        val receiverPhone: String,
        val receiverZipCode: String,
        val receiverAddress1: String,
        val receiverAddress2: String,
        val etcMessage: String,
    )

    @Serializable
    data class OrderItem(
        val orderCount: Int,
        val partnerId: Long,
        val itemId: Long,
        val itemName: String,
        val totalAmount: Long,
        val itemPrice: Long,
        val deliveryStatus: String,
        val deliveryStatusDescription: String,
        val orderItemOptionGroupList: List<OrderItemOptionGroup>,
    )

    @Serializable
    data class OrderItemOptionGroup(
        val ordering: Int,
        val itemOptionGroupName: String,
        val orderItemOptionList: List<OrderItemOption>,
    )

    @Serializable
    class OrderItemOption(
        val ordering: Int,
        val itemOptionName: String,
        val itemOptionPrice: Long,
    )
}