// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services.async

import com.turbopuffer.core.ClientOptions
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.RequestOptions
import com.turbopuffer.core.checkRequired
import com.turbopuffer.core.handlers.errorHandler
import com.turbopuffer.core.handlers.jsonHandler
import com.turbopuffer.core.handlers.withErrorHandler
import com.turbopuffer.core.http.HttpMethod
import com.turbopuffer.core.http.HttpRequest
import com.turbopuffer.core.http.HttpResponse.Handler
import com.turbopuffer.core.http.HttpResponseFor
import com.turbopuffer.core.http.json
import com.turbopuffer.core.http.parseable
import com.turbopuffer.core.prepareAsync
import com.turbopuffer.models.namespaces.NamespaceDeleteAllParams
import com.turbopuffer.models.namespaces.NamespaceDeleteAllResponse
import com.turbopuffer.models.namespaces.NamespaceHintCacheWarmParams
import com.turbopuffer.models.namespaces.NamespaceHintCacheWarmResponse
import com.turbopuffer.models.namespaces.NamespaceQueryParams
import com.turbopuffer.models.namespaces.NamespaceQueryResponse
import com.turbopuffer.models.namespaces.NamespaceRecallParams
import com.turbopuffer.models.namespaces.NamespaceRecallResponse
import com.turbopuffer.models.namespaces.NamespaceSchemaParams
import com.turbopuffer.models.namespaces.NamespaceSchemaResponse
import com.turbopuffer.models.namespaces.NamespaceUpdateSchemaParams
import com.turbopuffer.models.namespaces.NamespaceUpdateSchemaResponse
import com.turbopuffer.models.namespaces.NamespaceWriteParams
import com.turbopuffer.models.namespaces.NamespaceWriteResponse
import java.util.concurrent.CompletableFuture
import kotlin.jvm.optionals.getOrNull

class NamespaceServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    NamespaceServiceAsync {

    private val withRawResponse: NamespaceServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): NamespaceServiceAsync.WithRawResponse = withRawResponse

    override fun deleteAll(
        params: NamespaceDeleteAllParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<NamespaceDeleteAllResponse> =
        // delete /v2/namespaces/{namespace}
        withRawResponse().deleteAll(params, requestOptions).thenApply { it.parse() }

    override fun hintCacheWarm(
        params: NamespaceHintCacheWarmParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<NamespaceHintCacheWarmResponse> =
        // get /v1/namespaces/{namespace}/hint_cache_warm
        withRawResponse().hintCacheWarm(params, requestOptions).thenApply { it.parse() }

    override fun query(
        params: NamespaceQueryParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<NamespaceQueryResponse> =
        // post /v2/namespaces/{namespace}/query
        withRawResponse().query(params, requestOptions).thenApply { it.parse() }

    override fun recall(
        params: NamespaceRecallParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<NamespaceRecallResponse> =
        // post /v1/namespaces/{namespace}/_debug/recall
        withRawResponse().recall(params, requestOptions).thenApply { it.parse() }

    override fun schema(
        params: NamespaceSchemaParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<NamespaceSchemaResponse> =
        // get /v1/namespaces/{namespace}/schema
        withRawResponse().schema(params, requestOptions).thenApply { it.parse() }

    override fun updateSchema(
        params: NamespaceUpdateSchemaParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<NamespaceUpdateSchemaResponse> =
        // post /v1/namespaces/{namespace}/schema
        withRawResponse().updateSchema(params, requestOptions).thenApply { it.parse() }

    override fun write(
        params: NamespaceWriteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<NamespaceWriteResponse> =
        // post /v2/namespaces/{namespace}
        withRawResponse().write(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        NamespaceServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val deleteAllHandler: Handler<NamespaceDeleteAllResponse> =
            jsonHandler<NamespaceDeleteAllResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun deleteAll(
            params: NamespaceDeleteAllParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteAllResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments(
                        "v2",
                        "namespaces",
                        checkRequired(
                            "namespace",
                            params._pathParam(0).ifBlank {
                                clientOptions.defaultNamespace().getOrNull()
                            },
                        ),
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { deleteAllHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val hintCacheWarmHandler: Handler<NamespaceHintCacheWarmResponse> =
            jsonHandler<NamespaceHintCacheWarmResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun hintCacheWarm(
            params: NamespaceHintCacheWarmParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamespaceHintCacheWarmResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "namespaces",
                        checkRequired(
                            "namespace",
                            params._pathParam(0).ifBlank {
                                clientOptions.defaultNamespace().getOrNull()
                            },
                        ),
                        "hint_cache_warm",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { hintCacheWarmHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val queryHandler: Handler<NamespaceQueryResponse> =
            jsonHandler<NamespaceQueryResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun query(
            params: NamespaceQueryParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamespaceQueryResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "v2",
                        "namespaces",
                        checkRequired(
                            "namespace",
                            params._pathParam(0).ifBlank {
                                clientOptions.defaultNamespace().getOrNull()
                            },
                        ),
                        "query",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { queryHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val recallHandler: Handler<NamespaceRecallResponse> =
            jsonHandler<NamespaceRecallResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun recall(
            params: NamespaceRecallParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamespaceRecallResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "v1",
                        "namespaces",
                        checkRequired(
                            "namespace",
                            params._pathParam(0).ifBlank {
                                clientOptions.defaultNamespace().getOrNull()
                            },
                        ),
                        "_debug",
                        "recall",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { recallHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val schemaHandler: Handler<NamespaceSchemaResponse> =
            jsonHandler<NamespaceSchemaResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun schema(
            params: NamespaceSchemaParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamespaceSchemaResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "namespaces",
                        checkRequired(
                            "namespace",
                            params._pathParam(0).ifBlank {
                                clientOptions.defaultNamespace().getOrNull()
                            },
                        ),
                        "schema",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { schemaHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val updateSchemaHandler: Handler<NamespaceUpdateSchemaResponse> =
            jsonHandler<NamespaceUpdateSchemaResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun updateSchema(
            params: NamespaceUpdateSchemaParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamespaceUpdateSchemaResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "v1",
                        "namespaces",
                        checkRequired(
                            "namespace",
                            params._pathParam(0).ifBlank {
                                clientOptions.defaultNamespace().getOrNull()
                            },
                        ),
                        "schema",
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { updateSchemaHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val writeHandler: Handler<NamespaceWriteResponse> =
            jsonHandler<NamespaceWriteResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun write(
            params: NamespaceWriteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamespaceWriteResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "v2",
                        "namespaces",
                        checkRequired(
                            "namespace",
                            params._pathParam(0).ifBlank {
                                clientOptions.defaultNamespace().getOrNull()
                            },
                        ),
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { writeHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
