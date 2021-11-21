package com.example.hello.domain.order.item

import com.example.hello.domain.AbstractEntity
import com.google.common.collect.Lists
import javax.persistence.*

@Entity
@Table(name = "order_item_option_groups")
class OrderItemOptionGroup(
    orderItem: OrderItem,
    ordering: Int,
    itemOptionGroupName: String
) : AbstractEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "order_item_id")
    var orderItem: OrderItem = orderItem
    var ordering: Int = ordering
    var itemOptionGroupName: String = itemOptionGroupName

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderItemOptionGroup", cascade = [CascadeType.PERSIST])
    var orderItemOptionList: List<OrderItemOption> = Lists.newArrayList();

    fun calculateTotalAmount(): Long {
        return orderItemOptionList.map { it.itemOptionPrice }.sum()
    }

}