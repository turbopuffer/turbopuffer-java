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
 * Whether this attribute can be used as part of a BM25 full-text search. Requires the `string` or
 * `[]string` type, and by default, BM25-enabled attributes are not filterable. You can override
 * this by setting `filterable: true`.
 */
@JsonDeserialize(using = FullTextSearch.Deserializer::class)
@JsonSerialize(using = FullTextSearch.Serializer::class)
class FullTextSearch
private constructor(
    private val bool: Boolean? = null,
    private val config: FullTextSearchConfig? = null,
    private val _json: JsonValue? = null,
) {

    fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

    /** Configuration options for full-text search. */
    fun config(): Optional<FullTextSearchConfig> = Optional.ofNullable(config)

    fun isBool(): Boolean = bool != null

    fun isConfig(): Boolean = config != null

    fun asBool(): Boolean = bool.getOrThrow("bool")

    /** Configuration options for full-text search. */
    fun asConfig(): FullTextSearchConfig = config.getOrThrow("config")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            bool != null -> visitor.visitBool(bool)
            config != null -> visitor.visitConfig(config)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): FullTextSearch = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitBool(bool: Boolean) {}

                override fun visitConfig(config: FullTextSearchConfig) {
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
                override fun visitBool(bool: Boolean) = 1

                override fun visitConfig(config: FullTextSearchConfig) = config.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FullTextSearch && bool == other.bool && config == other.config
    }

    override fun hashCode(): Int = Objects.hash(bool, config)

    override fun toString(): String =
        when {
            bool != null -> "FullTextSearch{bool=$bool}"
            config != null -> "FullTextSearch{config=$config}"
            _json != null -> "FullTextSearch{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid FullTextSearch")
        }

    companion object {

        @JvmStatic fun ofBool(bool: Boolean) = FullTextSearch(bool = bool)

        /** Configuration options for full-text search. */
        @JvmStatic fun ofConfig(config: FullTextSearchConfig) = FullTextSearch(config = config)
    }

    /**
     * An interface that defines how to map each variant of [FullTextSearch] to a value of type [T].
     */
    interface Visitor<out T> {

        fun visitBool(bool: Boolean): T

        /** Configuration options for full-text search. */
        fun visitConfig(config: FullTextSearchConfig): T

        /**
         * Maps an unknown variant of [FullTextSearch] to a value of type [T].
         *
         * An instance of [FullTextSearch] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws TurbopufferInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw TurbopufferInvalidDataException("Unknown FullTextSearch: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<FullTextSearch>(FullTextSearch::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): FullTextSearch {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<FullTextSearchConfig>())?.let {
                            FullTextSearch(config = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                            FullTextSearch(bool = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from string).
                0 -> FullTextSearch(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<FullTextSearch>(FullTextSearch::class) {

        override fun serialize(
            value: FullTextSearch,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.bool != null -> generator.writeObject(value.bool)
                value.config != null -> generator.writeObject(value.config)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid FullTextSearch")
            }
        }
    }
}
