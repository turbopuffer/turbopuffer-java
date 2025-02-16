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
import com.turbopuffer.api.core.ExcludeMissing
import com.turbopuffer.api.core.JsonField
import com.turbopuffer.api.core.JsonMissing
import com.turbopuffer.api.core.JsonValue
import com.turbopuffer.api.core.NoAutoDetect
import com.turbopuffer.api.core.getOrThrow
import com.turbopuffer.api.core.immutableEmptyMap
import com.turbopuffer.api.core.toImmutable
import com.turbopuffer.api.errors.TurbopufferInvalidDataException
import java.util.Objects
import java.util.Optional

/** A list of documents in columnar format. */
@NoAutoDetect
class DocumentColumns
@JsonCreator
private constructor(
    @JsonProperty("attributes")
    @ExcludeMissing
    private val attributes: JsonField<Attributes> = JsonMissing.of(),
    @JsonProperty("ids") @ExcludeMissing private val ids: JsonField<List<Id>> = JsonMissing.of(),
    @JsonProperty("vectors")
    @ExcludeMissing
    private val vectors: JsonField<List<Vector?>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The attributes attached to each of the documents. */
    fun attributes(): Optional<Attributes> =
        Optional.ofNullable(attributes.getNullable("attributes"))

    /** The IDs of the documents. */
    fun ids(): Optional<List<Id>> = Optional.ofNullable(ids.getNullable("ids"))

    /** Vectors describing each of the documents. */
    fun vectors(): Optional<List<Vector?>> = Optional.ofNullable(vectors.getNullable("vectors"))

    /** The attributes attached to each of the documents. */
    @JsonProperty("attributes")
    @ExcludeMissing
    fun _attributes(): JsonField<Attributes> = attributes

    /** The IDs of the documents. */
    @JsonProperty("ids") @ExcludeMissing fun _ids(): JsonField<List<Id>> = ids

    /** Vectors describing each of the documents. */
    @JsonProperty("vectors") @ExcludeMissing fun _vectors(): JsonField<List<Vector?>> = vectors

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): DocumentColumns = apply {
        if (validated) {
            return@apply
        }

        attributes().ifPresent { it.validate() }
        ids().ifPresent { it.forEach { it.validate() } }
        vectors().ifPresent { it.forEach { it?.validate() } }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DocumentColumns]. */
    class Builder internal constructor() {

        private var attributes: JsonField<Attributes> = JsonMissing.of()
        private var ids: JsonField<MutableList<Id>>? = null
        private var vectors: JsonField<MutableList<Vector?>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(documentColumns: DocumentColumns) = apply {
            attributes = documentColumns.attributes
            ids = documentColumns.ids.map { it.toMutableList() }
            vectors = documentColumns.vectors.map { it.toMutableList() }
            additionalProperties = documentColumns.additionalProperties.toMutableMap()
        }

        /** The attributes attached to each of the documents. */
        fun attributes(attributes: Attributes) = attributes(JsonField.of(attributes))

        /** The attributes attached to each of the documents. */
        fun attributes(attributes: JsonField<Attributes>) = apply { this.attributes = attributes }

        /** The IDs of the documents. */
        fun ids(ids: List<Id>) = ids(JsonField.of(ids))

        /** The IDs of the documents. */
        fun ids(ids: JsonField<List<Id>>) = apply { this.ids = ids.map { it.toMutableList() } }

        /** The IDs of the documents. */
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

        /** A UUID. */
        fun addId(string: String) = addId(Id.ofString(string))

        /** An integer ID. */
        fun addId(integer: Long) = addId(Id.ofInteger(integer))

        /** Vectors describing each of the documents. */
        fun vectors(vectors: List<Vector?>) = vectors(JsonField.of(vectors))

        /** Vectors describing each of the documents. */
        fun vectors(vectors: JsonField<List<Vector?>>) = apply {
            this.vectors = vectors.map { it.toMutableList() }
        }

        /** Vectors describing each of the documents. */
        fun addVector(vector: Vector) = apply {
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

        /** Vectors describing each of the documents. */
        fun addVector(number: Double) = addVector(Vector.ofNumber(number))

        /** Vectors describing each of the documents. */
        fun addVectorOfNumber(number: List<Double>) = addVector(Vector.ofNumber(number))

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

        fun build(): DocumentColumns =
            DocumentColumns(
                attributes,
                (ids ?: JsonMissing.of()).map { it.toImmutable() },
                (vectors ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toImmutable(),
            )
    }

    /** The attributes attached to each of the documents. */
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

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

    /** An identifier for a document. */
    @JsonDeserialize(using = Id.Deserializer::class)
    @JsonSerialize(using = Id.Serializer::class)
    class Id
    private constructor(
        private val string: String? = null,
        private val integer: Long? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A UUID. */
        fun string(): Optional<String> = Optional.ofNullable(string)

        /** An integer ID. */
        fun integer(): Optional<Long> = Optional.ofNullable(integer)

        fun isString(): Boolean = string != null

        fun isInteger(): Boolean = integer != null

        /** A UUID. */
        fun asString(): String = string.getOrThrow("string")

        /** An integer ID. */
        fun asInteger(): Long = integer.getOrThrow("integer")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                string != null -> visitor.visitString(string)
                integer != null -> visitor.visitInteger(integer)
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
                    override fun visitString(string: String) {}

                    override fun visitInteger(integer: Long) {}
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Id && string == other.string && integer == other.integer /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, integer) /* spotless:on */

        override fun toString(): String =
            when {
                string != null -> "Id{string=$string}"
                integer != null -> "Id{integer=$integer}"
                _json != null -> "Id{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Id")
            }

        companion object {

            /** A UUID. */
            @JvmStatic fun ofString(string: String) = Id(string = string)

            /** An integer ID. */
            @JvmStatic fun ofInteger(integer: Long) = Id(integer = integer)
        }

        /** An interface that defines how to map each variant of [Id] to a value of type [T]. */
        interface Visitor<out T> {

            /** A UUID. */
            fun visitString(string: String): T

            /** An integer ID. */
            fun visitInteger(integer: Long): T

            /**
             * Maps an unknown variant of [Id] to a value of type [T].
             *
             * An instance of [Id] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
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

                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Id(string = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                    return Id(integer = it, _json = json)
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
                    value.string != null -> generator.writeObject(value.string)
                    value.integer != null -> generator.writeObject(value.integer)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Id")
                }
            }
        }
    }

    @JsonDeserialize(using = Vector.Deserializer::class)
    @JsonSerialize(using = Vector.Serializer::class)
    class Vector
    private constructor(
        private val number: Double? = null,
        private val number: List<Double>? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun number(): Optional<List<Double>> = Optional.ofNullable(number)

        fun isNumber(): Boolean = number != null

        fun isNumber(): Boolean = number != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asNumber(): List<Double> = number.getOrThrow("number")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                number != null -> visitor.visitNumber(number)
                number != null -> visitor.visitNumber(number)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Vector = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitNumber(number: List<Double>) {}
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Vector && number == other.number && number == other.number /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(number, number) /* spotless:on */

        override fun toString(): String =
            when {
                number != null -> "Vector{number=$number}"
                number != null -> "Vector{number=$number}"
                _json != null -> "Vector{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Vector")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = Vector(number = number)

            @JvmStatic fun ofNumber(number: List<Double>) = Vector(number = number)
        }

        /** An interface that defines how to map each variant of [Vector] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitNumber(number: List<Double>): T

            /**
             * Maps an unknown variant of [Vector] to a value of type [T].
             *
             * An instance of [Vector] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws TurbopufferInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw TurbopufferInvalidDataException("Unknown Vector: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Vector>(Vector::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Vector {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                    return Vector(number = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<Double>>())?.let {
                    return Vector(number = it, _json = json)
                }

                return Vector(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Vector>(Vector::class) {

            override fun serialize(
                value: Vector,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.number != null -> generator.writeObject(value.number)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Vector")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is DocumentColumns && attributes == other.attributes && ids == other.ids && vectors == other.vectors && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(attributes, ids, vectors, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DocumentColumns{attributes=$attributes, ids=$ids, vectors=$vectors, additionalProperties=$additionalProperties}"
}
