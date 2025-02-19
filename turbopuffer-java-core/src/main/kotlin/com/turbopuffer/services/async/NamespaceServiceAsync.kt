// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.turbopuffer.services.async

import com.turbopuffer.core.RequestOptions
import com.turbopuffer.models.DocumentRowResponse
import com.turbopuffer.models.NamespaceDeleteAllParams
import com.turbopuffer.models.NamespaceDeleteAllResponse
import com.turbopuffer.models.NamespaceGetSchemaParams
import com.turbopuffer.models.NamespaceGetSchemaResponse
import com.turbopuffer.models.NamespaceListPageAsync
import com.turbopuffer.models.NamespaceListParams
import com.turbopuffer.models.NamespaceQueryParams
import com.turbopuffer.models.NamespaceUpsertParams
import com.turbopuffer.models.NamespaceUpsertResponse
import java.util.concurrent.CompletableFuture

interface NamespaceServiceAsync {

    /** List namespaces */
    @JvmOverloads
    fun list(
        params: NamespaceListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceListPageAsync>

    /** Delete namespace */
    @JvmOverloads
    fun deleteAll(
        params: NamespaceDeleteAllParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceDeleteAllResponse>

    /** Get namespace schema. */
    @JvmOverloads
    fun getSchema(
        params: NamespaceGetSchemaParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceGetSchemaResponse>

    @JvmOverloads
    fun query(
        params: NamespaceQueryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<DocumentRowResponse>>

    /** Create, update, or delete documents. */
    @JvmOverloads
    fun upsert(
        params: NamespaceUpsertParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceUpsertResponse>
}
