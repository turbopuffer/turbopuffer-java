package com.turbopuffer.errors

import com.turbopuffer.core.http.Headers

class UnexpectedStatusCodeException(
    statusCode: Int,
    headers: Headers,
    body: String,
    error: TurbopufferError,
) : TurbopufferServiceException(statusCode, headers, body, error)
