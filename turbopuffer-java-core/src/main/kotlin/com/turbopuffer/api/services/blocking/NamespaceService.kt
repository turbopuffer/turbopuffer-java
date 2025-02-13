// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.turbopuffer.api.services.blocking

import com.turbopuffer.api.core.RequestOptions
import com.turbopuffer.api.models.NamespaceListParams
import com.turbopuffer.api.models.NamespaceQueryParams
import com.turbopuffer.api.models.NamespaceQueryResponse
import com.turbopuffer.api.models.NamespaceRetrieveParams
import com.turbopuffer.api.models.NamespaceRetrieveResponse
import com.turbopuffer.api.models.NamespaceUpsertParams
import com.turbopuffer.api.models.NamespaceUpsertResponse

interface NamespaceService {

    /** Retrieve metadata for a specific namespace. */
    @JvmOverloads
    fun retrieve(
        params: NamespaceRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): NamespaceRetrieveResponse

    /** Retrieve a list of all namespaces. */
    @JvmOverloads
    fun list(
        params: NamespaceListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): List<UnnamedSchemaWithArrayParent0>

    /**
     * Searches documents in a namespace using a vector (and optionally attribute filters). Provide
     * a query vector, filters, ranking, and other parameters to retrieve matching documents.
     */
    @JvmOverloads
    fun query(
        params: NamespaceQueryParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): NamespaceQueryResponse

    /**
     * Creates, updates, or deletes documents in a namespace. Documents are upserted in a
     * column-oriented format (using `ids`, `vectors`, `attributes`, etc.) or in a row-based format
     * (using `upserts`). To delete a document, send a `null` vector.
     */
    @JvmOverloads
    fun upsert(
        params: NamespaceUpsertParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): NamespaceUpsertResponse
}
