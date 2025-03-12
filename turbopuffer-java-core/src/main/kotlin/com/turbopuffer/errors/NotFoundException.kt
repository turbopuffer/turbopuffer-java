package com.turbopuffer.errors

import com.turbopuffer.core.http.Headers

class NotFoundException(
        headers: Headers,
        body: String,
        error: TurbopufferError,
) : TurbopufferServiceException(404, headers, body, error)
