// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models

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
import com.turbopuffer.core.ExcludeMissing
import com.turbopuffer.core.JsonField
import com.turbopuffer.core.JsonMissing
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.NoAutoDetect
import com.turbopuffer.core.getOrThrow
import com.turbopuffer.core.immutableEmptyMap
import com.turbopuffer.core.toImmutable
import com.turbopuffer.errors.TurbopufferInvalidDataException
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
    private val vectors: JsonField<List<List<Double>?>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The attributes attached to each of the documents. */
    fun attributes(): Optional<Attributes> =
        Optional.ofNullable(attributes.getNullable("attributes"))

    /** The IDs of the documents. */
    fun ids(): Optional<List<Id>> = Optional.ofNullable(ids.getNullable("ids"))

    /** Vectors describing each of the documents. */
    fun vectors(): Optional<List<List<Double>?>> =
        Optional.ofNullable(vectors.getNullable("vectors"))

    /** The attributes attached to each of the documents. */
    @JsonProperty("attributes")
    @ExcludeMissing
    fun _attributes(): JsonField<Attributes> = attributes

    /** The IDs of the documents. */
    @JsonProperty("ids") @ExcludeMissing fun _ids(): JsonField<List<Id>> = ids

    /** Vectors describing each of the documents. */
    @JsonProperty("vectors")
    @ExcludeMissing
    fun _vectors(): JsonField<List<List<Double>?>> = vectors

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
        vectors()
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
        private var vectors: JsonField<MutableList<List<Double>?>>? = null
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
        fun vectors(vectors: List<List<Double>?>) = vectors(JsonField.of(vectors))

        /** Vectors describing each of the documents. */
        fun vectors(vectors: JsonField<List<List<Double>?>>) = apply {
            this.vectors = vectors.map { it.toMutableList() }
        }

        /** Vectors describing each of the documents. */
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
