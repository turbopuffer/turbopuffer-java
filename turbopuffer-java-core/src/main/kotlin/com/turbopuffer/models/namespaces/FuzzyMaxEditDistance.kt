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

/** An edit distance threshold for the Fuzzy filter. */
class FuzzyMaxEditDistance
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val distance: JsonField<Long>,
    private val minQueryChars: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("distance") @ExcludeMissing distance: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("min_query_chars")
        @ExcludeMissing
        minQueryChars: JsonField<Long> = JsonMissing.of(),
    ) : this(distance, minQueryChars, mutableMapOf())

    /**
     * The maximum edit distance to allow.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun distance(): Long = distance.getRequired("distance")

    /**
     * Minimum number of characters in a query where this distance applies. Must be at least 3 ·
     * (distance + 1).
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun minQueryChars(): Long = minQueryChars.getRequired("min_query_chars")

    /**
     * Returns the raw JSON value of [distance].
     *
     * Unlike [distance], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("distance") @ExcludeMissing fun _distance(): JsonField<Long> = distance

    /**
     * Returns the raw JSON value of [minQueryChars].
     *
     * Unlike [minQueryChars], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("min_query_chars")
    @ExcludeMissing
    fun _minQueryChars(): JsonField<Long> = minQueryChars

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
         * Returns a mutable builder for constructing an instance of [FuzzyMaxEditDistance].
         *
         * The following fields are required:
         * ```java
         * .distance()
         * .minQueryChars()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FuzzyMaxEditDistance]. */
    class Builder internal constructor() {

        private var distance: JsonField<Long>? = null
        private var minQueryChars: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fuzzyMaxEditDistance: FuzzyMaxEditDistance) = apply {
            distance = fuzzyMaxEditDistance.distance
            minQueryChars = fuzzyMaxEditDistance.minQueryChars
            additionalProperties = fuzzyMaxEditDistance.additionalProperties.toMutableMap()
        }

        /** The maximum edit distance to allow. */
        fun distance(distance: Long) = distance(JsonField.of(distance))

        /**
         * Sets [Builder.distance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.distance] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun distance(distance: JsonField<Long>) = apply { this.distance = distance }

        /**
         * Minimum number of characters in a query where this distance applies. Must be at least 3 ·
         * (distance + 1).
         */
        fun minQueryChars(minQueryChars: Long) = minQueryChars(JsonField.of(minQueryChars))

        /**
         * Sets [Builder.minQueryChars] to an arbitrary JSON value.
         *
         * You should usually call [Builder.minQueryChars] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun minQueryChars(minQueryChars: JsonField<Long>) = apply {
            this.minQueryChars = minQueryChars
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
         * Returns an immutable instance of [FuzzyMaxEditDistance].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .distance()
         * .minQueryChars()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FuzzyMaxEditDistance =
            FuzzyMaxEditDistance(
                checkRequired("distance", distance),
                checkRequired("minQueryChars", minQueryChars),
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
    fun validate(): FuzzyMaxEditDistance = apply {
        if (validated) {
            return@apply
        }

        distance()
        minQueryChars()
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
        (if (distance.asKnown().isPresent) 1 else 0) +
            (if (minQueryChars.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FuzzyMaxEditDistance &&
            distance == other.distance &&
            minQueryChars == other.minQueryChars &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(distance, minQueryChars, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FuzzyMaxEditDistance{distance=$distance, minQueryChars=$minQueryChars, additionalProperties=$additionalProperties}"
}
