package com.example.hello.domain.order

import com.example.hello.common.exception.IllegalStatusException
import com.example.hello.common.util.TokenGenerator
import com.example.hello.domain.AbstractEntity
import com.example.hello.domain.order.fragment.DeliveryFragment
import com.example.hello.domain.order.item.OrderItem
import com.google.common.collect.Lists
import org.hibernate.annotations.CreationTimestamp
import java.time.ZonedDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


@Entity
@Table(name = "orders")
class Order(
    userId: Long,
    payMethod: String,
    deliveryFragment: DeliveryFragment
) : AbstractEntity() {

    companion object {
        val ORDER_PREFIX = "ord_"
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null;

    @field:NotBlank(message = "empty orderToken")
    var orderToken: String = TokenGenerator.randomCharacterWithPrefix(ORDER_PREFIX);

    @field:NotNull
    var userId: Long = userId

    @field:NotBlank(message = "empty payMethod")
    var payMethod: String = payMethod

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = [CascadeType.PERSIST])
    var orderItemList: List<OrderItem> = Lists.newArrayList()


    @Embedded
    var deliveryFragment: DeliveryFragment = deliveryFragment

    @CreationTimestamp
    @Column(name = "ordered_at")
    lateinit var orderedAt: ZonedDateTime

    @Enumerated(EnumType.STRING)
    var status: Status = Status.INIT

    enum class Status(private val description: String) {
        INIT("주문시작"),
        ORDER_COMPLETE("주문완료"),
        DELIVERY_PREPARE("배송준비"),
        IN_DELIVERY("배송중"),
        DELIVERY_COMPLETE("배송완료");

        fun getDescription(): String {
            return this.description
        }
    }

    /**
     * 주문 가격 = 주문 상품의 총 가격
     * 주문 하나의 상품의 가격 = (상품 가격 + 상품 옵션 가격) * 주문 갯수
     */
    fun calculateTotalAmount(): Long {
        return orderItemList.map { it.calculateTotalAmount() }.sum()
    }

    fun orderComplete() {
        if (status !== Status.INIT) throw IllegalStatusException()
        status = Status.ORDER_COMPLETE
    }

    fun deliveryPrepare() {
        if (this.status != Status.ORDER_COMPLETE) throw IllegalStatusException()
        this.status = Status.DELIVERY_PREPARE
        this.orderItemList.forEach { orderItem -> orderItem.deliveryPrepare() }
    }

    fun inDelivery() {
        if (this.status != Status.DELIVERY_PREPARE) throw IllegalStatusException()
        this.status = Status.IN_DELIVERY
        this.orderItemList.forEach { orderItem -> orderItem.inDelivery() }
    }

    fun deliveryComplete() {
        if (this.status != Status.IN_DELIVERY) throw IllegalStatusException()
        this.status = Status.DELIVERY_COMPLETE
        this.orderItemList.forEach { orderItem -> orderItem.deliveryComplete() }
    }


    fun isAlreadyPaymentComplete(): Boolean {
        return when (status) {
            Status.ORDER_COMPLETE, Status.DELIVERY_PREPARE, Status.IN_DELIVERY, Status.DELIVERY_COMPLETE -> true
            else -> false
        }
    }

    fun updateDeliveryFragment(
        receiverName: String,
        receiverPhone: String,
        receiverZipcode: String,
        receiverAddress1: String,
        receiverAddress2: String,
        etcMessage: String
    ){
        this.deliveryFragment = DeliveryFragment(
            receiverName=receiverName,
            receiverPhone=receiverPhone,
            receiverZipcode=receiverZipcode,
            receiverAddress1=receiverAddress1,
            receiverAddress2=receiverAddress2,
            etcMessage=etcMessage
        )
    }
}