package com.turbopuffer.client

import com.turbopuffer.services.async.NamespaceServiceAsync

interface NamespaceAsync : NamespaceServiceAsync {

    /** A view of [NamespaceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse : NamespaceServiceAsync.WithRawResponse {}
}
