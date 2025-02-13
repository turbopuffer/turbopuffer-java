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

@NoAutoDetect
class NamespaceQueryResponse
@JsonCreator
private constructor(
    @JsonProperty("vectors")
    @ExcludeMissing
    private val vectors: JsonField<List<Vector>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** Array of search result objects. */
    fun vectors(): Optional<List<Vector>> = Optional.ofNullable(vectors.getNullable("vectors"))

    /** Array of search result objects. */
    @JsonProperty("vectors") @ExcludeMissing fun _vectors(): JsonField<List<Vector>> = vectors

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): NamespaceQueryResponse = apply {
        if (validated) {
            return@apply
        }

        vectors().ifPresent { it.forEach { it.validate() } }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceQueryResponse]. */
    class Builder internal constructor() {

        private var vectors: JsonField<MutableList<Vector>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(namespaceQueryResponse: NamespaceQueryResponse) = apply {
            vectors = namespaceQueryResponse.vectors.map { it.toMutableList() }
            additionalProperties = namespaceQueryResponse.additionalProperties.toMutableMap()
        }

        /** Array of search result objects. */
        fun vectors(vectors: List<Vector>) = vectors(JsonField.of(vectors))

        /** Array of search result objects. */
        fun vectors(vectors: JsonField<List<Vector>>) = apply {
            this.vectors = vectors.map { it.toMutableList() }
        }

        /** Array of search result objects. */
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

        fun build(): NamespaceQueryResponse =
            NamespaceQueryResponse(
                (vectors ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toImmutable()
            )
    }

    @NoAutoDetect
    class Vector
    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing private val id: JsonField<Id> = JsonMissing.of(),
        @JsonProperty("attributes")
        @ExcludeMissing
        private val attributes: JsonValue = JsonMissing.of(),
        @JsonProperty("dist")
        @ExcludeMissing
        private val dist: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("vector")
        @ExcludeMissing
        private val vector: JsonField<List<Double>> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun id(): Optional<Id> = Optional.ofNullable(id.getNullable("id"))

        @JsonProperty("attributes") @ExcludeMissing fun _attributes(): JsonValue = attributes

        /** The distance (or relevance) score. */
        fun dist(): Optional<Double> = Optional.ofNullable(dist.getNullable("dist"))

        fun vector(): Optional<List<Double>> = Optional.ofNullable(vector.getNullable("vector"))

        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Id> = id

        /** The distance (or relevance) score. */
        @JsonProperty("dist") @ExcludeMissing fun _dist(): JsonField<Double> = dist

        @JsonProperty("vector") @ExcludeMissing fun _vector(): JsonField<List<Double>> = vector

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Vector = apply {
            if (validated) {
                return@apply
            }

            id().ifPresent { it.validate() }
            dist()
            vector()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Vector]. */
        class Builder internal constructor() {

            private var id: JsonField<Id> = JsonMissing.of()
            private var attributes: JsonValue = JsonMissing.of()
            private var dist: JsonField<Double> = JsonMissing.of()
            private var vector: JsonField<MutableList<Double>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(vector: Vector) = apply {
                id = vector.id
                attributes = vector.attributes
                dist = vector.dist
                this.vector = vector.vector.map { it.toMutableList() }
                additionalProperties = vector.additionalProperties.toMutableMap()
            }

            fun id(id: Id) = id(JsonField.of(id))

            fun id(id: JsonField<Id>) = apply { this.id = id }

            fun id(string: String) = id(Id.ofString(string))

            fun id(integer: Long) = id(Id.ofInteger(integer))

            fun attributes(attributes: JsonValue) = apply { this.attributes = attributes }

            /** The distance (or relevance) score. */
            fun dist(dist: Double) = dist(JsonField.of(dist))

            /** The distance (or relevance) score. */
            fun dist(dist: JsonField<Double>) = apply { this.dist = dist }

            fun vector(vector: List<Double>) = vector(JsonField.of(vector))

            fun vector(vector: JsonField<List<Double>>) = apply {
                this.vector = vector.map { it.toMutableList() }
            }

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

            fun build(): Vector =
                Vector(
                    id,
                    attributes,
                    dist,
                    (vector ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toImmutable(),
                )
        }

        @JsonDeserialize(using = Id.Deserializer::class)
        @JsonSerialize(using = Id.Serializer::class)
        class Id
        private constructor(
            private val string: String? = null,
            private val integer: Long? = null,
            private val _json: JsonValue? = null,
        ) {

            fun string(): Optional<String> = Optional.ofNullable(string)

            fun integer(): Optional<Long> = Optional.ofNullable(integer)

            fun isString(): Boolean = string != null

            fun isInteger(): Boolean = integer != null

            fun asString(): String = string.getOrThrow("string")

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

                @JvmStatic fun ofString(string: String) = Id(string = string)

                @JvmStatic fun ofInteger(integer: Long) = Id(integer = integer)
            }

            /** An interface that defines how to map each variant of [Id] to a value of type [T]. */
            interface Visitor<out T> {

                fun visitString(string: String): T

                fun visitInteger(integer: Long): T

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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Vector && id == other.id && attributes == other.attributes && dist == other.dist && vector == other.vector && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, attributes, dist, vector, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Vector{id=$id, attributes=$attributes, dist=$dist, vector=$vector, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is NamespaceQueryResponse && vectors == other.vectors && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(vectors, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "NamespaceQueryResponse{vectors=$vectors, additionalProperties=$additionalProperties}"
}
