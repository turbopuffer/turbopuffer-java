// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.services.blocking.NamespaceService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List namespaces. */
class NamespaceListPage
private constructor(
    private val namespacesService: NamespaceService,
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

        return /* spotless:off */ other is NamespaceListPage && namespacesService == other.namespacesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(namespacesService, params, response) /* spotless:on */

    override fun toString() =
        "NamespaceListPage{namespacesService=$namespacesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = namespaces().isNotEmpty() && nextCursor().isPresent

    fun getNextPageParams(): Optional<NamespaceListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            params.toBuilder().apply { nextCursor().ifPresent { cursor(it) } }.build()
        )
    }

    fun getNextPage(): Optional<NamespaceListPage> {
        return getNextPageParams().map { namespacesService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            namespacesService: NamespaceService,
            params: NamespaceListParams,
            response: NamespaceListPageResponse,
        ) = NamespaceListPage(namespacesService, params, response)
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
}
