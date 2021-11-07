package com.example.hello.common.exception

import com.example.hello.common.response.ErrorCode

class IllegalStatusException: BaseException {
    constructor(): super(ErrorCode.COMMON_ILLEGAL_STATUS)

    constructor(message:String): super(message, ErrorCode.COMMON_ILLEGAL_STATUS)
}