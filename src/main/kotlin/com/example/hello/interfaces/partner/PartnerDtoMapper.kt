package com.example.hello.interfaces.partner

import com.example.hello.domain.partner.PartnerCommand
import lombok.Builder
import lombok.NoArgsConstructor
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
interface PartnerDtoMapper {
    fun of(request : PartnerDto.RegisterRequest): PartnerCommand
}