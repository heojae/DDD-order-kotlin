package com.example.hello.interfaces.partner

import com.example.hello.application.partner.PartnerFacade
import com.example.hello.common.response.CommonResponse
import com.example.hello.domain.partner.PartnerCommand
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Slf4j
@RestController
@RequestMapping("/api/v1/partners")
@RequiredArgsConstructor
class PartnerApiController(
    private val partnerFacade: PartnerFacade
) {
    @PostMapping(produces = ["application/json"])
    @ResponseBody
    fun registerPartner(@RequestBody @Valid request: PartnerDto.RegisterRequest): CommonResponse<PartnerDto.RegisterResponse> {
        val command: PartnerCommand = request.toCommand()
        val partnerInfo = partnerFacade.registerPartner(command);
        val response = PartnerDto.RegisterResponse(partnerInfo)
        return CommonResponse.success(data = response, message = null)
    }
}
