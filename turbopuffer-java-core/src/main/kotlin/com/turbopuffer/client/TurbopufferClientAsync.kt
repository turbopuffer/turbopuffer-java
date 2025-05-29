// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.client

import com.turbopuffer.core.RequestOptions
import com.turbopuffer.core.http.HttpResponseFor
import com.turbopuffer.models.ClientListNamespacesPageAsync
import com.turbopuffer.models.ClientListNamespacesParams
import com.turbopuffer.services.async.NamespaceServiceAsync
import java.util.concurrent.CompletableFuture

/**
 * A client for interacting with the Turbopuffer REST API asynchronously. You can also switch to
 * synchronous execution via the [sync] method.
 *
 * This client performs best when you create a single instance and reuse it for all interactions
 * with the REST API. This is because each client holds its own connection pool and thread pools.
 * Reusing connections and threads reduces latency and saves memory. The client also handles rate
 * limiting per client. This means that creating and using multiple instances at the same time will
 * not respect rate limits.
 *
 * The threads and connections that are held will be released automatically if they remain idle. But
 * if you are writing an application that needs to aggressively release unused resources, then you
 * may call [close].
 */
interface TurbopufferClientAsync {

    /**
     * Returns a version of this client that uses synchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun sync(): TurbopufferClient

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun namespaces(): NamespaceServiceAsync

    /** List namespaces. */
    fun listNamespaces(): CompletableFuture<ClientListNamespacesPageAsync> =
        listNamespaces(ClientListNamespacesParams.none())

    /** @see [listNamespaces] */
    fun listNamespaces(
        params: ClientListNamespacesParams = ClientListNamespacesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ClientListNamespacesPageAsync>

    /** @see [listNamespaces] */
    fun listNamespaces(
        params: ClientListNamespacesParams = ClientListNamespacesParams.none()
    ): CompletableFuture<ClientListNamespacesPageAsync> =
        listNamespaces(params, RequestOptions.none())

    /** @see [listNamespaces] */
    fun listNamespaces(
        requestOptions: RequestOptions
    ): CompletableFuture<ClientListNamespacesPageAsync> =
        listNamespaces(ClientListNamespacesParams.none(), requestOptions)

    /**
     * Closes this client, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because the client is long-lived and
     * usually should not be synchronously closed via try-with-resources.
     *
     * It's also usually not necessary to call this method at all. the default HTTP client
     * automatically releases threads and connections if they remain idle, but if you are writing an
     * application that needs to aggressively release unused resources, then you may call this
     * method.
     */
    fun close()

    /**
     * A view of [TurbopufferClientAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        fun namespaces(): NamespaceServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/namespaces`, but is otherwise the same as
         * [TurbopufferClientAsync.listNamespaces].
         */
        fun listNamespaces(): CompletableFuture<HttpResponseFor<ClientListNamespacesPageAsync>> =
            listNamespaces(ClientListNamespacesParams.none())

        /** @see [listNamespaces] */
        fun listNamespaces(
            params: ClientListNamespacesParams = ClientListNamespacesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ClientListNamespacesPageAsync>>

        /** @see [listNamespaces] */
        fun listNamespaces(
            params: ClientListNamespacesParams = ClientListNamespacesParams.none()
        ): CompletableFuture<HttpResponseFor<ClientListNamespacesPageAsync>> =
            listNamespaces(params, RequestOptions.none())

        /** @see [listNamespaces] */
        fun listNamespaces(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ClientListNamespacesPageAsync>> =
            listNamespaces(ClientListNamespacesParams.none(), requestOptions)
    }
}
