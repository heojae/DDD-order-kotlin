package com.example.hello.domain.order.gift

import kotlinx.serialization.Serializable

@Serializable
data class GiftPaymentCompleteMessage(
    val orderToken: String
)
