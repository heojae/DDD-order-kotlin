package com.example.hello.common.exception

import com.example.hello.common.response.ErrorCode

class EntityNotFoundException: BaseException {
    constructor():super(ErrorCode.COMMON_INVALID_PARAMETER){}

    constructor(message: String):super(message=message, ErrorCode.COMMON_INVALID_PARAMETER){}
}