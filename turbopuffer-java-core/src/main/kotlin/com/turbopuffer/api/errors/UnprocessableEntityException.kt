package com.turbopuffer.api.errors

import com.turbopuffer.api.core.http.Headers

class UnprocessableEntityException(headers: Headers, body: String, error: TurbopufferError) :
    TurbopufferServiceException(422, headers, body, error)
