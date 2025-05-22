// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models

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
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Objects
import java.util.Optional

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

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            string != null -> visitor.visitString(string)
            integer != null -> visitor.visitInteger(integer)
            else -> visitor.unknown(_json)
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
                override fun visitString(string: String) = 1

                override fun visitInteger(integer: Long) = 1

                override fun unknown(json: JsonValue?) = 0
            }
        )

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
         * An instance of [Id] can contain an unknown variant if it was deserialized from data that
         * doesn't match any known variant. For example, if the SDK is on an older version than the
         * API, then the API may respond with new variants that the SDK is unaware of.
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

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            Id(string = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                            Id(integer = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from object).
                0 -> Id(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<Id>(Id::class) {

        override fun serialize(value: Id, generator: JsonGenerator, provider: SerializerProvider) {
            when {
                value.string != null -> generator.writeObject(value.string)
                value.integer != null -> generator.writeObject(value.integer)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid Id")
            }
        }
    }
}
