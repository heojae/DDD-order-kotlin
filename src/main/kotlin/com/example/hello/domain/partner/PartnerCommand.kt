package com.example.hello.domain.partner

data class PartnerCommand(val partnerName: String, val businessNo: String, val email: String) {
    fun toEntity(): Partner {
        return Partner(partnerName = partnerName, businessNo = businessNo, email = email)
    }
}