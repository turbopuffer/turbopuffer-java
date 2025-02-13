package com.turbopuffer.api.errors

import com.turbopuffer.api.core.http.Headers

class RateLimitException(
    headers: Headers,
    body: String,
    error: TurbopufferError,
) : TurbopufferServiceException(429, headers, body, error)
