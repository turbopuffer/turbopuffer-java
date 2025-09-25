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
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** Additional (optional) parameters for the ContainsAllTokens filter. */
class ContainsAllTokensFilterParams
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val lastAsPrefix: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("last_as_prefix")
        @ExcludeMissing
        lastAsPrefix: JsonField<Boolean> = JsonMissing.of()
    ) : this(lastAsPrefix, mutableMapOf())

    /**
     * Whether to treat the last token in the query input as a literal prefix.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun lastAsPrefix(): Optional<Boolean> = lastAsPrefix.getOptional("last_as_prefix")

    /**
     * Returns the raw JSON value of [lastAsPrefix].
     *
     * Unlike [lastAsPrefix], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("last_as_prefix")
    @ExcludeMissing
    fun _lastAsPrefix(): JsonField<Boolean> = lastAsPrefix

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
         * Returns a mutable builder for constructing an instance of
         * [ContainsAllTokensFilterParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContainsAllTokensFilterParams]. */
    class Builder internal constructor() {

        private var lastAsPrefix: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(containsAllTokensFilterParams: ContainsAllTokensFilterParams) = apply {
            lastAsPrefix = containsAllTokensFilterParams.lastAsPrefix
            additionalProperties = containsAllTokensFilterParams.additionalProperties.toMutableMap()
        }

        /** Whether to treat the last token in the query input as a literal prefix. */
        fun lastAsPrefix(lastAsPrefix: Boolean) = lastAsPrefix(JsonField.of(lastAsPrefix))

        /**
         * Sets [Builder.lastAsPrefix] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastAsPrefix] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun lastAsPrefix(lastAsPrefix: JsonField<Boolean>) = apply {
            this.lastAsPrefix = lastAsPrefix
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
         * Returns an immutable instance of [ContainsAllTokensFilterParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ContainsAllTokensFilterParams =
            ContainsAllTokensFilterParams(lastAsPrefix, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): ContainsAllTokensFilterParams = apply {
        if (validated) {
            return@apply
        }

        lastAsPrefix()
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
    @JvmSynthetic internal fun validity(): Int = (if (lastAsPrefix.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContainsAllTokensFilterParams &&
            lastAsPrefix == other.lastAsPrefix &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(lastAsPrefix, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ContainsAllTokensFilterParams{lastAsPrefix=$lastAsPrefix, additionalProperties=$additionalProperties}"
}
