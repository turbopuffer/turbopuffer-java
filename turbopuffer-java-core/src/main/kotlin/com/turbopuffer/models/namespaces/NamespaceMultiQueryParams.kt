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
import com.turbopuffer.core.checkRequired
import com.turbopuffer.core.http.Headers
import com.turbopuffer.core.http.QueryParams
import com.turbopuffer.core.toImmutable
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Issue multiple concurrent queries filter or search documents. */
class NamespaceMultiQueryParams
private constructor(
    private val namespace: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun namespace(): Optional<String> = Optional.ofNullable(namespace)

    /**
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun queries(): List<Query> = body.queries()

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
     * Returns the raw JSON value of [queries].
     *
     * Unlike [queries], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _queries(): JsonField<List<Query>> = body._queries()

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

        /**
         * Returns a mutable builder for constructing an instance of [NamespaceMultiQueryParams].
         *
         * The following fields are required:
         * ```java
         * .queries()
         * ```
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
         * - [queries]
         * - [consistency]
         * - [vectorEncoding]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

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
         * Returns an immutable instance of [NamespaceMultiQueryParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .queries()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
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
        private val queries: JsonField<List<Query>>,
        private val consistency: JsonField<Consistency>,
        private val vectorEncoding: JsonField<VectorEncoding>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("queries")
            @ExcludeMissing
            queries: JsonField<List<Query>> = JsonMissing.of(),
            @JsonProperty("consistency")
            @ExcludeMissing
            consistency: JsonField<Consistency> = JsonMissing.of(),
            @JsonProperty("vector_encoding")
            @ExcludeMissing
            vectorEncoding: JsonField<VectorEncoding> = JsonMissing.of(),
        ) : this(queries, consistency, vectorEncoding, mutableMapOf())

        /**
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun queries(): List<Query> = queries.getRequired("queries")

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
         * Returns the raw JSON value of [queries].
         *
         * Unlike [queries], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("queries") @ExcludeMissing fun _queries(): JsonField<List<Query>> = queries

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

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .queries()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var queries: JsonField<MutableList<Query>>? = null
            private var consistency: JsonField<Consistency> = JsonMissing.of()
            private var vectorEncoding: JsonField<VectorEncoding> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                queries = body.queries.map { it.toMutableList() }
                consistency = body.consistency
                vectorEncoding = body.vectorEncoding
                additionalProperties = body.additionalProperties.toMutableMap()
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
             *
             * The following fields are required:
             * ```java
             * .queries()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("queries", queries).map { it.toImmutable() },
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

            queries().forEach { it.validate() }
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
            (queries.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (consistency.asKnown().getOrNull()?.validity() ?: 0) +
                (vectorEncoding.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && queries == other.queries && consistency == other.consistency && vectorEncoding == other.vectorEncoding && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(queries, consistency, vectorEncoding, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{queries=$queries, consistency=$consistency, vectorEncoding=$vectorEncoding, additionalProperties=$additionalProperties}"
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

        return /* spotless:off */ other is NamespaceMultiQueryParams && namespace == other.namespace && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(namespace, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "NamespaceMultiQueryParams{namespace=$namespace, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
