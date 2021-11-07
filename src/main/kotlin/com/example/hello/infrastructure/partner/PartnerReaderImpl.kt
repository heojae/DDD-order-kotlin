package com.example.hello.infrastructure.partner

import com.example.hello.common.exception.EntityNotFoundException
import com.example.hello.domain.partner.Partner
import com.example.hello.domain.partner.PartnerReader
import org.springframework.stereotype.Component

@Component
class PartnerReaderImpl(
    val partnerRepository: PartnerRepository
) : PartnerReader {
    override fun getPartner(partnerId: Long): Partner {
        return this.partnerRepository.findPartnerById(partnerId) ?: throw EntityNotFoundException()
    }

    override fun getPartner(partnerToken: String): Partner {
        return this.partnerRepository.findPartnerByPartnerToken(partnerToken) ?: throw EntityNotFoundException()
    }
}