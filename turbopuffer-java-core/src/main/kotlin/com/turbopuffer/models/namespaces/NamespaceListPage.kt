// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.turbopuffer.core.ExcludeMissing
import com.turbopuffer.core.JsonField
import com.turbopuffer.core.JsonMissing
import com.turbopuffer.core.JsonValue
import com.turbopuffer.errors.TurbopufferInvalidDataException
import com.turbopuffer.services.blocking.NamespaceService
import java.util.Collections
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
    private val response: Response,
) {

    fun response(): Response = response

    fun namespaces(): List<NamespaceSummary> = response().namespaces()

    fun nextCursor(): Optional<String> = response().nextCursor()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is NamespaceListPage && namespacesService == other.namespacesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(namespacesService, params, response) /* spotless:on */

    override fun toString() =
        "NamespaceListPage{namespacesService=$namespacesService, params=$params, response=$response}"

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

    fun getNextPage(): Optional<NamespaceListPage> {
        return getNextPageParams().map { namespacesService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            namespacesService: NamespaceService,
            params: NamespaceListParams,
            response: Response,
        ) = NamespaceListPage(namespacesService, params, response)
    }

    class Response(
        private val namespaces: JsonField<List<NamespaceSummary>>,
        private val nextCursor: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("namespaces")
            namespaces: JsonField<List<NamespaceSummary>> = JsonMissing.of(),
            @JsonProperty("next_cursor") nextCursor: JsonField<String> = JsonMissing.of(),
        ) : this(namespaces, nextCursor, mutableMapOf())

        fun namespaces(): List<NamespaceSummary> =
            namespaces.getOptional("namespaces").getOrNull() ?: listOf()

        fun nextCursor(): Optional<String> = nextCursor.getOptional("next_cursor")

        @JsonProperty("namespaces")
        fun _namespaces(): Optional<JsonField<List<NamespaceSummary>>> =
            Optional.ofNullable(namespaces)

        @JsonProperty("next_cursor")
        fun _nextCursor(): Optional<JsonField<String>> = Optional.ofNullable(nextCursor)

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        private var validated: Boolean = false

        fun validate(): Response = apply {
            if (validated) {
                return@apply
            }

            namespaces().map { it.validate() }
            nextCursor()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: TurbopufferInvalidDataException) {
                false
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

            /** Returns a mutable builder for constructing an instance of [NamespaceListPage]. */
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

            /**
             * Returns an immutable instance of [Response].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Response =
                Response(namespaces, nextCursor, additionalProperties.toMutableMap())
        }
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
