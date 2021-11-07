package com.example.hello.infrastructure.partner

import com.example.hello.domain.partner.Partner
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface PartnerRepository : CrudRepository<Partner, Long>{
    fun findPartnerById(id: Long): Partner?
    fun findPartnerByPartnerToken(partnerToken: String): Partner?
}