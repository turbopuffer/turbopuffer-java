// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.client

import com.turbopuffer.core.ClientOptions
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.RequestOptions
import com.turbopuffer.core.getPackageVersion
import com.turbopuffer.core.handlers.errorHandler
import com.turbopuffer.core.handlers.jsonHandler
import com.turbopuffer.core.handlers.withErrorHandler
import com.turbopuffer.core.http.HttpMethod
import com.turbopuffer.core.http.HttpRequest
import com.turbopuffer.core.http.HttpResponse.Handler
import com.turbopuffer.core.http.HttpResponseFor
import com.turbopuffer.core.http.parseable
import com.turbopuffer.core.prepareAsync
import com.turbopuffer.models.ClientNamespacesPageAsync
import com.turbopuffer.models.ClientNamespacesPageResponse
import com.turbopuffer.models.ClientNamespacesParams
import com.turbopuffer.services.async.NamespaceServiceAsync
import com.turbopuffer.services.async.NamespaceServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

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

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): TurbopufferClientAsync =
        TurbopufferClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun namespaces(): NamespaceServiceAsync = namespaces

    override fun namespaces(
        params: ClientNamespacesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ClientNamespacesPageAsync> =
        // get /v1/namespaces
        withRawResponse().namespaces(params, requestOptions).thenApply { it.parse() }

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TurbopufferClientAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val namespaces: NamespaceServiceAsync.WithRawResponse by lazy {
            NamespaceServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TurbopufferClientAsync.WithRawResponse =
            TurbopufferClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun namespaces(): NamespaceServiceAsync.WithRawResponse = namespaces

        private val namespacesHandler: Handler<ClientNamespacesPageResponse> =
            jsonHandler<ClientNamespacesPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun namespaces(
            params: ClientNamespacesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ClientNamespacesPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "namespaces")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { namespacesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                ClientNamespacesPageAsync.builder()
                                    .service(TurbopufferClientAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }
    }
}
