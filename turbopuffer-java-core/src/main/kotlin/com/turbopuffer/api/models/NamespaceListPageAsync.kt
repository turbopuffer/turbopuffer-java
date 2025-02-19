// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.turbopuffer.api.core.ExcludeMissing
import com.turbopuffer.api.core.JsonField
import com.turbopuffer.api.core.JsonMissing
import com.turbopuffer.api.core.JsonValue
import com.turbopuffer.api.core.NoAutoDetect
import com.turbopuffer.api.core.immutableEmptyMap
import com.turbopuffer.api.core.toImmutable
import com.turbopuffer.api.services.async.NamespaceServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate

/** List namespaces. */
class NamespaceListPageAsync
private constructor(
    private val namespacesService: NamespaceServiceAsync,
    private val params: NamespaceListParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun namespaces(): List<NamespaceSummary> = response().namespaces()

    fun nextCursor(): Optional<String> = response().nextCursor()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is NamespaceListPageAsync && namespacesService == other.namespacesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(namespacesService, params, response) /* spotless:on */

    override fun toString() =
        "NamespaceListPageAsync{namespacesService=$namespacesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        if (namespaces().isEmpty()) {
            return false
        }

        return nextCursor().isPresent
    }

    fun getNextPageParams(): Optional<NamespaceListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            NamespaceListParams.builder()
                .from(params)
                .apply { nextCursor().ifPresent { this.cursor(it) } }
                .build()
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
            response: Response,
        ) = NamespaceListPageAsync(namespacesService, params, response)
    }

    @NoAutoDetect
    class Response
    @JsonCreator
    constructor(
        @JsonProperty("namespaces")
        private val namespaces: JsonField<List<NamespaceSummary>> = JsonMissing.of(),
        @JsonProperty("next_cursor") private val nextCursor: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun namespaces(): List<NamespaceSummary> = namespaces.getNullable("namespaces") ?: listOf()

        fun nextCursor(): Optional<String> =
            Optional.ofNullable(nextCursor.getNullable("next_cursor"))

        @JsonProperty("namespaces")
        fun _namespaces(): Optional<JsonField<List<NamespaceSummary>>> =
            Optional.ofNullable(namespaces)

        @JsonProperty("next_cursor")
        fun _nextCursor(): Optional<JsonField<String>> = Optional.ofNullable(nextCursor)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Response = apply {
            if (validated) {
                return@apply
            }

            namespaces().map { it.validate() }
            nextCursor()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Response && namespaces == other.namespaces && nextCursor == other.nextCursor && additionalProperties == other.additionalProperties /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(namespaces, nextCursor, additionalProperties) /* spotless:on */

        override fun toString() =
            "Response{namespaces=$namespaces, nextCursor=$nextCursor, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var namespaces: JsonField<List<NamespaceSummary>> = JsonMissing.of()
            private var nextCursor: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) = apply {
                this.namespaces = page.namespaces
                this.nextCursor = page.nextCursor
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun namespaces(namespaces: List<NamespaceSummary>) =
                namespaces(JsonField.of(namespaces))

            fun namespaces(namespaces: JsonField<List<NamespaceSummary>>) = apply {
                this.namespaces = namespaces
            }

            fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

            fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun build() = Response(namespaces, nextCursor, additionalProperties.toImmutable())
        }
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
