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

/** @see TurbopufferClientAsync.namespaces */
class ClientNamespacesPageAsync
private constructor(
    private val service: TurbopufferClientAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ClientNamespacesParams,
    private val response: ClientNamespacesPageResponse,
) : PageAsync<NamespaceSummary> {

    /**
     * Delegates to [ClientNamespacesPageResponse], but gracefully handles missing data.
     *
     * @see ClientNamespacesPageResponse.namespaces
     */
    fun namespaces(): List<NamespaceSummary> =
        response._namespaces().getOptional("namespaces").getOrNull() ?: emptyList()

    /**
     * Delegates to [ClientNamespacesPageResponse], but gracefully handles missing data.
     *
     * @see ClientNamespacesPageResponse.nextCursor
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("next_cursor")

    override fun items(): List<NamespaceSummary> = namespaces()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor().isPresent

    fun nextPageParams(): ClientNamespacesParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<ClientNamespacesPageAsync> =
        service.namespaces(nextPageParams())

    fun autoPager(): AutoPagerAsync<NamespaceSummary> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ClientNamespacesParams = params

    /** The response that this page was parsed from. */
    fun response(): ClientNamespacesPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ClientNamespacesPageAsync].
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

    /** A builder for [ClientNamespacesPageAsync]. */
    class Builder internal constructor() {

        private var service: TurbopufferClientAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ClientNamespacesParams? = null
        private var response: ClientNamespacesPageResponse? = null

        @JvmSynthetic
        internal fun from(clientNamespacesPageAsync: ClientNamespacesPageAsync) = apply {
            service = clientNamespacesPageAsync.service
            streamHandlerExecutor = clientNamespacesPageAsync.streamHandlerExecutor
            params = clientNamespacesPageAsync.params
            response = clientNamespacesPageAsync.response
        }

        fun service(service: TurbopufferClientAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: ClientNamespacesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ClientNamespacesPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ClientNamespacesPageAsync].
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
        fun build(): ClientNamespacesPageAsync =
            ClientNamespacesPageAsync(
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

        return other is ClientNamespacesPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "ClientNamespacesPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
