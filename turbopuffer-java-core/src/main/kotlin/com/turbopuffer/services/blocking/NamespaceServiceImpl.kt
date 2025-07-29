// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services.blocking

import com.turbopuffer.core.ClientOptions
import com.turbopuffer.core.RequestOptions
import com.turbopuffer.core.checkRequired
import com.turbopuffer.core.handlers.errorBodyHandler
import com.turbopuffer.core.handlers.errorHandler
import com.turbopuffer.core.handlers.jsonHandler
import com.turbopuffer.core.http.HttpMethod
import com.turbopuffer.core.http.HttpRequest
import com.turbopuffer.core.http.HttpResponse
import com.turbopuffer.core.http.HttpResponse.Handler
import com.turbopuffer.core.http.HttpResponseFor
import com.turbopuffer.core.http.json
import com.turbopuffer.core.http.parseable
import com.turbopuffer.core.prepare
import com.turbopuffer.models.namespaces.NamespaceDeleteAllParams
import com.turbopuffer.models.namespaces.NamespaceDeleteAllResponse
import com.turbopuffer.models.namespaces.NamespaceExplainQueryParams
import com.turbopuffer.models.namespaces.NamespaceExplainQueryResponse
import com.turbopuffer.models.namespaces.NamespaceHintCacheWarmParams
import com.turbopuffer.models.namespaces.NamespaceHintCacheWarmResponse
import com.turbopuffer.models.namespaces.NamespaceMetadata
import com.turbopuffer.models.namespaces.NamespaceMetadataParams
import com.turbopuffer.models.namespaces.NamespaceMultiQueryParams
import com.turbopuffer.models.namespaces.NamespaceMultiQueryResponse
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
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class NamespaceServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    NamespaceService {

    private val withRawResponse: NamespaceService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): NamespaceService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): NamespaceService =
        NamespaceServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun deleteAll(
        params: NamespaceDeleteAllParams,
        requestOptions: RequestOptions,
    ): NamespaceDeleteAllResponse =
        // delete /v2/namespaces/{namespace}
        withRawResponse().deleteAll(params, requestOptions).parse()

    override fun explainQuery(
        params: NamespaceExplainQueryParams,
        requestOptions: RequestOptions,
    ): NamespaceExplainQueryResponse =
        // post /v2/namespaces/{namespace}/explain_query
        withRawResponse().explainQuery(params, requestOptions).parse()

    override fun hintCacheWarm(
        params: NamespaceHintCacheWarmParams,
        requestOptions: RequestOptions,
    ): NamespaceHintCacheWarmResponse =
        // get /v1/namespaces/{namespace}/hint_cache_warm
        withRawResponse().hintCacheWarm(params, requestOptions).parse()

    override fun metadata(
        params: NamespaceMetadataParams,
        requestOptions: RequestOptions,
    ): NamespaceMetadata =
        // get /v1/namespaces/{namespace}/metadata
        withRawResponse().metadata(params, requestOptions).parse()

    override fun multiQuery(
        params: NamespaceMultiQueryParams,
        requestOptions: RequestOptions,
    ): NamespaceMultiQueryResponse =
        // post /v2/namespaces/{namespace}/query?stainless_overload=multiQuery
        withRawResponse().multiQuery(params, requestOptions).parse()

    override fun query(
        params: NamespaceQueryParams,
        requestOptions: RequestOptions,
    ): NamespaceQueryResponse =
        // post /v2/namespaces/{namespace}/query
        withRawResponse().query(params, requestOptions).parse()

    override fun recall(
        params: NamespaceRecallParams,
        requestOptions: RequestOptions,
    ): NamespaceRecallResponse =
        // post /v1/namespaces/{namespace}/_debug/recall
        withRawResponse().recall(params, requestOptions).parse()

    override fun schema(
        params: NamespaceSchemaParams,
        requestOptions: RequestOptions,
    ): NamespaceSchemaResponse =
        // get /v1/namespaces/{namespace}/schema
        withRawResponse().schema(params, requestOptions).parse()

    override fun updateSchema(
        params: NamespaceUpdateSchemaParams,
        requestOptions: RequestOptions,
    ): NamespaceUpdateSchemaResponse =
        // post /v1/namespaces/{namespace}/schema
        withRawResponse().updateSchema(params, requestOptions).parse()

    override fun write(
        params: NamespaceWriteParams,
        requestOptions: RequestOptions,
    ): NamespaceWriteResponse =
        // post /v2/namespaces/{namespace}
        withRawResponse().write(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        NamespaceService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): NamespaceService.WithRawResponse =
            NamespaceServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val deleteAllHandler: Handler<NamespaceDeleteAllResponse> =
            jsonHandler<NamespaceDeleteAllResponse>(clientOptions.jsonMapper)

        override fun deleteAll(
            params: NamespaceDeleteAllParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceDeleteAllResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deleteAllHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val explainQueryHandler: Handler<NamespaceExplainQueryResponse> =
            jsonHandler<NamespaceExplainQueryResponse>(clientOptions.jsonMapper)

        override fun explainQuery(
            params: NamespaceExplainQueryParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceExplainQueryResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v2",
                        "namespaces",
                        checkRequired(
                            "namespace",
                            params._pathParam(0).ifBlank {
                                clientOptions.defaultNamespace().getOrNull()
                            },
                        ),
                        "explain_query",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { explainQueryHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val hintCacheWarmHandler: Handler<NamespaceHintCacheWarmResponse> =
            jsonHandler<NamespaceHintCacheWarmResponse>(clientOptions.jsonMapper)

        override fun hintCacheWarm(
            params: NamespaceHintCacheWarmParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceHintCacheWarmResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { hintCacheWarmHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val metadataHandler: Handler<NamespaceMetadata> =
            jsonHandler<NamespaceMetadata>(clientOptions.jsonMapper)

        override fun metadata(
            params: NamespaceMetadataParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceMetadata> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "namespaces",
                        checkRequired(
                            "namespace",
                            params._pathParam(0).ifBlank {
                                clientOptions.defaultNamespace().getOrNull()
                            },
                        ),
                        "metadata",
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { metadataHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val multiQueryHandler: Handler<NamespaceMultiQueryResponse> =
            jsonHandler<NamespaceMultiQueryResponse>(clientOptions.jsonMapper)

        override fun multiQuery(
            params: NamespaceMultiQueryParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceMultiQueryResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
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
                    .putQueryParam("stainless_overload", "multiQuery")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { multiQueryHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val queryHandler: Handler<NamespaceQueryResponse> =
            jsonHandler<NamespaceQueryResponse>(clientOptions.jsonMapper)

        override fun query(
            params: NamespaceQueryParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceQueryResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { queryHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val recallHandler: Handler<NamespaceRecallResponse> =
            jsonHandler<NamespaceRecallResponse>(clientOptions.jsonMapper)

        override fun recall(
            params: NamespaceRecallParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceRecallResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { recallHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val schemaHandler: Handler<NamespaceSchemaResponse> =
            jsonHandler<NamespaceSchemaResponse>(clientOptions.jsonMapper)

        override fun schema(
            params: NamespaceSchemaParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceSchemaResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { schemaHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateSchemaHandler: Handler<NamespaceUpdateSchemaResponse> =
            jsonHandler<NamespaceUpdateSchemaResponse>(clientOptions.jsonMapper)

        override fun updateSchema(
            params: NamespaceUpdateSchemaParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceUpdateSchemaResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateSchemaHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val writeHandler: Handler<NamespaceWriteResponse> =
            jsonHandler<NamespaceWriteResponse>(clientOptions.jsonMapper)

        override fun write(
            params: NamespaceWriteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceWriteResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
