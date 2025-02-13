// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.client

import com.turbopuffer.api.core.ClientOptions
import com.turbopuffer.api.core.getPackageVersion
import com.turbopuffer.api.services.async.NamespaceServiceAsync
import com.turbopuffer.api.services.async.NamespaceServiceAsyncImpl

class TurbopufferClientAsyncImpl(
    private val clientOptions: ClientOptions,
) : TurbopufferClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: TurbopufferClient by lazy { TurbopufferClientImpl(clientOptions) }

    private val namespaces: NamespaceServiceAsync by lazy {
        NamespaceServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): TurbopufferClient = sync

    override fun namespaces(): NamespaceServiceAsync = namespaces

    override fun close() = clientOptions.httpClient.close()
}
