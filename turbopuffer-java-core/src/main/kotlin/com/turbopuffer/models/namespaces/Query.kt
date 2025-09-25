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

/** Query, filter, full-text search and vector search documents. */
class Query
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val aggregateBy: JsonField<AggregateBy>,
    private val distanceMetric: JsonField<DistanceMetric>,
    private val excludeAttributes: JsonField<List<String>>,
    private val filters: JsonValue,
    private val groupBy: JsonField<List<String>>,
    private val includeAttributes: JsonField<IncludeAttributes>,
    private val rankBy: JsonValue,
    private val topK: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("aggregate_by")
        @ExcludeMissing
        aggregateBy: JsonField<AggregateBy> = JsonMissing.of(),
        @JsonProperty("distance_metric")
        @ExcludeMissing
        distanceMetric: JsonField<DistanceMetric> = JsonMissing.of(),
        @JsonProperty("exclude_attributes")
        @ExcludeMissing
        excludeAttributes: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("filters") @ExcludeMissing filters: JsonValue = JsonMissing.of(),
        @JsonProperty("group_by")
        @ExcludeMissing
        groupBy: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("include_attributes")
        @ExcludeMissing
        includeAttributes: JsonField<IncludeAttributes> = JsonMissing.of(),
        @JsonProperty("rank_by") @ExcludeMissing rankBy: JsonValue = JsonMissing.of(),
        @JsonProperty("top_k") @ExcludeMissing topK: JsonField<Long> = JsonMissing.of(),
    ) : this(
        aggregateBy,
        distanceMetric,
        excludeAttributes,
        filters,
        groupBy,
        includeAttributes,
        rankBy,
        topK,
        mutableMapOf(),
    )

    /**
     * Aggregations to compute over all documents in the namespace that match the filters.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun aggregateBy(): Optional<AggregateBy> = aggregateBy.getOptional("aggregate_by")

    /**
     * A function used to calculate vector similarity.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun distanceMetric(): Optional<DistanceMetric> = distanceMetric.getOptional("distance_metric")

    /**
     * List of attribute names to exclude from the response. All other attributes will be included
     * in the response.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun excludeAttributes(): Optional<List<String>> =
        excludeAttributes.getOptional("exclude_attributes")

    /**
     * Exact filters for attributes to refine search results for. Think of it as a SQL WHERE clause.
     */
    @JsonProperty("filters") @ExcludeMissing fun _filters(): JsonValue = filters

    /**
     * Groups documents by the specified attributes (the "group key") before computing aggregates.
     * Aggregates are computed separately for each group.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun groupBy(): Optional<List<String>> = groupBy.getOptional("group_by")

    /**
     * Whether to include attributes in the response.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun includeAttributes(): Optional<IncludeAttributes> =
        includeAttributes.getOptional("include_attributes")

    /** How to rank the documents in the namespace. */
    @JsonProperty("rank_by") @ExcludeMissing fun _rankBy(): JsonValue = rankBy

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
    fun _aggregateBy(): JsonField<AggregateBy> = aggregateBy

    /**
     * Returns the raw JSON value of [distanceMetric].
     *
     * Unlike [distanceMetric], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("distance_metric")
    @ExcludeMissing
    fun _distanceMetric(): JsonField<DistanceMetric> = distanceMetric

    /**
     * Returns the raw JSON value of [excludeAttributes].
     *
     * Unlike [excludeAttributes], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("exclude_attributes")
    @ExcludeMissing
    fun _excludeAttributes(): JsonField<List<String>> = excludeAttributes

    /**
     * Returns the raw JSON value of [groupBy].
     *
     * Unlike [groupBy], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("group_by") @ExcludeMissing fun _groupBy(): JsonField<List<String>> = groupBy

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

        private var aggregateBy: JsonField<AggregateBy> = JsonMissing.of()
        private var distanceMetric: JsonField<DistanceMetric> = JsonMissing.of()
        private var excludeAttributes: JsonField<MutableList<String>>? = null
        private var filters: JsonValue = JsonMissing.of()
        private var groupBy: JsonField<MutableList<String>>? = null
        private var includeAttributes: JsonField<IncludeAttributes> = JsonMissing.of()
        private var rankBy: JsonValue = JsonMissing.of()
        private var topK: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(query: Query) = apply {
            aggregateBy = query.aggregateBy
            distanceMetric = query.distanceMetric
            excludeAttributes = query.excludeAttributes.map { it.toMutableList() }
            filters = query.filters
            groupBy = query.groupBy.map { it.toMutableList() }
            includeAttributes = query.includeAttributes
            rankBy = query.rankBy
            topK = query.topK
            additionalProperties = query.additionalProperties.toMutableMap()
        }

        /** Aggregations to compute over all documents in the namespace that match the filters. */
        fun aggregateBy(aggregateBy: AggregateBy) = aggregateBy(JsonField.of(aggregateBy))

        /**
         * Sets [Builder.aggregateBy] to an arbitrary JSON value.
         *
         * You should usually call [Builder.aggregateBy] with a well-typed [AggregateBy] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun aggregateBy(aggregateBy: JsonField<AggregateBy>) = apply {
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
         * List of attribute names to exclude from the response. All other attributes will be
         * included in the response.
         */
        fun excludeAttributes(excludeAttributes: List<String>) =
            excludeAttributes(JsonField.of(excludeAttributes))

        /**
         * Sets [Builder.excludeAttributes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.excludeAttributes] with a well-typed `List<String>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun excludeAttributes(excludeAttributes: JsonField<List<String>>) = apply {
            this.excludeAttributes = excludeAttributes.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [excludeAttributes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addExcludeAttribute(excludeAttribute: String) = apply {
            excludeAttributes =
                (excludeAttributes ?: JsonField.of(mutableListOf())).also {
                    checkKnown("excludeAttributes", it).add(excludeAttribute)
                }
        }

        /**
         * Exact filters for attributes to refine search results for. Think of it as a SQL WHERE
         * clause.
         */
        fun filters(filters: JsonValue) = apply { this.filters = filters }

        /**
         * Groups documents by the specified attributes (the "group key") before computing
         * aggregates. Aggregates are computed separately for each group.
         */
        fun groupBy(groupBy: List<String>) = groupBy(JsonField.of(groupBy))

        /**
         * Sets [Builder.groupBy] to an arbitrary JSON value.
         *
         * You should usually call [Builder.groupBy] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun groupBy(groupBy: JsonField<List<String>>) = apply {
            this.groupBy = groupBy.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [Builder.groupBy].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addGroupBy(groupBy: String) = apply {
            this.groupBy =
                (this.groupBy ?: JsonField.of(mutableListOf())).also {
                    checkKnown("groupBy", it).add(groupBy)
                }
        }

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
        fun rankBy(rankBy: JsonValue) = apply { this.rankBy = rankBy }

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
                (excludeAttributes ?: JsonMissing.of()).map { it.toImmutable() },
                filters,
                (groupBy ?: JsonMissing.of()).map { it.toImmutable() },
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

        aggregateBy().ifPresent { it.validate() }
        distanceMetric().ifPresent { it.validate() }
        excludeAttributes()
        groupBy()
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
        (aggregateBy.asKnown().getOrNull()?.validity() ?: 0) +
            (distanceMetric.asKnown().getOrNull()?.validity() ?: 0) +
            (excludeAttributes.asKnown().getOrNull()?.size ?: 0) +
            (groupBy.asKnown().getOrNull()?.size ?: 0) +
            (includeAttributes.asKnown().getOrNull()?.validity() ?: 0) +
            (if (topK.asKnown().isPresent) 1 else 0)

    /** Aggregations to compute over all documents in the namespace that match the filters. */
    class AggregateBy
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [AggregateBy]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AggregateBy]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(aggregateBy: AggregateBy) = apply {
                additionalProperties = aggregateBy.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [AggregateBy].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): AggregateBy = AggregateBy(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): AggregateBy = apply {
            if (validated) {
                return@apply
            }

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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AggregateBy && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "AggregateBy{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Query &&
            aggregateBy == other.aggregateBy &&
            distanceMetric == other.distanceMetric &&
            excludeAttributes == other.excludeAttributes &&
            filters == other.filters &&
            groupBy == other.groupBy &&
            includeAttributes == other.includeAttributes &&
            rankBy == other.rankBy &&
            topK == other.topK &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            aggregateBy,
            distanceMetric,
            excludeAttributes,
            filters,
            groupBy,
            includeAttributes,
            rankBy,
            topK,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Query{aggregateBy=$aggregateBy, distanceMetric=$distanceMetric, excludeAttributes=$excludeAttributes, filters=$filters, groupBy=$groupBy, includeAttributes=$includeAttributes, rankBy=$rankBy, topK=$topK, additionalProperties=$additionalProperties}"
}
