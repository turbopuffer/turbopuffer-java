// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.turbopuffer.core.ExcludeMissing
import com.turbopuffer.core.JsonField
import com.turbopuffer.core.JsonMissing
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.checkKnown
import com.turbopuffer.core.toImmutable
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class ClientNamespacesPageResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val namespaces: JsonField<List<NamespaceSummary>>,
    private val nextCursor: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("namespaces")
        @ExcludeMissing
        namespaces: JsonField<List<NamespaceSummary>> = JsonMissing.of(),
        @JsonProperty("next_cursor")
        @ExcludeMissing
        nextCursor: JsonField<String> = JsonMissing.of(),
    ) : this(namespaces, nextCursor, mutableMapOf())

    /**
     * The list of namespaces.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun namespaces(): Optional<List<NamespaceSummary>> = namespaces.getOptional("namespaces")

    /**
     * The cursor to use to retrieve the next page of results.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun nextCursor(): Optional<String> = nextCursor.getOptional("next_cursor")

    /**
     * Returns the raw JSON value of [namespaces].
     *
     * Unlike [namespaces], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("namespaces")
    @ExcludeMissing
    fun _namespaces(): JsonField<List<NamespaceSummary>> = namespaces

    /**
     * Returns the raw JSON value of [nextCursor].
     *
     * Unlike [nextCursor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("next_cursor") @ExcludeMissing fun _nextCursor(): JsonField<String> = nextCursor

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ClientNamespacesPageResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ClientNamespacesPageResponse]. */
    class Builder internal constructor() {

        private var namespaces: JsonField<MutableList<NamespaceSummary>>? = null
        private var nextCursor: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(clientNamespacesPageResponse: ClientNamespacesPageResponse) = apply {
            namespaces = clientNamespacesPageResponse.namespaces.map { it.toMutableList() }
            nextCursor = clientNamespacesPageResponse.nextCursor
            additionalProperties = clientNamespacesPageResponse.additionalProperties.toMutableMap()
        }

        /** The list of namespaces. */
        fun namespaces(namespaces: List<NamespaceSummary>) = namespaces(JsonField.of(namespaces))

        /**
         * Sets [Builder.namespaces] to an arbitrary JSON value.
         *
         * You should usually call [Builder.namespaces] with a well-typed `List<NamespaceSummary>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun namespaces(namespaces: JsonField<List<NamespaceSummary>>) = apply {
            this.namespaces = namespaces.map { it.toMutableList() }
        }

        /**
         * Adds a single [NamespaceSummary] to [namespaces].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addNamespace(namespace: NamespaceSummary) = apply {
            namespaces =
                (namespaces ?: JsonField.of(mutableListOf())).also {
                    checkKnown("namespaces", it).add(namespace)
                }
        }

        /** The cursor to use to retrieve the next page of results. */
        fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

        /**
         * Sets [Builder.nextCursor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nextCursor] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [ClientNamespacesPageResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ClientNamespacesPageResponse =
            ClientNamespacesPageResponse(
                (namespaces ?: JsonMissing.of()).map { it.toImmutable() },
                nextCursor,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ClientNamespacesPageResponse = apply {
        if (validated) {
            return@apply
        }

        namespaces().ifPresent { it.forEach { it.validate() } }
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

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (namespaces.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (nextCursor.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ClientNamespacesPageResponse &&
            namespaces == other.namespaces &&
            nextCursor == other.nextCursor &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(namespaces, nextCursor, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ClientNamespacesPageResponse{namespaces=$namespaces, nextCursor=$nextCursor, additionalProperties=$additionalProperties}"
}
