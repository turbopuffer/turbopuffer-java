// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.client

import com.turbopuffer.core.ClientOptions
import com.turbopuffer.core.RequestOptions
import com.turbopuffer.core.getPackageVersion
import com.turbopuffer.core.handlers.errorBodyHandler
import com.turbopuffer.core.handlers.errorHandler
import com.turbopuffer.core.handlers.jsonHandler
import com.turbopuffer.core.http.HttpMethod
import com.turbopuffer.core.http.HttpRequest
import com.turbopuffer.core.http.HttpResponse
import com.turbopuffer.core.http.HttpResponse.Handler
import com.turbopuffer.core.http.HttpResponseFor
import com.turbopuffer.core.http.parseable
import com.turbopuffer.core.prepare
import com.turbopuffer.models.ClientNamespacesPage
import com.turbopuffer.models.ClientNamespacesPageResponse
import com.turbopuffer.models.ClientNamespacesParams
import com.turbopuffer.services.blocking.NamespaceServiceImpl
import java.util.function.Consumer

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

    private val withRawResponse: TurbopufferClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun async(): TurbopufferClientAsync = async

    override fun withRawResponse(): TurbopufferClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): TurbopufferClient =
        TurbopufferClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun namespace(namespace: String): Namespace =
        NamespaceServiceImpl(
            clientOptionsWithUserAgent.toBuilder().defaultNamespace(namespace).build()
        )

    override fun namespaces(
        params: ClientNamespacesParams,
        requestOptions: RequestOptions,
    ): ClientNamespacesPage =
        // get /v1/namespaces
        withRawResponse().namespaces(params, requestOptions).parse()

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TurbopufferClient.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TurbopufferClient.WithRawResponse =
            TurbopufferClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun namespace(namespace: String): Namespace.WithRawResponse =
            NamespaceServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().defaultNamespace(namespace).build()
            )

        private val namespacesHandler: Handler<ClientNamespacesPageResponse> =
            jsonHandler<ClientNamespacesPageResponse>(clientOptions.jsonMapper)

        override fun namespaces(
            params: ClientNamespacesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ClientNamespacesPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "namespaces")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { namespacesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        ClientNamespacesPage.builder()
                            .service(TurbopufferClientImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
