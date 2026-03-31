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
import com.turbopuffer.core.getOrThrow
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Request to update namespace metadata configuration. */
class NamespaceMetadataPatch
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val pinning: JsonField<Pinning>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("pinning") @ExcludeMissing pinning: JsonField<Pinning> = JsonMissing.of()
    ) : this(pinning, mutableMapOf())

    /**
     * Configuration for namespace pinning.
     * - Missing field: no change to pinning configuration
     * - `null` or `false`: explicitly remove pinning
     * - `true`: enable pinning with default configuration
     * - Object: set pinning configuration
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun pinning(): Optional<Pinning> = pinning.getOptional("pinning")

    /**
     * Returns the raw JSON value of [pinning].
     *
     * Unlike [pinning], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("pinning") @ExcludeMissing fun _pinning(): JsonField<Pinning> = pinning

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

        /** Returns a mutable builder for constructing an instance of [NamespaceMetadataPatch]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceMetadataPatch]. */
    class Builder internal constructor() {

        private var pinning: JsonField<Pinning> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(namespaceMetadataPatch: NamespaceMetadataPatch) = apply {
            pinning = namespaceMetadataPatch.pinning
            additionalProperties = namespaceMetadataPatch.additionalProperties.toMutableMap()
        }

        /**
         * Configuration for namespace pinning.
         * - Missing field: no change to pinning configuration
         * - `null` or `false`: explicitly remove pinning
         * - `true`: enable pinning with default configuration
         * - Object: set pinning configuration
         */
        fun pinning(pinning: Pinning?) = pinning(JsonField.ofNullable(pinning))

        /** Alias for calling [Builder.pinning] with `pinning.orElse(null)`. */
        fun pinning(pinning: Optional<Pinning>) = pinning(pinning.getOrNull())

        /**
         * Sets [Builder.pinning] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pinning] with a well-typed [Pinning] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun pinning(pinning: JsonField<Pinning>) = apply { this.pinning = pinning }

        /** Alias for calling [pinning] with `Pinning.ofBool(bool)`. */
        fun pinning(bool: Boolean) = pinning(Pinning.ofBool(bool))

        /** Alias for calling [pinning] with `Pinning.ofConfig(config)`. */
        fun pinning(config: PinningConfig) = pinning(Pinning.ofConfig(config))

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
         * Returns an immutable instance of [NamespaceMetadataPatch].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): NamespaceMetadataPatch =
            NamespaceMetadataPatch(pinning, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): NamespaceMetadataPatch = apply {
        if (validated) {
            return@apply
        }

        pinning().ifPresent { it.validate() }
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
    @JvmSynthetic internal fun validity(): Int = (pinning.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Configuration for namespace pinning.
     * - Missing field: no change to pinning configuration
     * - `null` or `false`: explicitly remove pinning
     * - `true`: enable pinning with default configuration
     * - Object: set pinning configuration
     */
    @JsonDeserialize(using = Pinning.Deserializer::class)
    @JsonSerialize(using = Pinning.Serializer::class)
    class Pinning
    private constructor(
        private val bool: Boolean? = null,
        private val config: PinningConfig? = null,
        private val _json: JsonValue? = null,
    ) {

        fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

        /** Configuration for namespace pinning. */
        fun config(): Optional<PinningConfig> = Optional.ofNullable(config)

        fun isBool(): Boolean = bool != null

        fun isConfig(): Boolean = config != null

        fun asBool(): Boolean = bool.getOrThrow("bool")

        /** Configuration for namespace pinning. */
        fun asConfig(): PinningConfig = config.getOrThrow("config")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                bool != null -> visitor.visitBool(bool)
                config != null -> visitor.visitConfig(config)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Pinning = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitBool(bool: Boolean) {}

                    override fun visitConfig(config: PinningConfig) {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitBool(bool: Boolean) = 1

                    override fun visitConfig(config: PinningConfig) = config.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Pinning && bool == other.bool && config == other.config
        }

        override fun hashCode(): Int = Objects.hash(bool, config)

        override fun toString(): String =
            when {
                bool != null -> "Pinning{bool=$bool}"
                config != null -> "Pinning{config=$config}"
                _json != null -> "Pinning{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Pinning")
            }

        companion object {

            @JvmStatic fun ofBool(bool: Boolean) = Pinning(bool = bool)

            /** Configuration for namespace pinning. */
            @JvmStatic fun ofConfig(config: PinningConfig) = Pinning(config = config)
        }

        /**
         * An interface that defines how to map each variant of [Pinning] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitBool(bool: Boolean): T

            /** Configuration for namespace pinning. */
            fun visitConfig(config: PinningConfig): T

            /**
             * Maps an unknown variant of [Pinning] to a value of type [T].
             *
             * An instance of [Pinning] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws TurbopufferInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw TurbopufferInvalidDataException("Unknown Pinning: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Pinning>(Pinning::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Pinning {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<PinningConfig>())?.let {
                                Pinning(config = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                                Pinning(bool = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from string).
                    0 -> Pinning(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Pinning>(Pinning::class) {

            override fun serialize(
                value: Pinning,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.bool != null -> generator.writeObject(value.bool)
                    value.config != null -> generator.writeObject(value.config)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Pinning")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is NamespaceMetadataPatch &&
            pinning == other.pinning &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(pinning, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "NamespaceMetadataPatch{pinning=$pinning, additionalProperties=$additionalProperties}"
}
