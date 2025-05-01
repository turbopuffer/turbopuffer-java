// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.core.checkRequired
import com.turbopuffer.services.async.NamespaceServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [NamespaceServiceAsync.list] */
class NamespaceListPageAsync
private constructor(
    private val service: NamespaceServiceAsync,
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

    fun getNextPage(): CompletableFuture<Optional<NamespaceListPageAsync>> =
        getNextPageParams()
            .map { service.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): NamespaceListParams = params

    /** The response that this page was parsed from. */
    fun response(): NamespaceListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [NamespaceListPageAsync].
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

    /** A builder for [NamespaceListPageAsync]. */
    class Builder internal constructor() {

        private var service: NamespaceServiceAsync? = null
        private var params: NamespaceListParams? = null
        private var response: NamespaceListPageResponse? = null

        @JvmSynthetic
        internal fun from(namespaceListPageAsync: NamespaceListPageAsync) = apply {
            service = namespaceListPageAsync.service
            params = namespaceListPageAsync.params
            response = namespaceListPageAsync.response
        }

        fun service(service: NamespaceServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: NamespaceListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: NamespaceListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [NamespaceListPageAsync].
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
        fun build(): NamespaceListPageAsync =
            NamespaceListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: NamespaceListPageAsync) {

        fun forEach(
            action: Predicate<NamespaceSummary>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<NamespaceListPageAsync>>.forEach(
                action: (NamespaceSummary) -> Boolean,
                executor: Executor,
            ): CompletableFuture<Void> =
                thenComposeAsync(
                    { page ->
                        page
                            .filter { it.namespaces().all(action) }
                            .map { it.getNextPage().forEach(action, executor) }
                            .orElseGet { CompletableFuture.completedFuture(null) }
                    },
                    executor,
                )
            return CompletableFuture.completedFuture(Optional.of(firstPage))
                .forEach(action::test, executor)
        }

        fun toList(executor: Executor): CompletableFuture<List<NamespaceSummary>> {
            val values = mutableListOf<NamespaceSummary>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is NamespaceListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "NamespaceListPageAsync{service=$service, params=$params, response=$response}"
}
