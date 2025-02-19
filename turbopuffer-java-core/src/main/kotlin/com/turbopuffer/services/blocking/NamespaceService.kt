// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.turbopuffer.services.blocking

import com.turbopuffer.core.RequestOptions
import com.turbopuffer.models.NamespaceDeleteAllParams
import com.turbopuffer.models.NamespaceDeleteAllResponse
import com.turbopuffer.models.NamespaceGetSchemaParams
import com.turbopuffer.models.NamespaceGetSchemaResponse
import com.turbopuffer.models.NamespaceListPage
import com.turbopuffer.models.NamespaceListParams
import com.turbopuffer.models.NamespaceQueryParams
import com.turbopuffer.models.NamespaceUpsertParams
import com.turbopuffer.models.NamespaceUpsertResponse

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
    ): List<UnnamedSchemaWithArrayParent0>

    /** Create, update, or delete documents. */
    @JvmOverloads
    fun upsert(
        params: NamespaceUpsertParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceUpsertResponse
}
