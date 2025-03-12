package com.turbopuffer.errors

import com.turbopuffer.core.http.Headers

abstract class TurbopufferServiceException
@JvmOverloads
constructor(
        private val statusCode: Int,
        private val headers: Headers,
        private val body: String,
        private val error: TurbopufferError,
        message: String = "$statusCode: $error",
        cause: Throwable? = null
) : TurbopufferException(message, cause) {

    fun statusCode(): Int = statusCode

    fun headers(): Headers = headers

    fun body(): String = body

    fun error(): TurbopufferError = error
}
