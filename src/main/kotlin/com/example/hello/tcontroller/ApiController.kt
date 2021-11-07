package com.example.hello.tcontroller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ApiController {

    @GetMapping("/hello")
    fun hello(): String{
        return "hello spring boot"
    }
}
