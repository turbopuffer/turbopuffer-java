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
import com.turbopuffer.core.ExcludeMissing
import com.turbopuffer.core.JsonField
import com.turbopuffer.core.JsonMissing
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.allMaxBy
import com.turbopuffer.core.checkRequired
import com.turbopuffer.core.getOrThrow
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A single document, in a row-based format. */
class DocumentRow
private constructor(
    private val id: JsonField<Id>,
    private val vector: JsonField<Vector>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<Id> = JsonMissing.of(),
        @JsonProperty("vector") @ExcludeMissing vector: JsonField<Vector> = JsonMissing.of(),
    ) : this(id, vector, mutableMapOf())

    /**
     * An identifier for a document.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): Id = id.getRequired("id")

    /**
     * A vector embedding associated with a document.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun vector(): Optional<Vector> = vector.getOptional("vector")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Id> = id

    /**
     * Returns the raw JSON value of [vector].
     *
     * Unlike [vector], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("vector") @ExcludeMissing fun _vector(): JsonField<Vector> = vector

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
         * Returns a mutable builder for constructing an instance of [DocumentRow].
         *
         * The following fields are required:
         * ```java
         * .id()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DocumentRow]. */
    class Builder internal constructor() {

        private var id: JsonField<Id>? = null
        private var vector: JsonField<Vector> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(documentRow: DocumentRow) = apply {
            id = documentRow.id
            vector = documentRow.vector
            additionalProperties = documentRow.additionalProperties.toMutableMap()
        }

        /** An identifier for a document. */
        fun id(id: Id) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [Id] value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<Id>) = apply { this.id = id }

        /** Alias for calling [id] with `Id.ofString(string)`. */
        fun id(string: String) = id(Id.ofString(string))

        /** Alias for calling [id] with `Id.ofInteger(integer)`. */
        fun id(integer: Long) = id(Id.ofInteger(integer))

        /** A vector embedding associated with a document. */
        fun vector(vector: Vector) = vector(JsonField.of(vector))

        /**
         * Sets [Builder.vector] to an arbitrary JSON value.
         *
         * You should usually call [Builder.vector] with a well-typed [Vector] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun vector(vector: JsonField<Vector>) = apply { this.vector = vector }

        /** Alias for calling [vector] with `Vector.ofNumber(number)`. */
        fun vectorOfNumber(number: List<Double>) = vector(Vector.ofNumber(number))

        /** Alias for calling [vector] with `Vector.ofString(string)`. */
        fun vector(string: String) = vector(Vector.ofString(string))

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
         * Returns an immutable instance of [DocumentRow].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DocumentRow =
            DocumentRow(checkRequired("id", id), vector, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): DocumentRow = apply {
        if (validated) {
            return@apply
        }

        id().validate()
        vector().ifPresent { it.validate() }
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (id.asKnown().getOrNull()?.validity() ?: 0) +
            (vector.asKnown().getOrNull()?.validity() ?: 0)

    /** A vector embedding associated with a document. */
    @JsonDeserialize(using = Vector.Deserializer::class)
    @JsonSerialize(using = Vector.Serializer::class)
    class Vector
    private constructor(
        private val number: List<Double>? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A dense vector encoded as an array of floats. */
        fun number(): Optional<List<Double>> = Optional.ofNullable(number)

        /** A dense vector encoded as a base64 string. */
        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isString(): Boolean = string != null

        /** A dense vector encoded as an array of floats. */
        fun asNumber(): List<Double> = number.getOrThrow("number")

        /** A dense vector encoded as a base64 string. */
        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Vector = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: List<Double>) {}

                    override fun visitString(string: String) {}
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
                    override fun visitNumber(number: List<Double>) = number.size

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Vector && number == other.number && string == other.string /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(number, string) /* spotless:on */

        override fun toString(): String =
            when {
                number != null -> "Vector{number=$number}"
                string != null -> "Vector{string=$string}"
                _json != null -> "Vector{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Vector")
            }

        companion object {

            /** A dense vector encoded as an array of floats. */
            @JvmStatic fun ofNumber(number: List<Double>) = Vector(number = number)

            /** A dense vector encoded as a base64 string. */
            @JvmStatic fun ofString(string: String) = Vector(string = string)
        }

        /** An interface that defines how to map each variant of [Vector] to a value of type [T]. */
        interface Visitor<out T> {

            /** A dense vector encoded as an array of floats. */
            fun visitNumber(number: List<Double>): T

            /** A dense vector encoded as a base64 string. */
            fun visitString(string: String): T

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

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<List<Double>>())?.let {
                                Vector(number = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Vector(string = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> Vector(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Vector>(Vector::class) {

            override fun serialize(
                value: Vector,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
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

        return /* spotless:off */ other is DocumentRow && id == other.id && vector == other.vector && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, vector, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DocumentRow{id=$id, vector=$vector, additionalProperties=$additionalProperties}"
}
