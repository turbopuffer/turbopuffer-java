// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services.async

import com.turbopuffer.core.ClientOptions
import com.turbopuffer.core.RequestOptions
import com.turbopuffer.core.handlers.errorHandler
import com.turbopuffer.core.handlers.jsonHandler
import com.turbopuffer.core.handlers.withErrorHandler
import com.turbopuffer.core.http.HttpMethod
import com.turbopuffer.core.http.HttpRequest
import com.turbopuffer.core.http.HttpResponse.Handler
import com.turbopuffer.core.json
import com.turbopuffer.core.prepareAsync
import com.turbopuffer.errors.TurbopufferError
import com.turbopuffer.models.NamespaceDeleteAllParams
import com.turbopuffer.models.NamespaceDeleteAllResponse
import com.turbopuffer.models.NamespaceGetSchemaParams
import com.turbopuffer.models.NamespaceGetSchemaResponse
import com.turbopuffer.models.NamespaceListPageAsync
import com.turbopuffer.models.NamespaceListParams
import com.turbopuffer.models.NamespaceQueryParams
import com.turbopuffer.models.NamespaceUpsertParams
import com.turbopuffer.models.NamespaceUpsertResponse
import java.util.concurrent.CompletableFuture

class NamespaceServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    NamespaceServiceAsync {

    private val errorHandler: Handler<TurbopufferError> = errorHandler(clientOptions.jsonMapper)

    private val listHandler: Handler<NamespaceListPageAsync.Response> =
        jsonHandler<NamespaceListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List namespaces */
    override fun list(
        params: NamespaceListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<NamespaceListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("v1", "namespaces")
                .build()
                .prepareAsync(clientOptions, params)
        return request
            .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
            .thenApply { response ->
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                            it.validate()
                        }
                    }
                    .let { NamespaceListPageAsync.of(this, params, it) }
            }
    }

    private val deleteAllHandler: Handler<NamespaceDeleteAllResponse> =
        jsonHandler<NamespaceDeleteAllResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Delete namespace */
    override fun deleteAll(
        params: NamespaceDeleteAllParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<NamespaceDeleteAllResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("v1", "namespaces", params.getPathParam(0))
                .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
                .prepareAsync(clientOptions, params)
        return request
            .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
            .thenApply { response ->
                response
                    .use { deleteAllHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                            it.validate()
                        }
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
    ): CompletableFuture<NamespaceGetSchemaResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("v1", "namespaces", params.getPathParam(0), "schema")
                .build()
                .prepareAsync(clientOptions, params)
        return request
            .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
            .thenApply { response ->
                response
                    .use { getSchemaHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                            it.validate()
                        }
                    }
            }
    }

    private val queryHandler: Handler<List<DocumentRowResponse>> =
        jsonHandler<List<DocumentRowResponse>>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    override fun query(
        params: NamespaceQueryParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<DocumentRowResponse>> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("v1", "namespaces", params.getPathParam(0), "query")
                .body(json(clientOptions.jsonMapper, params._body()))
                .build()
                .prepareAsync(clientOptions, params)
        return request
            .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
            .thenApply { response ->
                response
                    .use { queryHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                            it.forEach { it.validate() }
                        }
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
    ): CompletableFuture<NamespaceUpsertResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("v1", "namespaces", params.getPathParam(0))
                .body(json(clientOptions.jsonMapper, params._body()))
                .build()
                .prepareAsync(clientOptions, params)
        return request
            .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
            .thenApply { response ->
                response
                    .use { upsertHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                            it.validate()
                        }
                    }
            }
    }
}
