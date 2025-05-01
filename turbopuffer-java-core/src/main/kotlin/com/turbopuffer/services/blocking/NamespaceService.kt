// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.turbopuffer.core.RequestOptions
import com.turbopuffer.core.http.HttpResponseFor
import com.turbopuffer.models.namespaces.DocumentRowWithScore
import com.turbopuffer.models.namespaces.NamespaceDeleteAllParams
import com.turbopuffer.models.namespaces.NamespaceDeleteAllResponse
import com.turbopuffer.models.namespaces.NamespaceGetSchemaParams
import com.turbopuffer.models.namespaces.NamespaceGetSchemaResponse
import com.turbopuffer.models.namespaces.NamespaceListPage
import com.turbopuffer.models.namespaces.NamespaceListParams
import com.turbopuffer.models.namespaces.NamespaceQueryParams
import com.turbopuffer.models.namespaces.NamespaceWriteParams
import com.turbopuffer.models.namespaces.NamespaceWriteResponse

interface NamespaceService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** List namespaces. */
    fun list(): NamespaceListPage = list(NamespaceListParams.none())

    /** @see [list] */
    fun list(
        params: NamespaceListParams = NamespaceListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceListPage

    /** @see [list] */
    fun list(params: NamespaceListParams = NamespaceListParams.none()): NamespaceListPage =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): NamespaceListPage =
        list(NamespaceListParams.none(), requestOptions)

    /** Delete namespace. */
    fun deleteAll(params: NamespaceDeleteAllParams): NamespaceDeleteAllResponse =
        deleteAll(params, RequestOptions.none())

    /** @see [deleteAll] */
    fun deleteAll(
        params: NamespaceDeleteAllParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceDeleteAllResponse

    /** Get namespace schema. */
    fun getSchema(params: NamespaceGetSchemaParams): NamespaceGetSchemaResponse =
        getSchema(params, RequestOptions.none())

    /** @see [getSchema] */
    fun getSchema(
        params: NamespaceGetSchemaParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceGetSchemaResponse

    /** Query, filter, full-text search and vector search documents. */
    fun query(params: NamespaceQueryParams): List<DocumentRowWithScore> =
        query(params, RequestOptions.none())

    /** @see [query] */
    fun query(
        params: NamespaceQueryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<DocumentRowWithScore>

    /** Create, update, or delete documents. */
    fun write(params: NamespaceWriteParams): NamespaceWriteResponse =
        write(params, RequestOptions.none())

    /** @see [write] */
    fun write(
        params: NamespaceWriteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceWriteResponse

    /** A view of [NamespaceService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/namespaces`, but is otherwise the same as
         * [NamespaceService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<NamespaceListPage> = list(NamespaceListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: NamespaceListParams = NamespaceListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: NamespaceListParams = NamespaceListParams.none()
        ): HttpResponseFor<NamespaceListPage> = list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<NamespaceListPage> =
            list(NamespaceListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v2/namespaces/{namespace}`, but is otherwise the
         * same as [NamespaceService.deleteAll].
         */
        @MustBeClosed
        fun deleteAll(
            params: NamespaceDeleteAllParams
        ): HttpResponseFor<NamespaceDeleteAllResponse> = deleteAll(params, RequestOptions.none())

        /** @see [deleteAll] */
        @MustBeClosed
        fun deleteAll(
            params: NamespaceDeleteAllParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceDeleteAllResponse>

        /**
         * Returns a raw HTTP response for `get /v1/namespaces/{namespace}/schema`, but is otherwise
         * the same as [NamespaceService.getSchema].
         */
        @MustBeClosed
        fun getSchema(
            params: NamespaceGetSchemaParams
        ): HttpResponseFor<NamespaceGetSchemaResponse> = getSchema(params, RequestOptions.none())

        /** @see [getSchema] */
        @MustBeClosed
        fun getSchema(
            params: NamespaceGetSchemaParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceGetSchemaResponse>

        /**
         * Returns a raw HTTP response for `post /v1/namespaces/{namespace}/query`, but is otherwise
         * the same as [NamespaceService.query].
         */
        @MustBeClosed
        fun query(params: NamespaceQueryParams): HttpResponseFor<List<DocumentRowWithScore>> =
            query(params, RequestOptions.none())

        /** @see [query] */
        @MustBeClosed
        fun query(
            params: NamespaceQueryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<DocumentRowWithScore>>

        /**
         * Returns a raw HTTP response for `post /v1/namespaces/{namespace}`, but is otherwise the
         * same as [NamespaceService.write].
         */
        @MustBeClosed
        fun write(params: NamespaceWriteParams): HttpResponseFor<NamespaceWriteResponse> =
            write(params, RequestOptions.none())

        /** @see [write] */
        @MustBeClosed
        fun write(
            params: NamespaceWriteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceWriteResponse>
    }
}
