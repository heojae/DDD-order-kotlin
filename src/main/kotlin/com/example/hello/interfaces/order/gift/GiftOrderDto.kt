package com.example.hello.interfaces.order.gift

import com.example.hello.domain.order.OrderCommand
import com.example.hello.domain.order.payment.PayMethod
import javax.validation.constraints.NotNull

class GiftOrderDto {

    data class RegisterOrderRequest(
        @field:NotNull(message = "buyerUserId 는 필수 값입니다.")
        val buyerUserId: Long,
        @field:NotNull(message = "buyerUserId 는 필수 값입니다.")
        val payMethod: String,
        val orderItemList: List<RegisterOrderItem>,
        val receiverName: String = "TEMP_VALUE",
        val receiverPhone: String = "TEMP_VALUE",
        val receiverZipcode: String = "TEMP_VALUE",
        val receiverAddress1: String = "TEMP_VALUE",
        val receiverAddress2: String = "TEMP_VALUE",
        val etcMessage: String = "TEMP_VALUE",
    )

    data class RegisterOrderItem(
        @field:NotNull(message = "orderToken 는 필수 값입니다.")
        val orderCount: Int,
        @field:NotNull(message = "payMethod 는 필수 값입니다.")
        val itemToken: String,
        @field:NotNull(message = "payMethod 는 필수 값입니다.")
        val itemName: String,
        @field:NotNull(message = "payMethod 는 필수 값입니다.")
        val itemPrice: Long,
        @field:NotNull(message = "amount 는 필수 값입니다.")
        val orderItemOptionGroupList: List<RegisterOrderItemOptionGroupRequest>
    )


    data class RegisterOrderItemOptionGroupRequest(
        @field:NotNull(message = "orderToken 는 필수 값입니다.")
        val ordering: Int,
        @field:NotNull(message = "payMethod 는 필수 값입니다.")
        val itemOptionGroupName: String,
        @field:NotNull(message = "amount 는 필수 값입니다.")
        val orderItemOptionList: List<RegisterOrderItemOptionRequest>
    )


    data class RegisterOrderItemOptionRequest(
        @field:NotNull(message = "orderToken 는 필수 값입니다.")
        val ordering: Int,
        @field:NotNull(message = "payMethod 는 필수 값입니다.")
        val itemOptionName: String,
        @field:NotNull(message = "amount 는 필수 값입니다.")
        val itemOptionPrice: Long
    )


    data class RegisterResponse(
        val orderToken: String
    )


    data class PaymentRequest(
        @field:NotNull(message = "orderToken 는 필수 값입니다.")
        val orderToken: String,
        @field:NotNull(message = "payMethod 는 필수 값입니다.")
        val payMethod: PayMethod,
        @field:NotNull(message = "amount 는 필수 값입니다.")
        val amount: Long,
        @field:NotNull(message = "orderDescription 는 필수 값입니다.")
        val orderDescription: String
    )

    data class UpdateReceiverInfoReq(
        val receiverName: String,
        val receiverPhone: String,
        val receiverZipcode: String,
        val receiverAddress1: String,
        val receiverAddress2: String,
        val etcMessage: String
    ) {
        fun toCommand(): OrderCommand.UpdateReceiverInfoRequest {
            return OrderCommand.UpdateReceiverInfoRequest(
                receiverName = receiverName,
                receiverPhone = receiverPhone,
                receiverZipcode = receiverZipcode,
                receiverAddress1 = receiverAddress1,
                receiverAddress2 = receiverAddress2,
                etcMessage = etcMessage
            )
        }
    }
}