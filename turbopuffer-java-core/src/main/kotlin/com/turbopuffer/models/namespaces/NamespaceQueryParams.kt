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
import com.turbopuffer.core.Enum
import com.turbopuffer.core.ExcludeMissing
import com.turbopuffer.core.JsonField
import com.turbopuffer.core.JsonMissing
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.Params
import com.turbopuffer.core.checkKnown
import com.turbopuffer.core.checkRequired
import com.turbopuffer.core.getOrThrow
import com.turbopuffer.core.http.Headers
import com.turbopuffer.core.http.QueryParams
import com.turbopuffer.core.toImmutable
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** Query, filter, full-text search and vector search documents. */
class NamespaceQueryParams
private constructor(
    private val namespace: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun namespace(): String = namespace

    /**
     * The consistency level for a query.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun consistency(): Optional<Consistency> = body.consistency()

    /**
     * A function used to calculate vector similarity.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun distanceMetric(): Optional<DistanceMetric> = body.distanceMetric()

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

    /**
     * Whether to return vectors for the search results. Vectors are large and slow to deserialize
     * on the client, so use this option only if you need them.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun includeVectors(): Optional<Boolean> = body.includeVectors()

    /** The attribute to rank the results by. Cannot be specified with `vector`. */
    fun _rankBy(): JsonValue = body._rankBy()

    /**
     * The number of results to return.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun topK(): Optional<Long> = body.topK()

    /**
     * A vector to search for. It must have the same number of dimensions as the vectors in the
     * namespace. Cannot be specified with `rank_by`.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun vector(): Optional<List<Double>> = body.vector()

    /**
     * Returns the raw JSON value of [consistency].
     *
     * Unlike [consistency], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _consistency(): JsonField<Consistency> = body._consistency()

    /**
     * Returns the raw JSON value of [distanceMetric].
     *
     * Unlike [distanceMetric], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _distanceMetric(): JsonField<DistanceMetric> = body._distanceMetric()

    /**
     * Returns the raw JSON value of [includeAttributes].
     *
     * Unlike [includeAttributes], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _includeAttributes(): JsonField<IncludeAttributes> = body._includeAttributes()

    /**
     * Returns the raw JSON value of [includeVectors].
     *
     * Unlike [includeVectors], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _includeVectors(): JsonField<Boolean> = body._includeVectors()

    /**
     * Returns the raw JSON value of [topK].
     *
     * Unlike [topK], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _topK(): JsonField<Long> = body._topK()

    /**
     * Returns the raw JSON value of [vector].
     *
     * Unlike [vector], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _vector(): JsonField<List<Double>> = body._vector()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [NamespaceQueryParams].
         *
         * The following fields are required:
         * ```java
         * .namespace()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceQueryParams]. */
    class Builder internal constructor() {

        private var namespace: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(namespaceQueryParams: NamespaceQueryParams) = apply {
            namespace = namespaceQueryParams.namespace
            body = namespaceQueryParams.body.toBuilder()
            additionalHeaders = namespaceQueryParams.additionalHeaders.toBuilder()
            additionalQueryParams = namespaceQueryParams.additionalQueryParams.toBuilder()
        }

        fun namespace(namespace: String) = apply { this.namespace = namespace }

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

        /**
         * Whether to return vectors for the search results. Vectors are large and slow to
         * deserialize on the client, so use this option only if you need them.
         */
        fun includeVectors(includeVectors: Boolean) = apply { body.includeVectors(includeVectors) }

        /**
         * Sets [Builder.includeVectors] to an arbitrary JSON value.
         *
         * You should usually call [Builder.includeVectors] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun includeVectors(includeVectors: JsonField<Boolean>) = apply {
            body.includeVectors(includeVectors)
        }

        /** The attribute to rank the results by. Cannot be specified with `vector`. */
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

        /**
         * A vector to search for. It must have the same number of dimensions as the vectors in the
         * namespace. Cannot be specified with `rank_by`.
         */
        fun vector(vector: List<Double>) = apply { body.vector(vector) }

        /**
         * Sets [Builder.vector] to an arbitrary JSON value.
         *
         * You should usually call [Builder.vector] with a well-typed `List<Double>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun vector(vector: JsonField<List<Double>>) = apply { body.vector(vector) }

        /**
         * Adds a single [Double] to [Builder.vector].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addVector(vector: Double) = apply { body.addVector(vector) }

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
         * Returns an immutable instance of [NamespaceQueryParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .namespace()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): NamespaceQueryParams =
            NamespaceQueryParams(
                checkRequired("namespace", namespace),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    @JvmSynthetic internal fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> namespace
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Query, filter, full-text search and vector search documents. */
    class Body
    private constructor(
        private val consistency: JsonField<Consistency>,
        private val distanceMetric: JsonField<DistanceMetric>,
        private val filters: JsonValue,
        private val includeAttributes: JsonField<IncludeAttributes>,
        private val includeVectors: JsonField<Boolean>,
        private val rankBy: JsonValue,
        private val topK: JsonField<Long>,
        private val vector: JsonField<List<Double>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("consistency")
            @ExcludeMissing
            consistency: JsonField<Consistency> = JsonMissing.of(),
            @JsonProperty("distance_metric")
            @ExcludeMissing
            distanceMetric: JsonField<DistanceMetric> = JsonMissing.of(),
            @JsonProperty("filters") @ExcludeMissing filters: JsonValue = JsonMissing.of(),
            @JsonProperty("include_attributes")
            @ExcludeMissing
            includeAttributes: JsonField<IncludeAttributes> = JsonMissing.of(),
            @JsonProperty("include_vectors")
            @ExcludeMissing
            includeVectors: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("rank_by") @ExcludeMissing rankBy: JsonValue = JsonMissing.of(),
            @JsonProperty("top_k") @ExcludeMissing topK: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("vector")
            @ExcludeMissing
            vector: JsonField<List<Double>> = JsonMissing.of(),
        ) : this(
            consistency,
            distanceMetric,
            filters,
            includeAttributes,
            includeVectors,
            rankBy,
            topK,
            vector,
            mutableMapOf(),
        )

        /**
         * The consistency level for a query.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun consistency(): Optional<Consistency> =
            Optional.ofNullable(consistency.getNullable("consistency"))

        /**
         * A function used to calculate vector similarity.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun distanceMetric(): Optional<DistanceMetric> =
            Optional.ofNullable(distanceMetric.getNullable("distance_metric"))

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
            Optional.ofNullable(includeAttributes.getNullable("include_attributes"))

        /**
         * Whether to return vectors for the search results. Vectors are large and slow to
         * deserialize on the client, so use this option only if you need them.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun includeVectors(): Optional<Boolean> =
            Optional.ofNullable(includeVectors.getNullable("include_vectors"))

        /** The attribute to rank the results by. Cannot be specified with `vector`. */
        @JsonProperty("rank_by") @ExcludeMissing fun _rankBy(): JsonValue = rankBy

        /**
         * The number of results to return.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun topK(): Optional<Long> = Optional.ofNullable(topK.getNullable("top_k"))

        /**
         * A vector to search for. It must have the same number of dimensions as the vectors in the
         * namespace. Cannot be specified with `rank_by`.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun vector(): Optional<List<Double>> = Optional.ofNullable(vector.getNullable("vector"))

        /**
         * Returns the raw JSON value of [consistency].
         *
         * Unlike [consistency], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("consistency")
        @ExcludeMissing
        fun _consistency(): JsonField<Consistency> = consistency

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
         * Returns the raw JSON value of [includeAttributes].
         *
         * Unlike [includeAttributes], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("include_attributes")
        @ExcludeMissing
        fun _includeAttributes(): JsonField<IncludeAttributes> = includeAttributes

        /**
         * Returns the raw JSON value of [includeVectors].
         *
         * Unlike [includeVectors], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("include_vectors")
        @ExcludeMissing
        fun _includeVectors(): JsonField<Boolean> = includeVectors

        /**
         * Returns the raw JSON value of [topK].
         *
         * Unlike [topK], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("top_k") @ExcludeMissing fun _topK(): JsonField<Long> = topK

        /**
         * Returns the raw JSON value of [vector].
         *
         * Unlike [vector], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("vector") @ExcludeMissing fun _vector(): JsonField<List<Double>> = vector

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

            private var consistency: JsonField<Consistency> = JsonMissing.of()
            private var distanceMetric: JsonField<DistanceMetric> = JsonMissing.of()
            private var filters: JsonValue = JsonMissing.of()
            private var includeAttributes: JsonField<IncludeAttributes> = JsonMissing.of()
            private var includeVectors: JsonField<Boolean> = JsonMissing.of()
            private var rankBy: JsonValue = JsonMissing.of()
            private var topK: JsonField<Long> = JsonMissing.of()
            private var vector: JsonField<MutableList<Double>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                consistency = body.consistency
                distanceMetric = body.distanceMetric
                filters = body.filters
                includeAttributes = body.includeAttributes
                includeVectors = body.includeVectors
                rankBy = body.rankBy
                topK = body.topK
                vector = body.vector.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

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

            /**
             * Whether to return vectors for the search results. Vectors are large and slow to
             * deserialize on the client, so use this option only if you need them.
             */
            fun includeVectors(includeVectors: Boolean) =
                includeVectors(JsonField.of(includeVectors))

            /**
             * Sets [Builder.includeVectors] to an arbitrary JSON value.
             *
             * You should usually call [Builder.includeVectors] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun includeVectors(includeVectors: JsonField<Boolean>) = apply {
                this.includeVectors = includeVectors
            }

            /** The attribute to rank the results by. Cannot be specified with `vector`. */
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

            /**
             * A vector to search for. It must have the same number of dimensions as the vectors in
             * the namespace. Cannot be specified with `rank_by`.
             */
            fun vector(vector: List<Double>) = vector(JsonField.of(vector))

            /**
             * Sets [Builder.vector] to an arbitrary JSON value.
             *
             * You should usually call [Builder.vector] with a well-typed `List<Double>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun vector(vector: JsonField<List<Double>>) = apply {
                this.vector = vector.map { it.toMutableList() }
            }

            /**
             * Adds a single [Double] to [Builder.vector].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addVector(vector: Double) = apply {
                this.vector =
                    (this.vector ?: JsonField.of(mutableListOf())).also {
                        checkKnown("vector", it).add(vector)
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(
                    consistency,
                    distanceMetric,
                    filters,
                    includeAttributes,
                    includeVectors,
                    rankBy,
                    topK,
                    (vector ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            consistency().ifPresent { it.validate() }
            distanceMetric()
            includeAttributes().ifPresent { it.validate() }
            includeVectors()
            topK()
            vector()
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && consistency == other.consistency && distanceMetric == other.distanceMetric && filters == other.filters && includeAttributes == other.includeAttributes && includeVectors == other.includeVectors && rankBy == other.rankBy && topK == other.topK && vector == other.vector && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(consistency, distanceMetric, filters, includeAttributes, includeVectors, rankBy, topK, vector, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{consistency=$consistency, distanceMetric=$distanceMetric, filters=$filters, includeAttributes=$includeAttributes, includeVectors=$includeVectors, rankBy=$rankBy, topK=$topK, vector=$vector, additionalProperties=$additionalProperties}"
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
        fun level(): Optional<Level> = Optional.ofNullable(level.getNullable("level"))

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

            level()
            validated = true
        }

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

    /** Whether to include attributes in the response. */
    @JsonDeserialize(using = IncludeAttributes.Deserializer::class)
    @JsonSerialize(using = IncludeAttributes.Serializer::class)
    class IncludeAttributes
    private constructor(
        private val bool: Boolean? = null,
        private val strings: List<String>? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * When `true`, include all attributes in the response. When `false`, include no attributes
         * in the response.
         */
        fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

        /** Include exactly the specified attributes in the response. */
        fun strings(): Optional<List<String>> = Optional.ofNullable(strings)

        fun isBool(): Boolean = bool != null

        fun isStrings(): Boolean = strings != null

        /**
         * When `true`, include all attributes in the response. When `false`, include no attributes
         * in the response.
         */
        fun asBool(): Boolean = bool.getOrThrow("bool")

        /** Include exactly the specified attributes in the response. */
        fun asStrings(): List<String> = strings.getOrThrow("strings")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                bool != null -> visitor.visitBool(bool)
                strings != null -> visitor.visitStrings(strings)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): IncludeAttributes = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitBool(bool: Boolean) {}

                    override fun visitStrings(strings: List<String>) {}
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is IncludeAttributes && bool == other.bool && strings == other.strings /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(bool, strings) /* spotless:on */

        override fun toString(): String =
            when {
                bool != null -> "IncludeAttributes{bool=$bool}"
                strings != null -> "IncludeAttributes{strings=$strings}"
                _json != null -> "IncludeAttributes{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid IncludeAttributes")
            }

        companion object {

            /**
             * When `true`, include all attributes in the response. When `false`, include no
             * attributes in the response.
             */
            @JvmStatic fun ofBool(bool: Boolean) = IncludeAttributes(bool = bool)

            /** Include exactly the specified attributes in the response. */
            @JvmStatic fun ofStrings(strings: List<String>) = IncludeAttributes(strings = strings)
        }

        /**
         * An interface that defines how to map each variant of [IncludeAttributes] to a value of
         * type [T].
         */
        interface Visitor<out T> {

            /**
             * When `true`, include all attributes in the response. When `false`, include no
             * attributes in the response.
             */
            fun visitBool(bool: Boolean): T

            /** Include exactly the specified attributes in the response. */
            fun visitStrings(strings: List<String>): T

            /**
             * Maps an unknown variant of [IncludeAttributes] to a value of type [T].
             *
             * An instance of [IncludeAttributes] can contain an unknown variant if it was
             * deserialized from data that doesn't match any known variant. For example, if the SDK
             * is on an older version than the API, then the API may respond with new variants that
             * the SDK is unaware of.
             *
             * @throws TurbopufferInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw TurbopufferInvalidDataException("Unknown IncludeAttributes: $json")
            }
        }

        internal class Deserializer :
            BaseDeserializer<IncludeAttributes>(IncludeAttributes::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): IncludeAttributes {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                    return IncludeAttributes(bool = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                    return IncludeAttributes(strings = it, _json = json)
                }

                return IncludeAttributes(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<IncludeAttributes>(IncludeAttributes::class) {

            override fun serialize(
                value: IncludeAttributes,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.bool != null -> generator.writeObject(value.bool)
                    value.strings != null -> generator.writeObject(value.strings)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid IncludeAttributes")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is NamespaceQueryParams && namespace == other.namespace && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(namespace, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "NamespaceQueryParams{namespace=$namespace, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
