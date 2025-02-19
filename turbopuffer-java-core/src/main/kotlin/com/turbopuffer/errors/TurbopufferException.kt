package com.turbopuffer.errors

open class TurbopufferException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
