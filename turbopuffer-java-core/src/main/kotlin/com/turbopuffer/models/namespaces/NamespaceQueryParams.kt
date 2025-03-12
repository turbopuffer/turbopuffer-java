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
import com.turbopuffer.core.NoAutoDetect
import com.turbopuffer.core.Params
import com.turbopuffer.core.checkKnown
import com.turbopuffer.core.checkRequired
import com.turbopuffer.core.getOrThrow
import com.turbopuffer.core.http.Headers
import com.turbopuffer.core.http.QueryParams
import com.turbopuffer.core.immutableEmptyMap
import com.turbopuffer.core.toImmutable
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Objects
import java.util.Optional

/** Query, filter, full-text search and vector search documents. */
class NamespaceQueryParams private constructor(
    private val namespace: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,

) : Params {

    fun namespace(): String = namespace

    /** The consistency level for a query. */
    fun consistency(): Optional<Consistency> = body.consistency()

    /** A function used to calculate vector similarity. */
    fun distanceMetric(): Optional<DistanceMetric> = body.distanceMetric()

    /**
     * Exact filters for attributes to refine search results for. Think of it as a SQL
     * WHERE clause.
     */
    fun _filter(): JsonValue = body._filter()

    /** Whether to include attributes in the response. */
    fun includeAttributes(): Optional<IncludeAttributes> = body.includeAttributes()

    /**
     * Whether to return vectors for the search results. Vectors are large and slow to
     * deserialize on the client, so use this option only if you need them.
     */
    fun includeVectors(): Optional<Boolean> = body.includeVectors()

    /** The attribute to rank the results by. Cannot be specified with `vector`. */
    fun _rankBy(): JsonValue = body._rankBy()

    /** The number of results to return. */
    fun topK(): Optional<Long> = body.topK()

    /**
     * A vector to search for. It must have the same number of dimensions as the
     * vectors in the namespace. Cannot be specified with `rank_by`.
     */
    fun vector(): Optional<List<Double>> = body.vector()

    /** The consistency level for a query. */
    fun _consistency(): JsonField<Consistency> = body._consistency()

    /** A function used to calculate vector similarity. */
    fun _distanceMetric(): JsonField<DistanceMetric> = body._distanceMetric()

    /** Whether to include attributes in the response. */
    fun _includeAttributes(): JsonField<IncludeAttributes> = body._includeAttributes()

    /**
     * Whether to return vectors for the search results. Vectors are large and slow to
     * deserialize on the client, so use this option only if you need them.
     */
    fun _includeVectors(): JsonField<Boolean> = body._includeVectors()

    /** The number of results to return. */
    fun _topK(): JsonField<Long> = body._topK()

    /**
     * A vector to search for. It must have the same number of dimensions as the
     * vectors in the namespace. Cannot be specified with `rank_by`.
     */
    fun _vector(): JsonField<List<Double>> = body._vector()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic
    internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
      return when (index) {
          0 -> namespace
          else -> ""
      }
    }

    /** Query, filter, full-text search and vector search documents. */
    @NoAutoDetect
    class Body @JsonCreator private constructor(
        @JsonProperty("consistency") @ExcludeMissing private val consistency: JsonField<Consistency> = JsonMissing.of(),
        @JsonProperty("distance_metric") @ExcludeMissing private val distanceMetric: JsonField<DistanceMetric> = JsonMissing.of(),
        @JsonProperty("filter") @ExcludeMissing private val filter: JsonValue = JsonMissing.of(),
        @JsonProperty("include_attributes") @ExcludeMissing private val includeAttributes: JsonField<IncludeAttributes> = JsonMissing.of(),
        @JsonProperty("include_vectors") @ExcludeMissing private val includeVectors: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("rank_by") @ExcludeMissing private val rankBy: JsonValue = JsonMissing.of(),
        @JsonProperty("top_k") @ExcludeMissing private val topK: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("vector") @ExcludeMissing private val vector: JsonField<List<Double>> = JsonMissing.of(),
        @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

    ) {

        /** The consistency level for a query. */
        fun consistency(): Optional<Consistency> = Optional.ofNullable(consistency.getNullable("consistency"))

        /** A function used to calculate vector similarity. */
        fun distanceMetric(): Optional<DistanceMetric> = Optional.ofNullable(distanceMetric.getNullable("distance_metric"))

        /**
         * Exact filters for attributes to refine search results for. Think of it as a SQL
         * WHERE clause.
         */
        @JsonProperty("filter")
        @ExcludeMissing
        fun _filter(): JsonValue = filter

        /** Whether to include attributes in the response. */
        fun includeAttributes(): Optional<IncludeAttributes> = Optional.ofNullable(includeAttributes.getNullable("include_attributes"))

        /**
         * Whether to return vectors for the search results. Vectors are large and slow to
         * deserialize on the client, so use this option only if you need them.
         */
        fun includeVectors(): Optional<Boolean> = Optional.ofNullable(includeVectors.getNullable("include_vectors"))

        /** The attribute to rank the results by. Cannot be specified with `vector`. */
        @JsonProperty("rank_by")
        @ExcludeMissing
        fun _rankBy(): JsonValue = rankBy

        /** The number of results to return. */
        fun topK(): Optional<Long> = Optional.ofNullable(topK.getNullable("top_k"))

        /**
         * A vector to search for. It must have the same number of dimensions as the
         * vectors in the namespace. Cannot be specified with `rank_by`.
         */
        fun vector(): Optional<List<Double>> = Optional.ofNullable(vector.getNullable("vector"))

        /** The consistency level for a query. */
        @JsonProperty("consistency")
        @ExcludeMissing
        fun _consistency(): JsonField<Consistency> = consistency

        /** A function used to calculate vector similarity. */
        @JsonProperty("distance_metric")
        @ExcludeMissing
        fun _distanceMetric(): JsonField<DistanceMetric> = distanceMetric

        /** Whether to include attributes in the response. */
        @JsonProperty("include_attributes")
        @ExcludeMissing
        fun _includeAttributes(): JsonField<IncludeAttributes> = includeAttributes

        /**
         * Whether to return vectors for the search results. Vectors are large and slow to
         * deserialize on the client, so use this option only if you need them.
         */
        @JsonProperty("include_vectors")
        @ExcludeMissing
        fun _includeVectors(): JsonField<Boolean> = includeVectors

        /** The number of results to return. */
        @JsonProperty("top_k")
        @ExcludeMissing
        fun _topK(): JsonField<Long> = topK

        /**
         * A vector to search for. It must have the same number of dimensions as the
         * vectors in the namespace. Cannot be specified with `rank_by`.
         */
        @JsonProperty("vector")
        @ExcludeMissing
        fun _vector(): JsonField<List<Double>> = vector

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Body =
            apply {
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

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic
            fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var consistency: JsonField<Consistency> = JsonMissing.of()
            private var distanceMetric: JsonField<DistanceMetric> = JsonMissing.of()
            private var filter: JsonValue = JsonMissing.of()
            private var includeAttributes: JsonField<IncludeAttributes> = JsonMissing.of()
            private var includeVectors: JsonField<Boolean> = JsonMissing.of()
            private var rankBy: JsonValue = JsonMissing.of()
            private var topK: JsonField<Long> = JsonMissing.of()
            private var vector: JsonField<MutableList<Double>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) =
                apply {
                    consistency = body.consistency
                    distanceMetric = body.distanceMetric
                    filter = body.filter
                    includeAttributes = body.includeAttributes
                    includeVectors = body.includeVectors
                    rankBy = body.rankBy
                    topK = body.topK
                    vector = body.vector.map { it.toMutableList() }
                    additionalProperties = body.additionalProperties.toMutableMap()
                }

            /** The consistency level for a query. */
            fun consistency(consistency: Consistency) = consistency(JsonField.of(consistency))

            /** The consistency level for a query. */
            fun consistency(consistency: JsonField<Consistency>) =
                apply {
                    this.consistency = consistency
                }

            /** A function used to calculate vector similarity. */
            fun distanceMetric(distanceMetric: DistanceMetric) = distanceMetric(JsonField.of(distanceMetric))

            /** A function used to calculate vector similarity. */
            fun distanceMetric(distanceMetric: JsonField<DistanceMetric>) =
                apply {
                    this.distanceMetric = distanceMetric
                }

            /**
             * Exact filters for attributes to refine search results for. Think of it as a SQL
             * WHERE clause.
             */
            fun filter(filter: JsonValue) =
                apply {
                    this.filter = filter
                }

            /** Whether to include attributes in the response. */
            fun includeAttributes(includeAttributes: IncludeAttributes) = includeAttributes(JsonField.of(includeAttributes))

            /** Whether to include attributes in the response. */
            fun includeAttributes(includeAttributes: JsonField<IncludeAttributes>) =
                apply {
                    this.includeAttributes = includeAttributes
                }

            /**
             * When `true`, include all attributes in the response. When `false`, include no
             * attributes in the response.
             */
            fun includeAttributes(bool: Boolean) = includeAttributes(IncludeAttributes.ofBool(bool))

            /** Include exactly the specified attributes in the response. */
            fun includeAttributesOfStrings(strings: List<String>) = includeAttributes(IncludeAttributes.ofStrings(strings))

            /**
             * Whether to return vectors for the search results. Vectors are large and slow to
             * deserialize on the client, so use this option only if you need them.
             */
            fun includeVectors(includeVectors: Boolean) = includeVectors(JsonField.of(includeVectors))

            /**
             * Whether to return vectors for the search results. Vectors are large and slow to
             * deserialize on the client, so use this option only if you need them.
             */
            fun includeVectors(includeVectors: JsonField<Boolean>) =
                apply {
                    this.includeVectors = includeVectors
                }

            /** The attribute to rank the results by. Cannot be specified with `vector`. */
            fun rankBy(rankBy: JsonValue) =
                apply {
                    this.rankBy = rankBy
                }

            /** The number of results to return. */
            fun topK(topK: Long) = topK(JsonField.of(topK))

            /** The number of results to return. */
            fun topK(topK: JsonField<Long>) =
                apply {
                    this.topK = topK
                }

            /**
             * A vector to search for. It must have the same number of dimensions as the
             * vectors in the namespace. Cannot be specified with `rank_by`.
             */
            fun vector(vector: List<Double>) = vector(JsonField.of(vector))

            /**
             * A vector to search for. It must have the same number of dimensions as the
             * vectors in the namespace. Cannot be specified with `rank_by`.
             */
            fun vector(vector: JsonField<List<Double>>) =
                apply {
                    this.vector = vector.map { it.toMutableList() }
                }

            /**
             * A vector to search for. It must have the same number of dimensions as the
             * vectors in the namespace. Cannot be specified with `rank_by`.
             */
            fun addVector(vector: Double) =
                apply {
                    this.vector = (this.vector ?: JsonField.of(mutableListOf())).also {
                        checkKnown("vector", it).add(vector)
                    }
                }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

            fun putAdditionalProperty(key: String, value: JsonValue) =
                apply {
                    additionalProperties.put(key, value)
                }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                apply {
                    this.additionalProperties.putAll(additionalProperties)
                }

            fun removeAdditionalProperty(key: String) =
                apply {
                    additionalProperties.remove(key)
                }

            fun removeAllAdditionalProperties(keys: Set<String>) =
                apply {
                    keys.forEach(::removeAdditionalProperty)
                }

            fun build(): Body =
                Body(
                  consistency,
                  distanceMetric,
                  filter,
                  includeAttributes,
                  includeVectors,
                  rankBy,
                  topK,
                  (vector ?: JsonMissing.of()).map { it.toImmutable() },
                  additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return /* spotless:off */ other is Body && consistency == other.consistency && distanceMetric == other.distanceMetric && filter == other.filter && includeAttributes == other.includeAttributes && includeVectors == other.includeVectors && rankBy == other.rankBy && topK == other.topK && vector == other.vector && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(consistency, distanceMetric, filter, includeAttributes, includeVectors, rankBy, topK, vector, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Body{consistency=$consistency, distanceMetric=$distanceMetric, filter=$filter, includeAttributes=$includeAttributes, includeVectors=$includeVectors, rankBy=$rankBy, topK=$topK, vector=$vector, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [NamespaceQueryParams].
         *
         * The following fields are required:
         *
         * ```java
         * .namespace()
         * ```
         */
        @JvmStatic
        fun builder() = Builder()
    }

    /** A builder for [NamespaceQueryParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var namespace: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(namespaceQueryParams: NamespaceQueryParams) =
            apply {
                namespace = namespaceQueryParams.namespace
                body = namespaceQueryParams.body.toBuilder()
                additionalHeaders = namespaceQueryParams.additionalHeaders.toBuilder()
                additionalQueryParams = namespaceQueryParams.additionalQueryParams.toBuilder()
            }

        fun namespace(namespace: String) =
            apply {
                this.namespace = namespace
            }

        /** The consistency level for a query. */
        fun consistency(consistency: Consistency) =
            apply {
                body.consistency(consistency)
            }

        /** The consistency level for a query. */
        fun consistency(consistency: JsonField<Consistency>) =
            apply {
                body.consistency(consistency)
            }

        /** A function used to calculate vector similarity. */
        fun distanceMetric(distanceMetric: DistanceMetric) =
            apply {
                body.distanceMetric(distanceMetric)
            }

        /** A function used to calculate vector similarity. */
        fun distanceMetric(distanceMetric: JsonField<DistanceMetric>) =
            apply {
                body.distanceMetric(distanceMetric)
            }

        /**
         * Exact filters for attributes to refine search results for. Think of it as a SQL
         * WHERE clause.
         */
        fun filter(filter: JsonValue) =
            apply {
                body.filter(filter)
            }

        /** Whether to include attributes in the response. */
        fun includeAttributes(includeAttributes: IncludeAttributes) =
            apply {
                body.includeAttributes(includeAttributes)
            }

        /** Whether to include attributes in the response. */
        fun includeAttributes(includeAttributes: JsonField<IncludeAttributes>) =
            apply {
                body.includeAttributes(includeAttributes)
            }

        /**
         * When `true`, include all attributes in the response. When `false`, include no
         * attributes in the response.
         */
        fun includeAttributes(bool: Boolean) =
            apply {
                body.includeAttributes(bool)
            }

        /** Include exactly the specified attributes in the response. */
        fun includeAttributesOfStrings(strings: List<String>) =
            apply {
                body.includeAttributesOfStrings(strings)
            }

        /**
         * Whether to return vectors for the search results. Vectors are large and slow to
         * deserialize on the client, so use this option only if you need them.
         */
        fun includeVectors(includeVectors: Boolean) =
            apply {
                body.includeVectors(includeVectors)
            }

        /**
         * Whether to return vectors for the search results. Vectors are large and slow to
         * deserialize on the client, so use this option only if you need them.
         */
        fun includeVectors(includeVectors: JsonField<Boolean>) =
            apply {
                body.includeVectors(includeVectors)
            }

        /** The attribute to rank the results by. Cannot be specified with `vector`. */
        fun rankBy(rankBy: JsonValue) =
            apply {
                body.rankBy(rankBy)
            }

        /** The number of results to return. */
        fun topK(topK: Long) =
            apply {
                body.topK(topK)
            }

        /** The number of results to return. */
        fun topK(topK: JsonField<Long>) =
            apply {
                body.topK(topK)
            }

        /**
         * A vector to search for. It must have the same number of dimensions as the
         * vectors in the namespace. Cannot be specified with `rank_by`.
         */
        fun vector(vector: List<Double>) =
            apply {
                body.vector(vector)
            }

        /**
         * A vector to search for. It must have the same number of dimensions as the
         * vectors in the namespace. Cannot be specified with `rank_by`.
         */
        fun vector(vector: JsonField<List<Double>>) =
            apply {
                body.vector(vector)
            }

        /**
         * A vector to search for. It must have the same number of dimensions as the
         * vectors in the namespace. Cannot be specified with `rank_by`.
         */
        fun addVector(vector: Double) =
            apply {
                body.addVector(vector)
            }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.additionalProperties(additionalBodyProperties)
            }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) =
            apply {
                body.putAdditionalProperty(
                  key, value
                )
            }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) =
            apply {
                body.removeAdditionalProperty(key)
            }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) =
            apply {
                body.removeAllAdditionalProperties(keys)
            }

        fun additionalHeaders(additionalHeaders: Headers) =
            apply {
                this.additionalHeaders.clear()
                putAllAdditionalHeaders(additionalHeaders)
            }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) =
            apply {
                this.additionalHeaders.clear()
                putAllAdditionalHeaders(additionalHeaders)
            }

        fun putAdditionalHeader(name: String, value: String) =
            apply {
                additionalHeaders.put(name, value)
            }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) =
            apply {
                additionalHeaders.put(name, values)
            }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) =
            apply {
                this.additionalHeaders.putAll(additionalHeaders)
            }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) =
            apply {
                this.additionalHeaders.putAll(additionalHeaders)
            }

        fun replaceAdditionalHeaders(name: String, value: String) =
            apply {
                additionalHeaders.replace(name, value)
            }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) =
            apply {
                additionalHeaders.replace(name, values)
            }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) =
            apply {
                this.additionalHeaders.replaceAll(additionalHeaders)
            }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) =
            apply {
                this.additionalHeaders.replaceAll(additionalHeaders)
            }

        fun removeAdditionalHeaders(name: String) =
            apply {
                additionalHeaders.remove(name)
            }

        fun removeAllAdditionalHeaders(names: Set<String>) =
            apply {
                additionalHeaders.removeAll(names)
            }

        fun additionalQueryParams(additionalQueryParams: QueryParams) =
            apply {
                this.additionalQueryParams.clear()
                putAllAdditionalQueryParams(additionalQueryParams)
            }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.clear()
                putAllAdditionalQueryParams(additionalQueryParams)
            }

        fun putAdditionalQueryParam(key: String, value: String) =
            apply {
                additionalQueryParams.put(key, value)
            }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) =
            apply {
                additionalQueryParams.put(key, values)
            }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) =
            apply {
                additionalQueryParams.replace(key, value)
            }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) =
            apply {
                additionalQueryParams.replace(key, values)
            }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) =
            apply {
                additionalQueryParams.remove(key)
            }

        fun removeAllAdditionalQueryParams(keys: Set<String>) =
            apply {
                additionalQueryParams.removeAll(keys)
            }

        fun build(): NamespaceQueryParams =
            NamespaceQueryParams(
              checkRequired(
                "namespace", namespace
              ),
              body.build(),
              additionalHeaders.build(),
              additionalQueryParams.build(),
            )
    }

    /** The consistency level for a query. */
    @NoAutoDetect
    class Consistency @JsonCreator private constructor(
        @JsonProperty("level") @ExcludeMissing private val level: JsonField<Level> = JsonMissing.of(),
        @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

    ) {

        /** The query's consistency level. */
        fun level(): Optional<Level> = Optional.ofNullable(level.getNullable("level"))

        /** The query's consistency level. */
        @JsonProperty("level")
        @ExcludeMissing
        fun _level(): JsonField<Level> = level

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Consistency =
            apply {
                if (validated) {
                  return@apply
                }

                level()
                validated = true
            }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Consistency]. */
            @JvmStatic
            fun builder() = Builder()
        }

        /** A builder for [Consistency]. */
        class Builder internal constructor() {

            private var level: JsonField<Level> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(consistency: Consistency) =
                apply {
                    level = consistency.level
                    additionalProperties = consistency.additionalProperties.toMutableMap()
                }

            /** The query's consistency level. */
            fun level(level: Level) = level(JsonField.of(level))

            /** The query's consistency level. */
            fun level(level: JsonField<Level>) =
                apply {
                    this.level = level
                }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

            fun putAdditionalProperty(key: String, value: JsonValue) =
                apply {
                    additionalProperties.put(key, value)
                }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                apply {
                    this.additionalProperties.putAll(additionalProperties)
                }

            fun removeAdditionalProperty(key: String) =
                apply {
                    additionalProperties.remove(key)
                }

            fun removeAllAdditionalProperties(keys: Set<String>) =
                apply {
                    keys.forEach(::removeAdditionalProperty)
                }

            fun build(): Consistency =
                Consistency(
                  level, additionalProperties.toImmutable()
                )
        }

        /** The query's consistency level. */
        class Level @JsonCreator private constructor(
            private val value: JsonField<String>,

        ) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that
             * doesn't match any known member, and you want to know that value. For example, if
             * the SDK is on an older version than the API, then the API may respond with new
             * members that the SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue
            fun _value(): JsonField<String> = value

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
             *
             * - It was deserialized from data that doesn't match any known member. For
             *   example, if the SDK is on an older version than the API, then the API may
             *   respond with new members that the SDK is unaware of.
             *
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
                /** An enum member indicating that [Level] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if
             * you want to throw for the unknown case.
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
             * @throws TurbopufferInvalidDataException if this class instance's value is a not
             * a known member.
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
             * @throws TurbopufferInvalidDataException if this class instance's value does not
             * have the expected primitive type.
             */
            fun asString(): String = _value().asString().orElseThrow { TurbopufferInvalidDataException("Value is not a String") }

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

        override fun toString() = "Consistency{level=$level, additionalProperties=$additionalProperties}"
    }

    /** Whether to include attributes in the response. */
    @JsonDeserialize(using = IncludeAttributes.Deserializer::class)
    @JsonSerialize(using = IncludeAttributes.Serializer::class)
    class IncludeAttributes private constructor(
        private val bool: Boolean? = null,
        private val strings: List<String>? = null,
        private val _json: JsonValue? = null,

    ) {

        /**
         * When `true`, include all attributes in the response. When `false`, include no
         * attributes in the response.
         */
        fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

        /** Include exactly the specified attributes in the response. */
        fun strings(): Optional<List<String>> = Optional.ofNullable(strings)

        fun isBool(): Boolean = bool != null

        fun isStrings(): Boolean = strings != null

        /**
         * When `true`, include all attributes in the response. When `false`, include no
         * attributes in the response.
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

        fun validate(): IncludeAttributes =
            apply {
                if (validated) {
                  return@apply
                }

                accept(object : Visitor<Unit> {
                    override fun visitBool(bool: Boolean) {

                    }

                    override fun visitStrings(strings: List<String>) {

                    }
                })
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
            @JvmStatic
            fun ofBool(bool: Boolean) = IncludeAttributes(bool = bool)

            /** Include exactly the specified attributes in the response. */
            @JvmStatic
            fun ofStrings(strings: List<String>) = IncludeAttributes(strings = strings)
        }

        /**
         * An interface that defines how to map each variant of [IncludeAttributes] to a
         * value of type [T].
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
             * deserialized from data that doesn't match any known variant. For example, if the
             * SDK is on an older version than the API, then the API may respond with new
             * variants that the SDK is unaware of.
             *
             * @throws TurbopufferInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
              throw TurbopufferInvalidDataException("Unknown IncludeAttributes: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<IncludeAttributes>(IncludeAttributes::class) {

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

            override fun serialize(value: IncludeAttributes, generator: JsonGenerator, provider: SerializerProvider) {
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

    override fun toString() = "NamespaceQueryParams{namespace=$namespace, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
