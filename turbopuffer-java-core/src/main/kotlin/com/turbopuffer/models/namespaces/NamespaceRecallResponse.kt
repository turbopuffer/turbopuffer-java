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

/** The response to a successful cache warm request. */
class NamespaceRecallResponse
private constructor(
    private val avgAnnCount: JsonField<Double>,
    private val avgExhaustiveCount: JsonField<Double>,
    private val avgRecall: JsonField<Double>,
    private val groundTruth: JsonField<List<GroundTruth>>,
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
        @JsonProperty("ground_truth")
        @ExcludeMissing
        groundTruth: JsonField<List<GroundTruth>> = JsonMissing.of(),
    ) : this(avgAnnCount, avgExhaustiveCount, avgRecall, groundTruth, mutableMapOf())

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
     * Ground truth data including query vectors and true nearest neighbors. Only included when
     * include_ground_truth is true.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun groundTruth(): Optional<List<GroundTruth>> = groundTruth.getOptional("ground_truth")

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

    /**
     * Returns the raw JSON value of [groundTruth].
     *
     * Unlike [groundTruth], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ground_truth")
    @ExcludeMissing
    fun _groundTruth(): JsonField<List<GroundTruth>> = groundTruth

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
        private var groundTruth: JsonField<MutableList<GroundTruth>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(namespaceRecallResponse: NamespaceRecallResponse) = apply {
            avgAnnCount = namespaceRecallResponse.avgAnnCount
            avgExhaustiveCount = namespaceRecallResponse.avgExhaustiveCount
            avgRecall = namespaceRecallResponse.avgRecall
            groundTruth = namespaceRecallResponse.groundTruth.map { it.toMutableList() }
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

        /**
         * Ground truth data including query vectors and true nearest neighbors. Only included when
         * include_ground_truth is true.
         */
        fun groundTruth(groundTruth: List<GroundTruth>) = groundTruth(JsonField.of(groundTruth))

        /**
         * Sets [Builder.groundTruth] to an arbitrary JSON value.
         *
         * You should usually call [Builder.groundTruth] with a well-typed `List<GroundTruth>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun groundTruth(groundTruth: JsonField<List<GroundTruth>>) = apply {
            this.groundTruth = groundTruth.map { it.toMutableList() }
        }

        /**
         * Adds a single [GroundTruth] to [Builder.groundTruth].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addGroundTruth(groundTruth: GroundTruth) = apply {
            this.groundTruth =
                (this.groundTruth ?: JsonField.of(mutableListOf())).also {
                    checkKnown("groundTruth", it).add(groundTruth)
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
                (groundTruth ?: JsonMissing.of()).map { it.toImmutable() },
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
        groundTruth().ifPresent { it.forEach { it.validate() } }
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
            (if (avgRecall.asKnown().isPresent) 1 else 0) +
            (groundTruth.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    class GroundTruth
    private constructor(
        private val nearestNeighbors: JsonField<List<Row>>,
        private val queryVector: JsonField<List<Double>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("nearest_neighbors")
            @ExcludeMissing
            nearestNeighbors: JsonField<List<Row>> = JsonMissing.of(),
            @JsonProperty("query_vector")
            @ExcludeMissing
            queryVector: JsonField<List<Double>> = JsonMissing.of(),
        ) : this(nearestNeighbors, queryVector, mutableMapOf())

        /**
         * The true nearest neighbors with their distances and vectors.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun nearestNeighbors(): List<Row> = nearestNeighbors.getRequired("nearest_neighbors")

        /**
         * The query vector used for this search.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun queryVector(): List<Double> = queryVector.getRequired("query_vector")

        /**
         * Returns the raw JSON value of [nearestNeighbors].
         *
         * Unlike [nearestNeighbors], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("nearest_neighbors")
        @ExcludeMissing
        fun _nearestNeighbors(): JsonField<List<Row>> = nearestNeighbors

        /**
         * Returns the raw JSON value of [queryVector].
         *
         * Unlike [queryVector], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("query_vector")
        @ExcludeMissing
        fun _queryVector(): JsonField<List<Double>> = queryVector

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
             * Returns a mutable builder for constructing an instance of [GroundTruth].
             *
             * The following fields are required:
             * ```java
             * .nearestNeighbors()
             * .queryVector()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [GroundTruth]. */
        class Builder internal constructor() {

            private var nearestNeighbors: JsonField<MutableList<Row>>? = null
            private var queryVector: JsonField<MutableList<Double>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(groundTruth: GroundTruth) = apply {
                nearestNeighbors = groundTruth.nearestNeighbors.map { it.toMutableList() }
                queryVector = groundTruth.queryVector.map { it.toMutableList() }
                additionalProperties = groundTruth.additionalProperties.toMutableMap()
            }

            /** The true nearest neighbors with their distances and vectors. */
            fun nearestNeighbors(nearestNeighbors: List<Row>) =
                nearestNeighbors(JsonField.of(nearestNeighbors))

            /**
             * Sets [Builder.nearestNeighbors] to an arbitrary JSON value.
             *
             * You should usually call [Builder.nearestNeighbors] with a well-typed `List<Row>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun nearestNeighbors(nearestNeighbors: JsonField<List<Row>>) = apply {
                this.nearestNeighbors = nearestNeighbors.map { it.toMutableList() }
            }

            /**
             * Adds a single [Row] to [nearestNeighbors].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addNearestNeighbor(nearestNeighbor: Row) = apply {
                nearestNeighbors =
                    (nearestNeighbors ?: JsonField.of(mutableListOf())).also {
                        checkKnown("nearestNeighbors", it).add(nearestNeighbor)
                    }
            }

            /** The query vector used for this search. */
            fun queryVector(queryVector: List<Double>) = queryVector(JsonField.of(queryVector))

            /**
             * Sets [Builder.queryVector] to an arbitrary JSON value.
             *
             * You should usually call [Builder.queryVector] with a well-typed `List<Double>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun queryVector(queryVector: JsonField<List<Double>>) = apply {
                this.queryVector = queryVector.map { it.toMutableList() }
            }

            /**
             * Adds a single [Double] to [Builder.queryVector].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addQueryVector(queryVector: Double) = apply {
                this.queryVector =
                    (this.queryVector ?: JsonField.of(mutableListOf())).also {
                        checkKnown("queryVector", it).add(queryVector)
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
             * Returns an immutable instance of [GroundTruth].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .nearestNeighbors()
             * .queryVector()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): GroundTruth =
                GroundTruth(
                    checkRequired("nearestNeighbors", nearestNeighbors).map { it.toImmutable() },
                    checkRequired("queryVector", queryVector).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): GroundTruth = apply {
            if (validated) {
                return@apply
            }

            nearestNeighbors()
            queryVector()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (nearestNeighbors.asKnown().getOrNull()?.size ?: 0) +
                (queryVector.asKnown().getOrNull()?.size ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is GroundTruth &&
                nearestNeighbors == other.nearestNeighbors &&
                queryVector == other.queryVector &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(nearestNeighbors, queryVector, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "GroundTruth{nearestNeighbors=$nearestNeighbors, queryVector=$queryVector, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is NamespaceRecallResponse &&
            avgAnnCount == other.avgAnnCount &&
            avgExhaustiveCount == other.avgExhaustiveCount &&
            avgRecall == other.avgRecall &&
            groundTruth == other.groundTruth &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(avgAnnCount, avgExhaustiveCount, avgRecall, groundTruth, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "NamespaceRecallResponse{avgAnnCount=$avgAnnCount, avgExhaustiveCount=$avgExhaustiveCount, avgRecall=$avgRecall, groundTruth=$groundTruth, additionalProperties=$additionalProperties}"
}
