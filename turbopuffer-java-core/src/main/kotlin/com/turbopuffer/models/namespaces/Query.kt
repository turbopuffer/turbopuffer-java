// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.BaseDeserializer
import com.turbopuffer.core.BaseSerializer
import com.turbopuffer.core.ExcludeMissing
import com.turbopuffer.core.JsonField
import com.turbopuffer.core.JsonMissing
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.allMaxBy
import com.turbopuffer.core.checkKnown
import com.turbopuffer.core.getOrThrow
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
    private val aggregateBy: JsonField<MutableMap<String, AggregateBy>>,
    private val distanceMetric: JsonField<DistanceMetric>,
    private val excludeAttributes: JsonField<List<String>>,
    private val filters: JsonField<Filter>,
    private val groupBy: JsonField<List<String>>,
    private val includeAttributes: JsonField<IncludeAttributes>,
    private val limit: JsonField<Limit>,
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
        @JsonProperty("exclude_attributes")
        @ExcludeMissing
        excludeAttributes: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("filters") @ExcludeMissing filters: JsonField<Filter> = JsonMissing.of(),
        @JsonProperty("group_by")
        @ExcludeMissing
        groupBy: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("include_attributes")
        @ExcludeMissing
        includeAttributes: JsonField<IncludeAttributes> = JsonMissing.of(),
        @JsonProperty("limit") @ExcludeMissing limit: JsonField<Limit> = JsonMissing.of(),
        @JsonProperty("rank_by") @ExcludeMissing rankBy: JsonField<RankBy> = JsonMissing.of(),
        @JsonProperty("top_k") @ExcludeMissing topK: JsonField<Long> = JsonMissing.of(),
    ) : this(
        aggregateBy,
        distanceMetric,
        excludeAttributes,
        filters,
        groupBy,
        includeAttributes,
        limit,
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

    /**
     * Limits the documents returned by a query.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun limit(): Optional<Limit> = limit.getOptional("limit")

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
     * Returns the raw JSON value of [limit].
     *
     * Unlike [limit], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("limit") @ExcludeMissing fun _limit(): JsonField<Limit> = limit

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
        private var excludeAttributes: JsonField<MutableList<String>>? = null
        private var filters: JsonField<Filter> = JsonMissing.of()
        private var groupBy: JsonField<MutableList<String>>? = null
        private var includeAttributes: JsonField<IncludeAttributes> = JsonMissing.of()
        private var limit: JsonField<Limit> = JsonMissing.of()
        private var rankBy: JsonField<RankBy> = JsonMissing.of()
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
            limit = query.limit
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
        fun filters(filters: Filter) = filters(JsonField.of(filters))

        /**
         * Sets [Builder.filters] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filters] with a well-typed [Filter] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun filters(filters: JsonField<Filter>) = apply { this.filters = filters }

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

        /** Limits the documents returned by a query. */
        fun limit(limit: Limit) = limit(JsonField.of(limit))

        /**
         * Sets [Builder.limit] to an arbitrary JSON value.
         *
         * You should usually call [Builder.limit] with a well-typed [Limit] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun limit(limit: JsonField<Limit>) = apply { this.limit = limit }

        /** Alias for calling [limit] with `Limit.ofInteger(integer)`. */
        fun limit(integer: Long) = limit(Limit.ofInteger(integer))

        /** Alias for calling [Builder.limit] with `Limit.ofLimit(limit)`. */
        fun limit(limit: com.turbopuffer.models.namespaces.Limit) = limit(Limit.ofLimit(limit))

        /** How to rank the documents in the namespace. */
        fun rankBy(rankBy: RankBy) = rankBy(JsonField.of(rankBy))

        /**
         * Sets [Builder.rankBy] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rankBy] with a well-typed [RankBy] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
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
                (excludeAttributes ?: JsonMissing.of()).map { it.toImmutable() },
                filters,
                (groupBy ?: JsonMissing.of()).map { it.toImmutable() },
                includeAttributes,
                limit,
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
        excludeAttributes()

        includeAttributes().ifPresent { it.validate() }
        limit().ifPresent { it.validate() }
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
            (excludeAttributes.asKnown().getOrNull()?.size ?: 0) +
            (if (filters.asKnown().isPresent()) 1 else 0) +
            (groupBy.asKnown().getOrNull()?.size ?: 0) +
            (includeAttributes.asKnown().getOrNull()?.validity() ?: 0) +
            (limit.asKnown().getOrNull()?.validity() ?: 0) +
            (if (rankBy.asKnown().isPresent()) 1 else 0) +
            (if (topK.asKnown().isPresent) 1 else 0)

    /** Limits the documents returned by a query. */
    @JsonDeserialize(using = Limit.Deserializer::class)
    @JsonSerialize(using = Limit.Serializer::class)
    class Limit
    private constructor(
        private val integer: Long? = null,
        private val limit: com.turbopuffer.models.namespaces.Limit? = null,
        private val _json: JsonValue? = null,
    ) {

        fun integer(): Optional<Long> = Optional.ofNullable(integer)

        /** Limits the documents returned by a query. */
        fun limit(): Optional<com.turbopuffer.models.namespaces.Limit> = Optional.ofNullable(limit)

        fun isInteger(): Boolean = integer != null

        fun isLimit(): Boolean = limit != null

        fun asInteger(): Long = integer.getOrThrow("integer")

        /** Limits the documents returned by a query. */
        fun asLimit(): com.turbopuffer.models.namespaces.Limit = limit.getOrThrow("limit")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                integer != null -> visitor.visitInteger(integer)
                limit != null -> visitor.visitLimit(limit)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Limit = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitInteger(integer: Long) {}

                    override fun visitLimit(limit: com.turbopuffer.models.namespaces.Limit) {
                        limit.validate()
                    }
                }
            )
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
            accept(
                object : Visitor<Int> {
                    override fun visitInteger(integer: Long) = 1

                    override fun visitLimit(limit: com.turbopuffer.models.namespaces.Limit) =
                        limit.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Limit && integer == other.integer && limit == other.limit
        }

        override fun hashCode(): Int = Objects.hash(integer, limit)

        override fun toString(): String =
            when {
                integer != null -> "Limit{integer=$integer}"
                limit != null -> "Limit{limit=$limit}"
                _json != null -> "Limit{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Limit")
            }

        companion object {

            @JvmStatic fun ofInteger(integer: Long) = Limit(integer = integer)

            /** Limits the documents returned by a query. */
            @JvmStatic
            fun ofLimit(limit: com.turbopuffer.models.namespaces.Limit) = Limit(limit = limit)
        }

        /** An interface that defines how to map each variant of [Limit] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitInteger(integer: Long): T

            /** Limits the documents returned by a query. */
            fun visitLimit(limit: com.turbopuffer.models.namespaces.Limit): T

            /**
             * Maps an unknown variant of [Limit] to a value of type [T].
             *
             * An instance of [Limit] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws TurbopufferInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw TurbopufferInvalidDataException("Unknown Limit: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Limit>(Limit::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Limit {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(
                                    node,
                                    jacksonTypeRef<com.turbopuffer.models.namespaces.Limit>(),
                                )
                                ?.let { Limit(limit = it, _json = json) },
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                Limit(integer = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Limit(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Limit>(Limit::class) {

            override fun serialize(
                value: Limit,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.integer != null -> generator.writeObject(value.integer)
                    value.limit != null -> generator.writeObject(value.limit)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Limit")
                }
            }
        }
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
            limit == other.limit &&
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
            limit,
            rankBy,
            topK,
            additionalProperties,
        )
    }

    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Query{aggregateBy=$aggregateBy, distanceMetric=$distanceMetric, excludeAttributes=$excludeAttributes, filters=$filters, groupBy=$groupBy, includeAttributes=$includeAttributes, limit=$limit, rankBy=$rankBy, topK=$topK, additionalProperties=$additionalProperties}"
}
