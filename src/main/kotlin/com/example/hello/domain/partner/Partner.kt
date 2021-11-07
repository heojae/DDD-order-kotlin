package com.example.hello.domain.partner

import com.example.hello.common.util.TokenGenerator
import com.example.hello.domain.AbstractEntity
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "partners")
class Partner(partnerName: String, businessNo: String, email:String) : AbstractEntity() {
    companion object{
        const val PREFIX_PARTNER : String = "ptn_"
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null


    @field:NotBlank(message = "empty partnerName")
    var partnerName: String = partnerName

    @field:NotBlank(message = "empty businessNo")
    var businessNo: String = businessNo

    @field:NotBlank(message = "empty email")
    var email: String = email

    var partnerToken: String = TokenGenerator.randomCharacterWithPrefix(PREFIX_PARTNER)

    var status: Status = Status.ENABLE
        private set

    enum class Status(val status: String){
        ENABLE("활성화"),
        DISABLE("비활성화")
    }

    fun enable(){ this.status = Status.ENABLE }

    fun disable(){ this.status = Status.DISABLE }

}