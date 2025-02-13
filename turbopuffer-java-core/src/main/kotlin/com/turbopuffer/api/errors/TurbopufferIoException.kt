package com.turbopuffer.api.errors

class TurbopufferIoException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) :
    TurbopufferException(message, cause)
