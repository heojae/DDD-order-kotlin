package com.example.hello.domain.partner

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PartnerServiceImpl(
    val partnerStore: PartnerStore,
    val partnerReader: PartnerReader
): PartnerService {

    @Transactional
    override fun registerPartner(command: PartnerCommand): PartnerInfo {
        val initPartner: Partner = command.toEntity()
        val partner: Partner = this.partnerStore.store(initPartner)
        return PartnerInfo(partner)
    }

    @Transactional(readOnly = true)
    override fun getPartnerInfo(partnerToken: String): PartnerInfo {
        val partner = this.partnerReader.getPartner(partnerToken = partnerToken)
        return PartnerInfo(partner)
    }

    @Transactional
    override fun enablePartner(partnerToken: String): PartnerInfo {
        var partner = this.partnerReader.getPartner(partnerToken = partnerToken)
        partner.enable()
        partner = this.partnerStore.store(partner)
        return PartnerInfo(partner)
    }

    @Transactional
    override fun disablePartner(partnerToken: String): PartnerInfo {
        var partner = this.partnerReader.getPartner(partnerToken = partnerToken)
        partner.disable()
        partner = this.partnerStore.store(partner)
        return PartnerInfo(partner)
    }
}
