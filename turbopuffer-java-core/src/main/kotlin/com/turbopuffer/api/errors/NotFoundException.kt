package com.turbopuffer.api.errors

import com.turbopuffer.api.core.http.Headers

class NotFoundException(headers: Headers, body: String, error: TurbopufferError) :
    TurbopufferServiceException(404, headers, body, error)
