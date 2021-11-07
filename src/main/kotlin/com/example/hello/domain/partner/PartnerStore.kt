package com.example.hello.domain.partner


interface PartnerStore {
    fun store(initPartner: Partner): Partner
}