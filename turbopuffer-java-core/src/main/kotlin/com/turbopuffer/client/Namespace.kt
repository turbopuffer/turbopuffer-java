package com.turbopuffer.client

import com.turbopuffer.services.blocking.NamespaceService

interface Namespace : NamespaceService {

    /** A view of [Namespace] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse : NamespaceService.WithRawResponse {}
}
