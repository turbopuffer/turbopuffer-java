package com.turbopuffer.errors

import com.turbopuffer.core.http.Headers

class UnauthorizedException(headers: Headers, body: String, error: TurbopufferError) :
    TurbopufferServiceException(401, headers, body, error)
