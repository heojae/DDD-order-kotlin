package com.example.hello.domain.order

interface OrderReader {
    fun getOrder(orderToken: String): Order
}