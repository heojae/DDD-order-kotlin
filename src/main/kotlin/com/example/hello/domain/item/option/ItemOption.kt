package com.example.hello.domain.item.option

import com.example.hello.domain.AbstractEntity
import com.example.hello.domain.item.optiongroup.ItemOptionGroup
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


@Entity
@Table(name = "item_options")
class ItemOption(
    itemOptionGroup: ItemOptionGroup,
    ordering: Int,
    itemOptionName: String,
    itemOptionPrice: Long
) : AbstractEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null;

    @ManyToOne
    @JoinColumn(name = "item_option_group_id")
    var itemOptionGroup: ItemOptionGroup = itemOptionGroup

    @field:NotNull
    var ordering: Int = ordering

    @field:NotBlank(message = "empty itemOptionName")
    var itemOptionName: String = itemOptionName

    @field:NotNull
    var itemOptionPrice: Long = itemOptionPrice



}