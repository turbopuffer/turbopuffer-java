// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.services.async.NamespaceServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** List namespaces. */
class NamespaceListPageAsync
private constructor(
    private val namespacesService: NamespaceServiceAsync,
    private val params: NamespaceListParams,
    private val response: NamespaceListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): NamespaceListPageResponse = response

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is NamespaceListPageAsync && namespacesService == other.namespacesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(namespacesService, params, response) /* spotless:on */

    override fun toString() =
        "NamespaceListPageAsync{namespacesService=$namespacesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = namespaces().isNotEmpty() && nextCursor().isPresent

    fun getNextPageParams(): Optional<NamespaceListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            params.toBuilder().apply { nextCursor().ifPresent { cursor(it) } }.build()
        )
    }

    fun getNextPage(): CompletableFuture<Optional<NamespaceListPageAsync>> {
        return getNextPageParams()
            .map { namespacesService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            namespacesService: NamespaceServiceAsync,
            params: NamespaceListParams,
            response: NamespaceListPageResponse,
        ) = NamespaceListPageAsync(namespacesService, params, response)
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
}
