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

/** The schema for an attribute attached to a document. */
@JsonDeserialize(using = AttributeSchema.Deserializer::class)
@JsonSerialize(using = AttributeSchema.Serializer::class)
class AttributeSchema
private constructor(
    private val type: String? = null,
    private val config: AttributeSchemaConfig? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * The data type of the attribute. Valid values: string, int, uint, float, uuid, datetime, bool,
     * []string, []int, []uint, []float, []uuid, []datetime, []bool, [DIMS]f16, [DIMS]f32.
     */
    fun type(): Optional<String> = Optional.ofNullable(type)

    /** Detailed configuration for an attribute attached to a document. */
    fun config(): Optional<AttributeSchemaConfig> = Optional.ofNullable(config)

    fun isType(): Boolean = type != null

    fun isConfig(): Boolean = config != null

    /**
     * The data type of the attribute. Valid values: string, int, uint, float, uuid, datetime, bool,
     * []string, []int, []uint, []float, []uuid, []datetime, []bool, [DIMS]f16, [DIMS]f32.
     */
    fun asType(): String = type.getOrThrow("type")

    /** Detailed configuration for an attribute attached to a document. */
    fun asConfig(): AttributeSchemaConfig = config.getOrThrow("config")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            type != null -> visitor.visitType(type)
            config != null -> visitor.visitConfig(config)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): AttributeSchema = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitType(type: String) {}

                override fun visitConfig(config: AttributeSchemaConfig) {
                    config.validate()
                }
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
                override fun visitType(type: String) = 1

                override fun visitConfig(config: AttributeSchemaConfig) = config.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AttributeSchema && type == other.type && config == other.config
    }

    override fun hashCode(): Int = Objects.hash(type, config)

    override fun toString(): String =
        when {
            type != null -> "AttributeSchema{type=$type}"
            config != null -> "AttributeSchema{config=$config}"
            _json != null -> "AttributeSchema{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AttributeSchema")
        }

    companion object {

        /**
         * The data type of the attribute. Valid values: string, int, uint, float, uuid, datetime,
         * bool, []string, []int, []uint, []float, []uuid, []datetime, []bool, [DIMS]f16, [DIMS]f32.
         */
        @JvmStatic fun ofType(type: String) = AttributeSchema(type = type)

        /** Detailed configuration for an attribute attached to a document. */
        @JvmStatic fun ofConfig(config: AttributeSchemaConfig) = AttributeSchema(config = config)
    }

    /**
     * An interface that defines how to map each variant of [AttributeSchema] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /**
         * The data type of the attribute. Valid values: string, int, uint, float, uuid, datetime,
         * bool, []string, []int, []uint, []float, []uuid, []datetime, []bool, [DIMS]f16, [DIMS]f32.
         */
        fun visitType(type: String): T

        /** Detailed configuration for an attribute attached to a document. */
        fun visitConfig(config: AttributeSchemaConfig): T

        /**
         * Maps an unknown variant of [AttributeSchema] to a value of type [T].
         *
         * An instance of [AttributeSchema] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws TurbopufferInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw TurbopufferInvalidDataException("Unknown AttributeSchema: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<AttributeSchema>(AttributeSchema::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AttributeSchema {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<AttributeSchemaConfig>())?.let {
                            AttributeSchema(config = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            AttributeSchema(type = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from array).
                0 -> AttributeSchema(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<AttributeSchema>(AttributeSchema::class) {

        override fun serialize(
            value: AttributeSchema,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.type != null -> generator.writeObject(value.type)
                value.config != null -> generator.writeObject(value.config)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AttributeSchema")
            }
        }
    }
}
