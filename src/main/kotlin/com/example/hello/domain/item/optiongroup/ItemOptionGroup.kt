package com.example.hello.domain.item.optiongroup

import com.example.hello.domain.AbstractEntity
import com.example.hello.domain.item.Item
import com.example.hello.domain.item.option.ItemOption
import com.google.common.collect.Lists
import javax.persistence.*
import javax.validation.constraints.NotBlank


@Entity
@Table(name = "item_option_groups")
class ItemOptionGroup(
    item: Item,
    ordering: Int,
    itemOptionGroupName: String
) : AbstractEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null;

    @ManyToOne
    @JoinColumn(name = "item_id")
    var item: Item = item

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "itemOptionGroup", cascade = [CascadeType.PERSIST])
    var itemOptionList: List<ItemOption> = Lists.newArrayList();

    @field:NotBlank(message = "empty ordering")
    var ordering: Int = ordering

    @field:NotBlank(message = "empty itemOptionGroupName")
    var itemOptionGroupName: String = itemOptionGroupName




}