// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services.blocking

import com.turbopuffer.core.ClientOptions
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.RequestOptions
import com.turbopuffer.core.handlers.errorHandler
import com.turbopuffer.core.handlers.jsonHandler
import com.turbopuffer.core.handlers.withErrorHandler
import com.turbopuffer.core.http.HttpMethod
import com.turbopuffer.core.http.HttpRequest
import com.turbopuffer.core.http.HttpResponse.Handler
import com.turbopuffer.core.http.HttpResponseFor
import com.turbopuffer.core.http.json
import com.turbopuffer.core.http.parseable
import com.turbopuffer.core.prepare
import com.turbopuffer.models.namespaces.DocumentRowWithScore
import com.turbopuffer.models.namespaces.NamespaceDeleteAllParams
import com.turbopuffer.models.namespaces.NamespaceDeleteAllResponse
import com.turbopuffer.models.namespaces.NamespaceGetSchemaParams
import com.turbopuffer.models.namespaces.NamespaceGetSchemaResponse
import com.turbopuffer.models.namespaces.NamespaceListPage
import com.turbopuffer.models.namespaces.NamespaceListPageResponse
import com.turbopuffer.models.namespaces.NamespaceListParams
import com.turbopuffer.models.namespaces.NamespaceQueryParams
import com.turbopuffer.models.namespaces.NamespaceWriteParams
import com.turbopuffer.models.namespaces.NamespaceWriteResponse

class NamespaceServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    NamespaceService {

    private val withRawResponse: NamespaceService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): NamespaceService.WithRawResponse = withRawResponse

    override fun list(
        params: NamespaceListParams,
        requestOptions: RequestOptions,
    ): NamespaceListPage =
        // get /v1/namespaces
        withRawResponse().list(params, requestOptions).parse()

    override fun deleteAll(
        params: NamespaceDeleteAllParams,
        requestOptions: RequestOptions,
    ): NamespaceDeleteAllResponse =
        // delete /v1/namespaces/{namespace}
        withRawResponse().deleteAll(params, requestOptions).parse()

    override fun getSchema(
        params: NamespaceGetSchemaParams,
        requestOptions: RequestOptions,
    ): NamespaceGetSchemaResponse =
        // get /v1/namespaces/{namespace}/schema
        withRawResponse().getSchema(params, requestOptions).parse()

    override fun query(
        params: NamespaceQueryParams,
        requestOptions: RequestOptions,
    ): List<DocumentRowWithScore> =
        // post /v1/namespaces/{namespace}/query
        withRawResponse().query(params, requestOptions).parse()

    override fun write(
        params: NamespaceWriteParams,
        requestOptions: RequestOptions,
    ): NamespaceWriteResponse =
        // post /v2/namespaces/{namespace}
        withRawResponse().write(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        NamespaceService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val listHandler: Handler<NamespaceListPageResponse> =
            jsonHandler<NamespaceListPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: NamespaceListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "namespaces")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        NamespaceListPage.builder()
                            .service(NamespaceServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteAllHandler: Handler<NamespaceDeleteAllResponse> =
            jsonHandler<NamespaceDeleteAllResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun deleteAll(
            params: NamespaceDeleteAllParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceDeleteAllResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "namespaces", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { deleteAllHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getSchemaHandler: Handler<NamespaceGetSchemaResponse> =
            jsonHandler<NamespaceGetSchemaResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getSchema(
            params: NamespaceGetSchemaParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceGetSchemaResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "namespaces", params._pathParam(0), "schema")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { getSchemaHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val queryHandler: Handler<List<DocumentRowWithScore>> =
            jsonHandler<List<DocumentRowWithScore>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun query(
            params: NamespaceQueryParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<DocumentRowWithScore>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "namespaces", params._pathParam(0), "query")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { queryHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
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
        ): HttpResponseFor<NamespaceWriteResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v2", "namespaces", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
