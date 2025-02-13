package com.turbopuffer.api.errors

import com.turbopuffer.api.core.http.Headers

class InternalServerException(
    statusCode: Int,
    headers: Headers,
    body: String,
    error: TurbopufferError,
) : TurbopufferServiceException(statusCode, headers, body, error)
