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
import com.turbopuffer.api.models.NamespaceListParams
import com.turbopuffer.api.models.NamespaceQueryParams
import com.turbopuffer.api.models.NamespaceQueryResponse
import com.turbopuffer.api.models.NamespaceRetrieveParams
import com.turbopuffer.api.models.NamespaceRetrieveResponse
import com.turbopuffer.api.models.NamespaceUpsertParams
import com.turbopuffer.api.models.NamespaceUpsertResponse

class NamespaceServiceImpl
internal constructor(
    private val clientOptions: ClientOptions,
) : NamespaceService {

    private val errorHandler: Handler<TurbopufferError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<NamespaceRetrieveResponse> =
        jsonHandler<NamespaceRetrieveResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Retrieve metadata for a specific namespace. */
    override fun retrieve(
        params: NamespaceRetrieveParams,
        requestOptions: RequestOptions
    ): NamespaceRetrieveResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("v1", "namespaces", params.getPathParam(0))
                .build()
                .prepare(clientOptions, params)
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .use { retrieveHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
                }
            }
    }

    private val listHandler: Handler<List<UnnamedSchemaWithArrayParent0>> =
        jsonHandler<List<UnnamedSchemaWithArrayParent0>>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Retrieve a list of all namespaces. */
    override fun list(
        params: NamespaceListParams,
        requestOptions: RequestOptions
    ): List<UnnamedSchemaWithArrayParent0> {
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
                    it.forEach { it.validate() }
                }
            }
    }

    private val queryHandler: Handler<NamespaceQueryResponse> =
        jsonHandler<NamespaceQueryResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Searches documents in a namespace using a vector (and optionally attribute filters). Provide
     * a query vector, filters, ranking, and other parameters to retrieve matching documents.
     */
    override fun query(
        params: NamespaceQueryParams,
        requestOptions: RequestOptions
    ): NamespaceQueryResponse {
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
                    it.validate()
                }
            }
    }

    private val upsertHandler: Handler<NamespaceUpsertResponse> =
        jsonHandler<NamespaceUpsertResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /**
     * Creates, updates, or deletes documents in a namespace. Documents are upserted in a
     * column-oriented format (using `ids`, `vectors`, `attributes`, etc.) or in a row-based format
     * (using `upserts`). To delete a document, send a `null` vector.
     */
    override fun upsert(
        params: NamespaceUpsertParams,
        requestOptions: RequestOptions
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
