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
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Objects
import java.util.Optional

/** Whether to include attributes in the response. */
@JsonDeserialize(using = IncludeAttributes.Deserializer::class)
@JsonSerialize(using = IncludeAttributes.Serializer::class)
class IncludeAttributes
private constructor(
    private val bool: Boolean? = null,
    private val strings: List<String>? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * When `true`, include all attributes in the response. When `false`, include no attributes in
     * the response.
     */
    fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

    /** Include exactly the specified attributes in the response. */
    fun strings(): Optional<List<String>> = Optional.ofNullable(strings)

    fun isBool(): Boolean = bool != null

    fun isStrings(): Boolean = strings != null

    /**
     * When `true`, include all attributes in the response. When `false`, include no attributes in
     * the response.
     */
    fun asBool(): Boolean = bool.getOrThrow("bool")

    /** Include exactly the specified attributes in the response. */
    fun asStrings(): List<String> = strings.getOrThrow("strings")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            bool != null -> visitor.visitBool(bool)
            strings != null -> visitor.visitStrings(strings)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): IncludeAttributes = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitBool(bool: Boolean) {}

                override fun visitStrings(strings: List<String>) {}
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
                override fun visitBool(bool: Boolean) = 1

                override fun visitStrings(strings: List<String>) = strings.size

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is IncludeAttributes && bool == other.bool && strings == other.strings /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(bool, strings) /* spotless:on */

    override fun toString(): String =
        when {
            bool != null -> "IncludeAttributes{bool=$bool}"
            strings != null -> "IncludeAttributes{strings=$strings}"
            _json != null -> "IncludeAttributes{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid IncludeAttributes")
        }

    companion object {

        /**
         * When `true`, include all attributes in the response. When `false`, include no attributes
         * in the response.
         */
        @JvmStatic fun ofBool(bool: Boolean) = IncludeAttributes(bool = bool)

        /** Include exactly the specified attributes in the response. */
        @JvmStatic fun ofStrings(strings: List<String>) = IncludeAttributes(strings = strings)

        /** Include exactly the specified attributes in the response. */
        @JvmStatic
        fun select(vararg strings: String) = IncludeAttributes(strings = strings.toList())
    }

    /**
     * An interface that defines how to map each variant of [IncludeAttributes] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /**
         * When `true`, include all attributes in the response. When `false`, include no attributes
         * in the response.
         */
        fun visitBool(bool: Boolean): T

        /** Include exactly the specified attributes in the response. */
        fun visitStrings(strings: List<String>): T

        /**
         * Maps an unknown variant of [IncludeAttributes] to a value of type [T].
         *
         * An instance of [IncludeAttributes] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws TurbopufferInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw TurbopufferInvalidDataException("Unknown IncludeAttributes: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<IncludeAttributes>(IncludeAttributes::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): IncludeAttributes {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                            IncludeAttributes(bool = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                            IncludeAttributes(strings = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from string).
                0 -> IncludeAttributes(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<IncludeAttributes>(IncludeAttributes::class) {

        override fun serialize(
            value: IncludeAttributes,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.bool != null -> generator.writeObject(value.bool)
                value.strings != null -> generator.writeObject(value.strings)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid IncludeAttributes")
            }
        }
    }
}
