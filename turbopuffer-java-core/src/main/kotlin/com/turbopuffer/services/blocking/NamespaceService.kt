// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.turbopuffer.core.ClientOptions
import com.turbopuffer.core.RequestOptions
import com.turbopuffer.core.http.HttpResponseFor
import com.turbopuffer.models.namespaces.NamespaceDeleteAllParams
import com.turbopuffer.models.namespaces.NamespaceDeleteAllResponse
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

interface NamespaceService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): NamespaceService

    /** Returns the ID of the namespace. */
    fun id(): String

    /** Delete namespace. */
    fun deleteAll(): NamespaceDeleteAllResponse = deleteAll(NamespaceDeleteAllParams.none())

    /** @see [deleteAll] */
    fun deleteAll(
        params: NamespaceDeleteAllParams = NamespaceDeleteAllParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceDeleteAllResponse

    /** @see [deleteAll] */
    fun deleteAll(
        params: NamespaceDeleteAllParams = NamespaceDeleteAllParams.none()
    ): NamespaceDeleteAllResponse = deleteAll(params, RequestOptions.none())

    /** @see [deleteAll] */
    fun deleteAll(requestOptions: RequestOptions): NamespaceDeleteAllResponse =
        deleteAll(NamespaceDeleteAllParams.none(), requestOptions)

    /** Warm the cache for a namespace. */
    fun hintCacheWarm(): NamespaceHintCacheWarmResponse =
        hintCacheWarm(NamespaceHintCacheWarmParams.none())

    /** @see [hintCacheWarm] */
    fun hintCacheWarm(
        params: NamespaceHintCacheWarmParams = NamespaceHintCacheWarmParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceHintCacheWarmResponse

    /** @see [hintCacheWarm] */
    fun hintCacheWarm(
        params: NamespaceHintCacheWarmParams = NamespaceHintCacheWarmParams.none()
    ): NamespaceHintCacheWarmResponse = hintCacheWarm(params, RequestOptions.none())

    /** @see [hintCacheWarm] */
    fun hintCacheWarm(requestOptions: RequestOptions): NamespaceHintCacheWarmResponse =
        hintCacheWarm(NamespaceHintCacheWarmParams.none(), requestOptions)

    /** Get metadata about a namespace. */
    fun metadata(): NamespaceMetadata = metadata(NamespaceMetadataParams.none())

    /** @see [metadata] */
    fun metadata(
        params: NamespaceMetadataParams = NamespaceMetadataParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceMetadata

    /** @see [metadata] */
    fun metadata(
        params: NamespaceMetadataParams = NamespaceMetadataParams.none()
    ): NamespaceMetadata = metadata(params, RequestOptions.none())

    /** @see [metadata] */
    fun metadata(requestOptions: RequestOptions): NamespaceMetadata =
        metadata(NamespaceMetadataParams.none(), requestOptions)

    /** Issue multiple concurrent queries filter or search documents. */
    fun multiQuery(params: NamespaceMultiQueryParams): NamespaceMultiQueryResponse =
        multiQuery(params, RequestOptions.none())

    /** @see [multiQuery] */
    fun multiQuery(
        params: NamespaceMultiQueryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceMultiQueryResponse

    /** Query, filter, full-text search and vector search documents. */
    fun query(): NamespaceQueryResponse = query(NamespaceQueryParams.none())

    /** @see [query] */
    fun query(
        params: NamespaceQueryParams = NamespaceQueryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceQueryResponse

    /** @see [query] */
    fun query(params: NamespaceQueryParams = NamespaceQueryParams.none()): NamespaceQueryResponse =
        query(params, RequestOptions.none())

    /** @see [query] */
    fun query(requestOptions: RequestOptions): NamespaceQueryResponse =
        query(NamespaceQueryParams.none(), requestOptions)

    /** Evaluate recall. */
    fun recall(): NamespaceRecallResponse = recall(NamespaceRecallParams.none())

    /** @see [recall] */
    fun recall(
        params: NamespaceRecallParams = NamespaceRecallParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceRecallResponse

    /** @see [recall] */
    fun recall(
        params: NamespaceRecallParams = NamespaceRecallParams.none()
    ): NamespaceRecallResponse = recall(params, RequestOptions.none())

    /** @see [recall] */
    fun recall(requestOptions: RequestOptions): NamespaceRecallResponse =
        recall(NamespaceRecallParams.none(), requestOptions)

    /** Get namespace schema. */
    fun schema(): NamespaceSchemaResponse = schema(NamespaceSchemaParams.none())

    /** @see [schema] */
    fun schema(
        params: NamespaceSchemaParams = NamespaceSchemaParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceSchemaResponse

    /** @see [schema] */
    fun schema(
        params: NamespaceSchemaParams = NamespaceSchemaParams.none()
    ): NamespaceSchemaResponse = schema(params, RequestOptions.none())

    /** @see [schema] */
    fun schema(requestOptions: RequestOptions): NamespaceSchemaResponse =
        schema(NamespaceSchemaParams.none(), requestOptions)

    /** Update namespace schema. */
    fun updateSchema(): NamespaceUpdateSchemaResponse =
        updateSchema(NamespaceUpdateSchemaParams.none())

    /** @see [updateSchema] */
    fun updateSchema(
        params: NamespaceUpdateSchemaParams = NamespaceUpdateSchemaParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceUpdateSchemaResponse

    /** @see [updateSchema] */
    fun updateSchema(
        params: NamespaceUpdateSchemaParams = NamespaceUpdateSchemaParams.none()
    ): NamespaceUpdateSchemaResponse = updateSchema(params, RequestOptions.none())

    /** @see [updateSchema] */
    fun updateSchema(requestOptions: RequestOptions): NamespaceUpdateSchemaResponse =
        updateSchema(NamespaceUpdateSchemaParams.none(), requestOptions)

    /** Create, update, or delete documents. */
    fun write(): NamespaceWriteResponse = write(NamespaceWriteParams.none())

    /** @see [write] */
    fun write(
        params: NamespaceWriteParams = NamespaceWriteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceWriteResponse

    /** @see [write] */
    fun write(params: NamespaceWriteParams = NamespaceWriteParams.none()): NamespaceWriteResponse =
        write(params, RequestOptions.none())

    /** @see [write] */
    fun write(requestOptions: RequestOptions): NamespaceWriteResponse =
        write(NamespaceWriteParams.none(), requestOptions)

    /** A view of [NamespaceService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): NamespaceService.WithRawResponse

        /** Returns the ID of the namespace. */
        fun id(): String

        /**
         * Returns a raw HTTP response for `delete /v2/namespaces/{namespace}`, but is otherwise the
         * same as [NamespaceService.deleteAll].
         */
        @MustBeClosed
        fun deleteAll(): HttpResponseFor<NamespaceDeleteAllResponse> =
            deleteAll(NamespaceDeleteAllParams.none())

        /** @see [deleteAll] */
        @MustBeClosed
        fun deleteAll(
            params: NamespaceDeleteAllParams = NamespaceDeleteAllParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceDeleteAllResponse>

        /** @see [deleteAll] */
        @MustBeClosed
        fun deleteAll(
            params: NamespaceDeleteAllParams = NamespaceDeleteAllParams.none()
        ): HttpResponseFor<NamespaceDeleteAllResponse> = deleteAll(params, RequestOptions.none())

        /** @see [deleteAll] */
        @MustBeClosed
        fun deleteAll(requestOptions: RequestOptions): HttpResponseFor<NamespaceDeleteAllResponse> =
            deleteAll(NamespaceDeleteAllParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/namespaces/{namespace}/hint_cache_warm`, but is
         * otherwise the same as [NamespaceService.hintCacheWarm].
         */
        @MustBeClosed
        fun hintCacheWarm(): HttpResponseFor<NamespaceHintCacheWarmResponse> =
            hintCacheWarm(NamespaceHintCacheWarmParams.none())

        /** @see [hintCacheWarm] */
        @MustBeClosed
        fun hintCacheWarm(
            params: NamespaceHintCacheWarmParams = NamespaceHintCacheWarmParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceHintCacheWarmResponse>

        /** @see [hintCacheWarm] */
        @MustBeClosed
        fun hintCacheWarm(
            params: NamespaceHintCacheWarmParams = NamespaceHintCacheWarmParams.none()
        ): HttpResponseFor<NamespaceHintCacheWarmResponse> =
            hintCacheWarm(params, RequestOptions.none())

        /** @see [hintCacheWarm] */
        @MustBeClosed
        fun hintCacheWarm(
            requestOptions: RequestOptions
        ): HttpResponseFor<NamespaceHintCacheWarmResponse> =
            hintCacheWarm(NamespaceHintCacheWarmParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/namespaces/{namespace}/metadata`, but is
         * otherwise the same as [NamespaceService.metadata].
         */
        @MustBeClosed
        fun metadata(): HttpResponseFor<NamespaceMetadata> =
            metadata(NamespaceMetadataParams.none())

        /** @see [metadata] */
        @MustBeClosed
        fun metadata(
            params: NamespaceMetadataParams = NamespaceMetadataParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceMetadata>

        /** @see [metadata] */
        @MustBeClosed
        fun metadata(
            params: NamespaceMetadataParams = NamespaceMetadataParams.none()
        ): HttpResponseFor<NamespaceMetadata> = metadata(params, RequestOptions.none())

        /** @see [metadata] */
        @MustBeClosed
        fun metadata(requestOptions: RequestOptions): HttpResponseFor<NamespaceMetadata> =
            metadata(NamespaceMetadataParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /v2/namespaces/{namespace}/query?stainless_overload=multiQuery`, but is otherwise the
         * same as [NamespaceService.multiQuery].
         */
        @MustBeClosed
        fun multiQuery(
            params: NamespaceMultiQueryParams
        ): HttpResponseFor<NamespaceMultiQueryResponse> = multiQuery(params, RequestOptions.none())

        /** @see [multiQuery] */
        @MustBeClosed
        fun multiQuery(
            params: NamespaceMultiQueryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceMultiQueryResponse>

        /**
         * Returns a raw HTTP response for `post /v2/namespaces/{namespace}/query`, but is otherwise
         * the same as [NamespaceService.query].
         */
        @MustBeClosed
        fun query(): HttpResponseFor<NamespaceQueryResponse> = query(NamespaceQueryParams.none())

        /** @see [query] */
        @MustBeClosed
        fun query(
            params: NamespaceQueryParams = NamespaceQueryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceQueryResponse>

        /** @see [query] */
        @MustBeClosed
        fun query(
            params: NamespaceQueryParams = NamespaceQueryParams.none()
        ): HttpResponseFor<NamespaceQueryResponse> = query(params, RequestOptions.none())

        /** @see [query] */
        @MustBeClosed
        fun query(requestOptions: RequestOptions): HttpResponseFor<NamespaceQueryResponse> =
            query(NamespaceQueryParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/namespaces/{namespace}/_debug/recall`, but is
         * otherwise the same as [NamespaceService.recall].
         */
        @MustBeClosed
        fun recall(): HttpResponseFor<NamespaceRecallResponse> =
            recall(NamespaceRecallParams.none())

        /** @see [recall] */
        @MustBeClosed
        fun recall(
            params: NamespaceRecallParams = NamespaceRecallParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceRecallResponse>

        /** @see [recall] */
        @MustBeClosed
        fun recall(
            params: NamespaceRecallParams = NamespaceRecallParams.none()
        ): HttpResponseFor<NamespaceRecallResponse> = recall(params, RequestOptions.none())

        /** @see [recall] */
        @MustBeClosed
        fun recall(requestOptions: RequestOptions): HttpResponseFor<NamespaceRecallResponse> =
            recall(NamespaceRecallParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/namespaces/{namespace}/schema`, but is otherwise
         * the same as [NamespaceService.schema].
         */
        @MustBeClosed
        fun schema(): HttpResponseFor<NamespaceSchemaResponse> =
            schema(NamespaceSchemaParams.none())

        /** @see [schema] */
        @MustBeClosed
        fun schema(
            params: NamespaceSchemaParams = NamespaceSchemaParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceSchemaResponse>

        /** @see [schema] */
        @MustBeClosed
        fun schema(
            params: NamespaceSchemaParams = NamespaceSchemaParams.none()
        ): HttpResponseFor<NamespaceSchemaResponse> = schema(params, RequestOptions.none())

        /** @see [schema] */
        @MustBeClosed
        fun schema(requestOptions: RequestOptions): HttpResponseFor<NamespaceSchemaResponse> =
            schema(NamespaceSchemaParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/namespaces/{namespace}/schema`, but is
         * otherwise the same as [NamespaceService.updateSchema].
         */
        @MustBeClosed
        fun updateSchema(): HttpResponseFor<NamespaceUpdateSchemaResponse> =
            updateSchema(NamespaceUpdateSchemaParams.none())

        /** @see [updateSchema] */
        @MustBeClosed
        fun updateSchema(
            params: NamespaceUpdateSchemaParams = NamespaceUpdateSchemaParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceUpdateSchemaResponse>

        /** @see [updateSchema] */
        @MustBeClosed
        fun updateSchema(
            params: NamespaceUpdateSchemaParams = NamespaceUpdateSchemaParams.none()
        ): HttpResponseFor<NamespaceUpdateSchemaResponse> =
            updateSchema(params, RequestOptions.none())

        /** @see [updateSchema] */
        @MustBeClosed
        fun updateSchema(
            requestOptions: RequestOptions
        ): HttpResponseFor<NamespaceUpdateSchemaResponse> =
            updateSchema(NamespaceUpdateSchemaParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v2/namespaces/{namespace}`, but is otherwise the
         * same as [NamespaceService.write].
         */
        @MustBeClosed
        fun write(): HttpResponseFor<NamespaceWriteResponse> = write(NamespaceWriteParams.none())

        /** @see [write] */
        @MustBeClosed
        fun write(
            params: NamespaceWriteParams = NamespaceWriteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceWriteResponse>

        /** @see [write] */
        @MustBeClosed
        fun write(
            params: NamespaceWriteParams = NamespaceWriteParams.none()
        ): HttpResponseFor<NamespaceWriteResponse> = write(params, RequestOptions.none())

        /** @see [write] */
        @MustBeClosed
        fun write(requestOptions: RequestOptions): HttpResponseFor<NamespaceWriteResponse> =
            write(NamespaceWriteParams.none(), requestOptions)
    }
}
