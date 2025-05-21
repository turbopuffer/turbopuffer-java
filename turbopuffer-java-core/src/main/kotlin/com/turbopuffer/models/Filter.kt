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

@JsonDeserialize(using = Filter.Deserializer::class)
@JsonSerialize(using = Filter.Serializer::class)
class Filter
private constructor(
    private val jsonValues: List<JsonValue>? = null,
    private val jsonValues: List<JsonValue>? = null,
    private val jsonValues: List<JsonValue>? = null,
    private val jsonValues: List<JsonValue>? = null,
    private val _json: JsonValue? = null,
) {

    fun jsonValues(): Optional<List<JsonValue>> = Optional.ofNullable(jsonValues)

    fun jsonValues(): Optional<List<JsonValue>> = Optional.ofNullable(jsonValues)

    fun jsonValues(): Optional<List<JsonValue>> = Optional.ofNullable(jsonValues)

    fun jsonValues(): Optional<List<JsonValue>> = Optional.ofNullable(jsonValues)

    fun isJsonValues(): Boolean = jsonValues != null

    fun isJsonValues(): Boolean = jsonValues != null

    fun isJsonValues(): Boolean = jsonValues != null

    fun isJsonValues(): Boolean = jsonValues != null

    fun asJsonValues(): List<JsonValue> = jsonValues.getOrThrow("jsonValues")

    fun asJsonValues(): List<JsonValue> = jsonValues.getOrThrow("jsonValues")

    fun asJsonValues(): List<JsonValue> = jsonValues.getOrThrow("jsonValues")

    fun asJsonValues(): List<JsonValue> = jsonValues.getOrThrow("jsonValues")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            jsonValues != null -> visitor.visitJsonValues(jsonValues)
            jsonValues != null -> visitor.visitJsonValues(jsonValues)
            jsonValues != null -> visitor.visitJsonValues(jsonValues)
            jsonValues != null -> visitor.visitJsonValues(jsonValues)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): Filter = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitJsonValues(jsonValues: List<JsonValue>) {}

                override fun visitJsonValues(jsonValues: List<JsonValue>) {}

                override fun visitJsonValues(jsonValues: List<JsonValue>) {}

                override fun visitJsonValues(jsonValues: List<JsonValue>) {}
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
                override fun visitJsonValues(jsonValues: List<JsonValue>) = jsonValues.size

                override fun visitJsonValues(jsonValues: List<JsonValue>) = jsonValues.size

                override fun visitJsonValues(jsonValues: List<JsonValue>) = jsonValues.size

                override fun visitJsonValues(jsonValues: List<JsonValue>) = jsonValues.size

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Filter && jsonValues == other.jsonValues && jsonValues == other.jsonValues && jsonValues == other.jsonValues && jsonValues == other.jsonValues /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(jsonValues, jsonValues, jsonValues, jsonValues) /* spotless:on */

    override fun toString(): String =
        when {
            jsonValues != null -> "Filter{jsonValues=$jsonValues}"
            jsonValues != null -> "Filter{jsonValues=$jsonValues}"
            jsonValues != null -> "Filter{jsonValues=$jsonValues}"
            jsonValues != null -> "Filter{jsonValues=$jsonValues}"
            _json != null -> "Filter{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid Filter")
        }

    companion object {

        @JvmStatic fun ofJsonValues(jsonValues: List<JsonValue>) = Filter(jsonValues = jsonValues)

        @JvmStatic fun ofJsonValues(jsonValues: List<JsonValue>) = Filter(jsonValues = jsonValues)

        @JvmStatic fun ofJsonValues(jsonValues: List<JsonValue>) = Filter(jsonValues = jsonValues)

        @JvmStatic fun ofJsonValues(jsonValues: List<JsonValue>) = Filter(jsonValues = jsonValues)
    }

    /** An interface that defines how to map each variant of [Filter] to a value of type [T]. */
    interface Visitor<out T> {

        fun visitJsonValues(jsonValues: List<JsonValue>): T

        fun visitJsonValues(jsonValues: List<JsonValue>): T

        fun visitJsonValues(jsonValues: List<JsonValue>): T

        fun visitJsonValues(jsonValues: List<JsonValue>): T

        /**
         * Maps an unknown variant of [Filter] to a value of type [T].
         *
         * An instance of [Filter] can contain an unknown variant if it was deserialized from data
         * that doesn't match any known variant. For example, if the SDK is on an older version than
         * the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws TurbopufferInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw TurbopufferInvalidDataException("Unknown Filter: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<Filter>(Filter::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): Filter {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<List<JsonValue>>())?.let {
                            Filter(jsonValues = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<List<JsonValue>>())?.let {
                            Filter(jsonValues = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<List<JsonValue>>())?.let {
                            Filter(jsonValues = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<List<JsonValue>>())?.let {
                            Filter(jsonValues = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> Filter(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<Filter>(Filter::class) {

        override fun serialize(
            value: Filter,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.jsonValues != null -> generator.writeObject(value.jsonValues)
                value.jsonValues != null -> generator.writeObject(value.jsonValues)
                value.jsonValues != null -> generator.writeObject(value.jsonValues)
                value.jsonValues != null -> generator.writeObject(value.jsonValues)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid Filter")
            }
        }
    }
}
