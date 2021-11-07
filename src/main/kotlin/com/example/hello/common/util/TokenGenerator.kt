package com.example.hello.common.util

import org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric

object TokenGenerator {
    private val TOKEN_LENGTH: Int = 20

    fun randomCharacter(length: Int): String {
        return randomAlphanumeric(length)
    }

    fun randomCharacterWithPrefix(prefix: String): String {
        return prefix + this.randomCharacter(TOKEN_LENGTH - prefix.length)
    }

}
