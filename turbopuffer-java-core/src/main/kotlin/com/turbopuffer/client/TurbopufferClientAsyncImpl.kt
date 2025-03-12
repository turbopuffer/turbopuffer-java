// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.client

import com.turbopuffer.core.ClientOptions
import com.turbopuffer.core.getPackageVersion
import com.turbopuffer.services.async.NamespaceServiceAsync
import com.turbopuffer.services.async.NamespaceServiceAsyncImpl

class TurbopufferClientAsyncImpl(private val clientOptions: ClientOptions) :
    TurbopufferClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: TurbopufferClient by lazy { TurbopufferClientImpl(clientOptions) }

    private val withRawResponse: TurbopufferClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val namespaces: NamespaceServiceAsync by lazy {
        NamespaceServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): TurbopufferClient = sync

    override fun withRawResponse(): TurbopufferClientAsync.WithRawResponse = withRawResponse

    override fun namespaces(): NamespaceServiceAsync = namespaces

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TurbopufferClientAsync.WithRawResponse {

        private val namespaces: NamespaceServiceAsync.WithRawResponse by lazy {
            NamespaceServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun namespaces(): NamespaceServiceAsync.WithRawResponse = namespaces
    }
}
