// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.core.checkRequired
import com.turbopuffer.services.blocking.NamespaceService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [NamespaceService.list] */
class NamespaceListPage
private constructor(
    private val service: NamespaceService,
    private val params: NamespaceListParams,
    private val response: NamespaceListPageResponse,
) {

    /**
     * Delegates to [NamespaceListPageResponse], but gracefully handles missing data.
     *
     * @see [NamespaceListPageResponse.namespaces]
     */
    fun namespaces(): List<NamespaceSummary> =
        response._namespaces().getOptional("namespaces").getOrNull() ?: emptyList()

    /**
     * Delegates to [NamespaceListPageResponse], but gracefully handles missing data.
     *
     * @see [NamespaceListPageResponse.nextCursor]
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("next_cursor")

    fun hasNextPage(): Boolean = namespaces().isNotEmpty() && nextCursor().isPresent

    fun getNextPageParams(): Optional<NamespaceListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            params.toBuilder().apply { nextCursor().ifPresent { cursor(it) } }.build()
        )
    }

    fun getNextPage(): Optional<NamespaceListPage> = getNextPageParams().map { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): NamespaceListParams = params

    /** The response that this page was parsed from. */
    fun response(): NamespaceListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [NamespaceListPage].
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

    /** A builder for [NamespaceListPage]. */
    class Builder internal constructor() {

        private var service: NamespaceService? = null
        private var params: NamespaceListParams? = null
        private var response: NamespaceListPageResponse? = null

        @JvmSynthetic
        internal fun from(namespaceListPage: NamespaceListPage) = apply {
            service = namespaceListPage.service
            params = namespaceListPage.params
            response = namespaceListPage.response
        }

        fun service(service: NamespaceService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: NamespaceListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: NamespaceListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [NamespaceListPage].
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
        fun build(): NamespaceListPage =
            NamespaceListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: NamespaceListPage) : Iterable<NamespaceSummary> {

        override fun iterator(): Iterator<NamespaceSummary> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.namespaces().size) {
                    yield(page.namespaces()[index++])
                }
                page = page.getNextPage().getOrNull() ?: break
                index = 0
            }
        }

        fun stream(): Stream<NamespaceSummary> {
            return StreamSupport.stream(spliterator(), false)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is NamespaceListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "NamespaceListPage{service=$service, params=$params, response=$response}"
}
