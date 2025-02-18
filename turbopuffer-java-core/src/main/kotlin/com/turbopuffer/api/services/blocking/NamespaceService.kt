// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.turbopuffer.api.services.blocking

import com.turbopuffer.api.core.RequestOptions
import com.turbopuffer.api.models.DocumentRow
import com.turbopuffer.api.models.NamespaceDeleteAllParams
import com.turbopuffer.api.models.NamespaceDeleteAllResponse
import com.turbopuffer.api.models.NamespaceGetSchemaParams
import com.turbopuffer.api.models.NamespaceGetSchemaResponse
import com.turbopuffer.api.models.NamespaceListPage
import com.turbopuffer.api.models.NamespaceListParams
import com.turbopuffer.api.models.NamespaceQueryParams
import com.turbopuffer.api.models.NamespaceUpsertParams
import com.turbopuffer.api.models.NamespaceUpsertResponse

interface NamespaceService {

    /** List namespaces */
    @JvmOverloads
    fun list(
        params: NamespaceListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceListPage

    /** Delete namespace */
    @JvmOverloads
    fun deleteAll(
        params: NamespaceDeleteAllParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceDeleteAllResponse

    /** Get namespace schema. */
    @JvmOverloads
    fun getSchema(
        params: NamespaceGetSchemaParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceGetSchemaResponse

    @JvmOverloads
    fun query(
        params: NamespaceQueryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<DocumentRow>

    /** Create, update, or delete documents. */
    @JvmOverloads
    fun upsert(
        params: NamespaceUpsertParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceUpsertResponse
}
