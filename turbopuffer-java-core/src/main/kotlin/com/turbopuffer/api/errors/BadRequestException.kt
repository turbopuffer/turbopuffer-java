package com.turbopuffer.api.errors

import com.turbopuffer.api.core.http.Headers

class BadRequestException(headers: Headers, body: String, error: TurbopufferError) :
    TurbopufferServiceException(400, headers, body, error)
