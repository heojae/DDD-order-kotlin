package com.example.hello.application.partner

import com.example.hello.domain.partner.PartnerCommand
import com.example.hello.domain.partner.PartnerInfo
import com.example.hello.domain.partner.PartnerService
import org.springframework.stereotype.Component

@Component
class PartnerFacade(
    private val partnerService: PartnerService,
) {
    fun registerPartner(command: PartnerCommand): PartnerInfo{
        println("aaaaa start")
        val partnerInfo = partnerService.registerPartner(command)
        println("aaaaa end")
        return partnerInfo
    }

}