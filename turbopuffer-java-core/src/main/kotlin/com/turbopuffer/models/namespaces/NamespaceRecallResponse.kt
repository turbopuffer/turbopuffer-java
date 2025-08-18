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

/** The response to a successful cache warm request. */
class NamespaceRecallResponse
private constructor(
    private val avgAnnCount: JsonField<Double>,
    private val avgExhaustiveCount: JsonField<Double>,
    private val avgRecall: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("avg_ann_count")
        @ExcludeMissing
        avgAnnCount: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("avg_exhaustive_count")
        @ExcludeMissing
        avgExhaustiveCount: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("avg_recall") @ExcludeMissing avgRecall: JsonField<Double> = JsonMissing.of(),
    ) : this(avgAnnCount, avgExhaustiveCount, avgRecall, mutableMapOf())

    /**
     * The average number of documents retrieved by the approximate nearest neighbor searches.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun avgAnnCount(): Double = avgAnnCount.getRequired("avg_ann_count")

    /**
     * The average number of documents retrieved by the exhaustive searches.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun avgExhaustiveCount(): Double = avgExhaustiveCount.getRequired("avg_exhaustive_count")

    /**
     * The average recall of the queries.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun avgRecall(): Double = avgRecall.getRequired("avg_recall")

    /**
     * Returns the raw JSON value of [avgAnnCount].
     *
     * Unlike [avgAnnCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("avg_ann_count")
    @ExcludeMissing
    fun _avgAnnCount(): JsonField<Double> = avgAnnCount

    /**
     * Returns the raw JSON value of [avgExhaustiveCount].
     *
     * Unlike [avgExhaustiveCount], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("avg_exhaustive_count")
    @ExcludeMissing
    fun _avgExhaustiveCount(): JsonField<Double> = avgExhaustiveCount

    /**
     * Returns the raw JSON value of [avgRecall].
     *
     * Unlike [avgRecall], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("avg_recall") @ExcludeMissing fun _avgRecall(): JsonField<Double> = avgRecall

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
         * Returns a mutable builder for constructing an instance of [NamespaceRecallResponse].
         *
         * The following fields are required:
         * ```java
         * .avgAnnCount()
         * .avgExhaustiveCount()
         * .avgRecall()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceRecallResponse]. */
    class Builder internal constructor() {

        private var avgAnnCount: JsonField<Double>? = null
        private var avgExhaustiveCount: JsonField<Double>? = null
        private var avgRecall: JsonField<Double>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(namespaceRecallResponse: NamespaceRecallResponse) = apply {
            avgAnnCount = namespaceRecallResponse.avgAnnCount
            avgExhaustiveCount = namespaceRecallResponse.avgExhaustiveCount
            avgRecall = namespaceRecallResponse.avgRecall
            additionalProperties = namespaceRecallResponse.additionalProperties.toMutableMap()
        }

        /**
         * The average number of documents retrieved by the approximate nearest neighbor searches.
         */
        fun avgAnnCount(avgAnnCount: Double) = avgAnnCount(JsonField.of(avgAnnCount))

        /**
         * Sets [Builder.avgAnnCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.avgAnnCount] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun avgAnnCount(avgAnnCount: JsonField<Double>) = apply { this.avgAnnCount = avgAnnCount }

        /** The average number of documents retrieved by the exhaustive searches. */
        fun avgExhaustiveCount(avgExhaustiveCount: Double) =
            avgExhaustiveCount(JsonField.of(avgExhaustiveCount))

        /**
         * Sets [Builder.avgExhaustiveCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.avgExhaustiveCount] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun avgExhaustiveCount(avgExhaustiveCount: JsonField<Double>) = apply {
            this.avgExhaustiveCount = avgExhaustiveCount
        }

        /** The average recall of the queries. */
        fun avgRecall(avgRecall: Double) = avgRecall(JsonField.of(avgRecall))

        /**
         * Sets [Builder.avgRecall] to an arbitrary JSON value.
         *
         * You should usually call [Builder.avgRecall] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun avgRecall(avgRecall: JsonField<Double>) = apply { this.avgRecall = avgRecall }

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
         * Returns an immutable instance of [NamespaceRecallResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .avgAnnCount()
         * .avgExhaustiveCount()
         * .avgRecall()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): NamespaceRecallResponse =
            NamespaceRecallResponse(
                checkRequired("avgAnnCount", avgAnnCount),
                checkRequired("avgExhaustiveCount", avgExhaustiveCount),
                checkRequired("avgRecall", avgRecall),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): NamespaceRecallResponse = apply {
        if (validated) {
            return@apply
        }

        avgAnnCount()
        avgExhaustiveCount()
        avgRecall()
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
        (if (avgAnnCount.asKnown().isPresent) 1 else 0) +
            (if (avgExhaustiveCount.asKnown().isPresent) 1 else 0) +
            (if (avgRecall.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is NamespaceRecallResponse &&
            avgAnnCount == other.avgAnnCount &&
            avgExhaustiveCount == other.avgExhaustiveCount &&
            avgRecall == other.avgRecall &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(avgAnnCount, avgExhaustiveCount, avgRecall, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "NamespaceRecallResponse{avgAnnCount=$avgAnnCount, avgExhaustiveCount=$avgExhaustiveCount, avgRecall=$avgRecall, additionalProperties=$additionalProperties}"
}
