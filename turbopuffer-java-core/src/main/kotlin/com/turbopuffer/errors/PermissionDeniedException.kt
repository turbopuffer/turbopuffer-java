package com.turbopuffer.errors

import com.turbopuffer.core.http.Headers

class PermissionDeniedException(headers: Headers, body: String, error: TurbopufferError) :
    TurbopufferServiceException(403, headers, body, error)
