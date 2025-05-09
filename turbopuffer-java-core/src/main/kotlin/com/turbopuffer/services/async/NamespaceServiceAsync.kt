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
import com.turbopuffer.models.namespaces.NamespaceWriteParams
import com.turbopuffer.models.namespaces.NamespaceWriteResponse
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
    fun deleteAll(namespace: String): CompletableFuture<NamespaceDeleteAllResponse> =
        deleteAll(namespace, NamespaceDeleteAllParams.none())

    /** @see [deleteAll] */
    fun deleteAll(
        namespace: String,
        params: NamespaceDeleteAllParams = NamespaceDeleteAllParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceDeleteAllResponse> =
        deleteAll(params.toBuilder().namespace(namespace).build(), requestOptions)

    /** @see [deleteAll] */
    fun deleteAll(
        namespace: String,
        params: NamespaceDeleteAllParams = NamespaceDeleteAllParams.none(),
    ): CompletableFuture<NamespaceDeleteAllResponse> =
        deleteAll(namespace, params, RequestOptions.none())

    /** @see [deleteAll] */
    fun deleteAll(
        params: NamespaceDeleteAllParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceDeleteAllResponse>

    /** @see [deleteAll] */
    fun deleteAll(params: NamespaceDeleteAllParams): CompletableFuture<NamespaceDeleteAllResponse> =
        deleteAll(params, RequestOptions.none())

    /** @see [deleteAll] */
    fun deleteAll(
        namespace: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<NamespaceDeleteAllResponse> =
        deleteAll(namespace, NamespaceDeleteAllParams.none(), requestOptions)

    /** Get namespace schema. */
    fun getSchema(namespace: String): CompletableFuture<NamespaceGetSchemaResponse> =
        getSchema(namespace, NamespaceGetSchemaParams.none())

    /** @see [getSchema] */
    fun getSchema(
        namespace: String,
        params: NamespaceGetSchemaParams = NamespaceGetSchemaParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceGetSchemaResponse> =
        getSchema(params.toBuilder().namespace(namespace).build(), requestOptions)

    /** @see [getSchema] */
    fun getSchema(
        namespace: String,
        params: NamespaceGetSchemaParams = NamespaceGetSchemaParams.none(),
    ): CompletableFuture<NamespaceGetSchemaResponse> =
        getSchema(namespace, params, RequestOptions.none())

    /** @see [getSchema] */
    fun getSchema(
        params: NamespaceGetSchemaParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceGetSchemaResponse>

    /** @see [getSchema] */
    fun getSchema(params: NamespaceGetSchemaParams): CompletableFuture<NamespaceGetSchemaResponse> =
        getSchema(params, RequestOptions.none())

    /** @see [getSchema] */
    fun getSchema(
        namespace: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<NamespaceGetSchemaResponse> =
        getSchema(namespace, NamespaceGetSchemaParams.none(), requestOptions)

    /** Query, filter, full-text search and vector search documents. */
    fun query(namespace: String): CompletableFuture<List<DocumentRowWithScore>> =
        query(namespace, NamespaceQueryParams.none())

    /** @see [query] */
    fun query(
        namespace: String,
        params: NamespaceQueryParams = NamespaceQueryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<DocumentRowWithScore>> =
        query(params.toBuilder().namespace(namespace).build(), requestOptions)

    /** @see [query] */
    fun query(
        namespace: String,
        params: NamespaceQueryParams = NamespaceQueryParams.none(),
    ): CompletableFuture<List<DocumentRowWithScore>> =
        query(namespace, params, RequestOptions.none())

    /** @see [query] */
    fun query(
        params: NamespaceQueryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<DocumentRowWithScore>>

    /** @see [query] */
    fun query(params: NamespaceQueryParams): CompletableFuture<List<DocumentRowWithScore>> =
        query(params, RequestOptions.none())

    /** @see [query] */
    fun query(
        namespace: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<DocumentRowWithScore>> =
        query(namespace, NamespaceQueryParams.none(), requestOptions)

    /** Create, update, or delete documents. */
    fun write(namespace: String): CompletableFuture<NamespaceWriteResponse> =
        write(namespace, NamespaceWriteParams.none())

    /** @see [write] */
    fun write(
        namespace: String,
        params: NamespaceWriteParams = NamespaceWriteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceWriteResponse> =
        write(params.toBuilder().namespace(namespace).build(), requestOptions)

    /** @see [write] */
    fun write(
        namespace: String,
        params: NamespaceWriteParams = NamespaceWriteParams.none(),
    ): CompletableFuture<NamespaceWriteResponse> = write(namespace, params, RequestOptions.none())

    /** @see [write] */
    fun write(
        params: NamespaceWriteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceWriteResponse>

    /** @see [write] */
    fun write(params: NamespaceWriteParams): CompletableFuture<NamespaceWriteResponse> =
        write(params, RequestOptions.none())

    /** @see [write] */
    fun write(
        namespace: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<NamespaceWriteResponse> =
        write(namespace, NamespaceWriteParams.none(), requestOptions)

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
         * Returns a raw HTTP response for `delete /v2/namespaces/{namespace}`, but is otherwise the
         * same as [NamespaceServiceAsync.deleteAll].
         */
        @MustBeClosed
        fun deleteAll(
            namespace: String
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteAllResponse>> =
            deleteAll(namespace, NamespaceDeleteAllParams.none())

        /** @see [deleteAll] */
        @MustBeClosed
        fun deleteAll(
            namespace: String,
            params: NamespaceDeleteAllParams = NamespaceDeleteAllParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteAllResponse>> =
            deleteAll(params.toBuilder().namespace(namespace).build(), requestOptions)

        /** @see [deleteAll] */
        @MustBeClosed
        fun deleteAll(
            namespace: String,
            params: NamespaceDeleteAllParams = NamespaceDeleteAllParams.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteAllResponse>> =
            deleteAll(namespace, params, RequestOptions.none())

        /** @see [deleteAll] */
        @MustBeClosed
        fun deleteAll(
            params: NamespaceDeleteAllParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteAllResponse>>

        /** @see [deleteAll] */
        @MustBeClosed
        fun deleteAll(
            params: NamespaceDeleteAllParams
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteAllResponse>> =
            deleteAll(params, RequestOptions.none())

        /** @see [deleteAll] */
        @MustBeClosed
        fun deleteAll(
            namespace: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteAllResponse>> =
            deleteAll(namespace, NamespaceDeleteAllParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/namespaces/{namespace}/schema`, but is otherwise
         * the same as [NamespaceServiceAsync.getSchema].
         */
        @MustBeClosed
        fun getSchema(
            namespace: String
        ): CompletableFuture<HttpResponseFor<NamespaceGetSchemaResponse>> =
            getSchema(namespace, NamespaceGetSchemaParams.none())

        /** @see [getSchema] */
        @MustBeClosed
        fun getSchema(
            namespace: String,
            params: NamespaceGetSchemaParams = NamespaceGetSchemaParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceGetSchemaResponse>> =
            getSchema(params.toBuilder().namespace(namespace).build(), requestOptions)

        /** @see [getSchema] */
        @MustBeClosed
        fun getSchema(
            namespace: String,
            params: NamespaceGetSchemaParams = NamespaceGetSchemaParams.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceGetSchemaResponse>> =
            getSchema(namespace, params, RequestOptions.none())

        /** @see [getSchema] */
        @MustBeClosed
        fun getSchema(
            params: NamespaceGetSchemaParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceGetSchemaResponse>>

        /** @see [getSchema] */
        @MustBeClosed
        fun getSchema(
            params: NamespaceGetSchemaParams
        ): CompletableFuture<HttpResponseFor<NamespaceGetSchemaResponse>> =
            getSchema(params, RequestOptions.none())

        /** @see [getSchema] */
        @MustBeClosed
        fun getSchema(
            namespace: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamespaceGetSchemaResponse>> =
            getSchema(namespace, NamespaceGetSchemaParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/namespaces/{namespace}/query`, but is otherwise
         * the same as [NamespaceServiceAsync.query].
         */
        @MustBeClosed
        fun query(
            namespace: String
        ): CompletableFuture<HttpResponseFor<List<DocumentRowWithScore>>> =
            query(namespace, NamespaceQueryParams.none())

        /** @see [query] */
        @MustBeClosed
        fun query(
            namespace: String,
            params: NamespaceQueryParams = NamespaceQueryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<DocumentRowWithScore>>> =
            query(params.toBuilder().namespace(namespace).build(), requestOptions)

        /** @see [query] */
        @MustBeClosed
        fun query(
            namespace: String,
            params: NamespaceQueryParams = NamespaceQueryParams.none(),
        ): CompletableFuture<HttpResponseFor<List<DocumentRowWithScore>>> =
            query(namespace, params, RequestOptions.none())

        /** @see [query] */
        @MustBeClosed
        fun query(
            params: NamespaceQueryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<DocumentRowWithScore>>>

        /** @see [query] */
        @MustBeClosed
        fun query(
            params: NamespaceQueryParams
        ): CompletableFuture<HttpResponseFor<List<DocumentRowWithScore>>> =
            query(params, RequestOptions.none())

        /** @see [query] */
        @MustBeClosed
        fun query(
            namespace: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<DocumentRowWithScore>>> =
            query(namespace, NamespaceQueryParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v2/namespaces/{namespace}`, but is otherwise the
         * same as [NamespaceServiceAsync.write].
         */
        @MustBeClosed
        fun write(namespace: String): CompletableFuture<HttpResponseFor<NamespaceWriteResponse>> =
            write(namespace, NamespaceWriteParams.none())

        /** @see [write] */
        @MustBeClosed
        fun write(
            namespace: String,
            params: NamespaceWriteParams = NamespaceWriteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceWriteResponse>> =
            write(params.toBuilder().namespace(namespace).build(), requestOptions)

        /** @see [write] */
        @MustBeClosed
        fun write(
            namespace: String,
            params: NamespaceWriteParams = NamespaceWriteParams.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceWriteResponse>> =
            write(namespace, params, RequestOptions.none())

        /** @see [write] */
        @MustBeClosed
        fun write(
            params: NamespaceWriteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceWriteResponse>>

        /** @see [write] */
        @MustBeClosed
        fun write(
            params: NamespaceWriteParams
        ): CompletableFuture<HttpResponseFor<NamespaceWriteResponse>> =
            write(params, RequestOptions.none())

        /** @see [write] */
        @MustBeClosed
        fun write(
            namespace: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamespaceWriteResponse>> =
            write(namespace, NamespaceWriteParams.none(), requestOptions)
    }
}
