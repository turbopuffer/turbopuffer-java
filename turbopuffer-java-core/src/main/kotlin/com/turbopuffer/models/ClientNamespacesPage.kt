// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models

import com.turbopuffer.client.TurbopufferClient
import com.turbopuffer.core.AutoPager
import com.turbopuffer.core.Page
import com.turbopuffer.core.checkRequired
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see TurbopufferClient.namespaces */
class ClientNamespacesPage
private constructor(
    private val service: TurbopufferClient,
    private val params: ClientNamespacesParams,
    private val response: ClientNamespacesPageResponse,
) : Page<NamespaceSummary> {

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

    override fun nextPage(): ClientNamespacesPage = service.namespaces(nextPageParams())

    fun autoPager(): AutoPager<NamespaceSummary> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ClientNamespacesParams = params

    /** The response that this page was parsed from. */
    fun response(): ClientNamespacesPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ClientNamespacesPage].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ClientNamespacesPage]. */
    class Builder internal constructor() {

        private var service: TurbopufferClient? = null
        private var params: ClientNamespacesParams? = null
        private var response: ClientNamespacesPageResponse? = null

        @JvmSynthetic
        internal fun from(clientNamespacesPage: ClientNamespacesPage) = apply {
            service = clientNamespacesPage.service
            params = clientNamespacesPage.params
            response = clientNamespacesPage.response
        }

        fun service(service: TurbopufferClient) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ClientNamespacesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ClientNamespacesPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ClientNamespacesPage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ClientNamespacesPage =
            ClientNamespacesPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ClientNamespacesPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "ClientNamespacesPage{service=$service, params=$params, response=$response}"
}
