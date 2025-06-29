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
import kotlin.jvm.optionals.getOrNull

/** Query, filter, full-text search and vector search documents. */
class Query
private constructor(
    private val aggregateBy: JsonField<MutableMap<String, AggregateBy>>,
    private val distanceMetric: JsonField<DistanceMetric>,
    private val filters: JsonField<Filter>,
    private val includeAttributes: JsonField<IncludeAttributes>,
    private val rankBy: JsonField<RankBy>,
    private val topK: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("aggregate_by")
        @ExcludeMissing
        aggregateBy: JsonField<MutableMap<String, AggregateBy>> = JsonMissing.of(),
        @JsonProperty("distance_metric")
        @ExcludeMissing
        distanceMetric: JsonField<DistanceMetric> = JsonMissing.of(),
        @JsonProperty("filters") @ExcludeMissing filters: JsonField<Filter> = JsonMissing.of(),
        @JsonProperty("include_attributes")
        @ExcludeMissing
        includeAttributes: JsonField<IncludeAttributes> = JsonMissing.of(),
        @JsonProperty("rank_by") @ExcludeMissing rankBy: JsonField<RankBy> = JsonMissing.of(),
        @JsonProperty("top_k") @ExcludeMissing topK: JsonField<Long> = JsonMissing.of(),
    ) : this(aggregateBy, distanceMetric, filters, includeAttributes, rankBy, topK, mutableMapOf())

    /**
     * Aggregations to compute over all documents in the namespace that match the filters.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun aggregateBy(): Optional<MutableMap<String, AggregateBy>> =
        aggregateBy.getOptional("aggregate_by")

    /**
     * A function used to calculate vector similarity.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun distanceMetric(): Optional<DistanceMetric> = distanceMetric.getOptional("distance_metric")

    /**
     * Exact filters for attributes to refine search results for. Think of it as a SQL WHERE clause.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun filters(): Optional<Filter> = filters.getOptional("filters")

    /**
     * Exact filters for attributes to refine search results for. Think of it as a SQL WHERE clause.
     *
     * Unlike [filters], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("filters") @ExcludeMissing fun _filters(): JsonField<Filter> = filters

    /**
     * Whether to include attributes in the response.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun includeAttributes(): Optional<IncludeAttributes> =
        includeAttributes.getOptional("include_attributes")

    /**
     * How to rank the documents in the namespace.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun rankBy(): Optional<RankBy> = rankBy.getOptional("rank_by")

    /**
     * How to rank the documents in the namespace.
     *
     * Unlike [rankBy], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("rank_by") @ExcludeMissing fun _rankBy(): JsonField<RankBy> = rankBy

    /**
     * The number of results to return.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun topK(): Optional<Long> = topK.getOptional("top_k")

    /**
     * Returns the raw JSON value of [aggregateBy].
     *
     * Unlike [aggregateBy], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("aggregate_by")
    @ExcludeMissing
    fun _aggregateBy(): JsonField<MutableMap<String, AggregateBy>> = aggregateBy

    /**
     * Returns the raw JSON value of [distanceMetric].
     *
     * Unlike [distanceMetric], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("distance_metric")
    @ExcludeMissing
    fun _distanceMetric(): JsonField<DistanceMetric> = distanceMetric

    /**
     * Returns the raw JSON value of [includeAttributes].
     *
     * Unlike [includeAttributes], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("include_attributes")
    @ExcludeMissing
    fun _includeAttributes(): JsonField<IncludeAttributes> = includeAttributes

    /**
     * Returns the raw JSON value of [topK].
     *
     * Unlike [topK], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("top_k") @ExcludeMissing fun _topK(): JsonField<Long> = topK

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

        /** Returns a mutable builder for constructing an instance of [Query]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Query]. */
    class Builder internal constructor() {

        private var aggregateBy: JsonField<MutableMap<String, AggregateBy>> = JsonMissing.of()
        private var distanceMetric: JsonField<DistanceMetric> = JsonMissing.of()
        private var filters: JsonField<Filter> = JsonMissing.of()
        private var includeAttributes: JsonField<IncludeAttributes> = JsonMissing.of()
        private var rankBy: JsonField<RankBy> = JsonMissing.of()
        private var topK: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(query: Query) = apply {
            aggregateBy = query.aggregateBy
            distanceMetric = query.distanceMetric
            filters = query.filters
            includeAttributes = query.includeAttributes
            rankBy = query.rankBy
            topK = query.topK
            additionalProperties = query.additionalProperties.toMutableMap()
        }

        /** Aggregations to compute over all documents in the namespace that match the filters. */
        fun aggregateBy(aggregateBy: MutableMap<String, AggregateBy>) =
            aggregateBy(JsonField.of(aggregateBy))

        /**
         * Sets [Builder.aggregateBy] to an arbitrary JSON value.
         *
         * You should usually call [Builder.aggregateBy] with a well-typed [AggregateBy] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun aggregateBy(aggregateBy: JsonField<MutableMap<String, AggregateBy>>) = apply {
            this.aggregateBy = aggregateBy
        }

        /** A function used to calculate vector similarity. */
        fun distanceMetric(distanceMetric: DistanceMetric) =
            distanceMetric(JsonField.of(distanceMetric))

        /**
         * Sets [Builder.distanceMetric] to an arbitrary JSON value.
         *
         * You should usually call [Builder.distanceMetric] with a well-typed [DistanceMetric] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun distanceMetric(distanceMetric: JsonField<DistanceMetric>) = apply {
            this.distanceMetric = distanceMetric
        }

        /**
         * Exact filters for attributes to refine search results for. Think of it as a SQL WHERE
         * clause.
         */
        fun filters(filters: JsonField<Filter>) = apply { this.filters = filters }

        /** Whether to include attributes in the response. */
        fun includeAttributes(includeAttributes: IncludeAttributes) =
            includeAttributes(JsonField.of(includeAttributes))

        /**
         * Sets [Builder.includeAttributes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.includeAttributes] with a well-typed [IncludeAttributes]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun includeAttributes(includeAttributes: JsonField<IncludeAttributes>) = apply {
            this.includeAttributes = includeAttributes
        }

        /** Alias for calling [includeAttributes] with `IncludeAttributes.ofBool(bool)`. */
        fun includeAttributes(bool: Boolean) = includeAttributes(IncludeAttributes.ofBool(bool))

        /** Alias for calling [includeAttributes] with `IncludeAttributes.ofStrings(strings)`. */
        fun includeAttributesOfStrings(strings: List<String>) =
            includeAttributes(IncludeAttributes.ofStrings(strings))

        /** How to rank the documents in the namespace. */
        fun rankBy(rankBy: JsonField<RankBy>) = apply { this.rankBy = rankBy }

        /** The number of results to return. */
        fun topK(topK: Long) = topK(JsonField.of(topK))

        /**
         * Sets [Builder.topK] to an arbitrary JSON value.
         *
         * You should usually call [Builder.topK] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun topK(topK: JsonField<Long>) = apply { this.topK = topK }

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
         * Returns an immutable instance of [Query].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): Query =
            Query(
                aggregateBy,
                distanceMetric,
                filters,
                includeAttributes,
                rankBy,
                topK,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Query = apply {
        if (validated) {
            return@apply
        }

        aggregateBy()
        distanceMetric().ifPresent { it.validate() }
        filters()
        rankBy()
        includeAttributes().ifPresent { it.validate() }
        topK()
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
        (if (aggregateBy.asKnown().isPresent()) 1 else 0) +
            (distanceMetric.asKnown().getOrNull()?.validity() ?: 0) +
            (if (filters.asKnown().isPresent()) 1 else 0) +
            (if (rankBy.asKnown().isPresent()) 1 else 0) +
            (includeAttributes.asKnown().getOrNull()?.validity() ?: 0) +
            (if (topK.asKnown().isPresent) 1 else 0)

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(aggregateBy, distanceMetric, filters, includeAttributes, rankBy, topK, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Query{aggregateBy=$aggregateBy, distanceMetric=$distanceMetric, filters=$filters, includeAttributes=$includeAttributes, rankBy=$rankBy, topK=$topK, additionalProperties=$additionalProperties}"
}
