package com.turbopuffer.api.errors

import com.turbopuffer.api.core.http.Headers

class PermissionDeniedException(headers: Headers, body: String, error: TurbopufferError) :
    TurbopufferServiceException(403, headers, body, error)
