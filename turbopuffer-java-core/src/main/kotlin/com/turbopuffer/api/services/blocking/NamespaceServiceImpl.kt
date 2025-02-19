// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.services.blocking

import com.turbopuffer.api.core.ClientOptions
import com.turbopuffer.api.core.RequestOptions
import com.turbopuffer.api.core.handlers.errorHandler
import com.turbopuffer.api.core.handlers.jsonHandler
import com.turbopuffer.api.core.handlers.withErrorHandler
import com.turbopuffer.api.core.http.HttpMethod
import com.turbopuffer.api.core.http.HttpRequest
import com.turbopuffer.api.core.http.HttpResponse.Handler
import com.turbopuffer.api.core.json
import com.turbopuffer.api.core.prepare
import com.turbopuffer.api.errors.TurbopufferError
import com.turbopuffer.api.models.DocumentRow
import com.turbopuffer.api.models.NamespaceDeleteAllParams
import com.turbopuffer.api.models.NamespaceDeleteAllResponse
import com.turbopuffer.api.models.NamespaceGetSchemaParams
import com.turbopuffer.api.models.NamespaceGetSchemaResponse
import com.turbopuffer.api.models.NamespaceListPage
import com.turbopuffer.api.models.NamespaceListParams
import com.turbopuffer.api.models.NamespaceQueryParams
import com.turbopuffer.api.models.NamespaceUpsertParams
import com.turbopuffer.api.models.NamespaceUpsertResponse

class NamespaceServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    NamespaceService {

    private val errorHandler: Handler<TurbopufferError> = errorHandler(clientOptions.jsonMapper)

    private val listHandler: Handler<NamespaceListPage.Response> =
        jsonHandler<NamespaceListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List namespaces. */
    override fun list(
        params: NamespaceListParams,
        requestOptions: RequestOptions,
    ): NamespaceListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("v1", "namespaces")
                .build()
                .prepare(clientOptions, params)
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .use { listHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
                }
            }
            .let { NamespaceListPage.of(this, params, it) }
    }

    private val deleteAllHandler: Handler<NamespaceDeleteAllResponse> =
        jsonHandler<NamespaceDeleteAllResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Delete namespace. */
    override fun deleteAll(
        params: NamespaceDeleteAllParams,
        requestOptions: RequestOptions,
    ): NamespaceDeleteAllResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("v1", "namespaces", params.getPathParam(0))
                .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
                .prepare(clientOptions, params)
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .use { deleteAllHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
                }
            }
    }

    private val getSchemaHandler: Handler<NamespaceGetSchemaResponse> =
        jsonHandler<NamespaceGetSchemaResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Get namespace schema. */
    override fun getSchema(
        params: NamespaceGetSchemaParams,
        requestOptions: RequestOptions,
    ): NamespaceGetSchemaResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("v1", "namespaces", params.getPathParam(0), "schema")
                .build()
                .prepare(clientOptions, params)
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .use { getSchemaHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
                }
            }
    }

    private val queryHandler: Handler<List<DocumentRow>> =
        jsonHandler<List<DocumentRow>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Query, filter, full-text search and vector search documents. */
    override fun query(
        params: NamespaceQueryParams,
        requestOptions: RequestOptions,
    ): List<DocumentRow> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("v1", "namespaces", params.getPathParam(0), "query")
                .body(json(clientOptions.jsonMapper, params._body()))
                .build()
                .prepare(clientOptions, params)
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .use { queryHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.forEach { it.validate() }
                }
            }
    }

    private val upsertHandler: Handler<NamespaceUpsertResponse> =
        jsonHandler<NamespaceUpsertResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Create, update, or delete documents. */
    override fun upsert(
        params: NamespaceUpsertParams,
        requestOptions: RequestOptions,
    ): NamespaceUpsertResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("v1", "namespaces", params.getPathParam(0))
                .body(json(clientOptions.jsonMapper, params._body()))
                .build()
                .prepare(clientOptions, params)
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .use { upsertHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
                }
            }
    }
}
