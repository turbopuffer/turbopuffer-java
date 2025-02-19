package com.turbopuffer.api.errors

import com.turbopuffer.api.core.http.Headers

class UnauthorizedException(headers: Headers, body: String, error: TurbopufferError) :
    TurbopufferServiceException(401, headers, body, error)
