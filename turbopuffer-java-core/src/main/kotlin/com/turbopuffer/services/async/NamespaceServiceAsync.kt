// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.turbopuffer.core.RequestOptions
import com.turbopuffer.core.http.HttpResponseFor
import com.turbopuffer.models.namespaces.NamespaceDeleteAllParams
import com.turbopuffer.models.namespaces.NamespaceDeleteAllResponse
import com.turbopuffer.models.namespaces.NamespaceExportParams
import com.turbopuffer.models.namespaces.NamespaceExportResponse
import com.turbopuffer.models.namespaces.NamespaceGetSchemaParams
import com.turbopuffer.models.namespaces.NamespaceGetSchemaResponse
import com.turbopuffer.models.namespaces.NamespaceMultiQueryParams
import com.turbopuffer.models.namespaces.NamespaceMultiQueryResponse
import com.turbopuffer.models.namespaces.NamespaceQueryParams
import com.turbopuffer.models.namespaces.NamespaceQueryResponse
import com.turbopuffer.models.namespaces.NamespaceUpdateSchemaParams
import com.turbopuffer.models.namespaces.NamespaceUpdateSchemaResponse
import com.turbopuffer.models.namespaces.NamespaceWriteParams
import com.turbopuffer.models.namespaces.NamespaceWriteResponse
import java.util.concurrent.CompletableFuture

interface NamespaceServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

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

    /** Export documents. */
    fun export(): CompletableFuture<NamespaceExportResponse> = export(NamespaceExportParams.none())

    /** @see [export] */
    fun export(
        params: NamespaceExportParams = NamespaceExportParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceExportResponse>

    /** @see [export] */
    fun export(
        params: NamespaceExportParams = NamespaceExportParams.none()
    ): CompletableFuture<NamespaceExportResponse> = export(params, RequestOptions.none())

    /** @see [export] */
    fun export(requestOptions: RequestOptions): CompletableFuture<NamespaceExportResponse> =
        export(NamespaceExportParams.none(), requestOptions)

    /** Get namespace schema. */
    fun getSchema(): CompletableFuture<NamespaceGetSchemaResponse> =
        getSchema(NamespaceGetSchemaParams.none())

    /** @see [getSchema] */
    fun getSchema(
        params: NamespaceGetSchemaParams = NamespaceGetSchemaParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceGetSchemaResponse>

    /** @see [getSchema] */
    fun getSchema(
        params: NamespaceGetSchemaParams = NamespaceGetSchemaParams.none()
    ): CompletableFuture<NamespaceGetSchemaResponse> = getSchema(params, RequestOptions.none())

    /** @see [getSchema] */
    fun getSchema(requestOptions: RequestOptions): CompletableFuture<NamespaceGetSchemaResponse> =
        getSchema(NamespaceGetSchemaParams.none(), requestOptions)

    /** Send multiple queries at once. */
    fun multiQuery(): CompletableFuture<NamespaceMultiQueryResponse> =
        multiQuery(NamespaceMultiQueryParams.none())

    /** @see [multiQuery] */
    fun multiQuery(
        params: NamespaceMultiQueryParams = NamespaceMultiQueryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceMultiQueryResponse>

    /** @see [multiQuery] */
    fun multiQuery(
        params: NamespaceMultiQueryParams = NamespaceMultiQueryParams.none()
    ): CompletableFuture<NamespaceMultiQueryResponse> = multiQuery(params, RequestOptions.none())

    /** @see [multiQuery] */
    fun multiQuery(requestOptions: RequestOptions): CompletableFuture<NamespaceMultiQueryResponse> =
        multiQuery(NamespaceMultiQueryParams.none(), requestOptions)

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
         * Returns a raw HTTP response for `delete /v2/namespaces/{namespace}`, but is otherwise the
         * same as [NamespaceServiceAsync.deleteAll].
         */
        @MustBeClosed
        fun deleteAll(): CompletableFuture<HttpResponseFor<NamespaceDeleteAllResponse>> =
            deleteAll(NamespaceDeleteAllParams.none())

        /** @see [deleteAll] */
        @MustBeClosed
        fun deleteAll(
            params: NamespaceDeleteAllParams = NamespaceDeleteAllParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteAllResponse>>

        /** @see [deleteAll] */
        @MustBeClosed
        fun deleteAll(
            params: NamespaceDeleteAllParams = NamespaceDeleteAllParams.none()
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteAllResponse>> =
            deleteAll(params, RequestOptions.none())

        /** @see [deleteAll] */
        @MustBeClosed
        fun deleteAll(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteAllResponse>> =
            deleteAll(NamespaceDeleteAllParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/namespaces/{namespace}`, but is otherwise the
         * same as [NamespaceServiceAsync.export].
         */
        @MustBeClosed
        fun export(): CompletableFuture<HttpResponseFor<NamespaceExportResponse>> =
            export(NamespaceExportParams.none())

        /** @see [export] */
        @MustBeClosed
        fun export(
            params: NamespaceExportParams = NamespaceExportParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceExportResponse>>

        /** @see [export] */
        @MustBeClosed
        fun export(
            params: NamespaceExportParams = NamespaceExportParams.none()
        ): CompletableFuture<HttpResponseFor<NamespaceExportResponse>> =
            export(params, RequestOptions.none())

        /** @see [export] */
        @MustBeClosed
        fun export(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<NamespaceExportResponse>> =
            export(NamespaceExportParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/namespaces/{namespace}/schema`, but is otherwise
         * the same as [NamespaceServiceAsync.getSchema].
         */
        @MustBeClosed
        fun getSchema(): CompletableFuture<HttpResponseFor<NamespaceGetSchemaResponse>> =
            getSchema(NamespaceGetSchemaParams.none())

        /** @see [getSchema] */
        @MustBeClosed
        fun getSchema(
            params: NamespaceGetSchemaParams = NamespaceGetSchemaParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceGetSchemaResponse>>

        /** @see [getSchema] */
        @MustBeClosed
        fun getSchema(
            params: NamespaceGetSchemaParams = NamespaceGetSchemaParams.none()
        ): CompletableFuture<HttpResponseFor<NamespaceGetSchemaResponse>> =
            getSchema(params, RequestOptions.none())

        /** @see [getSchema] */
        @MustBeClosed
        fun getSchema(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<NamespaceGetSchemaResponse>> =
            getSchema(NamespaceGetSchemaParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v2/namespaces/{namespace}/query?overload=multi`,
         * but is otherwise the same as [NamespaceServiceAsync.multiQuery].
         */
        @MustBeClosed
        fun multiQuery(): CompletableFuture<HttpResponseFor<NamespaceMultiQueryResponse>> =
            multiQuery(NamespaceMultiQueryParams.none())

        /** @see [multiQuery] */
        @MustBeClosed
        fun multiQuery(
            params: NamespaceMultiQueryParams = NamespaceMultiQueryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceMultiQueryResponse>>

        /** @see [multiQuery] */
        @MustBeClosed
        fun multiQuery(
            params: NamespaceMultiQueryParams = NamespaceMultiQueryParams.none()
        ): CompletableFuture<HttpResponseFor<NamespaceMultiQueryResponse>> =
            multiQuery(params, RequestOptions.none())

        /** @see [multiQuery] */
        @MustBeClosed
        fun multiQuery(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<NamespaceMultiQueryResponse>> =
            multiQuery(NamespaceMultiQueryParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v2/namespaces/{namespace}/query`, but is otherwise
         * the same as [NamespaceServiceAsync.query].
         */
        @MustBeClosed
        fun query(): CompletableFuture<HttpResponseFor<NamespaceQueryResponse>> =
            query(NamespaceQueryParams.none())

        /** @see [query] */
        @MustBeClosed
        fun query(
            params: NamespaceQueryParams = NamespaceQueryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceQueryResponse>>

        /** @see [query] */
        @MustBeClosed
        fun query(
            params: NamespaceQueryParams = NamespaceQueryParams.none()
        ): CompletableFuture<HttpResponseFor<NamespaceQueryResponse>> =
            query(params, RequestOptions.none())

        /** @see [query] */
        @MustBeClosed
        fun query(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<NamespaceQueryResponse>> =
            query(NamespaceQueryParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/namespaces/{namespace}/schema`, but is
         * otherwise the same as [NamespaceServiceAsync.updateSchema].
         */
        @MustBeClosed
        fun updateSchema(): CompletableFuture<HttpResponseFor<NamespaceUpdateSchemaResponse>> =
            updateSchema(NamespaceUpdateSchemaParams.none())

        /** @see [updateSchema] */
        @MustBeClosed
        fun updateSchema(
            params: NamespaceUpdateSchemaParams = NamespaceUpdateSchemaParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceUpdateSchemaResponse>>

        /** @see [updateSchema] */
        @MustBeClosed
        fun updateSchema(
            params: NamespaceUpdateSchemaParams = NamespaceUpdateSchemaParams.none()
        ): CompletableFuture<HttpResponseFor<NamespaceUpdateSchemaResponse>> =
            updateSchema(params, RequestOptions.none())

        /** @see [updateSchema] */
        @MustBeClosed
        fun updateSchema(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<NamespaceUpdateSchemaResponse>> =
            updateSchema(NamespaceUpdateSchemaParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v2/namespaces/{namespace}`, but is otherwise the
         * same as [NamespaceServiceAsync.write].
         */
        @MustBeClosed
        fun write(): CompletableFuture<HttpResponseFor<NamespaceWriteResponse>> =
            write(NamespaceWriteParams.none())

        /** @see [write] */
        @MustBeClosed
        fun write(
            params: NamespaceWriteParams = NamespaceWriteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceWriteResponse>>

        /** @see [write] */
        @MustBeClosed
        fun write(
            params: NamespaceWriteParams = NamespaceWriteParams.none()
        ): CompletableFuture<HttpResponseFor<NamespaceWriteResponse>> =
            write(params, RequestOptions.none())

        /** @see [write] */
        @MustBeClosed
        fun write(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<NamespaceWriteResponse>> =
            write(NamespaceWriteParams.none(), requestOptions)
    }
}
