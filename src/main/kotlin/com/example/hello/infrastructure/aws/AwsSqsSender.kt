package com.example.hello.infrastructure.aws


import com.amazonaws.services.sqs.AmazonSQSAsync
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class AwsSqsSender(
    private val amazonSQSAsync: AmazonSQSAsync
) {
    @Bean
    fun queueMessagingTemplate(): QueueMessagingTemplate {
        return QueueMessagingTemplate(amazonSQSAsync)
    }
}