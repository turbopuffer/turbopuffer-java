// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.client

import com.google.errorprone.annotations.MustBeClosed
import com.turbopuffer.core.RequestOptions
import com.turbopuffer.core.http.HttpResponseFor
import com.turbopuffer.models.ClientListNamespacesPage
import com.turbopuffer.models.ClientListNamespacesParams
import com.turbopuffer.services.blocking.NamespaceService

/**
 * A client for interacting with the Turbopuffer REST API synchronously. You can also switch to
 * asynchronous execution via the [async] method.
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
interface TurbopufferClient {

    /**
     * Returns a version of this client that uses asynchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun async(): TurbopufferClientAsync

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun namespaces(): NamespaceService

    /** List namespaces. */
    fun listNamespaces(): ClientListNamespacesPage =
        listNamespaces(ClientListNamespacesParams.none())

    /** @see [listNamespaces] */
    fun listNamespaces(
        params: ClientListNamespacesParams = ClientListNamespacesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ClientListNamespacesPage

    /** @see [listNamespaces] */
    fun listNamespaces(
        params: ClientListNamespacesParams = ClientListNamespacesParams.none()
    ): ClientListNamespacesPage = listNamespaces(params, RequestOptions.none())

    /** @see [listNamespaces] */
    fun listNamespaces(requestOptions: RequestOptions): ClientListNamespacesPage =
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

    /** A view of [TurbopufferClient] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun namespaces(): NamespaceService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/namespaces`, but is otherwise the same as
         * [TurbopufferClient.listNamespaces].
         */
        @MustBeClosed
        fun listNamespaces(): HttpResponseFor<ClientListNamespacesPage> =
            listNamespaces(ClientListNamespacesParams.none())

        /** @see [listNamespaces] */
        @MustBeClosed
        fun listNamespaces(
            params: ClientListNamespacesParams = ClientListNamespacesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ClientListNamespacesPage>

        /** @see [listNamespaces] */
        @MustBeClosed
        fun listNamespaces(
            params: ClientListNamespacesParams = ClientListNamespacesParams.none()
        ): HttpResponseFor<ClientListNamespacesPage> = listNamespaces(params, RequestOptions.none())

        /** @see [listNamespaces] */
        @MustBeClosed
        fun listNamespaces(
            requestOptions: RequestOptions
        ): HttpResponseFor<ClientListNamespacesPage> =
            listNamespaces(ClientListNamespacesParams.none(), requestOptions)
    }
}
