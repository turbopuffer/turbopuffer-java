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
import com.turbopuffer.core.checkKnown
import com.turbopuffer.core.checkRequired
import com.turbopuffer.core.toImmutable
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Additional parameters for the Fuzzy filter. */
class FuzzyParams
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val maxEditDistance: JsonField<List<FuzzyMaxEditDistance>>,
    private val caseSensitive: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("max_edit_distance")
        @ExcludeMissing
        maxEditDistance: JsonField<List<FuzzyMaxEditDistance>> = JsonMissing.of(),
        @JsonProperty("case_sensitive")
        @ExcludeMissing
        caseSensitive: JsonField<Boolean> = JsonMissing.of(),
    ) : this(maxEditDistance, caseSensitive, mutableMapOf())

    /**
     * Maximum edit distance allowed at each query length. Queries shorter than the first threshold
     * return no matches.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun maxEditDistance(): List<FuzzyMaxEditDistance> =
        maxEditDistance.getRequired("max_edit_distance")

    /**
     * Whether searching with Fuzzy filter is case-sensitive. Defaults to `true` (i.e.
     * case-sensitive).
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun caseSensitive(): Optional<Boolean> = caseSensitive.getOptional("case_sensitive")

    /**
     * Returns the raw JSON value of [maxEditDistance].
     *
     * Unlike [maxEditDistance], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("max_edit_distance")
    @ExcludeMissing
    fun _maxEditDistance(): JsonField<List<FuzzyMaxEditDistance>> = maxEditDistance

    /**
     * Returns the raw JSON value of [caseSensitive].
     *
     * Unlike [caseSensitive], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("case_sensitive")
    @ExcludeMissing
    fun _caseSensitive(): JsonField<Boolean> = caseSensitive

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
         * Returns a mutable builder for constructing an instance of [FuzzyParams].
         *
         * The following fields are required:
         * ```java
         * .maxEditDistance()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FuzzyParams]. */
    class Builder internal constructor() {

        private var maxEditDistance: JsonField<MutableList<FuzzyMaxEditDistance>>? = null
        private var caseSensitive: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fuzzyParams: FuzzyParams) = apply {
            maxEditDistance = fuzzyParams.maxEditDistance.map { it.toMutableList() }
            caseSensitive = fuzzyParams.caseSensitive
            additionalProperties = fuzzyParams.additionalProperties.toMutableMap()
        }

        /**
         * Maximum edit distance allowed at each query length. Queries shorter than the first
         * threshold return no matches.
         */
        fun maxEditDistance(maxEditDistance: List<FuzzyMaxEditDistance>) =
            maxEditDistance(JsonField.of(maxEditDistance))

        /**
         * Sets [Builder.maxEditDistance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxEditDistance] with a well-typed
         * `List<FuzzyMaxEditDistance>` value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun maxEditDistance(maxEditDistance: JsonField<List<FuzzyMaxEditDistance>>) = apply {
            this.maxEditDistance = maxEditDistance.map { it.toMutableList() }
        }

        /**
         * Adds a single [FuzzyMaxEditDistance] to [Builder.maxEditDistance].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMaxEditDistance(maxEditDistance: FuzzyMaxEditDistance) = apply {
            this.maxEditDistance =
                (this.maxEditDistance ?: JsonField.of(mutableListOf())).also {
                    checkKnown("maxEditDistance", it).add(maxEditDistance)
                }
        }

        /**
         * Whether searching with Fuzzy filter is case-sensitive. Defaults to `true` (i.e.
         * case-sensitive).
         */
        fun caseSensitive(caseSensitive: Boolean) = caseSensitive(JsonField.of(caseSensitive))

        /**
         * Sets [Builder.caseSensitive] to an arbitrary JSON value.
         *
         * You should usually call [Builder.caseSensitive] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun caseSensitive(caseSensitive: JsonField<Boolean>) = apply {
            this.caseSensitive = caseSensitive
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
         * Returns an immutable instance of [FuzzyParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .maxEditDistance()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FuzzyParams =
            FuzzyParams(
                checkRequired("maxEditDistance", maxEditDistance).map { it.toImmutable() },
                caseSensitive,
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
    fun validate(): FuzzyParams = apply {
        if (validated) {
            return@apply
        }

        maxEditDistance().forEach { it.validate() }
        caseSensitive()
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
        (maxEditDistance.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (caseSensitive.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FuzzyParams &&
            maxEditDistance == other.maxEditDistance &&
            caseSensitive == other.caseSensitive &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(maxEditDistance, caseSensitive, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FuzzyParams{maxEditDistance=$maxEditDistance, caseSensitive=$caseSensitive, additionalProperties=$additionalProperties}"
}
