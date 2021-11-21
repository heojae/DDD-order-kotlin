package com.example.hello.domain.order.item

import com.example.hello.domain.AbstractEntity
import com.example.hello.domain.order.Order
import com.google.common.collect.Lists
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


@Entity
@Table(name = "order_items")
class OrderItem(
    order: Order,
    orderCount: Int,
    partnerId: Long,
    itemId: Long,
    itemName: String,
    itemToken: String,
    itemPrice: Long
) : AbstractEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null;

    @ManyToOne
    @JoinColumn(name = "order_id")
    var order: Order = order

    @field:NotNull
    var orderCount: Int = orderCount

    @field:NotNull
    var partnerId: Long = partnerId

    @field:NotNull
    var itemId: Long = itemId

    @field:NotBlank(message = "empty itemName")
    var itemName: String = itemName

    @field:NotBlank(message = "empty itemToken")
    var itemToken: String = itemToken

    @field:NotNull
    var itemPrice: Long = itemPrice

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderItem", cascade = [CascadeType.PERSIST])
    var orderItemOptionGroupList: List<OrderItemOptionGroup> = Lists.newArrayList()

    @Enumerated(EnumType.STRING)
    var deliveryStatus: DeliveryStatus = DeliveryStatus.BEFORE_DELIVERY

    enum class DeliveryStatus(private val description: String) {
        BEFORE_DELIVERY("배송전"),
        DELIVERY_PREPARE("배송준비중"),
        DELIVERING("배송중"),
        COMPLETE_DELIVERY("배송완료");

        fun getDescription(): String {
            return this.description
        }
    }

    fun calculateTotalAmount(): Long {
        val itemOptionTotalAmount = this.orderItemOptionGroupList.map { it.calculateTotalAmount() }.sum()
        return (this.itemPrice + itemOptionTotalAmount) * this.orderCount
    }

}
