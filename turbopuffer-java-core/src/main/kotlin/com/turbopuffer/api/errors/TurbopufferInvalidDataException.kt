package com.turbopuffer.api.errors

class TurbopufferInvalidDataException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) :
    TurbopufferException(message, cause)
