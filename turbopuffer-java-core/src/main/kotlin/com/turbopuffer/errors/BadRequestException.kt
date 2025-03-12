package com.turbopuffer.errors

import com.turbopuffer.core.http.Headers

class BadRequestException(
        headers: Headers,
        body: String,
        error: TurbopufferError,
) : TurbopufferServiceException(400, headers, body, error)
