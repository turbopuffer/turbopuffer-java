// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.client

import com.turbopuffer.core.ClientOptions
import com.turbopuffer.core.getPackageVersion
import com.turbopuffer.services.blocking.NamespaceService
import com.turbopuffer.services.blocking.NamespaceServiceImpl

class TurbopufferClientImpl(
    private val clientOptions: ClientOptions,

) : TurbopufferClient {

    private val clientOptionsWithUserAgent =

      if (clientOptions.headers.names().contains("User-Agent")) clientOptions

      else clientOptions.toBuilder().putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}").build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: TurbopufferClientAsync by lazy { TurbopufferClientAsyncImpl(clientOptions) }

    private val withRawResponse: TurbopufferClient.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    private val namespaces: NamespaceService by lazy { NamespaceServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): TurbopufferClientAsync = async

    override fun withRawResponse(): TurbopufferClient.WithRawResponse = withRawResponse

    override fun namespaces(): NamespaceService = namespaces

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : TurbopufferClient.WithRawResponse {

        private val namespaces: NamespaceService.WithRawResponse by lazy { NamespaceServiceImpl.WithRawResponseImpl(clientOptions) }

        override fun namespaces(): NamespaceService.WithRawResponse = namespaces
    }
}
