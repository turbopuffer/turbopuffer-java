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
 * Creates, updates, or deletes documents in a namespace. Documents are upserted in a
 * column-oriented format (using `ids`, `vectors`, `attributes`, etc.) or in a row-based format
 * (using `upserts`). To delete a document, send a `null` vector.
 */
class NamespaceUpsertParams
private constructor(
    private val namespace: String,
    private val body: NamespaceUpsertBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun namespace(): String = namespace

    fun variant0(): Optional<UnionMember0> = body.variant0()

    fun variant1(): Optional<Upserts> = body.variant1()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): NamespaceUpsertBody = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> namespace
            else -> ""
        }
    }

    @JsonDeserialize(using = NamespaceUpsertBody.Deserializer::class)
    @JsonSerialize(using = NamespaceUpsertBody.Serializer::class)
    class NamespaceUpsertBody
    internal constructor(
        private val unionMember0: UnionMember0? = null,
        private val upserts: Upserts? = null,
        private val _json: JsonValue? = null,
    ) {

        fun unionMember0(): Optional<UnionMember0> = Optional.ofNullable(unionMember0)

        fun upserts(): Optional<Upserts> = Optional.ofNullable(upserts)

        fun isUnionMember0(): Boolean = unionMember0 != null

        fun isUpserts(): Boolean = upserts != null

        fun asUnionMember0(): UnionMember0 = unionMember0.getOrThrow("unionMember0")

        fun asUpserts(): Upserts = upserts.getOrThrow("upserts")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                unionMember0 != null -> visitor.visitUnionMember0(unionMember0)
                upserts != null -> visitor.visitUpserts(upserts)
                else -> visitor.unknown(_json)
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is NamespaceUpsertBody && unionMember0 == other.unionMember0 && upserts == other.upserts /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(unionMember0, upserts) /* spotless:on */

        override fun toString(): String =
            when {
                unionMember0 != null -> "NamespaceUpsertBody{unionMember0=$unionMember0}"
                upserts != null -> "NamespaceUpsertBody{upserts=$upserts}"
                _json != null -> "NamespaceUpsertBody{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid NamespaceUpsertBody")
            }

        companion object {

            @JvmStatic
            fun ofUnionMember0(unionMember0: UnionMember0) =
                NamespaceUpsertBody(unionMember0 = unionMember0)

            @JvmStatic fun ofUpserts(upserts: Upserts) = NamespaceUpsertBody(upserts = upserts)
        }

        /**
         * An interface that defines how to map each variant of [NamespaceUpsertBody] to a value of
         * type [T].
         */
        interface Visitor<out T> {

            fun visitUnionMember0(unionMember0: UnionMember0): T

            fun visitUpserts(upserts: Upserts): T

            /**
             * Maps an unknown variant of [NamespaceUpsertBody] to a value of type [T].
             *
             * An instance of [NamespaceUpsertBody] can contain an unknown variant if it was
             * deserialized from data that doesn't match any known variant. For example, if the SDK
             * is on an older version than the API, then the API may respond with new variants that
             * the SDK is unaware of.
             *
             * @throws TurbopufferInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw TurbopufferInvalidDataException("Unknown NamespaceUpsertBody: $json")
            }
        }

        internal class Deserializer :
            BaseDeserializer<NamespaceUpsertBody>(NamespaceUpsertBody::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): NamespaceUpsertBody {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<UnionMember0>())?.let {
                    return NamespaceUpsertBody(unionMember0 = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<Upserts>())?.let {
                    return NamespaceUpsertBody(upserts = it, _json = json)
                }

                return NamespaceUpsertBody(_json = json)
            }
        }

        internal class Serializer :
            BaseSerializer<NamespaceUpsertBody>(NamespaceUpsertBody::class) {

            override fun serialize(
                value: NamespaceUpsertBody,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.unionMember0 != null -> generator.writeObject(value.unionMember0)
                    value.upserts != null -> generator.writeObject(value.upserts)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid NamespaceUpsertBody")
                }
            }
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceUpsertParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var namespace: String? = null
        private var body: NamespaceUpsertBody? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(namespaceUpsertParams: NamespaceUpsertParams) = apply {
            namespace = namespaceUpsertParams.namespace
            body = namespaceUpsertParams.body
            additionalHeaders = namespaceUpsertParams.additionalHeaders.toBuilder()
            additionalQueryParams = namespaceUpsertParams.additionalQueryParams.toBuilder()
        }

        fun namespace(namespace: String) = apply { this.namespace = namespace }

        fun forVariant0(variant0: UnionMember0) = apply {
            body = NamespaceUpsertBody.ofUnionMember0(variant0)
        }

        fun forVariant1(variant1: Upserts) = apply {
            body = NamespaceUpsertBody.ofUpserts(variant1)
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

        fun build(): NamespaceUpsertParams =
            NamespaceUpsertParams(
                checkRequired("namespace", namespace),
                body ?: NamespaceUpsertBody(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    @NoAutoDetect
    class UnionMember0
    @JsonCreator
    private constructor(
        @JsonProperty("distance_metric")
        @ExcludeMissing
        private val distanceMetric: JsonField<DistanceMetric> = JsonMissing.of(),
        @JsonProperty("ids")
        @ExcludeMissing
        private val ids: JsonField<List<Id>> = JsonMissing.of(),
        @JsonProperty("vectors")
        @ExcludeMissing
        private val vectors: JsonField<List<List<Double>?>> = JsonMissing.of(),
        @JsonProperty("attributes")
        @ExcludeMissing
        private val attributes: JsonField<Attributes> = JsonMissing.of(),
        @JsonProperty("copy_from_namespace")
        @ExcludeMissing
        private val copyFromNamespace: JsonField<String> = JsonMissing.of(),
        @JsonProperty("schema") @ExcludeMissing private val schema: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The function used to calculate vector similarity. */
        fun distanceMetric(): DistanceMetric = distanceMetric.getRequired("distance_metric")

        /** Array of document IDs (unsigned 64-bit integers, UUIDs, or strings). */
        fun ids(): List<Id> = ids.getRequired("ids")

        /**
         * Array of vectors. Each vector is an array of numbers. Use `null` to delete a document.
         */
        fun vectors(): List<List<Double>?> = vectors.getRequired("vectors")

        /** Object mapping attribute names to arrays of attribute values. */
        fun attributes(): Optional<Attributes> =
            Optional.ofNullable(attributes.getNullable("attributes"))

        /** Copy all documents from another namespace into this one. */
        fun copyFromNamespace(): Optional<String> =
            Optional.ofNullable(copyFromNamespace.getNullable("copy_from_namespace"))

        /** Manually specify the schema for the documents. */
        @JsonProperty("schema") @ExcludeMissing fun _schema(): JsonValue = schema

        /** The function used to calculate vector similarity. */
        @JsonProperty("distance_metric")
        @ExcludeMissing
        fun _distanceMetric(): JsonField<DistanceMetric> = distanceMetric

        /** Array of document IDs (unsigned 64-bit integers, UUIDs, or strings). */
        @JsonProperty("ids") @ExcludeMissing fun _ids(): JsonField<List<Id>> = ids

        /**
         * Array of vectors. Each vector is an array of numbers. Use `null` to delete a document.
         */
        @JsonProperty("vectors")
        @ExcludeMissing
        fun _vectors(): JsonField<List<List<Double>?>> = vectors

        /** Object mapping attribute names to arrays of attribute values. */
        @JsonProperty("attributes")
        @ExcludeMissing
        fun _attributes(): JsonField<Attributes> = attributes

        /** Copy all documents from another namespace into this one. */
        @JsonProperty("copy_from_namespace")
        @ExcludeMissing
        fun _copyFromNamespace(): JsonField<String> = copyFromNamespace

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): UnionMember0 = apply {
            if (validated) {
                return@apply
            }

            distanceMetric()
            ids().forEach { it.validate() }
            vectors()
            attributes().ifPresent { it.validate() }
            copyFromNamespace()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UnionMember0]. */
        class Builder internal constructor() {

            private var distanceMetric: JsonField<DistanceMetric>? = null
            private var ids: JsonField<MutableList<Id>>? = null
            private var vectors: JsonField<MutableList<List<Double>?>>? = null
            private var attributes: JsonField<Attributes> = JsonMissing.of()
            private var copyFromNamespace: JsonField<String> = JsonMissing.of()
            private var schema: JsonValue = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(unionMember0: UnionMember0) = apply {
                distanceMetric = unionMember0.distanceMetric
                ids = unionMember0.ids.map { it.toMutableList() }
                vectors = unionMember0.vectors.map { it.toMutableList() }
                attributes = unionMember0.attributes
                copyFromNamespace = unionMember0.copyFromNamespace
                schema = unionMember0.schema
                additionalProperties = unionMember0.additionalProperties.toMutableMap()
            }

            /** The function used to calculate vector similarity. */
            fun distanceMetric(distanceMetric: DistanceMetric) =
                distanceMetric(JsonField.of(distanceMetric))

            /** The function used to calculate vector similarity. */
            fun distanceMetric(distanceMetric: JsonField<DistanceMetric>) = apply {
                this.distanceMetric = distanceMetric
            }

            /** Array of document IDs (unsigned 64-bit integers, UUIDs, or strings). */
            fun ids(ids: List<Id>) = ids(JsonField.of(ids))

            /** Array of document IDs (unsigned 64-bit integers, UUIDs, or strings). */
            fun ids(ids: JsonField<List<Id>>) = apply { this.ids = ids.map { it.toMutableList() } }

            /** Array of document IDs (unsigned 64-bit integers, UUIDs, or strings). */
            fun addId(id: Id) = apply {
                ids =
                    (ids ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(id)
                    }
            }

            /** Array of document IDs (unsigned 64-bit integers, UUIDs, or strings). */
            fun addId(integer: Long) = addId(Id.ofInteger(integer))

            /** Array of document IDs (unsigned 64-bit integers, UUIDs, or strings). */
            fun addId(string: String) = addId(Id.ofString(string))

            /**
             * Array of vectors. Each vector is an array of numbers. Use `null` to delete a
             * document.
             */
            fun vectors(vectors: List<List<Double>?>) = vectors(JsonField.of(vectors))

            /**
             * Array of vectors. Each vector is an array of numbers. Use `null` to delete a
             * document.
             */
            fun vectors(vectors: JsonField<List<List<Double>?>>) = apply {
                this.vectors = vectors.map { it.toMutableList() }
            }

            /**
             * Array of vectors. Each vector is an array of numbers. Use `null` to delete a
             * document.
             */
            fun addVector(vector: List<Double>) = apply {
                vectors =
                    (vectors ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(vector)
                    }
            }

            /** Object mapping attribute names to arrays of attribute values. */
            fun attributes(attributes: Attributes) = attributes(JsonField.of(attributes))

            /** Object mapping attribute names to arrays of attribute values. */
            fun attributes(attributes: JsonField<Attributes>) = apply {
                this.attributes = attributes
            }

            /** Copy all documents from another namespace into this one. */
            fun copyFromNamespace(copyFromNamespace: String) =
                copyFromNamespace(JsonField.of(copyFromNamespace))

            /** Copy all documents from another namespace into this one. */
            fun copyFromNamespace(copyFromNamespace: JsonField<String>) = apply {
                this.copyFromNamespace = copyFromNamespace
            }

            /** Manually specify the schema for the documents. */
            fun schema(schema: JsonValue) = apply { this.schema = schema }

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

            fun build(): UnionMember0 =
                UnionMember0(
                    checkRequired("distanceMetric", distanceMetric),
                    checkRequired("ids", ids).map { it.toImmutable() },
                    checkRequired("vectors", vectors).map { it.toImmutable() },
                    attributes,
                    copyFromNamespace,
                    schema,
                    additionalProperties.toImmutable(),
                )
        }

        /** The function used to calculate vector similarity. */
        class DistanceMetric
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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
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
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
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
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws TurbopufferInvalidDataException if this class instance's value is a not a
             *   known member.
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

        @JsonDeserialize(using = Id.Deserializer::class)
        @JsonSerialize(using = Id.Serializer::class)
        class Id
        private constructor(
            private val integer: Long? = null,
            private val string: String? = null,
            private val _json: JsonValue? = null,
        ) {

            fun integer(): Optional<Long> = Optional.ofNullable(integer)

            fun string(): Optional<String> = Optional.ofNullable(string)

            fun isInteger(): Boolean = integer != null

            fun isString(): Boolean = string != null

            fun asInteger(): Long = integer.getOrThrow("integer")

            fun asString(): String = string.getOrThrow("string")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    integer != null -> visitor.visitInteger(integer)
                    string != null -> visitor.visitString(string)
                    else -> visitor.unknown(_json)
                }
            }

            private var validated: Boolean = false

            fun validate(): Id = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitInteger(integer: Long) {}

                        override fun visitString(string: String) {}
                    }
                )
                validated = true
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Id && integer == other.integer && string == other.string /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(integer, string) /* spotless:on */

            override fun toString(): String =
                when {
                    integer != null -> "Id{integer=$integer}"
                    string != null -> "Id{string=$string}"
                    _json != null -> "Id{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Id")
                }

            companion object {

                @JvmStatic fun ofInteger(integer: Long) = Id(integer = integer)

                @JvmStatic fun ofString(string: String) = Id(string = string)
            }

            /** An interface that defines how to map each variant of [Id] to a value of type [T]. */
            interface Visitor<out T> {

                fun visitInteger(integer: Long): T

                fun visitString(string: String): T

                /**
                 * Maps an unknown variant of [Id] to a value of type [T].
                 *
                 * An instance of [Id] can contain an unknown variant if it was deserialized from
                 * data that doesn't match any known variant. For example, if the SDK is on an older
                 * version than the API, then the API may respond with new variants that the SDK is
                 * unaware of.
                 *
                 * @throws TurbopufferInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw TurbopufferInvalidDataException("Unknown Id: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Id>(Id::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Id {
                    val json = JsonValue.fromJsonNode(node)

                    tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                        return Id(integer = it, _json = json)
                    }
                    tryDeserialize(node, jacksonTypeRef<String>())?.let {
                        return Id(string = it, _json = json)
                    }

                    return Id(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<Id>(Id::class) {

                override fun serialize(
                    value: Id,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.integer != null -> generator.writeObject(value.integer)
                        value.string != null -> generator.writeObject(value.string)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Id")
                    }
                }
            }
        }

        /** Object mapping attribute names to arrays of attribute values. */
        @NoAutoDetect
        class Attributes
        @JsonCreator
        private constructor(
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Attributes = apply {
                if (validated) {
                    return@apply
                }

                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Attributes]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(attributes: Attributes) = apply {
                    additionalProperties = attributes.additionalProperties.toMutableMap()
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                fun build(): Attributes = Attributes(additionalProperties.toImmutable())
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Attributes && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() = "Attributes{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is UnionMember0 && distanceMetric == other.distanceMetric && ids == other.ids && vectors == other.vectors && attributes == other.attributes && copyFromNamespace == other.copyFromNamespace && schema == other.schema && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(distanceMetric, ids, vectors, attributes, copyFromNamespace, schema, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UnionMember0{distanceMetric=$distanceMetric, ids=$ids, vectors=$vectors, attributes=$attributes, copyFromNamespace=$copyFromNamespace, schema=$schema, additionalProperties=$additionalProperties}"
    }

    @NoAutoDetect
    class Upserts
    @JsonCreator
    private constructor(
        @JsonProperty("upserts")
        @ExcludeMissing
        private val upserts: JsonField<List<Upsert>> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** Array of document operations in row-based format. */
        fun upserts(): List<Upsert> = upserts.getRequired("upserts")

        /** Array of document operations in row-based format. */
        @JsonProperty("upserts") @ExcludeMissing fun _upserts(): JsonField<List<Upsert>> = upserts

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Upserts = apply {
            if (validated) {
                return@apply
            }

            upserts().forEach { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Upserts]. */
        class Builder internal constructor() {

            private var upserts: JsonField<MutableList<Upsert>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(upserts: Upserts) = apply {
                this.upserts = upserts.upserts.map { it.toMutableList() }
                additionalProperties = upserts.additionalProperties.toMutableMap()
            }

            /** Array of document operations in row-based format. */
            fun upserts(upserts: List<Upsert>) = upserts(JsonField.of(upserts))

            /** Array of document operations in row-based format. */
            fun upserts(upserts: JsonField<List<Upsert>>) = apply {
                this.upserts = upserts.map { it.toMutableList() }
            }

            /** Array of document operations in row-based format. */
            fun addUpsert(upsert: Upsert) = apply {
                upserts =
                    (upserts ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(upsert)
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

            fun build(): Upserts =
                Upserts(
                    checkRequired("upserts", upserts).map { it.toImmutable() },
                    additionalProperties.toImmutable()
                )
        }

        @NoAutoDetect
        class Upsert
        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing private val id: JsonField<Id> = JsonMissing.of(),
            @JsonProperty("attributes")
            @ExcludeMissing
            private val attributes: JsonValue = JsonMissing.of(),
            @JsonProperty("vector")
            @ExcludeMissing
            private val vector: JsonField<List<Double>> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** Document ID. */
            fun id(): Id = id.getRequired("id")

            /** Object mapping attribute names to values. */
            @JsonProperty("attributes") @ExcludeMissing fun _attributes(): JsonValue = attributes

            /** Document vector. Use `null` to indicate deletion. */
            fun vector(): Optional<List<Double>> = Optional.ofNullable(vector.getNullable("vector"))

            /** Document ID. */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Id> = id

            /** Document vector. Use `null` to indicate deletion. */
            @JsonProperty("vector") @ExcludeMissing fun _vector(): JsonField<List<Double>> = vector

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Upsert = apply {
                if (validated) {
                    return@apply
                }

                id().validate()
                vector()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Upsert]. */
            class Builder internal constructor() {

                private var id: JsonField<Id>? = null
                private var attributes: JsonValue = JsonMissing.of()
                private var vector: JsonField<MutableList<Double>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(upsert: Upsert) = apply {
                    id = upsert.id
                    attributes = upsert.attributes
                    vector = upsert.vector.map { it.toMutableList() }
                    additionalProperties = upsert.additionalProperties.toMutableMap()
                }

                /** Document ID. */
                fun id(id: Id) = id(JsonField.of(id))

                /** Document ID. */
                fun id(id: JsonField<Id>) = apply { this.id = id }

                /** Document ID. */
                fun id(integer: Long) = id(Id.ofInteger(integer))

                /** Document ID. */
                fun id(string: String) = id(Id.ofString(string))

                /** Object mapping attribute names to values. */
                fun attributes(attributes: JsonValue) = apply { this.attributes = attributes }

                /** Document vector. Use `null` to indicate deletion. */
                fun vector(vector: List<Double>?) = vector(JsonField.ofNullable(vector))

                /** Document vector. Use `null` to indicate deletion. */
                fun vector(vector: Optional<List<Double>>) = vector(vector.orElse(null))

                /** Document vector. Use `null` to indicate deletion. */
                fun vector(vector: JsonField<List<Double>>) = apply {
                    this.vector = vector.map { it.toMutableList() }
                }

                /** Document vector. Use `null` to indicate deletion. */
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

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                fun build(): Upsert =
                    Upsert(
                        checkRequired("id", id),
                        attributes,
                        (vector ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toImmutable(),
                    )
            }

            /** Document ID. */
            @JsonDeserialize(using = Id.Deserializer::class)
            @JsonSerialize(using = Id.Serializer::class)
            class Id
            private constructor(
                private val integer: Long? = null,
                private val string: String? = null,
                private val _json: JsonValue? = null,
            ) {

                fun integer(): Optional<Long> = Optional.ofNullable(integer)

                fun string(): Optional<String> = Optional.ofNullable(string)

                fun isInteger(): Boolean = integer != null

                fun isString(): Boolean = string != null

                fun asInteger(): Long = integer.getOrThrow("integer")

                fun asString(): String = string.getOrThrow("string")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T {
                    return when {
                        integer != null -> visitor.visitInteger(integer)
                        string != null -> visitor.visitString(string)
                        else -> visitor.unknown(_json)
                    }
                }

                private var validated: Boolean = false

                fun validate(): Id = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitInteger(integer: Long) {}

                            override fun visitString(string: String) {}
                        }
                    )
                    validated = true
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Id && integer == other.integer && string == other.string /* spotless:on */
                }

                override fun hashCode(): Int = /* spotless:off */ Objects.hash(integer, string) /* spotless:on */

                override fun toString(): String =
                    when {
                        integer != null -> "Id{integer=$integer}"
                        string != null -> "Id{string=$string}"
                        _json != null -> "Id{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Id")
                    }

                companion object {

                    @JvmStatic fun ofInteger(integer: Long) = Id(integer = integer)

                    @JvmStatic fun ofString(string: String) = Id(string = string)
                }

                /**
                 * An interface that defines how to map each variant of [Id] to a value of type [T].
                 */
                interface Visitor<out T> {

                    fun visitInteger(integer: Long): T

                    fun visitString(string: String): T

                    /**
                     * Maps an unknown variant of [Id] to a value of type [T].
                     *
                     * An instance of [Id] can contain an unknown variant if it was deserialized
                     * from data that doesn't match any known variant. For example, if the SDK is on
                     * an older version than the API, then the API may respond with new variants
                     * that the SDK is unaware of.
                     *
                     * @throws TurbopufferInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw TurbopufferInvalidDataException("Unknown Id: $json")
                    }
                }

                internal class Deserializer : BaseDeserializer<Id>(Id::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Id {
                        val json = JsonValue.fromJsonNode(node)

                        tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                            return Id(integer = it, _json = json)
                        }
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            return Id(string = it, _json = json)
                        }

                        return Id(_json = json)
                    }
                }

                internal class Serializer : BaseSerializer<Id>(Id::class) {

                    override fun serialize(
                        value: Id,
                        generator: JsonGenerator,
                        provider: SerializerProvider
                    ) {
                        when {
                            value.integer != null -> generator.writeObject(value.integer)
                            value.string != null -> generator.writeObject(value.string)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Id")
                        }
                    }
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Upsert && id == other.id && attributes == other.attributes && vector == other.vector && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(id, attributes, vector, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Upsert{id=$id, attributes=$attributes, vector=$vector, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Upserts && upserts == other.upserts && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(upserts, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Upserts{upserts=$upserts, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is NamespaceUpsertParams && namespace == other.namespace && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(namespace, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "NamespaceUpsertParams{namespace=$namespace, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
