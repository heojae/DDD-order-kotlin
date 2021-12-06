package com.example.hello.domain.order.item

import com.example.hello.common.exception.IllegalStatusException
import com.example.hello.domain.AbstractEntity
import com.example.hello.domain.order.Order
import com.google.common.collect.Lists
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import kotlin.concurrent.thread


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

    fun deliveryPrepare() {
        if (this.deliveryStatus != DeliveryStatus.BEFORE_DELIVERY) throw IllegalStatusException()
        this.deliveryStatus = DeliveryStatus.DELIVERY_PREPARE
    }

    fun inDelivery(){
        if (this.deliveryStatus != DeliveryStatus.DELIVERY_PREPARE) throw IllegalStatusException()
        this.deliveryStatus = DeliveryStatus.DELIVERING
    }

    fun deliveryComplete(){
        if (this.deliveryStatus != DeliveryStatus.DELIVERING) throw IllegalStatusException()
        this.deliveryStatus = DeliveryStatus.COMPLETE_DELIVERY
    }

}
