package com.turbopuffer.errors

import com.turbopuffer.core.http.Headers

class RateLimitException(
        headers: Headers,
        body: String,
        error: TurbopufferError,
) : TurbopufferServiceException(429, headers, body, error)
