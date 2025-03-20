// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.errors

import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.http.Headers

abstract class TurbopufferServiceException
protected constructor(message: String, cause: Throwable? = null) :
    TurbopufferException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
