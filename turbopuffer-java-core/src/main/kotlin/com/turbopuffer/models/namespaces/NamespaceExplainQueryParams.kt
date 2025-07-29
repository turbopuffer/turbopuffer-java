// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.turbopuffer.core.Enum
import com.turbopuffer.core.ExcludeMissing
import com.turbopuffer.core.JsonField
import com.turbopuffer.core.JsonMissing
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.Params
import com.turbopuffer.core.checkKnown
import com.turbopuffer.core.http.Headers
import com.turbopuffer.core.http.QueryParams
import com.turbopuffer.core.toImmutable
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Explain a query plan. */
class NamespaceExplainQueryParams
private constructor(
    private val namespace: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun namespace(): Optional<String> = Optional.ofNullable(namespace)

    /**
     * Aggregations to compute over all documents in the namespace that match the filters.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun aggregateBy(): Optional<Query.AggregateBy> = body.aggregateBy()

    /**
     * A function used to calculate vector similarity.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun distanceMetric(): Optional<DistanceMetric> = body.distanceMetric()

    /**
     * List of attribute names to exclude from the response. All other attributes will be included
     * in the response.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun excludeAttributes(): Optional<List<String>> = body.excludeAttributes()

    /**
     * Exact filters for attributes to refine search results for. Think of it as a SQL WHERE clause.
     */
    fun _filters(): JsonValue = body._filters()

    /**
     * Whether to include attributes in the response.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun includeAttributes(): Optional<IncludeAttributes> = body.includeAttributes()

    /** How to rank the documents in the namespace. */
    fun _rankBy(): JsonValue = body._rankBy()

    /**
     * The number of results to return.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun topK(): Optional<Long> = body.topK()

    /**
     * The consistency level for a query.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun consistency(): Optional<Consistency> = body.consistency()

    /**
     * The encoding to use for vectors in the response.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun vectorEncoding(): Optional<VectorEncoding> = body.vectorEncoding()

    /**
     * Returns the raw JSON value of [aggregateBy].
     *
     * Unlike [aggregateBy], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _aggregateBy(): JsonField<Query.AggregateBy> = body._aggregateBy()

    /**
     * Returns the raw JSON value of [distanceMetric].
     *
     * Unlike [distanceMetric], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _distanceMetric(): JsonField<DistanceMetric> = body._distanceMetric()

    /**
     * Returns the raw JSON value of [excludeAttributes].
     *
     * Unlike [excludeAttributes], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _excludeAttributes(): JsonField<List<String>> = body._excludeAttributes()

    /**
     * Returns the raw JSON value of [includeAttributes].
     *
     * Unlike [includeAttributes], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _includeAttributes(): JsonField<IncludeAttributes> = body._includeAttributes()

    /**
     * Returns the raw JSON value of [topK].
     *
     * Unlike [topK], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _topK(): JsonField<Long> = body._topK()

    /**
     * Returns the raw JSON value of [consistency].
     *
     * Unlike [consistency], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _consistency(): JsonField<Consistency> = body._consistency()

    /**
     * Returns the raw JSON value of [vectorEncoding].
     *
     * Unlike [vectorEncoding], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _vectorEncoding(): JsonField<VectorEncoding> = body._vectorEncoding()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): NamespaceExplainQueryParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of [NamespaceExplainQueryParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceExplainQueryParams]. */
    class Builder internal constructor() {

        private var namespace: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(namespaceExplainQueryParams: NamespaceExplainQueryParams) = apply {
            namespace = namespaceExplainQueryParams.namespace
            body = namespaceExplainQueryParams.body.toBuilder()
            additionalHeaders = namespaceExplainQueryParams.additionalHeaders.toBuilder()
            additionalQueryParams = namespaceExplainQueryParams.additionalQueryParams.toBuilder()
        }

        fun namespace(namespace: String?) = apply { this.namespace = namespace }

        /** Alias for calling [Builder.namespace] with `namespace.orElse(null)`. */
        fun namespace(namespace: Optional<String>) = namespace(namespace.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [aggregateBy]
         * - [distanceMetric]
         * - [excludeAttributes]
         * - [filters]
         * - [includeAttributes]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Aggregations to compute over all documents in the namespace that match the filters. */
        fun aggregateBy(aggregateBy: Query.AggregateBy) = apply { body.aggregateBy(aggregateBy) }

        /**
         * Sets [Builder.aggregateBy] to an arbitrary JSON value.
         *
         * You should usually call [Builder.aggregateBy] with a well-typed [Query.AggregateBy] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun aggregateBy(aggregateBy: JsonField<Query.AggregateBy>) = apply {
            body.aggregateBy(aggregateBy)
        }

        /** A function used to calculate vector similarity. */
        fun distanceMetric(distanceMetric: DistanceMetric) = apply {
            body.distanceMetric(distanceMetric)
        }

        /**
         * Sets [Builder.distanceMetric] to an arbitrary JSON value.
         *
         * You should usually call [Builder.distanceMetric] with a well-typed [DistanceMetric] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun distanceMetric(distanceMetric: JsonField<DistanceMetric>) = apply {
            body.distanceMetric(distanceMetric)
        }

        /**
         * List of attribute names to exclude from the response. All other attributes will be
         * included in the response.
         */
        fun excludeAttributes(excludeAttributes: List<String>) = apply {
            body.excludeAttributes(excludeAttributes)
        }

        /**
         * Sets [Builder.excludeAttributes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.excludeAttributes] with a well-typed `List<String>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun excludeAttributes(excludeAttributes: JsonField<List<String>>) = apply {
            body.excludeAttributes(excludeAttributes)
        }

        /**
         * Adds a single [String] to [excludeAttributes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addExcludeAttribute(excludeAttribute: String) = apply {
            body.addExcludeAttribute(excludeAttribute)
        }

        /**
         * Exact filters for attributes to refine search results for. Think of it as a SQL WHERE
         * clause.
         */
        fun filters(filters: JsonValue) = apply { body.filters(filters) }

        /** Whether to include attributes in the response. */
        fun includeAttributes(includeAttributes: IncludeAttributes) = apply {
            body.includeAttributes(includeAttributes)
        }

        /**
         * Sets [Builder.includeAttributes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.includeAttributes] with a well-typed [IncludeAttributes]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun includeAttributes(includeAttributes: JsonField<IncludeAttributes>) = apply {
            body.includeAttributes(includeAttributes)
        }

        /** Alias for calling [includeAttributes] with `IncludeAttributes.ofBool(bool)`. */
        fun includeAttributes(bool: Boolean) = apply { body.includeAttributes(bool) }

        /** Alias for calling [includeAttributes] with `IncludeAttributes.ofStrings(strings)`. */
        fun includeAttributesOfStrings(strings: List<String>) = apply {
            body.includeAttributesOfStrings(strings)
        }

        /** How to rank the documents in the namespace. */
        fun rankBy(rankBy: JsonValue) = apply { body.rankBy(rankBy) }

        /** The number of results to return. */
        fun topK(topK: Long) = apply { body.topK(topK) }

        /**
         * Sets [Builder.topK] to an arbitrary JSON value.
         *
         * You should usually call [Builder.topK] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun topK(topK: JsonField<Long>) = apply { body.topK(topK) }

        /** The consistency level for a query. */
        fun consistency(consistency: Consistency) = apply { body.consistency(consistency) }

        /**
         * Sets [Builder.consistency] to an arbitrary JSON value.
         *
         * You should usually call [Builder.consistency] with a well-typed [Consistency] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun consistency(consistency: JsonField<Consistency>) = apply {
            body.consistency(consistency)
        }

        /** The encoding to use for vectors in the response. */
        fun vectorEncoding(vectorEncoding: VectorEncoding) = apply {
            body.vectorEncoding(vectorEncoding)
        }

        /**
         * Sets [Builder.vectorEncoding] to an arbitrary JSON value.
         *
         * You should usually call [Builder.vectorEncoding] with a well-typed [VectorEncoding] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun vectorEncoding(vectorEncoding: JsonField<VectorEncoding>) = apply {
            body.vectorEncoding(vectorEncoding)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [NamespaceExplainQueryParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): NamespaceExplainQueryParams =
            NamespaceExplainQueryParams(
                namespace,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> namespace ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Query, filter, full-text search and vector search documents. */
    class Body
    private constructor(
        private val aggregateBy: JsonField<Query.AggregateBy>,
        private val distanceMetric: JsonField<DistanceMetric>,
        private val excludeAttributes: JsonField<List<String>>,
        private val filters: JsonValue,
        private val includeAttributes: JsonField<IncludeAttributes>,
        private val rankBy: JsonValue,
        private val topK: JsonField<Long>,
        private val consistency: JsonField<Consistency>,
        private val vectorEncoding: JsonField<VectorEncoding>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("aggregate_by")
            @ExcludeMissing
            aggregateBy: JsonField<Query.AggregateBy> = JsonMissing.of(),
            @JsonProperty("distance_metric")
            @ExcludeMissing
            distanceMetric: JsonField<DistanceMetric> = JsonMissing.of(),
            @JsonProperty("exclude_attributes")
            @ExcludeMissing
            excludeAttributes: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("filters") @ExcludeMissing filters: JsonValue = JsonMissing.of(),
            @JsonProperty("include_attributes")
            @ExcludeMissing
            includeAttributes: JsonField<IncludeAttributes> = JsonMissing.of(),
            @JsonProperty("rank_by") @ExcludeMissing rankBy: JsonValue = JsonMissing.of(),
            @JsonProperty("top_k") @ExcludeMissing topK: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("consistency")
            @ExcludeMissing
            consistency: JsonField<Consistency> = JsonMissing.of(),
            @JsonProperty("vector_encoding")
            @ExcludeMissing
            vectorEncoding: JsonField<VectorEncoding> = JsonMissing.of(),
        ) : this(
            aggregateBy,
            distanceMetric,
            excludeAttributes,
            filters,
            includeAttributes,
            rankBy,
            topK,
            consistency,
            vectorEncoding,
            mutableMapOf(),
        )

        fun toQuery(): Query =
            Query.builder()
                .aggregateBy(aggregateBy)
                .distanceMetric(distanceMetric)
                .excludeAttributes(excludeAttributes)
                .filters(filters)
                .includeAttributes(includeAttributes)
                .rankBy(rankBy)
                .topK(topK)
                .build()

        /**
         * Aggregations to compute over all documents in the namespace that match the filters.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun aggregateBy(): Optional<Query.AggregateBy> = aggregateBy.getOptional("aggregate_by")

        /**
         * A function used to calculate vector similarity.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun distanceMetric(): Optional<DistanceMetric> =
            distanceMetric.getOptional("distance_metric")

        /**
         * List of attribute names to exclude from the response. All other attributes will be
         * included in the response.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun excludeAttributes(): Optional<List<String>> =
            excludeAttributes.getOptional("exclude_attributes")

        /**
         * Exact filters for attributes to refine search results for. Think of it as a SQL WHERE
         * clause.
         */
        @JsonProperty("filters") @ExcludeMissing fun _filters(): JsonValue = filters

        /**
         * Whether to include attributes in the response.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun includeAttributes(): Optional<IncludeAttributes> =
            includeAttributes.getOptional("include_attributes")

        /** How to rank the documents in the namespace. */
        @JsonProperty("rank_by") @ExcludeMissing fun _rankBy(): JsonValue = rankBy

        /**
         * The number of results to return.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun topK(): Optional<Long> = topK.getOptional("top_k")

        /**
         * The consistency level for a query.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun consistency(): Optional<Consistency> = consistency.getOptional("consistency")

        /**
         * The encoding to use for vectors in the response.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun vectorEncoding(): Optional<VectorEncoding> =
            vectorEncoding.getOptional("vector_encoding")

        /**
         * Returns the raw JSON value of [aggregateBy].
         *
         * Unlike [aggregateBy], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("aggregate_by")
        @ExcludeMissing
        fun _aggregateBy(): JsonField<Query.AggregateBy> = aggregateBy

        /**
         * Returns the raw JSON value of [distanceMetric].
         *
         * Unlike [distanceMetric], this method doesn't throw if the JSON field has an unexpected
         * type.
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

        /**
         * Returns the raw JSON value of [consistency].
         *
         * Unlike [consistency], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("consistency")
        @ExcludeMissing
        fun _consistency(): JsonField<Consistency> = consistency

        /**
         * Returns the raw JSON value of [vectorEncoding].
         *
         * Unlike [vectorEncoding], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("vector_encoding")
        @ExcludeMissing
        fun _vectorEncoding(): JsonField<VectorEncoding> = vectorEncoding

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var aggregateBy: JsonField<Query.AggregateBy> = JsonMissing.of()
            private var distanceMetric: JsonField<DistanceMetric> = JsonMissing.of()
            private var excludeAttributes: JsonField<MutableList<String>>? = null
            private var filters: JsonValue = JsonMissing.of()
            private var includeAttributes: JsonField<IncludeAttributes> = JsonMissing.of()
            private var rankBy: JsonValue = JsonMissing.of()
            private var topK: JsonField<Long> = JsonMissing.of()
            private var consistency: JsonField<Consistency> = JsonMissing.of()
            private var vectorEncoding: JsonField<VectorEncoding> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                aggregateBy = body.aggregateBy
                distanceMetric = body.distanceMetric
                excludeAttributes = body.excludeAttributes.map { it.toMutableList() }
                filters = body.filters
                includeAttributes = body.includeAttributes
                rankBy = body.rankBy
                topK = body.topK
                consistency = body.consistency
                vectorEncoding = body.vectorEncoding
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Aggregations to compute over all documents in the namespace that match the filters.
             */
            fun aggregateBy(aggregateBy: Query.AggregateBy) = aggregateBy(JsonField.of(aggregateBy))

            /**
             * Sets [Builder.aggregateBy] to an arbitrary JSON value.
             *
             * You should usually call [Builder.aggregateBy] with a well-typed [Query.AggregateBy]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun aggregateBy(aggregateBy: JsonField<Query.AggregateBy>) = apply {
                this.aggregateBy = aggregateBy
            }

            /** A function used to calculate vector similarity. */
            fun distanceMetric(distanceMetric: DistanceMetric) =
                distanceMetric(JsonField.of(distanceMetric))

            /**
             * Sets [Builder.distanceMetric] to an arbitrary JSON value.
             *
             * You should usually call [Builder.distanceMetric] with a well-typed [DistanceMetric]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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

            /** Whether to include attributes in the response. */
            fun includeAttributes(includeAttributes: IncludeAttributes) =
                includeAttributes(JsonField.of(includeAttributes))

            /**
             * Sets [Builder.includeAttributes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.includeAttributes] with a well-typed
             * [IncludeAttributes] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun includeAttributes(includeAttributes: JsonField<IncludeAttributes>) = apply {
                this.includeAttributes = includeAttributes
            }

            /** Alias for calling [includeAttributes] with `IncludeAttributes.ofBool(bool)`. */
            fun includeAttributes(bool: Boolean) = includeAttributes(IncludeAttributes.ofBool(bool))

            /**
             * Alias for calling [includeAttributes] with `IncludeAttributes.ofStrings(strings)`.
             */
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
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun topK(topK: JsonField<Long>) = apply { this.topK = topK }

            /** The consistency level for a query. */
            fun consistency(consistency: Consistency) = consistency(JsonField.of(consistency))

            /**
             * Sets [Builder.consistency] to an arbitrary JSON value.
             *
             * You should usually call [Builder.consistency] with a well-typed [Consistency] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun consistency(consistency: JsonField<Consistency>) = apply {
                this.consistency = consistency
            }

            /** The encoding to use for vectors in the response. */
            fun vectorEncoding(vectorEncoding: VectorEncoding) =
                vectorEncoding(JsonField.of(vectorEncoding))

            /**
             * Sets [Builder.vectorEncoding] to an arbitrary JSON value.
             *
             * You should usually call [Builder.vectorEncoding] with a well-typed [VectorEncoding]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun vectorEncoding(vectorEncoding: JsonField<VectorEncoding>) = apply {
                this.vectorEncoding = vectorEncoding
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(
                    aggregateBy,
                    distanceMetric,
                    (excludeAttributes ?: JsonMissing.of()).map { it.toImmutable() },
                    filters,
                    includeAttributes,
                    rankBy,
                    topK,
                    consistency,
                    vectorEncoding,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            aggregateBy().ifPresent { it.validate() }
            distanceMetric().ifPresent { it.validate() }
            excludeAttributes()
            includeAttributes().ifPresent { it.validate() }
            topK()
            consistency().ifPresent { it.validate() }
            vectorEncoding().ifPresent { it.validate() }
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
            (aggregateBy.asKnown().getOrNull()?.validity() ?: 0) +
                (distanceMetric.asKnown().getOrNull()?.validity() ?: 0) +
                (excludeAttributes.asKnown().getOrNull()?.size ?: 0) +
                (includeAttributes.asKnown().getOrNull()?.validity() ?: 0) +
                (if (topK.asKnown().isPresent) 1 else 0) +
                (consistency.asKnown().getOrNull()?.validity() ?: 0) +
                (vectorEncoding.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && aggregateBy == other.aggregateBy && distanceMetric == other.distanceMetric && excludeAttributes == other.excludeAttributes && filters == other.filters && includeAttributes == other.includeAttributes && rankBy == other.rankBy && topK == other.topK && consistency == other.consistency && vectorEncoding == other.vectorEncoding && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(aggregateBy, distanceMetric, excludeAttributes, filters, includeAttributes, rankBy, topK, consistency, vectorEncoding, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{aggregateBy=$aggregateBy, distanceMetric=$distanceMetric, excludeAttributes=$excludeAttributes, filters=$filters, includeAttributes=$includeAttributes, rankBy=$rankBy, topK=$topK, consistency=$consistency, vectorEncoding=$vectorEncoding, additionalProperties=$additionalProperties}"
    }

    /** The consistency level for a query. */
    class Consistency
    private constructor(
        private val level: JsonField<Level>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("level") @ExcludeMissing level: JsonField<Level> = JsonMissing.of()
        ) : this(level, mutableMapOf())

        /**
         * The query's consistency level.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun level(): Optional<Level> = level.getOptional("level")

        /**
         * Returns the raw JSON value of [level].
         *
         * Unlike [level], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("level") @ExcludeMissing fun _level(): JsonField<Level> = level

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

            /** Returns a mutable builder for constructing an instance of [Consistency]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Consistency]. */
        class Builder internal constructor() {

            private var level: JsonField<Level> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(consistency: Consistency) = apply {
                level = consistency.level
                additionalProperties = consistency.additionalProperties.toMutableMap()
            }

            /** The query's consistency level. */
            fun level(level: Level) = level(JsonField.of(level))

            /**
             * Sets [Builder.level] to an arbitrary JSON value.
             *
             * You should usually call [Builder.level] with a well-typed [Level] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun level(level: JsonField<Level>) = apply { this.level = level }

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
             * Returns an immutable instance of [Consistency].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Consistency = Consistency(level, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Consistency = apply {
            if (validated) {
                return@apply
            }

            level().ifPresent { it.validate() }
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
        @JvmSynthetic internal fun validity(): Int = (level.asKnown().getOrNull()?.validity() ?: 0)

        /** The query's consistency level. */
        class Level @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                /**
                 * Strong consistency. Requires a round-trip to object storage to fetch the latest
                 * writes.
                 */
                @JvmField val STRONG = of("strong")

                /**
                 * Eventual consistency. Does not require a round-trip to object storage, but may
                 * not see the latest writes.
                 */
                @JvmField val EVENTUAL = of("eventual")

                @JvmStatic fun of(value: String) = Level(JsonField.of(value))
            }

            /** An enum containing [Level]'s known values. */
            enum class Known {
                /**
                 * Strong consistency. Requires a round-trip to object storage to fetch the latest
                 * writes.
                 */
                STRONG,
                /**
                 * Eventual consistency. Does not require a round-trip to object storage, but may
                 * not see the latest writes.
                 */
                EVENTUAL,
            }

            /**
             * An enum containing [Level]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Level] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                /**
                 * Strong consistency. Requires a round-trip to object storage to fetch the latest
                 * writes.
                 */
                STRONG,
                /**
                 * Eventual consistency. Does not require a round-trip to object storage, but may
                 * not see the latest writes.
                 */
                EVENTUAL,
                /**
                 * An enum member indicating that [Level] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    STRONG -> Value.STRONG
                    EVENTUAL -> Value.EVENTUAL
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws TurbopufferInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    STRONG -> Known.STRONG
                    EVENTUAL -> Known.EVENTUAL
                    else -> throw TurbopufferInvalidDataException("Unknown Level: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws TurbopufferInvalidDataException if this class instance's value does not have
             *   the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    TurbopufferInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): Level = apply {
                if (validated) {
                    return@apply
                }

                known()
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
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Level && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Consistency && level == other.level && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(level, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Consistency{level=$level, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is NamespaceExplainQueryParams && namespace == other.namespace && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(namespace, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "NamespaceExplainQueryParams{namespace=$namespace, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
