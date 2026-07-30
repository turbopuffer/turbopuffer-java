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
import com.turbopuffer.core.toImmutable
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Configuration options for RRF. */
class RrfParams
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val rankConstant: JsonField<Long>,
    private val weights: JsonField<List<Float>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("rank_constant")
        @ExcludeMissing
        rankConstant: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("weights") @ExcludeMissing weights: JsonField<List<Float>> = JsonMissing.of(),
    ) : this(rankConstant, weights, mutableMapOf())

    /**
     * RRF rank constant (`k`). Must be greater than zero. Defaults to `60`.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun rankConstant(): Optional<Long> = rankConstant.getOptional("rank_constant")

    /**
     * A positive weight for each subquery, in the same order as `queries`. The number of weights
     * must match the number of subqueries. When omitted, every subquery has a weight of `1`.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun weights(): Optional<List<Float>> = weights.getOptional("weights")

    /**
     * Returns the raw JSON value of [rankConstant].
     *
     * Unlike [rankConstant], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("rank_constant")
    @ExcludeMissing
    fun _rankConstant(): JsonField<Long> = rankConstant

    /**
     * Returns the raw JSON value of [weights].
     *
     * Unlike [weights], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("weights") @ExcludeMissing fun _weights(): JsonField<List<Float>> = weights

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

        /** Returns a mutable builder for constructing an instance of [RrfParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RrfParams]. */
    class Builder internal constructor() {

        private var rankConstant: JsonField<Long> = JsonMissing.of()
        private var weights: JsonField<MutableList<Float>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(rrfParams: RrfParams) = apply {
            rankConstant = rrfParams.rankConstant
            weights = rrfParams.weights.map { it.toMutableList() }
            additionalProperties = rrfParams.additionalProperties.toMutableMap()
        }

        /** RRF rank constant (`k`). Must be greater than zero. Defaults to `60`. */
        fun rankConstant(rankConstant: Long) = rankConstant(JsonField.of(rankConstant))

        /**
         * Sets [Builder.rankConstant] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rankConstant] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun rankConstant(rankConstant: JsonField<Long>) = apply { this.rankConstant = rankConstant }

        /**
         * A positive weight for each subquery, in the same order as `queries`. The number of
         * weights must match the number of subqueries. When omitted, every subquery has a weight of
         * `1`.
         */
        fun weights(weights: List<Float>) = weights(JsonField.of(weights))

        /**
         * Sets [Builder.weights] to an arbitrary JSON value.
         *
         * You should usually call [Builder.weights] with a well-typed `List<Float>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun weights(weights: JsonField<List<Float>>) = apply {
            this.weights = weights.map { it.toMutableList() }
        }

        /**
         * Adds a single [Float] to [weights].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addWeight(weight: Float) = apply {
            weights =
                (weights ?: JsonField.of(mutableListOf())).also {
                    checkKnown("weights", it).add(weight)
                }
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
         * Returns an immutable instance of [RrfParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RrfParams =
            RrfParams(
                rankConstant,
                (weights ?: JsonMissing.of()).map { it.toImmutable() },
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
    fun validate(): RrfParams = apply {
        if (validated) {
            return@apply
        }

        rankConstant()
        weights()
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
        (if (rankConstant.asKnown().isPresent) 1 else 0) +
            (weights.asKnown().getOrNull()?.size ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RrfParams &&
            rankConstant == other.rankConstant &&
            weights == other.weights &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(rankConstant, weights, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RrfParams{rankConstant=$rankConstant, weights=$weights, additionalProperties=$additionalProperties}"
}
