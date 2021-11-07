package com.example.hello.infrastructure.partner

import com.example.hello.domain.partner.Partner
import com.example.hello.domain.partner.PartnerStore
import org.springframework.stereotype.Component

@Component
class PartnerStoreImpl(
    private val partnerRepository: PartnerRepository
) : PartnerStore {
    override fun store(initPartner: Partner): Partner {
        return this.partnerRepository.save(initPartner)
    }

}