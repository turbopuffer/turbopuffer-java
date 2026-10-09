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
import com.turbopuffer.core.checkRequired
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** The performance information for a write request. */
class WritePerformance
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val serverTotalMs: JsonField<Long>,
    private val embeddingMs: JsonField<Long>,
    private val embeddingTokens: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("server_total_ms")
        @ExcludeMissing
        serverTotalMs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("embedding_ms")
        @ExcludeMissing
        embeddingMs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("embedding_tokens")
        @ExcludeMissing
        embeddingTokens: JsonField<Long> = JsonMissing.of(),
    ) : this(serverTotalMs, embeddingMs, embeddingTokens, mutableMapOf())

    /**
     * Request time measured on the server, in milliseconds.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun serverTotalMs(): Long = serverTotalMs.getRequired("server_total_ms")

    /**
     * Time spent embedding text, in milliseconds. Only set when using a native embedding model.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun embeddingMs(): Optional<Long> = embeddingMs.getOptional("embedding_ms")

    /**
     * The number of tokens embedded. Only set when using a native embedding model.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun embeddingTokens(): Optional<Long> = embeddingTokens.getOptional("embedding_tokens")

    /**
     * Returns the raw JSON value of [serverTotalMs].
     *
     * Unlike [serverTotalMs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("server_total_ms")
    @ExcludeMissing
    fun _serverTotalMs(): JsonField<Long> = serverTotalMs

    /**
     * Returns the raw JSON value of [embeddingMs].
     *
     * Unlike [embeddingMs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("embedding_ms") @ExcludeMissing fun _embeddingMs(): JsonField<Long> = embeddingMs

    /**
     * Returns the raw JSON value of [embeddingTokens].
     *
     * Unlike [embeddingTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("embedding_tokens")
    @ExcludeMissing
    fun _embeddingTokens(): JsonField<Long> = embeddingTokens

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
         * Returns a mutable builder for constructing an instance of [WritePerformance].
         *
         * The following fields are required:
         * ```java
         * .serverTotalMs()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WritePerformance]. */
    class Builder internal constructor() {

        private var serverTotalMs: JsonField<Long>? = null
        private var embeddingMs: JsonField<Long> = JsonMissing.of()
        private var embeddingTokens: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(writePerformance: WritePerformance) = apply {
            serverTotalMs = writePerformance.serverTotalMs
            embeddingMs = writePerformance.embeddingMs
            embeddingTokens = writePerformance.embeddingTokens
            additionalProperties = writePerformance.additionalProperties.toMutableMap()
        }

        /** Request time measured on the server, in milliseconds. */
        fun serverTotalMs(serverTotalMs: Long) = serverTotalMs(JsonField.of(serverTotalMs))

        /**
         * Sets [Builder.serverTotalMs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.serverTotalMs] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun serverTotalMs(serverTotalMs: JsonField<Long>) = apply {
            this.serverTotalMs = serverTotalMs
        }

        /**
         * Time spent embedding text, in milliseconds. Only set when using a native embedding model.
         */
        fun embeddingMs(embeddingMs: Long) = embeddingMs(JsonField.of(embeddingMs))

        /**
         * Sets [Builder.embeddingMs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.embeddingMs] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun embeddingMs(embeddingMs: JsonField<Long>) = apply { this.embeddingMs = embeddingMs }

        /** The number of tokens embedded. Only set when using a native embedding model. */
        fun embeddingTokens(embeddingTokens: Long) = embeddingTokens(JsonField.of(embeddingTokens))

        /**
         * Sets [Builder.embeddingTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.embeddingTokens] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun embeddingTokens(embeddingTokens: JsonField<Long>) = apply {
            this.embeddingTokens = embeddingTokens
        }

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
         * Returns an immutable instance of [WritePerformance].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .serverTotalMs()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WritePerformance =
            WritePerformance(
                checkRequired("serverTotalMs", serverTotalMs),
                embeddingMs,
                embeddingTokens,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws TurbopufferInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): WritePerformance = apply {
        if (validated) {
            return@apply
        }

        serverTotalMs()
        embeddingMs()
        embeddingTokens()
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
        (if (serverTotalMs.asKnown().isPresent) 1 else 0) +
            (if (embeddingMs.asKnown().isPresent) 1 else 0) +
            (if (embeddingTokens.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WritePerformance &&
            serverTotalMs == other.serverTotalMs &&
            embeddingMs == other.embeddingMs &&
            embeddingTokens == other.embeddingTokens &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(serverTotalMs, embeddingMs, embeddingTokens, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "WritePerformance{serverTotalMs=$serverTotalMs, embeddingMs=$embeddingMs, embeddingTokens=$embeddingTokens, additionalProperties=$additionalProperties}"
}
