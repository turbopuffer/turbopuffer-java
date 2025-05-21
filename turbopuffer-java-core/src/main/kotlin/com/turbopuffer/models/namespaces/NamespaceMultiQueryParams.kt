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
import com.turbopuffer.core.allMaxBy
import com.turbopuffer.core.checkKnown
import com.turbopuffer.core.checkRequired
import com.turbopuffer.core.getOrThrow
import com.turbopuffer.core.http.Headers
import com.turbopuffer.core.http.QueryParams
import com.turbopuffer.core.toImmutable
import com.turbopuffer.errors.TurbopufferInvalidDataException
import com.turbopuffer.models.Filter
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Send multiple queries at once. */
class NamespaceMultiQueryParams
private constructor(
    private val namespace: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun namespace(): Optional<String> = Optional.ofNullable(namespace)

    /**
     * The consistency level for a query.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun consistency(): Optional<Consistency> = body.consistency()

    /**
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun queries(): Optional<List<Query>> = body.queries()

    /**
     * The encoding to use for vectors in the response.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun vectorEncoding(): Optional<VectorEncoding> = body.vectorEncoding()

    /**
     * Returns the raw JSON value of [consistency].
     *
     * Unlike [consistency], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _consistency(): JsonField<Consistency> = body._consistency()

    /**
     * Returns the raw JSON value of [queries].
     *
     * Unlike [queries], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _queries(): JsonField<List<Query>> = body._queries()

    /**
     * Returns the raw JSON value of [vectorEncoding].
     *
     * Unlike [vectorEncoding], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _vectorEncoding(): JsonField<VectorEncoding> = body._vectorEncoding()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): NamespaceMultiQueryParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of [NamespaceMultiQueryParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceMultiQueryParams]. */
    class Builder internal constructor() {

        private var namespace: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(namespaceMultiQueryParams: NamespaceMultiQueryParams) = apply {
            namespace = namespaceMultiQueryParams.namespace
            body = namespaceMultiQueryParams.body.toBuilder()
            additionalHeaders = namespaceMultiQueryParams.additionalHeaders.toBuilder()
            additionalQueryParams = namespaceMultiQueryParams.additionalQueryParams.toBuilder()
        }

        fun namespace(namespace: String?) = apply { this.namespace = namespace }

        /** Alias for calling [Builder.namespace] with `namespace.orElse(null)`. */
        fun namespace(namespace: Optional<String>) = namespace(namespace.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [consistency]
         * - [queries]
         * - [vectorEncoding]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

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

        fun queries(queries: List<Query>) = apply { body.queries(queries) }

        /**
         * Sets [Builder.queries] to an arbitrary JSON value.
         *
         * You should usually call [Builder.queries] with a well-typed `List<Query>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun queries(queries: JsonField<List<Query>>) = apply { body.queries(queries) }

        /**
         * Adds a single [Query] to [queries].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addQuery(query: Query) = apply { body.addQuery(query) }

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
         * Returns an immutable instance of [NamespaceMultiQueryParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): NamespaceMultiQueryParams =
            NamespaceMultiQueryParams(
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

    class Body
    private constructor(
        private val consistency: JsonField<Consistency>,
        private val queries: JsonField<List<Query>>,
        private val vectorEncoding: JsonField<VectorEncoding>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("consistency")
            @ExcludeMissing
            consistency: JsonField<Consistency> = JsonMissing.of(),
            @JsonProperty("queries")
            @ExcludeMissing
            queries: JsonField<List<Query>> = JsonMissing.of(),
            @JsonProperty("vector_encoding")
            @ExcludeMissing
            vectorEncoding: JsonField<VectorEncoding> = JsonMissing.of(),
        ) : this(consistency, queries, vectorEncoding, mutableMapOf())

        /**
         * The consistency level for a query.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun consistency(): Optional<Consistency> = consistency.getOptional("consistency")

        /**
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun queries(): Optional<List<Query>> = queries.getOptional("queries")

        /**
         * The encoding to use for vectors in the response.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun vectorEncoding(): Optional<VectorEncoding> =
            vectorEncoding.getOptional("vector_encoding")

        /**
         * Returns the raw JSON value of [consistency].
         *
         * Unlike [consistency], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("consistency")
        @ExcludeMissing
        fun _consistency(): JsonField<Consistency> = consistency

        /**
         * Returns the raw JSON value of [queries].
         *
         * Unlike [queries], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("queries") @ExcludeMissing fun _queries(): JsonField<List<Query>> = queries

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

            private var consistency: JsonField<Consistency> = JsonMissing.of()
            private var queries: JsonField<MutableList<Query>>? = null
            private var vectorEncoding: JsonField<VectorEncoding> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                consistency = body.consistency
                queries = body.queries.map { it.toMutableList() }
                vectorEncoding = body.vectorEncoding
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

            fun queries(queries: List<Query>) = queries(JsonField.of(queries))

            /**
             * Sets [Builder.queries] to an arbitrary JSON value.
             *
             * You should usually call [Builder.queries] with a well-typed `List<Query>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun queries(queries: JsonField<List<Query>>) = apply {
                this.queries = queries.map { it.toMutableList() }
            }

            /**
             * Adds a single [Query] to [queries].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addQuery(query: Query) = apply {
                queries =
                    (queries ?: JsonField.of(mutableListOf())).also {
                        checkKnown("queries", it).add(query)
                    }
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
                    consistency,
                    (queries ?: JsonMissing.of()).map { it.toImmutable() },
                    vectorEncoding,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            consistency().ifPresent { it.validate() }
            queries().ifPresent { it.forEach { it.validate() } }
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
            (consistency.asKnown().getOrNull()?.validity() ?: 0) +
                (queries.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (vectorEncoding.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && consistency == other.consistency && queries == other.queries && vectorEncoding == other.vectorEncoding && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(consistency, queries, vectorEncoding, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{consistency=$consistency, queries=$queries, vectorEncoding=$vectorEncoding, additionalProperties=$additionalProperties}"
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

    /** Query, filter, full-text search and vector search documents. */
    class Query
    private constructor(
        private val rankBy: JsonField<RankBy>,
        private val topK: JsonField<Long>,
        private val distanceMetric: JsonField<DistanceMetric>,
        private val filters: JsonField<Filter>,
        private val includeAttributes: JsonField<IncludeAttributes>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("rank_by") @ExcludeMissing rankBy: JsonField<RankBy> = JsonMissing.of(),
            @JsonProperty("top_k") @ExcludeMissing topK: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("distance_metric")
            @ExcludeMissing
            distanceMetric: JsonField<DistanceMetric> = JsonMissing.of(),
            @JsonProperty("filters") @ExcludeMissing filters: JsonField<Filter> = JsonMissing.of(),
            @JsonProperty("include_attributes")
            @ExcludeMissing
            includeAttributes: JsonField<IncludeAttributes> = JsonMissing.of(),
        ) : this(rankBy, topK, distanceMetric, filters, includeAttributes, mutableMapOf())

        /**
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun rankBy(): RankBy = rankBy.getRequired("rank_by")

        /**
         * The number of results to return.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun topK(): Long = topK.getRequired("top_k")

        /**
         * A function used to calculate vector similarity.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun distanceMetric(): Optional<DistanceMetric> =
            distanceMetric.getOptional("distance_metric")

        /**
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun filters(): Optional<Filter> = filters.getOptional("filters")

        /**
         * Whether to include attributes in the response.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun includeAttributes(): Optional<IncludeAttributes> =
            includeAttributes.getOptional("include_attributes")

        /**
         * Returns the raw JSON value of [rankBy].
         *
         * Unlike [rankBy], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("rank_by") @ExcludeMissing fun _rankBy(): JsonField<RankBy> = rankBy

        /**
         * Returns the raw JSON value of [topK].
         *
         * Unlike [topK], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("top_k") @ExcludeMissing fun _topK(): JsonField<Long> = topK

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
         * Returns the raw JSON value of [filters].
         *
         * Unlike [filters], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("filters") @ExcludeMissing fun _filters(): JsonField<Filter> = filters

        /**
         * Returns the raw JSON value of [includeAttributes].
         *
         * Unlike [includeAttributes], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("include_attributes")
        @ExcludeMissing
        fun _includeAttributes(): JsonField<IncludeAttributes> = includeAttributes

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
             * Returns a mutable builder for constructing an instance of [Query].
             *
             * The following fields are required:
             * ```java
             * .rankBy()
             * .topK()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Query]. */
        class Builder internal constructor() {

            private var rankBy: JsonField<RankBy>? = null
            private var topK: JsonField<Long>? = null
            private var distanceMetric: JsonField<DistanceMetric> = JsonMissing.of()
            private var filters: JsonField<Filter> = JsonMissing.of()
            private var includeAttributes: JsonField<IncludeAttributes> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(query: Query) = apply {
                rankBy = query.rankBy
                topK = query.topK
                distanceMetric = query.distanceMetric
                filters = query.filters
                includeAttributes = query.includeAttributes
                additionalProperties = query.additionalProperties.toMutableMap()
            }

            fun rankBy(rankBy: RankBy) = rankBy(JsonField.of(rankBy))

            /**
             * Sets [Builder.rankBy] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rankBy] with a well-typed [RankBy] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun rankBy(rankBy: JsonField<RankBy>) = apply { this.rankBy = rankBy }

            /** Alias for calling [rankBy] with `RankBy.ofVector(vector)`. */
            fun rankByOfVector(vector: List<JsonValue>) = rankBy(RankBy.ofVector(vector))

            /** Alias for calling [rankBy] with `RankBy.ofJsonValues(jsonValues)`. */
            fun rankByOfJsonValues(jsonValues: List<JsonValue>) =
                rankBy(RankBy.ofJsonValues(jsonValues))

            /** Alias for calling [rankBy] with `RankBy.ofJsonValues(jsonValues)`. */
            fun rankByOfJsonValues(jsonValues: List<JsonValue>) =
                rankBy(RankBy.ofJsonValues(jsonValues))

            /** Alias for calling [rankBy] with `RankBy.ofJsonValues(jsonValues)`. */
            fun rankByOfJsonValues(jsonValues: List<JsonValue>) =
                rankBy(RankBy.ofJsonValues(jsonValues))

            /** Alias for calling [rankBy] with `RankBy.ofJsonValues(jsonValues)`. */
            fun rankByOfJsonValues(jsonValues: List<JsonValue>) =
                rankBy(RankBy.ofJsonValues(jsonValues))

            /** Alias for calling [rankBy] with `RankBy.ofJsonValues(jsonValues)`. */
            fun rankByOfJsonValues(jsonValues: List<JsonValue>) =
                rankBy(RankBy.ofJsonValues(jsonValues))

            /** Alias for calling [rankBy] with `RankBy.ofAttribute(attribute)`. */
            fun rankByOfAttribute(attribute: List<JsonValue>) =
                rankBy(RankBy.ofAttribute(attribute))

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

            fun filters(filters: Filter) = filters(JsonField.of(filters))

            /**
             * Sets [Builder.filters] to an arbitrary JSON value.
             *
             * You should usually call [Builder.filters] with a well-typed [Filter] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun filters(filters: JsonField<Filter>) = apply { this.filters = filters }

            /** Alias for calling [filters] with `Filter.ofJsonValues(jsonValues)`. */
            fun filtersOfJsonValues(jsonValues: List<JsonValue>) =
                filters(Filter.ofJsonValues(jsonValues))

            /** Alias for calling [filters] with `Filter.ofJsonValues(jsonValues)`. */
            fun filtersOfJsonValues(jsonValues: List<JsonValue>) =
                filters(Filter.ofJsonValues(jsonValues))

            /** Alias for calling [filters] with `Filter.ofJsonValues(jsonValues)`. */
            fun filtersOfJsonValues(jsonValues: List<JsonValue>) =
                filters(Filter.ofJsonValues(jsonValues))

            /** Alias for calling [filters] with `Filter.ofJsonValues(jsonValues)`. */
            fun filtersOfJsonValues(jsonValues: List<JsonValue>) =
                filters(Filter.ofJsonValues(jsonValues))

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
             *
             * The following fields are required:
             * ```java
             * .rankBy()
             * .topK()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Query =
                Query(
                    checkRequired("rankBy", rankBy),
                    checkRequired("topK", topK),
                    distanceMetric,
                    filters,
                    includeAttributes,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Query = apply {
            if (validated) {
                return@apply
            }

            rankBy().validate()
            topK()
            distanceMetric().ifPresent { it.validate() }
            filters().ifPresent { it.validate() }
            includeAttributes().ifPresent { it.validate() }
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
            (rankBy.asKnown().getOrNull()?.validity() ?: 0) +
                (if (topK.asKnown().isPresent) 1 else 0) +
                (distanceMetric.asKnown().getOrNull()?.validity() ?: 0) +
                (filters.asKnown().getOrNull()?.validity() ?: 0) +
                (includeAttributes.asKnown().getOrNull()?.validity() ?: 0)

        @JsonDeserialize(using = RankBy.Deserializer::class)
        @JsonSerialize(using = RankBy.Serializer::class)
        class RankBy
        private constructor(
            private val vector: List<JsonValue>? = null,
            private val jsonValues: List<JsonValue>? = null,
            private val jsonValues: List<JsonValue>? = null,
            private val jsonValues: List<JsonValue>? = null,
            private val jsonValues: List<JsonValue>? = null,
            private val jsonValues: List<JsonValue>? = null,
            private val attribute: List<JsonValue>? = null,
            private val _json: JsonValue? = null,
        ) {

            fun vector(): Optional<List<JsonValue>> = Optional.ofNullable(vector)

            fun jsonValues(): Optional<List<JsonValue>> = Optional.ofNullable(jsonValues)

            fun jsonValues(): Optional<List<JsonValue>> = Optional.ofNullable(jsonValues)

            fun jsonValues(): Optional<List<JsonValue>> = Optional.ofNullable(jsonValues)

            fun jsonValues(): Optional<List<JsonValue>> = Optional.ofNullable(jsonValues)

            fun jsonValues(): Optional<List<JsonValue>> = Optional.ofNullable(jsonValues)

            fun attribute(): Optional<List<JsonValue>> = Optional.ofNullable(attribute)

            fun isVector(): Boolean = vector != null

            fun isJsonValues(): Boolean = jsonValues != null

            fun isJsonValues(): Boolean = jsonValues != null

            fun isJsonValues(): Boolean = jsonValues != null

            fun isJsonValues(): Boolean = jsonValues != null

            fun isJsonValues(): Boolean = jsonValues != null

            fun isAttribute(): Boolean = attribute != null

            fun asVector(): List<JsonValue> = vector.getOrThrow("vector")

            fun asJsonValues(): List<JsonValue> = jsonValues.getOrThrow("jsonValues")

            fun asJsonValues(): List<JsonValue> = jsonValues.getOrThrow("jsonValues")

            fun asJsonValues(): List<JsonValue> = jsonValues.getOrThrow("jsonValues")

            fun asJsonValues(): List<JsonValue> = jsonValues.getOrThrow("jsonValues")

            fun asJsonValues(): List<JsonValue> = jsonValues.getOrThrow("jsonValues")

            fun asAttribute(): List<JsonValue> = attribute.getOrThrow("attribute")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    vector != null -> visitor.visitVector(vector)
                    jsonValues != null -> visitor.visitJsonValues(jsonValues)
                    jsonValues != null -> visitor.visitJsonValues(jsonValues)
                    jsonValues != null -> visitor.visitJsonValues(jsonValues)
                    jsonValues != null -> visitor.visitJsonValues(jsonValues)
                    jsonValues != null -> visitor.visitJsonValues(jsonValues)
                    attribute != null -> visitor.visitAttribute(attribute)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): RankBy = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitVector(vector: List<JsonValue>) {}

                        override fun visitJsonValues(jsonValues: List<JsonValue>) {}

                        override fun visitJsonValues(jsonValues: List<JsonValue>) {}

                        override fun visitJsonValues(jsonValues: List<JsonValue>) {}

                        override fun visitJsonValues(jsonValues: List<JsonValue>) {}

                        override fun visitJsonValues(jsonValues: List<JsonValue>) {}

                        override fun visitAttribute(attribute: List<JsonValue>) {}
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
                        override fun visitVector(vector: List<JsonValue>) = vector.size

                        override fun visitJsonValues(jsonValues: List<JsonValue>) = jsonValues.size

                        override fun visitJsonValues(jsonValues: List<JsonValue>) = jsonValues.size

                        override fun visitJsonValues(jsonValues: List<JsonValue>) = jsonValues.size

                        override fun visitJsonValues(jsonValues: List<JsonValue>) = jsonValues.size

                        override fun visitJsonValues(jsonValues: List<JsonValue>) = jsonValues.size

                        override fun visitAttribute(attribute: List<JsonValue>) = attribute.size

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is RankBy && vector == other.vector && jsonValues == other.jsonValues && jsonValues == other.jsonValues && jsonValues == other.jsonValues && jsonValues == other.jsonValues && jsonValues == other.jsonValues && attribute == other.attribute /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(vector, jsonValues, jsonValues, jsonValues, jsonValues, jsonValues, attribute) /* spotless:on */

            override fun toString(): String =
                when {
                    vector != null -> "RankBy{vector=$vector}"
                    jsonValues != null -> "RankBy{jsonValues=$jsonValues}"
                    jsonValues != null -> "RankBy{jsonValues=$jsonValues}"
                    jsonValues != null -> "RankBy{jsonValues=$jsonValues}"
                    jsonValues != null -> "RankBy{jsonValues=$jsonValues}"
                    jsonValues != null -> "RankBy{jsonValues=$jsonValues}"
                    attribute != null -> "RankBy{attribute=$attribute}"
                    _json != null -> "RankBy{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid RankBy")
                }

            companion object {

                @JvmStatic fun ofVector(vector: List<JsonValue>) = RankBy(vector = vector)

                @JvmStatic
                fun ofJsonValues(jsonValues: List<JsonValue>) = RankBy(jsonValues = jsonValues)

                @JvmStatic
                fun ofJsonValues(jsonValues: List<JsonValue>) = RankBy(jsonValues = jsonValues)

                @JvmStatic
                fun ofJsonValues(jsonValues: List<JsonValue>) = RankBy(jsonValues = jsonValues)

                @JvmStatic
                fun ofJsonValues(jsonValues: List<JsonValue>) = RankBy(jsonValues = jsonValues)

                @JvmStatic
                fun ofJsonValues(jsonValues: List<JsonValue>) = RankBy(jsonValues = jsonValues)

                @JvmStatic
                fun ofAttribute(attribute: List<JsonValue>) = RankBy(attribute = attribute)
            }

            /**
             * An interface that defines how to map each variant of [RankBy] to a value of type [T].
             */
            interface Visitor<out T> {

                fun visitVector(vector: List<JsonValue>): T

                fun visitJsonValues(jsonValues: List<JsonValue>): T

                fun visitJsonValues(jsonValues: List<JsonValue>): T

                fun visitJsonValues(jsonValues: List<JsonValue>): T

                fun visitJsonValues(jsonValues: List<JsonValue>): T

                fun visitJsonValues(jsonValues: List<JsonValue>): T

                fun visitAttribute(attribute: List<JsonValue>): T

                /**
                 * Maps an unknown variant of [RankBy] to a value of type [T].
                 *
                 * An instance of [RankBy] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws TurbopufferInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw TurbopufferInvalidDataException("Unknown RankBy: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<RankBy>(RankBy::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): RankBy {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<List<JsonValue>>())?.let {
                                    RankBy(vector = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<List<JsonValue>>())?.let {
                                    RankBy(jsonValues = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<List<JsonValue>>())?.let {
                                    RankBy(jsonValues = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<List<JsonValue>>())?.let {
                                    RankBy(jsonValues = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<List<JsonValue>>())?.let {
                                    RankBy(jsonValues = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<List<JsonValue>>())?.let {
                                    RankBy(jsonValues = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<List<JsonValue>>())?.let {
                                    RankBy(attribute = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from boolean).
                        0 -> RankBy(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<RankBy>(RankBy::class) {

                override fun serialize(
                    value: RankBy,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.vector != null -> generator.writeObject(value.vector)
                        value.jsonValues != null -> generator.writeObject(value.jsonValues)
                        value.jsonValues != null -> generator.writeObject(value.jsonValues)
                        value.jsonValues != null -> generator.writeObject(value.jsonValues)
                        value.jsonValues != null -> generator.writeObject(value.jsonValues)
                        value.jsonValues != null -> generator.writeObject(value.jsonValues)
                        value.attribute != null -> generator.writeObject(value.attribute)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid RankBy")
                    }
                }
            }
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

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    bool != null -> visitor.visitBool(bool)
                    strings != null -> visitor.visitStrings(strings)
                    else -> visitor.unknown(_json)
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
                        override fun visitBool(bool: Boolean) = 1

                        override fun visitStrings(strings: List<String>) = strings.size

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

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
                @JvmStatic
                fun ofStrings(strings: List<String>) = IncludeAttributes(strings = strings)
            }

            /**
             * An interface that defines how to map each variant of [IncludeAttributes] to a value
             * of type [T].
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

            internal class Deserializer :
                BaseDeserializer<IncludeAttributes>(IncludeAttributes::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): IncludeAttributes {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                                    IncludeAttributes(bool = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                                    IncludeAttributes(strings = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from string).
                        0 -> IncludeAttributes(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer :
                BaseSerializer<IncludeAttributes>(IncludeAttributes::class) {

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

            return /* spotless:off */ other is Query && rankBy == other.rankBy && topK == other.topK && distanceMetric == other.distanceMetric && filters == other.filters && includeAttributes == other.includeAttributes && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(rankBy, topK, distanceMetric, filters, includeAttributes, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Query{rankBy=$rankBy, topK=$topK, distanceMetric=$distanceMetric, filters=$filters, includeAttributes=$includeAttributes, additionalProperties=$additionalProperties}"
    }

    /** The encoding to use for vectors in the response. */
    class VectorEncoding @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val FLOAT = of("float")

            @JvmField val BASE64 = of("base64")

            @JvmStatic fun of(value: String) = VectorEncoding(JsonField.of(value))
        }

        /** An enum containing [VectorEncoding]'s known values. */
        enum class Known {
            FLOAT,
            BASE64,
        }

        /**
         * An enum containing [VectorEncoding]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [VectorEncoding] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            FLOAT,
            BASE64,
            /**
             * An enum member indicating that [VectorEncoding] was instantiated with an unknown
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
                FLOAT -> Value.FLOAT
                BASE64 -> Value.BASE64
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
                FLOAT -> Known.FLOAT
                BASE64 -> Known.BASE64
                else -> throw TurbopufferInvalidDataException("Unknown VectorEncoding: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                TurbopufferInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): VectorEncoding = apply {
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

            return /* spotless:off */ other is VectorEncoding && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is NamespaceMultiQueryParams && namespace == other.namespace && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(namespace, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "NamespaceMultiQueryParams{namespace=$namespace, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
