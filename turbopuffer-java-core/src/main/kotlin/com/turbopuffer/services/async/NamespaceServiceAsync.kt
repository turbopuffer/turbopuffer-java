// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services.async

import com.turbopuffer.core.ClientOptions
import com.turbopuffer.core.RequestOptions
import com.turbopuffer.core.http.HttpResponseFor
import com.turbopuffer.models.namespaces.NamespaceDeleteAllParams
import com.turbopuffer.models.namespaces.NamespaceDeleteAllResponse
import com.turbopuffer.models.namespaces.NamespaceHintCacheWarmParams
import com.turbopuffer.models.namespaces.NamespaceHintCacheWarmResponse
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
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface NamespaceServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): NamespaceServiceAsync

    /** Delete namespace. */
    fun deleteAll(): CompletableFuture<NamespaceDeleteAllResponse> =
        deleteAll(NamespaceDeleteAllParams.none())

    /** @see [deleteAll] */
    fun deleteAll(
        params: NamespaceDeleteAllParams = NamespaceDeleteAllParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceDeleteAllResponse>

    /** @see [deleteAll] */
    fun deleteAll(
        params: NamespaceDeleteAllParams = NamespaceDeleteAllParams.none()
    ): CompletableFuture<NamespaceDeleteAllResponse> = deleteAll(params, RequestOptions.none())

    /** @see [deleteAll] */
    fun deleteAll(requestOptions: RequestOptions): CompletableFuture<NamespaceDeleteAllResponse> =
        deleteAll(NamespaceDeleteAllParams.none(), requestOptions)

    /** Warm the cache for a namespace. */
    fun hintCacheWarm(): CompletableFuture<NamespaceHintCacheWarmResponse> =
        hintCacheWarm(NamespaceHintCacheWarmParams.none())

    /** @see [hintCacheWarm] */
    fun hintCacheWarm(
        params: NamespaceHintCacheWarmParams = NamespaceHintCacheWarmParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceHintCacheWarmResponse>

    /** @see [hintCacheWarm] */
    fun hintCacheWarm(
        params: NamespaceHintCacheWarmParams = NamespaceHintCacheWarmParams.none()
    ): CompletableFuture<NamespaceHintCacheWarmResponse> =
        hintCacheWarm(params, RequestOptions.none())

    /** @see [hintCacheWarm] */
    fun hintCacheWarm(
        requestOptions: RequestOptions
    ): CompletableFuture<NamespaceHintCacheWarmResponse> =
        hintCacheWarm(NamespaceHintCacheWarmParams.none(), requestOptions)

    /** Issue multiple concurrent queries filter or search documents. */
    fun multiQuery(
        params: NamespaceMultiQueryParams
    ): CompletableFuture<NamespaceMultiQueryResponse> = multiQuery(params, RequestOptions.none())

    /** @see [multiQuery] */
    fun multiQuery(
        params: NamespaceMultiQueryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceMultiQueryResponse>

    /** Query, filter, full-text search and vector search documents. */
    fun query(): CompletableFuture<NamespaceQueryResponse> = query(NamespaceQueryParams.none())

    /** @see [query] */
    fun query(
        params: NamespaceQueryParams = NamespaceQueryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceQueryResponse>

    /** @see [query] */
    fun query(
        params: NamespaceQueryParams = NamespaceQueryParams.none()
    ): CompletableFuture<NamespaceQueryResponse> = query(params, RequestOptions.none())

    /** @see [query] */
    fun query(requestOptions: RequestOptions): CompletableFuture<NamespaceQueryResponse> =
        query(NamespaceQueryParams.none(), requestOptions)

    /** Evaluate recall. */
    fun recall(): CompletableFuture<NamespaceRecallResponse> = recall(NamespaceRecallParams.none())

    /** @see [recall] */
    fun recall(
        params: NamespaceRecallParams = NamespaceRecallParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceRecallResponse>

    /** @see [recall] */
    fun recall(
        params: NamespaceRecallParams = NamespaceRecallParams.none()
    ): CompletableFuture<NamespaceRecallResponse> = recall(params, RequestOptions.none())

    /** @see [recall] */
    fun recall(requestOptions: RequestOptions): CompletableFuture<NamespaceRecallResponse> =
        recall(NamespaceRecallParams.none(), requestOptions)

    /** Get namespace schema. */
    fun schema(): CompletableFuture<NamespaceSchemaResponse> = schema(NamespaceSchemaParams.none())

    /** @see [schema] */
    fun schema(
        params: NamespaceSchemaParams = NamespaceSchemaParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceSchemaResponse>

    /** @see [schema] */
    fun schema(
        params: NamespaceSchemaParams = NamespaceSchemaParams.none()
    ): CompletableFuture<NamespaceSchemaResponse> = schema(params, RequestOptions.none())

    /** @see [schema] */
    fun schema(requestOptions: RequestOptions): CompletableFuture<NamespaceSchemaResponse> =
        schema(NamespaceSchemaParams.none(), requestOptions)

    /** Update namespace schema. */
    fun updateSchema(): CompletableFuture<NamespaceUpdateSchemaResponse> =
        updateSchema(NamespaceUpdateSchemaParams.none())

    /** @see [updateSchema] */
    fun updateSchema(
        params: NamespaceUpdateSchemaParams = NamespaceUpdateSchemaParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceUpdateSchemaResponse>

    /** @see [updateSchema] */
    fun updateSchema(
        params: NamespaceUpdateSchemaParams = NamespaceUpdateSchemaParams.none()
    ): CompletableFuture<NamespaceUpdateSchemaResponse> =
        updateSchema(params, RequestOptions.none())

    /** @see [updateSchema] */
    fun updateSchema(
        requestOptions: RequestOptions
    ): CompletableFuture<NamespaceUpdateSchemaResponse> =
        updateSchema(NamespaceUpdateSchemaParams.none(), requestOptions)

    /** Create, update, or delete documents. */
    fun write(): CompletableFuture<NamespaceWriteResponse> = write(NamespaceWriteParams.none())

    /** @see [write] */
    fun write(
        params: NamespaceWriteParams = NamespaceWriteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceWriteResponse>

    /** @see [write] */
    fun write(
        params: NamespaceWriteParams = NamespaceWriteParams.none()
    ): CompletableFuture<NamespaceWriteResponse> = write(params, RequestOptions.none())

    /** @see [write] */
    fun write(requestOptions: RequestOptions): CompletableFuture<NamespaceWriteResponse> =
        write(NamespaceWriteParams.none(), requestOptions)

    /**
     * A view of [NamespaceServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): NamespaceServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `delete /v2/namespaces/{namespace}`, but is otherwise the
         * same as [NamespaceServiceAsync.deleteAll].
         */
        fun deleteAll(): CompletableFuture<HttpResponseFor<NamespaceDeleteAllResponse>> =
            deleteAll(NamespaceDeleteAllParams.none())

        /** @see [deleteAll] */
        fun deleteAll(
            params: NamespaceDeleteAllParams = NamespaceDeleteAllParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteAllResponse>>

        /** @see [deleteAll] */
        fun deleteAll(
            params: NamespaceDeleteAllParams = NamespaceDeleteAllParams.none()
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteAllResponse>> =
            deleteAll(params, RequestOptions.none())

        /** @see [deleteAll] */
        fun deleteAll(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteAllResponse>> =
            deleteAll(NamespaceDeleteAllParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/namespaces/{namespace}/hint_cache_warm`, but is
         * otherwise the same as [NamespaceServiceAsync.hintCacheWarm].
         */
        fun hintCacheWarm(): CompletableFuture<HttpResponseFor<NamespaceHintCacheWarmResponse>> =
            hintCacheWarm(NamespaceHintCacheWarmParams.none())

        /** @see [hintCacheWarm] */
        fun hintCacheWarm(
            params: NamespaceHintCacheWarmParams = NamespaceHintCacheWarmParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceHintCacheWarmResponse>>

        /** @see [hintCacheWarm] */
        fun hintCacheWarm(
            params: NamespaceHintCacheWarmParams = NamespaceHintCacheWarmParams.none()
        ): CompletableFuture<HttpResponseFor<NamespaceHintCacheWarmResponse>> =
            hintCacheWarm(params, RequestOptions.none())

        /** @see [hintCacheWarm] */
        fun hintCacheWarm(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<NamespaceHintCacheWarmResponse>> =
            hintCacheWarm(NamespaceHintCacheWarmParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /v2/namespaces/{namespace}/query?stainless_overload=multiQuery`, but is otherwise the
         * same as [NamespaceServiceAsync.multiQuery].
         */
        fun multiQuery(
            params: NamespaceMultiQueryParams
        ): CompletableFuture<HttpResponseFor<NamespaceMultiQueryResponse>> =
            multiQuery(params, RequestOptions.none())

        /** @see [multiQuery] */
        fun multiQuery(
            params: NamespaceMultiQueryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceMultiQueryResponse>>

        /**
         * Returns a raw HTTP response for `post /v2/namespaces/{namespace}/query`, but is otherwise
         * the same as [NamespaceServiceAsync.query].
         */
        fun query(): CompletableFuture<HttpResponseFor<NamespaceQueryResponse>> =
            query(NamespaceQueryParams.none())

        /** @see [query] */
        fun query(
            params: NamespaceQueryParams = NamespaceQueryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceQueryResponse>>

        /** @see [query] */
        fun query(
            params: NamespaceQueryParams = NamespaceQueryParams.none()
        ): CompletableFuture<HttpResponseFor<NamespaceQueryResponse>> =
            query(params, RequestOptions.none())

        /** @see [query] */
        fun query(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<NamespaceQueryResponse>> =
            query(NamespaceQueryParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/namespaces/{namespace}/_debug/recall`, but is
         * otherwise the same as [NamespaceServiceAsync.recall].
         */
        fun recall(): CompletableFuture<HttpResponseFor<NamespaceRecallResponse>> =
            recall(NamespaceRecallParams.none())

        /** @see [recall] */
        fun recall(
            params: NamespaceRecallParams = NamespaceRecallParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceRecallResponse>>

        /** @see [recall] */
        fun recall(
            params: NamespaceRecallParams = NamespaceRecallParams.none()
        ): CompletableFuture<HttpResponseFor<NamespaceRecallResponse>> =
            recall(params, RequestOptions.none())

        /** @see [recall] */
        fun recall(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<NamespaceRecallResponse>> =
            recall(NamespaceRecallParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/namespaces/{namespace}/schema`, but is otherwise
         * the same as [NamespaceServiceAsync.schema].
         */
        fun schema(): CompletableFuture<HttpResponseFor<NamespaceSchemaResponse>> =
            schema(NamespaceSchemaParams.none())

        /** @see [schema] */
        fun schema(
            params: NamespaceSchemaParams = NamespaceSchemaParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceSchemaResponse>>

        /** @see [schema] */
        fun schema(
            params: NamespaceSchemaParams = NamespaceSchemaParams.none()
        ): CompletableFuture<HttpResponseFor<NamespaceSchemaResponse>> =
            schema(params, RequestOptions.none())

        /** @see [schema] */
        fun schema(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<NamespaceSchemaResponse>> =
            schema(NamespaceSchemaParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/namespaces/{namespace}/schema`, but is
         * otherwise the same as [NamespaceServiceAsync.updateSchema].
         */
        fun updateSchema(): CompletableFuture<HttpResponseFor<NamespaceUpdateSchemaResponse>> =
            updateSchema(NamespaceUpdateSchemaParams.none())

        /** @see [updateSchema] */
        fun updateSchema(
            params: NamespaceUpdateSchemaParams = NamespaceUpdateSchemaParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceUpdateSchemaResponse>>

        /** @see [updateSchema] */
        fun updateSchema(
            params: NamespaceUpdateSchemaParams = NamespaceUpdateSchemaParams.none()
        ): CompletableFuture<HttpResponseFor<NamespaceUpdateSchemaResponse>> =
            updateSchema(params, RequestOptions.none())

        /** @see [updateSchema] */
        fun updateSchema(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<NamespaceUpdateSchemaResponse>> =
            updateSchema(NamespaceUpdateSchemaParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v2/namespaces/{namespace}`, but is otherwise the
         * same as [NamespaceServiceAsync.write].
         */
        fun write(): CompletableFuture<HttpResponseFor<NamespaceWriteResponse>> =
            write(NamespaceWriteParams.none())

        /** @see [write] */
        fun write(
            params: NamespaceWriteParams = NamespaceWriteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceWriteResponse>>

        /** @see [write] */
        fun write(
            params: NamespaceWriteParams = NamespaceWriteParams.none()
        ): CompletableFuture<HttpResponseFor<NamespaceWriteResponse>> =
            write(params, RequestOptions.none())

        /** @see [write] */
        fun write(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<NamespaceWriteResponse>> =
            write(NamespaceWriteParams.none(), requestOptions)
    }
}
