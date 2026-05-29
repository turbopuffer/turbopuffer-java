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

/**
 * Whether to automatically embed this string attribute into a vector attribute. Can be a model
 * name, a detailed configuration object, or `null` to remove an existing embedding configuration.
 */
@JsonDeserialize(using = AttributeEmbed.Deserializer::class)
@JsonSerialize(using = AttributeEmbed.Serializer::class)
class AttributeEmbed
private constructor(
    private val string: String? = null,
    private val config: AttributeEmbedConfig? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * The model to use for embedding. If you only specify a model, turbopuffer will generate a
     * vector attribute for you to store the embedding.
     */
    fun string(): Optional<String> = Optional.ofNullable(string)

    /** Configuration options for automatic embedding. */
    fun config(): Optional<AttributeEmbedConfig> = Optional.ofNullable(config)

    fun isString(): Boolean = string != null

    fun isConfig(): Boolean = config != null

    /**
     * The model to use for embedding. If you only specify a model, turbopuffer will generate a
     * vector attribute for you to store the embedding.
     */
    fun asString(): String = string.getOrThrow("string")

    /** Configuration options for automatic embedding. */
    fun asConfig(): AttributeEmbedConfig = config.getOrThrow("config")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.turbopuffer.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = attributeEmbed.accept(new AttributeEmbed.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitString(String string) {
     *         return Optional.of(string.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws TurbopufferInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
     *   and the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            string != null -> visitor.visitString(string)
            config != null -> visitor.visitConfig(config)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws TurbopufferInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): AttributeEmbed = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitString(string: String) {}

                override fun visitConfig(config: AttributeEmbedConfig) {
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
                override fun visitString(string: String) = 1

                override fun visitConfig(config: AttributeEmbedConfig) = config.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AttributeEmbed && string == other.string && config == other.config
    }

    override fun hashCode(): Int = Objects.hash(string, config)

    override fun toString(): String =
        when {
            string != null -> "AttributeEmbed{string=$string}"
            config != null -> "AttributeEmbed{config=$config}"
            _json != null -> "AttributeEmbed{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AttributeEmbed")
        }

    companion object {

        /**
         * The model to use for embedding. If you only specify a model, turbopuffer will generate a
         * vector attribute for you to store the embedding.
         */
        @JvmStatic fun ofString(string: String) = AttributeEmbed(string = string)

        /** Configuration options for automatic embedding. */
        @JvmStatic fun ofConfig(config: AttributeEmbedConfig) = AttributeEmbed(config = config)
    }

    /**
     * An interface that defines how to map each variant of [AttributeEmbed] to a value of type [T].
     */
    interface Visitor<out T> {

        /**
         * The model to use for embedding. If you only specify a model, turbopuffer will generate a
         * vector attribute for you to store the embedding.
         */
        fun visitString(string: String): T

        /** Configuration options for automatic embedding. */
        fun visitConfig(config: AttributeEmbedConfig): T

        /**
         * Maps an unknown variant of [AttributeEmbed] to a value of type [T].
         *
         * An instance of [AttributeEmbed] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws TurbopufferInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw TurbopufferInvalidDataException("Unknown AttributeEmbed: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<AttributeEmbed>(AttributeEmbed::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AttributeEmbed {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<AttributeEmbedConfig>())?.let {
                            AttributeEmbed(config = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            AttributeEmbed(string = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> AttributeEmbed(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<AttributeEmbed>(AttributeEmbed::class) {

        override fun serialize(
            value: AttributeEmbed,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.string != null -> generator.writeObject(value.string)
                value.config != null -> generator.writeObject(value.config)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AttributeEmbed")
            }
        }
    }
}
