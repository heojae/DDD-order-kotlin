package com.example.hello.common.response

import kotlinx.serialization.Serializable

@Serializable
data class CommonResponse<T>(
    private val result: Result? = null,
    private val data: T? = null,
    private val message: String? = null,
    private val errorCode: String? = null
) {


    enum class Result {
        SUCCESS, FAIL
    }

    companion object {
        fun <T> success(data: T, message: String?): CommonResponse<T> {
            return CommonResponse(
                result = Result.SUCCESS,
                data = data,
                message = message
            )
        }

        fun <T> success(data: T): CommonResponse<T> {
            return success(data, null)
        }

        fun fail(message: String?, errorCode: String?): CommonResponse<String> {
            return CommonResponse(
                result = Result.FAIL,
                message = message,
                errorCode = errorCode
            )
        }

        fun fail(errorCode: ErrorCode): CommonResponse<String> {
            return CommonResponse(
                result = Result.FAIL,
                message=errorCode.getErrorMsg(),
                errorCode = errorCode.name
            )
        }
    }
}