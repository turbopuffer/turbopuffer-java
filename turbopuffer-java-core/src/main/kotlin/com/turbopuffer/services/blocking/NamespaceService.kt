// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.turbopuffer.core.RequestOptions
import com.turbopuffer.core.http.HttpResponseFor
import com.turbopuffer.models.namespaces.NamespaceDeleteAllParams
import com.turbopuffer.models.namespaces.NamespaceDeleteAllResponse
import com.turbopuffer.models.namespaces.NamespaceGetSchemaParams
import com.turbopuffer.models.namespaces.NamespaceGetSchemaResponse
import com.turbopuffer.models.namespaces.NamespaceMultiQueryParams
import com.turbopuffer.models.namespaces.NamespaceMultiQueryResponse
import com.turbopuffer.models.namespaces.NamespaceQueryParams
import com.turbopuffer.models.namespaces.NamespaceQueryResponse
import com.turbopuffer.models.namespaces.NamespaceWriteParams
import com.turbopuffer.models.namespaces.NamespaceWriteResponse

interface NamespaceService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

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

    /** Get namespace schema. */
    fun getSchema(): NamespaceGetSchemaResponse = getSchema(NamespaceGetSchemaParams.none())

    /** @see [getSchema] */
    fun getSchema(
        params: NamespaceGetSchemaParams = NamespaceGetSchemaParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceGetSchemaResponse

    /** @see [getSchema] */
    fun getSchema(
        params: NamespaceGetSchemaParams = NamespaceGetSchemaParams.none()
    ): NamespaceGetSchemaResponse = getSchema(params, RequestOptions.none())

    /** @see [getSchema] */
    fun getSchema(requestOptions: RequestOptions): NamespaceGetSchemaResponse =
        getSchema(NamespaceGetSchemaParams.none(), requestOptions)

    /** Send multiple queries at once. */
    fun multiQuery(): NamespaceMultiQueryResponse = multiQuery(NamespaceMultiQueryParams.none())

    /** @see [multiQuery] */
    fun multiQuery(
        params: NamespaceMultiQueryParams = NamespaceMultiQueryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceMultiQueryResponse

    /** @see [multiQuery] */
    fun multiQuery(
        params: NamespaceMultiQueryParams = NamespaceMultiQueryParams.none()
    ): NamespaceMultiQueryResponse = multiQuery(params, RequestOptions.none())

    /** @see [multiQuery] */
    fun multiQuery(requestOptions: RequestOptions): NamespaceMultiQueryResponse =
        multiQuery(NamespaceMultiQueryParams.none(), requestOptions)

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
         * Returns a raw HTTP response for `get /v1/namespaces/{namespace}/schema`, but is otherwise
         * the same as [NamespaceService.getSchema].
         */
        @MustBeClosed
        fun getSchema(): HttpResponseFor<NamespaceGetSchemaResponse> =
            getSchema(NamespaceGetSchemaParams.none())

        /** @see [getSchema] */
        @MustBeClosed
        fun getSchema(
            params: NamespaceGetSchemaParams = NamespaceGetSchemaParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceGetSchemaResponse>

        /** @see [getSchema] */
        @MustBeClosed
        fun getSchema(
            params: NamespaceGetSchemaParams = NamespaceGetSchemaParams.none()
        ): HttpResponseFor<NamespaceGetSchemaResponse> = getSchema(params, RequestOptions.none())

        /** @see [getSchema] */
        @MustBeClosed
        fun getSchema(requestOptions: RequestOptions): HttpResponseFor<NamespaceGetSchemaResponse> =
            getSchema(NamespaceGetSchemaParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v2/namespaces/{namespace}/query?overload=multi`,
         * but is otherwise the same as [NamespaceService.multiQuery].
         */
        @MustBeClosed
        fun multiQuery(): HttpResponseFor<NamespaceMultiQueryResponse> =
            multiQuery(NamespaceMultiQueryParams.none())

        /** @see [multiQuery] */
        @MustBeClosed
        fun multiQuery(
            params: NamespaceMultiQueryParams = NamespaceMultiQueryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceMultiQueryResponse>

        /** @see [multiQuery] */
        @MustBeClosed
        fun multiQuery(
            params: NamespaceMultiQueryParams = NamespaceMultiQueryParams.none()
        ): HttpResponseFor<NamespaceMultiQueryResponse> = multiQuery(params, RequestOptions.none())

        /** @see [multiQuery] */
        @MustBeClosed
        fun multiQuery(
            requestOptions: RequestOptions
        ): HttpResponseFor<NamespaceMultiQueryResponse> =
            multiQuery(NamespaceMultiQueryParams.none(), requestOptions)

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
