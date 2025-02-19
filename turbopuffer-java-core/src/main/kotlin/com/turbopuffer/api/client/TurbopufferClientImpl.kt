// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.client

import com.turbopuffer.api.core.ClientOptions
import com.turbopuffer.api.core.getPackageVersion
import com.turbopuffer.api.services.blocking.NamespaceService
import com.turbopuffer.api.services.blocking.NamespaceServiceImpl

class TurbopufferClientImpl(private val clientOptions: ClientOptions) : TurbopufferClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: TurbopufferClientAsync by lazy { TurbopufferClientAsyncImpl(clientOptions) }

    private val namespaces: NamespaceService by lazy {
        NamespaceServiceImpl(clientOptionsWithUserAgent)
    }

    override fun async(): TurbopufferClientAsync = async

    override fun namespaces(): NamespaceService = namespaces

    override fun close() = clientOptions.httpClient.close()
}
