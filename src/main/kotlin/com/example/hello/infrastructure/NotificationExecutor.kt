package com.example.hello.infrastructure

import com.example.hello.domain.notification.NotificationService
import org.springframework.stereotype.Service

@Service
class NotificationExecutor : NotificationService {
    override fun sendEmail(email: String, title: String, description: String): Boolean {
        println("send sendEmail");
        return true
    }

    override fun sendKakao(phoneNo: String, description: String): Boolean {
        println("send sendKakao");
        return true
    }

    override fun sendSms(phoneNo: String, description: String): Boolean {
        println("send sendSms");
        return true
    }

}