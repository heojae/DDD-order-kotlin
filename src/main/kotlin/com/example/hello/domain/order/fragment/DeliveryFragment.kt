package com.example.hello.domain.order.fragment

import javax.persistence.Embeddable
import javax.validation.constraints.NotBlank

@Embeddable
class DeliveryFragment(
    @field:NotBlank(message = "empty receiverName")
    var receiverName: String,
    @field:NotBlank(message = "empty receiverPhone")
    var receiverPhone: String,
    @field:NotBlank(message = "empty receiverZipCode")
    var receiverZipCode: String,
    @field:NotBlank(message = "empty receiverAddress1")
    var receiverAddress1: String,
    @field:NotBlank(message = "empty receiverAddress2")
    var receiverAddress2: String,
    @field:NotBlank(message = "empty etcMessage")
    var etcMessage: String
) {}