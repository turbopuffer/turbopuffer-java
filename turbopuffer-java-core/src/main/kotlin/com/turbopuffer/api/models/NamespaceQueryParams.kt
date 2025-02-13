// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

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
import com.turbopuffer.api.core.BaseDeserializer
import com.turbopuffer.api.core.BaseSerializer
import com.turbopuffer.api.core.Enum
import com.turbopuffer.api.core.ExcludeMissing
import com.turbopuffer.api.core.JsonField
import com.turbopuffer.api.core.JsonMissing
import com.turbopuffer.api.core.JsonValue
import com.turbopuffer.api.core.NoAutoDetect
import com.turbopuffer.api.core.Params
import com.turbopuffer.api.core.checkRequired
import com.turbopuffer.api.core.getOrThrow
import com.turbopuffer.api.core.http.Headers
import com.turbopuffer.api.core.http.QueryParams
import com.turbopuffer.api.core.immutableEmptyMap
import com.turbopuffer.api.core.toImmutable
import com.turbopuffer.api.errors.TurbopufferInvalidDataException
import java.util.Objects
import java.util.Optional

/**
 * Searches documents in a namespace using a vector (and optionally attribute filters). Provide a
 * query vector, filters, ranking, and other parameters to retrieve matching documents.
 */
class NamespaceQueryParams
private constructor(
    private val namespace: String,
    private val body: NamespaceQueryBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun namespace(): String = namespace

    /** Consistency level for the query. */
    fun consistency(): Optional<Consistency> = body.consistency()

    /** Required if a query vector is provided. */
    fun distanceMetric(): Optional<DistanceMetric> = body.distanceMetric()

    /** Filters to narrow down search results (e.g., attribute conditions). */
    fun filters(): Optional<Filters> = body.filters()

    /** A list of attribute names to return or `true` to include all attributes. */
    fun includeAttributes(): Optional<IncludeAttributes> = body.includeAttributes()

    /** Whether to include the stored vectors in the response. */
    fun includeVectors(): Optional<Boolean> = body.includeVectors()

    /**
     * Parameter to order results (either BM25 for full-text search or attribute-based ordering).
     */
    fun rankBy(): Optional<List<String>> = body.rankBy()

    /** Number of results to return. */
    fun topK(): Optional<Long> = body.topK()

    /** The query vector. */
    fun vector(): Optional<List<Double>> = body.vector()

    /** Consistency level for the query. */
    fun _consistency(): JsonField<Consistency> = body._consistency()

    /** Required if a query vector is provided. */
    fun _distanceMetric(): JsonField<DistanceMetric> = body._distanceMetric()

    /** Filters to narrow down search results (e.g., attribute conditions). */
    fun _filters(): JsonField<Filters> = body._filters()

    /** A list of attribute names to return or `true` to include all attributes. */
    fun _includeAttributes(): JsonField<IncludeAttributes> = body._includeAttributes()

    /** Whether to include the stored vectors in the response. */
    fun _includeVectors(): JsonField<Boolean> = body._includeVectors()

    /**
     * Parameter to order results (either BM25 for full-text search or attribute-based ordering).
     */
    fun _rankBy(): JsonField<List<String>> = body._rankBy()

    /** Number of results to return. */
    fun _topK(): JsonField<Long> = body._topK()

    /** The query vector. */
    fun _vector(): JsonField<List<Double>> = body._vector()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): NamespaceQueryBody = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> namespace
            else -> ""
        }
    }

    @NoAutoDetect
    class NamespaceQueryBody
    @JsonCreator
    internal constructor(
        @JsonProperty("consistency")
        @ExcludeMissing
        private val consistency: JsonField<Consistency> = JsonMissing.of(),
        @JsonProperty("distance_metric")
        @ExcludeMissing
        private val distanceMetric: JsonField<DistanceMetric> = JsonMissing.of(),
        @JsonProperty("filters")
        @ExcludeMissing
        private val filters: JsonField<Filters> = JsonMissing.of(),
        @JsonProperty("include_attributes")
        @ExcludeMissing
        private val includeAttributes: JsonField<IncludeAttributes> = JsonMissing.of(),
        @JsonProperty("include_vectors")
        @ExcludeMissing
        private val includeVectors: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("rank_by")
        @ExcludeMissing
        private val rankBy: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("top_k") @ExcludeMissing private val topK: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("vector")
        @ExcludeMissing
        private val vector: JsonField<List<Double>> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** Consistency level for the query. */
        fun consistency(): Optional<Consistency> =
            Optional.ofNullable(consistency.getNullable("consistency"))

        /** Required if a query vector is provided. */
        fun distanceMetric(): Optional<DistanceMetric> =
            Optional.ofNullable(distanceMetric.getNullable("distance_metric"))

        /** Filters to narrow down search results (e.g., attribute conditions). */
        fun filters(): Optional<Filters> = Optional.ofNullable(filters.getNullable("filters"))

        /** A list of attribute names to return or `true` to include all attributes. */
        fun includeAttributes(): Optional<IncludeAttributes> =
            Optional.ofNullable(includeAttributes.getNullable("include_attributes"))

        /** Whether to include the stored vectors in the response. */
        fun includeVectors(): Optional<Boolean> =
            Optional.ofNullable(includeVectors.getNullable("include_vectors"))

        /**
         * Parameter to order results (either BM25 for full-text search or attribute-based
         * ordering).
         */
        fun rankBy(): Optional<List<String>> = Optional.ofNullable(rankBy.getNullable("rank_by"))

        /** Number of results to return. */
        fun topK(): Optional<Long> = Optional.ofNullable(topK.getNullable("top_k"))

        /** The query vector. */
        fun vector(): Optional<List<Double>> = Optional.ofNullable(vector.getNullable("vector"))

        /** Consistency level for the query. */
        @JsonProperty("consistency")
        @ExcludeMissing
        fun _consistency(): JsonField<Consistency> = consistency

        /** Required if a query vector is provided. */
        @JsonProperty("distance_metric")
        @ExcludeMissing
        fun _distanceMetric(): JsonField<DistanceMetric> = distanceMetric

        /** Filters to narrow down search results (e.g., attribute conditions). */
        @JsonProperty("filters") @ExcludeMissing fun _filters(): JsonField<Filters> = filters

        /** A list of attribute names to return or `true` to include all attributes. */
        @JsonProperty("include_attributes")
        @ExcludeMissing
        fun _includeAttributes(): JsonField<IncludeAttributes> = includeAttributes

        /** Whether to include the stored vectors in the response. */
        @JsonProperty("include_vectors")
        @ExcludeMissing
        fun _includeVectors(): JsonField<Boolean> = includeVectors

        /**
         * Parameter to order results (either BM25 for full-text search or attribute-based
         * ordering).
         */
        @JsonProperty("rank_by") @ExcludeMissing fun _rankBy(): JsonField<List<String>> = rankBy

        /** Number of results to return. */
        @JsonProperty("top_k") @ExcludeMissing fun _topK(): JsonField<Long> = topK

        /** The query vector. */
        @JsonProperty("vector") @ExcludeMissing fun _vector(): JsonField<List<Double>> = vector

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): NamespaceQueryBody = apply {
            if (validated) {
                return@apply
            }

            consistency().ifPresent { it.validate() }
            distanceMetric()
            filters().ifPresent { it.validate() }
            includeAttributes().ifPresent { it.validate() }
            includeVectors()
            rankBy()
            topK()
            vector()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [NamespaceQueryBody]. */
        class Builder internal constructor() {

            private var consistency: JsonField<Consistency> = JsonMissing.of()
            private var distanceMetric: JsonField<DistanceMetric> = JsonMissing.of()
            private var filters: JsonField<Filters> = JsonMissing.of()
            private var includeAttributes: JsonField<IncludeAttributes> = JsonMissing.of()
            private var includeVectors: JsonField<Boolean> = JsonMissing.of()
            private var rankBy: JsonField<MutableList<String>>? = null
            private var topK: JsonField<Long> = JsonMissing.of()
            private var vector: JsonField<MutableList<Double>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(namespaceQueryBody: NamespaceQueryBody) = apply {
                consistency = namespaceQueryBody.consistency
                distanceMetric = namespaceQueryBody.distanceMetric
                filters = namespaceQueryBody.filters
                includeAttributes = namespaceQueryBody.includeAttributes
                includeVectors = namespaceQueryBody.includeVectors
                rankBy = namespaceQueryBody.rankBy.map { it.toMutableList() }
                topK = namespaceQueryBody.topK
                vector = namespaceQueryBody.vector.map { it.toMutableList() }
                additionalProperties = namespaceQueryBody.additionalProperties.toMutableMap()
            }

            /** Consistency level for the query. */
            fun consistency(consistency: Consistency) = consistency(JsonField.of(consistency))

            /** Consistency level for the query. */
            fun consistency(consistency: JsonField<Consistency>) = apply {
                this.consistency = consistency
            }

            /** Required if a query vector is provided. */
            fun distanceMetric(distanceMetric: DistanceMetric) =
                distanceMetric(JsonField.of(distanceMetric))

            /** Required if a query vector is provided. */
            fun distanceMetric(distanceMetric: JsonField<DistanceMetric>) = apply {
                this.distanceMetric = distanceMetric
            }

            /** Filters to narrow down search results (e.g., attribute conditions). */
            fun filters(filters: Filters) = filters(JsonField.of(filters))

            /** Filters to narrow down search results (e.g., attribute conditions). */
            fun filters(filters: JsonField<Filters>) = apply { this.filters = filters }

            /** Filters to narrow down search results (e.g., attribute conditions). */
            fun filters(jsonValue: JsonValue) = filters(Filters.ofJsonValue(jsonValue))

            /** Filters to narrow down search results (e.g., attribute conditions). */
            fun filtersOfJsonValues(jsonValues: List<JsonValue>) =
                filters(Filters.ofJsonValues(jsonValues))

            /** A list of attribute names to return or `true` to include all attributes. */
            fun includeAttributes(includeAttributes: IncludeAttributes) =
                includeAttributes(JsonField.of(includeAttributes))

            /** A list of attribute names to return or `true` to include all attributes. */
            fun includeAttributes(includeAttributes: JsonField<IncludeAttributes>) = apply {
                this.includeAttributes = includeAttributes
            }

            /** A list of attribute names to return or `true` to include all attributes. */
            fun includeAttributesOfStrings(strings: List<String>) =
                includeAttributes(IncludeAttributes.ofStrings(strings))

            /** A list of attribute names to return or `true` to include all attributes. */
            fun includeAttributes(bool: Boolean) = includeAttributes(IncludeAttributes.ofBool(bool))

            /** Whether to include the stored vectors in the response. */
            fun includeVectors(includeVectors: Boolean) =
                includeVectors(JsonField.of(includeVectors))

            /** Whether to include the stored vectors in the response. */
            fun includeVectors(includeVectors: JsonField<Boolean>) = apply {
                this.includeVectors = includeVectors
            }

            /**
             * Parameter to order results (either BM25 for full-text search or attribute-based
             * ordering).
             */
            fun rankBy(rankBy: List<String>) = rankBy(JsonField.of(rankBy))

            /**
             * Parameter to order results (either BM25 for full-text search or attribute-based
             * ordering).
             */
            fun rankBy(rankBy: JsonField<List<String>>) = apply {
                this.rankBy = rankBy.map { it.toMutableList() }
            }

            /**
             * Parameter to order results (either BM25 for full-text search or attribute-based
             * ordering).
             */
            fun addRankBy(rankBy: String) = apply {
                this.rankBy =
                    (this.rankBy ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(rankBy)
                    }
            }

            /** Number of results to return. */
            fun topK(topK: Long) = topK(JsonField.of(topK))

            /** Number of results to return. */
            fun topK(topK: JsonField<Long>) = apply { this.topK = topK }

            /** The query vector. */
            fun vector(vector: List<Double>) = vector(JsonField.of(vector))

            /** The query vector. */
            fun vector(vector: JsonField<List<Double>>) = apply {
                this.vector = vector.map { it.toMutableList() }
            }

            /** The query vector. */
            fun addVector(vector: Double) = apply {
                this.vector =
                    (this.vector ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(vector)
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

            fun build(): NamespaceQueryBody =
                NamespaceQueryBody(
                    consistency,
                    distanceMetric,
                    filters,
                    includeAttributes,
                    includeVectors,
                    (rankBy ?: JsonMissing.of()).map { it.toImmutable() },
                    topK,
                    (vector ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is NamespaceQueryBody && consistency == other.consistency && distanceMetric == other.distanceMetric && filters == other.filters && includeAttributes == other.includeAttributes && includeVectors == other.includeVectors && rankBy == other.rankBy && topK == other.topK && vector == other.vector && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(consistency, distanceMetric, filters, includeAttributes, includeVectors, rankBy, topK, vector, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "NamespaceQueryBody{consistency=$consistency, distanceMetric=$distanceMetric, filters=$filters, includeAttributes=$includeAttributes, includeVectors=$includeVectors, rankBy=$rankBy, topK=$topK, vector=$vector, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceQueryParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var namespace: String? = null
        private var body: NamespaceQueryBody.Builder = NamespaceQueryBody.builder()
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

        /** Consistency level for the query. */
        fun consistency(consistency: Consistency) = apply { body.consistency(consistency) }

        /** Consistency level for the query. */
        fun consistency(consistency: JsonField<Consistency>) = apply {
            body.consistency(consistency)
        }

        /** Required if a query vector is provided. */
        fun distanceMetric(distanceMetric: DistanceMetric) = apply {
            body.distanceMetric(distanceMetric)
        }

        /** Required if a query vector is provided. */
        fun distanceMetric(distanceMetric: JsonField<DistanceMetric>) = apply {
            body.distanceMetric(distanceMetric)
        }

        /** Filters to narrow down search results (e.g., attribute conditions). */
        fun filters(filters: Filters) = apply { body.filters(filters) }

        /** Filters to narrow down search results (e.g., attribute conditions). */
        fun filters(filters: JsonField<Filters>) = apply { body.filters(filters) }

        /** Filters to narrow down search results (e.g., attribute conditions). */
        fun filters(jsonValue: JsonValue) = apply { body.filters(jsonValue) }

        /** Filters to narrow down search results (e.g., attribute conditions). */
        fun filtersOfJsonValues(jsonValues: List<JsonValue>) = apply {
            body.filtersOfJsonValues(jsonValues)
        }

        /** A list of attribute names to return or `true` to include all attributes. */
        fun includeAttributes(includeAttributes: IncludeAttributes) = apply {
            body.includeAttributes(includeAttributes)
        }

        /** A list of attribute names to return or `true` to include all attributes. */
        fun includeAttributes(includeAttributes: JsonField<IncludeAttributes>) = apply {
            body.includeAttributes(includeAttributes)
        }

        /** A list of attribute names to return or `true` to include all attributes. */
        fun includeAttributesOfStrings(strings: List<String>) = apply {
            body.includeAttributesOfStrings(strings)
        }

        /** A list of attribute names to return or `true` to include all attributes. */
        fun includeAttributes(bool: Boolean) = apply { body.includeAttributes(bool) }

        /** Whether to include the stored vectors in the response. */
        fun includeVectors(includeVectors: Boolean) = apply { body.includeVectors(includeVectors) }

        /** Whether to include the stored vectors in the response. */
        fun includeVectors(includeVectors: JsonField<Boolean>) = apply {
            body.includeVectors(includeVectors)
        }

        /**
         * Parameter to order results (either BM25 for full-text search or attribute-based
         * ordering).
         */
        fun rankBy(rankBy: List<String>) = apply { body.rankBy(rankBy) }

        /**
         * Parameter to order results (either BM25 for full-text search or attribute-based
         * ordering).
         */
        fun rankBy(rankBy: JsonField<List<String>>) = apply { body.rankBy(rankBy) }

        /**
         * Parameter to order results (either BM25 for full-text search or attribute-based
         * ordering).
         */
        fun addRankBy(rankBy: String) = apply { body.addRankBy(rankBy) }

        /** Number of results to return. */
        fun topK(topK: Long) = apply { body.topK(topK) }

        /** Number of results to return. */
        fun topK(topK: JsonField<Long>) = apply { body.topK(topK) }

        /** The query vector. */
        fun vector(vector: List<Double>) = apply { body.vector(vector) }

        /** The query vector. */
        fun vector(vector: JsonField<List<Double>>) = apply { body.vector(vector) }

        /** The query vector. */
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

        fun build(): NamespaceQueryParams =
            NamespaceQueryParams(
                checkRequired("namespace", namespace),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    /** Consistency level for the query. */
    @NoAutoDetect
    class Consistency
    @JsonCreator
    private constructor(
        @JsonProperty("level")
        @ExcludeMissing
        private val level: JsonField<Level> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun level(): Optional<Level> = Optional.ofNullable(level.getNullable("level"))

        @JsonProperty("level") @ExcludeMissing fun _level(): JsonField<Level> = level

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Consistency = apply {
            if (validated) {
                return@apply
            }

            level()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

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

            fun level(level: Level) = level(JsonField.of(level))

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

            fun build(): Consistency = Consistency(level, additionalProperties.toImmutable())
        }

        class Level
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

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

                @JvmField val STRONG = of("strong")

                @JvmField val EVENTUAL = of("eventual")

                @JvmStatic fun of(value: String) = Level(JsonField.of(value))
            }

            /** An enum containing [Level]'s known values. */
            enum class Known {
                STRONG,
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
                STRONG,
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

            fun asString(): String = _value().asStringOrThrow()

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

    /** Required if a query vector is provided. */
    class DistanceMetric
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val COSINE_DISTANCE = of("cosine_distance")

            @JvmField val EUCLIDEAN_SQUARED = of("euclidean_squared")

            @JvmStatic fun of(value: String) = DistanceMetric(JsonField.of(value))
        }

        /** An enum containing [DistanceMetric]'s known values. */
        enum class Known {
            COSINE_DISTANCE,
            EUCLIDEAN_SQUARED,
        }

        /**
         * An enum containing [DistanceMetric]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [DistanceMetric] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            COSINE_DISTANCE,
            EUCLIDEAN_SQUARED,
            /**
             * An enum member indicating that [DistanceMetric] was instantiated with an unknown
             * value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                COSINE_DISTANCE -> Value.COSINE_DISTANCE
                EUCLIDEAN_SQUARED -> Value.EUCLIDEAN_SQUARED
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                COSINE_DISTANCE -> Known.COSINE_DISTANCE
                EUCLIDEAN_SQUARED -> Known.EUCLIDEAN_SQUARED
                else -> throw TurbopufferInvalidDataException("Unknown DistanceMetric: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is DistanceMetric && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Filters to narrow down search results (e.g., attribute conditions). */
    @JsonDeserialize(using = Filters.Deserializer::class)
    @JsonSerialize(using = Filters.Serializer::class)
    class Filters
    private constructor(
        private val jsonValue: JsonValue? = null,
        private val jsonValues: List<JsonValue>? = null,
        private val _json: JsonValue? = null,
    ) {

        fun jsonValue(): Optional<JsonValue> = Optional.ofNullable(jsonValue)

        fun jsonValues(): Optional<List<JsonValue>> = Optional.ofNullable(jsonValues)

        fun isJsonValue(): Boolean = jsonValue != null

        fun isJsonValues(): Boolean = jsonValues != null

        fun asJsonValue(): JsonValue = jsonValue.getOrThrow("jsonValue")

        fun asJsonValues(): List<JsonValue> = jsonValues.getOrThrow("jsonValues")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                jsonValue != null -> visitor.visitJsonValue(jsonValue)
                jsonValues != null -> visitor.visitJsonValues(jsonValues)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Filters = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitJsonValue(jsonValue: JsonValue) {}

                    override fun visitJsonValues(jsonValues: List<JsonValue>) {}
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Filters && jsonValue == other.jsonValue && jsonValues == other.jsonValues /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(jsonValue, jsonValues) /* spotless:on */

        override fun toString(): String =
            when {
                jsonValue != null -> "Filters{jsonValue=$jsonValue}"
                jsonValues != null -> "Filters{jsonValues=$jsonValues}"
                _json != null -> "Filters{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Filters")
            }

        companion object {

            @JvmStatic fun ofJsonValue(jsonValue: JsonValue) = Filters(jsonValue = jsonValue)

            @JvmStatic
            fun ofJsonValues(jsonValues: List<JsonValue>) = Filters(jsonValues = jsonValues)
        }

        /**
         * An interface that defines how to map each variant of [Filters] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitJsonValue(jsonValue: JsonValue): T

            fun visitJsonValues(jsonValues: List<JsonValue>): T

            /**
             * Maps an unknown variant of [Filters] to a value of type [T].
             *
             * An instance of [Filters] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws TurbopufferInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw TurbopufferInvalidDataException("Unknown Filters: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Filters>(Filters::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Filters {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<JsonValue>())?.let {
                    return Filters(jsonValue = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<JsonValue>>())?.let {
                    return Filters(jsonValues = it, _json = json)
                }

                return Filters(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Filters>(Filters::class) {

            override fun serialize(
                value: Filters,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.jsonValue != null -> generator.writeObject(value.jsonValue)
                    value.jsonValues != null -> generator.writeObject(value.jsonValues)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Filters")
                }
            }
        }
    }

    /** A list of attribute names to return or `true` to include all attributes. */
    @JsonDeserialize(using = IncludeAttributes.Deserializer::class)
    @JsonSerialize(using = IncludeAttributes.Serializer::class)
    class IncludeAttributes
    private constructor(
        private val strings: List<String>? = null,
        private val bool: Boolean? = null,
        private val _json: JsonValue? = null,
    ) {

        fun strings(): Optional<List<String>> = Optional.ofNullable(strings)

        fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

        fun isStrings(): Boolean = strings != null

        fun isBool(): Boolean = bool != null

        fun asStrings(): List<String> = strings.getOrThrow("strings")

        fun asBool(): Boolean = bool.getOrThrow("bool")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                strings != null -> visitor.visitStrings(strings)
                bool != null -> visitor.visitBool(bool)
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
                    override fun visitStrings(strings: List<String>) {}

                    override fun visitBool(bool: Boolean) {}
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is IncludeAttributes && strings == other.strings && bool == other.bool /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(strings, bool) /* spotless:on */

        override fun toString(): String =
            when {
                strings != null -> "IncludeAttributes{strings=$strings}"
                bool != null -> "IncludeAttributes{bool=$bool}"
                _json != null -> "IncludeAttributes{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid IncludeAttributes")
            }

        companion object {

            @JvmStatic fun ofStrings(strings: List<String>) = IncludeAttributes(strings = strings)

            @JvmStatic fun ofBool(bool: Boolean) = IncludeAttributes(bool = bool)
        }

        /**
         * An interface that defines how to map each variant of [IncludeAttributes] to a value of
         * type [T].
         */
        interface Visitor<out T> {

            fun visitStrings(strings: List<String>): T

            fun visitBool(bool: Boolean): T

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

                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                    return IncludeAttributes(strings = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                    return IncludeAttributes(bool = it, _json = json)
                }

                return IncludeAttributes(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<IncludeAttributes>(IncludeAttributes::class) {

            override fun serialize(
                value: IncludeAttributes,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.strings != null -> generator.writeObject(value.strings)
                    value.bool != null -> generator.writeObject(value.bool)
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
