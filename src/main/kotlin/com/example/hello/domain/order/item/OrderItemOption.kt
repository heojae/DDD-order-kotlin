package com.example.hello.domain.order.item

import com.example.hello.domain.AbstractEntity
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


@Entity
@Table(name = "order_item_options")
class OrderItemOption(
    orderItemOptionGroup: OrderItemOptionGroup,
    ordering: Int,
    itemOptionName: String,
    itemOptionPrice: Long
) : AbstractEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "order_item_option_group_id")
    var orderItemOptionGroup: OrderItemOptionGroup = orderItemOptionGroup

    @field:NotNull
    var ordering: Int = ordering

    @field:NotBlank(message = "empty itemOptionName")
    var itemOptionName: String = itemOptionName

    @field:NotNull
    var itemOptionPrice: Long = itemOptionPrice

}