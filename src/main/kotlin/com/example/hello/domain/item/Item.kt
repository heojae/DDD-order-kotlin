package com.example.hello.domain.item

import com.example.hello.common.util.TokenGenerator
import com.example.hello.domain.AbstractEntity
import com.example.hello.domain.item.optiongroup.ItemOptionGroup
import com.google.common.collect.Lists
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name = "items")
class Item(
    partnerId: Long,
    itemName: String,
    itemPrice: Long
) : AbstractEntity() {
    companion object {
        val ITEM_PREFIX: String = "item_"
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = [CascadeType.PERSIST])
    var itemOptionGroupList: List<ItemOptionGroup> = Lists.newArrayList()

    @field:NotNull
    var partnerId: Long = partnerId

    @field:NotBlank(message = "empty itemName")
    var itemName: String = itemName

    @field:NotNull
    val itemPrice: Long = itemPrice

    var status: Status = Status.PREPARE
        private set

    var itemToken: String = TokenGenerator.randomCharacterWithPrefix(ITEM_PREFIX)

    enum class Status(private val description: String) {
        PREPARE("판매준비중"),
        ON_SALE("판매중"),
        END_OF_SALE("판매종료");
    }

    fun changeOnSale() {
        this.status = Status.ON_SALE
    }

    fun changeEndOfSale() {
        this.status = Status.END_OF_SALE
    }

    fun availableSales(): Boolean {
        return this.status == Status.ON_SALE
    }


}