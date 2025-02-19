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

/** A single document, in a row-based format. */
@NoAutoDetect
class DocumentRow
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<Id> = JsonMissing.of(),
    @JsonProperty("attributes")
    @ExcludeMissing
    private val attributes: JsonField<Attributes> = JsonMissing.of(),
    @JsonProperty("vector")
    @ExcludeMissing
    private val vector: JsonField<List<Double>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** An identifier for a document. */
    fun id(): Optional<Id> = Optional.ofNullable(id.getNullable("id"))

    /** The attributes attached to the document. */
    fun attributes(): Optional<Attributes> =
        Optional.ofNullable(attributes.getNullable("attributes"))

    /** A vector describing the document. */
    fun vector(): Optional<List<Double>> = Optional.ofNullable(vector.getNullable("vector"))

    /** An identifier for a document. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Id> = id

    /** The attributes attached to the document. */
    @JsonProperty("attributes")
    @ExcludeMissing
    fun _attributes(): JsonField<Attributes> = attributes

    /** A vector describing the document. */
    @JsonProperty("vector") @ExcludeMissing fun _vector(): JsonField<List<Double>> = vector

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): DocumentRow = apply {
        if (validated) {
            return@apply
        }

        id().ifPresent { it.validate() }
        attributes().ifPresent { it.validate() }
        vector()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DocumentRow]. */
    class Builder internal constructor() {

        private var id: JsonField<Id> = JsonMissing.of()
        private var attributes: JsonField<Attributes> = JsonMissing.of()
        private var vector: JsonField<MutableList<Double>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(documentRow: DocumentRow) = apply {
            id = documentRow.id
            attributes = documentRow.attributes
            vector = documentRow.vector.map { it.toMutableList() }
            additionalProperties = documentRow.additionalProperties.toMutableMap()
        }

        /** An identifier for a document. */
        fun id(id: Id) = id(JsonField.of(id))

        /** An identifier for a document. */
        fun id(id: JsonField<Id>) = apply { this.id = id }

        /** A UUID. */
        fun id(string: String) = id(Id.ofString(string))

        /** An integer ID. */
        fun id(integer: Long) = id(Id.ofInteger(integer))

        /** The attributes attached to the document. */
        fun attributes(attributes: Attributes) = attributes(JsonField.of(attributes))

        /** The attributes attached to the document. */
        fun attributes(attributes: JsonField<Attributes>) = apply { this.attributes = attributes }

        /** A vector describing the document. */
        fun vector(vector: List<Double>?) = vector(JsonField.ofNullable(vector))

        /** A vector describing the document. */
        fun vector(vector: Optional<List<Double>>) = vector(vector.orElse(null))

        /** A vector describing the document. */
        fun vector(vector: JsonField<List<Double>>) = apply {
            this.vector = vector.map { it.toMutableList() }
        }

        /** A vector describing the document. */
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

        fun build(): DocumentRow =
            DocumentRow(
                id,
                attributes,
                (vector ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toImmutable(),
            )
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
                provider: SerializerProvider,
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

    /** The attributes attached to the document. */
    @NoAutoDetect
    class Attributes
    @JsonCreator
    private constructor(
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is DocumentRow && id == other.id && attributes == other.attributes && vector == other.vector && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, attributes, vector, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DocumentRow{id=$id, attributes=$attributes, vector=$vector, additionalProperties=$additionalProperties}"
}
