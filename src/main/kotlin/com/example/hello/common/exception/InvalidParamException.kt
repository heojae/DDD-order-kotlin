package com.example.hello.common.exception

import com.example.hello.common.response.ErrorCode

class InvalidParamException: BaseException {
    constructor():super(ErrorCode.COMMON_INVALID_PARAMETER)

    constructor(errorCode: ErrorCode):super(errorCode)

    constructor(errorMsg: String): super(errorMsg, ErrorCode.COMMON_INVALID_PARAMETER)

    constructor(message: String, errorCode: ErrorCode): super(message=message, errorCode=errorCode)
}