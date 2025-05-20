// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models

import com.turbopuffer.client.TurbopufferClientAsync
import com.turbopuffer.core.AutoPagerAsync
import com.turbopuffer.core.PageAsync
import com.turbopuffer.core.checkRequired
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [TurbopufferClientAsync.listNamespaces] */
class ClientListNamespacesPageAsync
private constructor(
    private val service: TurbopufferClientAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ClientListNamespacesParams,
    private val response: ClientListNamespacesPageResponse,
) : PageAsync<NamespaceSummary> {

    /**
     * Delegates to [ClientListNamespacesPageResponse], but gracefully handles missing data.
     *
     * @see [ClientListNamespacesPageResponse.namespaces]
     */
    fun namespaces(): List<NamespaceSummary> =
        response._namespaces().getOptional("namespaces").getOrNull() ?: emptyList()

    /**
     * Delegates to [ClientListNamespacesPageResponse], but gracefully handles missing data.
     *
     * @see [ClientListNamespacesPageResponse.nextCursor]
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("next_cursor")

    override fun items(): List<NamespaceSummary> = namespaces()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor().isPresent

    fun nextPageParams(): ClientListNamespacesParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<ClientListNamespacesPageAsync> =
        service.listNamespaces(nextPageParams())

    fun autoPager(): AutoPagerAsync<NamespaceSummary> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ClientListNamespacesParams = params

    /** The response that this page was parsed from. */
    fun response(): ClientListNamespacesPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ClientListNamespacesPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ClientListNamespacesPageAsync]. */
    class Builder internal constructor() {

        private var service: TurbopufferClientAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ClientListNamespacesParams? = null
        private var response: ClientListNamespacesPageResponse? = null

        @JvmSynthetic
        internal fun from(clientListNamespacesPageAsync: ClientListNamespacesPageAsync) = apply {
            service = clientListNamespacesPageAsync.service
            streamHandlerExecutor = clientListNamespacesPageAsync.streamHandlerExecutor
            params = clientListNamespacesPageAsync.params
            response = clientListNamespacesPageAsync.response
        }

        fun service(service: TurbopufferClientAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: ClientListNamespacesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ClientListNamespacesPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [ClientListNamespacesPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ClientListNamespacesPageAsync =
            ClientListNamespacesPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ClientListNamespacesPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "ClientListNamespacesPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
