package com.example.hello.infrastructure.order.gift

import com.example.hello.domain.order.gift.GiftMessageChannelSender
import com.example.hello.domain.order.gift.GiftPaymentCompleteMessage
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.cloud.aws.messaging.core.SqsMessageHeaders
import org.springframework.stereotype.Component
import java.util.*


@Component
class GiftMessageAwsSqsSender(
    private val queueMessagingTemplate: QueueMessagingTemplate
) : GiftMessageChannelSender {
    private val SQS_QUEUE_NAME = "order-payComplete-live.fifo"

    override fun paymentComplete(message: GiftPaymentCompleteMessage) {
        try {
            val headers: MutableMap<String, Any> = HashMap()
            headers[SqsMessageHeaders.SQS_GROUP_ID_HEADER] = "item-queues"
            headers[SqsMessageHeaders.SQS_DEDUPLICATION_ID_HEADER] = UUID.randomUUID().toString()
            queueMessagingTemplate.convertAndSend(SQS_QUEUE_NAME, message, headers)
            println("[SQS enqueued topic: $SQS_QUEUE_NAME, message: $message")
        } catch (e: Exception) {
            println("[SQS failed topic: $SQS_QUEUE_NAME, message: $message")
            throw RuntimeException(e)
        }
    }
}