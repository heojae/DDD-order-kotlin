package com.example.hello.domain.notification

interface NotificationService {
    fun sendEmail(email: String, title:String, description: String): Boolean;
    fun sendKakao(phoneNo: String, description: String): Boolean;
    fun sendSms(phoneNo: String, description: String): Boolean;
}