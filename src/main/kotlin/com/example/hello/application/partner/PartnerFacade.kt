package com.example.hello.application.partner

import com.example.hello.domain.notification.NotificationService
import com.example.hello.domain.partner.PartnerCommand
import com.example.hello.domain.partner.PartnerInfo
import com.example.hello.domain.partner.PartnerService
import org.springframework.stereotype.Component

@Component
class PartnerFacade(
    private val partnerService: PartnerService,
    private val notificationService: NotificationService
) {
    fun registerPartner(command: PartnerCommand): PartnerInfo {
        val partnerInfo = this.partnerService.registerPartner(command)
        this.notificationService.sendEmail(email = partnerInfo.email, title = "title", description = "description")
        return partnerInfo
    }
}