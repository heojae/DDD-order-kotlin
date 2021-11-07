package com.example.hello.domain.partner

data class PartnerCommand(private val partnerName: String, private val businessNo: String, private val email: String) {
    fun toEntity(): Partner {
        return Partner(partnerName = partnerName, businessNo = businessNo, email = email)
    }
}