package com.turbopuffer.errors

import com.turbopuffer.core.http.Headers

class UnprocessableEntityException(
        headers: Headers,
        body: String,
        error: TurbopufferError,
) : TurbopufferServiceException(422, headers, body, error)
