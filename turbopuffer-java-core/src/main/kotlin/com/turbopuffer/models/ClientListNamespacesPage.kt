// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models

import com.turbopuffer.client.TurbopufferClient
import com.turbopuffer.core.AutoPager
import com.turbopuffer.core.Page
import com.turbopuffer.core.checkRequired
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see [TurbopufferClient.listNamespaces] */
class ClientListNamespacesPage
private constructor(
    private val service: TurbopufferClient,
    private val params: ClientListNamespacesParams,
    private val response: ClientListNamespacesPageResponse,
) : Page<ClientListNamespacesPageResponse> {

    /**
     * Delegates to [ClientListNamespacesPageResponse], but gracefully handles missing data.
     *
     * @see [ClientListNamespacesPageResponse.nextCursor]
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("next_cursor")

    override fun items(): List<ClientListNamespacesPageResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor().isPresent

    fun nextPageParams(): ClientListNamespacesParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): ClientListNamespacesPage = service.listNamespaces(nextPageParams())

    fun autoPager(): AutoPager<ClientListNamespacesPageResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ClientListNamespacesParams = params

    /** The response that this page was parsed from. */
    fun response(): ClientListNamespacesPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ClientListNamespacesPage].
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

    /** A builder for [ClientListNamespacesPage]. */
    class Builder internal constructor() {

        private var service: TurbopufferClient? = null
        private var params: ClientListNamespacesParams? = null
        private var response: ClientListNamespacesPageResponse? = null

        @JvmSynthetic
        internal fun from(clientListNamespacesPage: ClientListNamespacesPage) = apply {
            service = clientListNamespacesPage.service
            params = clientListNamespacesPage.params
            response = clientListNamespacesPage.response
        }

        fun service(service: TurbopufferClient) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ClientListNamespacesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ClientListNamespacesPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [ClientListNamespacesPage].
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
        fun build(): ClientListNamespacesPage =
            ClientListNamespacesPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ClientListNamespacesPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ClientListNamespacesPage{service=$service, params=$params, response=$response}"
}
