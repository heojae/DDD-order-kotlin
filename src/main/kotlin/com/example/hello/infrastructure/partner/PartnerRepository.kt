package com.example.hello.infrastructure.partner

import com.example.hello.domain.partner.Partner
import org.springframework.data.jpa.repository.JpaRepository

interface PartnerRepository : JpaRepository<Partner, Long>{
}