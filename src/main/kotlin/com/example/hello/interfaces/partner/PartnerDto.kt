package com.example.hello.interfaces.partner

import com.example.hello.domain.partner.Partner
import com.example.hello.domain.partner.PartnerCommand
import com.example.hello.domain.partner.PartnerInfo
import kotlinx.serialization.Serializable
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class PartnerDto {

    @Serializable
    data class RegisterRequest(
        @field:NotBlank(message = "partnerName 는 필수값입니다.")
        val partnerName: String,
        @field:NotBlank(message = "businessNo 는 필수값입니다.")
        val businessNo: String,
        @field:Email(message = "email 형식에 맞아야 합니다.")
        @field:NotBlank(message = "email 는 필수값입니다.")
        val email: String,
    ) {
        fun toCommand(): PartnerCommand {
            return PartnerCommand(
                partnerName = this.partnerName,
                businessNo = this.businessNo,
                email = this.email,
                )
        }
    }

    @Serializable
    data class RegisterResponse(
        val partnerToken: String,
        val partnerName: String,
        val businessNo: String,
        val email: String,
        val status: Partner.Status
    ){
        constructor(partnerInfo: PartnerInfo): this(
            partnerToken=partnerInfo.partnerToken,
            partnerName=partnerInfo.partnerName,
            businessNo=partnerInfo.businessNo,
            email=partnerInfo.email,
            status=partnerInfo.status
        ){}
    }

}