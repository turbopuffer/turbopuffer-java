// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.turbopuffer.core.RequestOptions
import com.turbopuffer.core.http.HttpResponseFor
import com.turbopuffer.models.namespaces.DocumentRowWithScore
import com.turbopuffer.models.namespaces.NamespaceDeleteAllParams
import com.turbopuffer.models.namespaces.NamespaceDeleteAllResponse
import com.turbopuffer.models.namespaces.NamespaceGetSchemaParams
import com.turbopuffer.models.namespaces.NamespaceGetSchemaResponse
import com.turbopuffer.models.namespaces.NamespaceListPageAsync
import com.turbopuffer.models.namespaces.NamespaceListParams
import com.turbopuffer.models.namespaces.NamespaceQueryParams
import com.turbopuffer.models.namespaces.NamespaceUpsertParams
import com.turbopuffer.models.namespaces.NamespaceUpsertResponse
import java.util.concurrent.CompletableFuture

interface NamespaceServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** List namespaces. */
    fun list(): CompletableFuture<NamespaceListPageAsync> = list(NamespaceListParams.none())

    /** @see [list] */
    fun list(
        params: NamespaceListParams = NamespaceListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceListPageAsync>

    /** @see [list] */
    fun list(
        params: NamespaceListParams = NamespaceListParams.none()
    ): CompletableFuture<NamespaceListPageAsync> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<NamespaceListPageAsync> =
        list(NamespaceListParams.none(), requestOptions)

    /** Delete namespace. */
    fun deleteAll(params: NamespaceDeleteAllParams): CompletableFuture<NamespaceDeleteAllResponse> =
        deleteAll(params, RequestOptions.none())

    /** @see [deleteAll] */
    fun deleteAll(
        params: NamespaceDeleteAllParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceDeleteAllResponse>

    /** Get namespace schema. */
    fun getSchema(params: NamespaceGetSchemaParams): CompletableFuture<NamespaceGetSchemaResponse> =
        getSchema(params, RequestOptions.none())

    /** @see [getSchema] */
    fun getSchema(
        params: NamespaceGetSchemaParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceGetSchemaResponse>

    /** Query, filter, full-text search and vector search documents. */
    fun query(params: NamespaceQueryParams): CompletableFuture<List<DocumentRowWithScore>> =
        query(params, RequestOptions.none())

    /** @see [query] */
    fun query(
        params: NamespaceQueryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<DocumentRowWithScore>>

    /** Create, update, or delete documents. */
    fun upsert(params: NamespaceUpsertParams): CompletableFuture<NamespaceUpsertResponse> =
        upsert(params, RequestOptions.none())

    /** @see [upsert] */
    fun upsert(
        params: NamespaceUpsertParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceUpsertResponse>

    /**
     * A view of [NamespaceServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/namespaces`, but is otherwise the same as
         * [NamespaceServiceAsync.list].
         */
        @MustBeClosed
        fun list(): CompletableFuture<HttpResponseFor<NamespaceListPageAsync>> =
            list(NamespaceListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: NamespaceListParams = NamespaceListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceListPageAsync>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: NamespaceListParams = NamespaceListParams.none()
        ): CompletableFuture<HttpResponseFor<NamespaceListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<NamespaceListPageAsync>> =
            list(NamespaceListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/namespaces/{namespace}`, but is otherwise the
         * same as [NamespaceServiceAsync.deleteAll].
         */
        @MustBeClosed
        fun deleteAll(
            params: NamespaceDeleteAllParams
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteAllResponse>> =
            deleteAll(params, RequestOptions.none())

        /** @see [deleteAll] */
        @MustBeClosed
        fun deleteAll(
            params: NamespaceDeleteAllParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteAllResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/namespaces/{namespace}/schema`, but is otherwise
         * the same as [NamespaceServiceAsync.getSchema].
         */
        @MustBeClosed
        fun getSchema(
            params: NamespaceGetSchemaParams
        ): CompletableFuture<HttpResponseFor<NamespaceGetSchemaResponse>> =
            getSchema(params, RequestOptions.none())

        /** @see [getSchema] */
        @MustBeClosed
        fun getSchema(
            params: NamespaceGetSchemaParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceGetSchemaResponse>>

        /**
         * Returns a raw HTTP response for `post /v1/namespaces/{namespace}/query`, but is otherwise
         * the same as [NamespaceServiceAsync.query].
         */
        @MustBeClosed
        fun query(
            params: NamespaceQueryParams
        ): CompletableFuture<HttpResponseFor<List<DocumentRowWithScore>>> =
            query(params, RequestOptions.none())

        /** @see [query] */
        @MustBeClosed
        fun query(
            params: NamespaceQueryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<DocumentRowWithScore>>>

        /**
         * Returns a raw HTTP response for `post /v1/namespaces/{namespace}`, but is otherwise the
         * same as [NamespaceServiceAsync.upsert].
         */
        @MustBeClosed
        fun upsert(
            params: NamespaceUpsertParams
        ): CompletableFuture<HttpResponseFor<NamespaceUpsertResponse>> =
            upsert(params, RequestOptions.none())

        /** @see [upsert] */
        @MustBeClosed
        fun upsert(
            params: NamespaceUpsertParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceUpsertResponse>>
    }
}
