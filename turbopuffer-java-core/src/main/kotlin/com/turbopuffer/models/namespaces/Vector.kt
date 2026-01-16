// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.BaseDeserializer
import com.turbopuffer.core.BaseSerializer
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.allMaxBy
import com.turbopuffer.core.getOrThrow
import com.turbopuffer.core.toImmutable
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Objects
import java.util.Optional

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
     * Returns a score indicating how many valid values are contained in this object recursively.
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

        return other is Vector && number == other.number && string == other.string
    }

    override fun hashCode(): Int = Objects.hash(number, string)

    override fun toString(): String =
        when {
            number != null -> "Vector{number=$number}"
            string != null -> "Vector{string=$string}"
            _json != null -> "Vector{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid Vector")
        }

    companion object {

        /** A dense vector encoded as an array of floats. */
        @JvmStatic fun ofNumber(number: List<Double>) = Vector(number = number.toImmutable())

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
         * An instance of [Vector] can contain an unknown variant if it was deserialized from data
         * that doesn't match any known variant. For example, if the SDK is on an older version than
         * the API, then the API may respond with new variants that the SDK is unaware of.
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
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> Vector(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
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
