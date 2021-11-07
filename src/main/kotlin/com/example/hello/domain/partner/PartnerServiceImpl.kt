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
        val partner: Partner = partnerStore.store(initPartner)
        return PartnerInfo(partner)
    }

    override fun getPartnerInfo(partnerToken: String): PartnerInfo {
        TODO("Not yet implemented")
    }

    override fun enablePartner(partnerToken: String): PartnerInfo {
        TODO("Not yet implemented")
    }

    override fun disablePartner(partnerToken: String): PartnerInfo {
        TODO("Not yet implemented")
    }
}