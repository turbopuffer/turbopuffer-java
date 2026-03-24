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

/** The namespace to create an instant, copy-on-write clone of. */
@JsonDeserialize(using = BranchFromNamespaceParams.Deserializer::class)
@JsonSerialize(using = BranchFromNamespaceParams.Serializer::class)
class BranchFromNamespaceParams
private constructor(
    private val string: String? = null,
    private val config: BranchFromNamespaceConfig? = null,
    private val _json: JsonValue? = null,
) {

    /** The namespace to create an instant, copy-on-write clone of. */
    fun string(): Optional<String> = Optional.ofNullable(string)

    fun config(): Optional<BranchFromNamespaceConfig> = Optional.ofNullable(config)

    fun isString(): Boolean = string != null

    fun isConfig(): Boolean = config != null

    /** The namespace to create an instant, copy-on-write clone of. */
    fun asString(): String = string.getOrThrow("string")

    fun asConfig(): BranchFromNamespaceConfig = config.getOrThrow("config")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            string != null -> visitor.visitString(string)
            config != null -> visitor.visitConfig(config)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): BranchFromNamespaceParams = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitString(string: String) {}

                override fun visitConfig(config: BranchFromNamespaceConfig) {
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

                override fun visitConfig(config: BranchFromNamespaceConfig) = config.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BranchFromNamespaceParams &&
            string == other.string &&
            config == other.config
    }

    override fun hashCode(): Int = Objects.hash(string, config)

    override fun toString(): String =
        when {
            string != null -> "BranchFromNamespaceParams{string=$string}"
            config != null -> "BranchFromNamespaceParams{config=$config}"
            _json != null -> "BranchFromNamespaceParams{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid BranchFromNamespaceParams")
        }

    companion object {

        /** The namespace to create an instant, copy-on-write clone of. */
        @JvmStatic fun ofString(string: String) = BranchFromNamespaceParams(string = string)

        @JvmStatic
        fun ofConfig(config: BranchFromNamespaceConfig) = BranchFromNamespaceParams(config = config)
    }

    /**
     * An interface that defines how to map each variant of [BranchFromNamespaceParams] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        /** The namespace to create an instant, copy-on-write clone of. */
        fun visitString(string: String): T

        fun visitConfig(config: BranchFromNamespaceConfig): T

        /**
         * Maps an unknown variant of [BranchFromNamespaceParams] to a value of type [T].
         *
         * An instance of [BranchFromNamespaceParams] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws TurbopufferInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw TurbopufferInvalidDataException("Unknown BranchFromNamespaceParams: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<BranchFromNamespaceParams>(BranchFromNamespaceParams::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): BranchFromNamespaceParams {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<BranchFromNamespaceConfig>())?.let {
                            BranchFromNamespaceParams(config = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            BranchFromNamespaceParams(string = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> BranchFromNamespaceParams(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer :
        BaseSerializer<BranchFromNamespaceParams>(BranchFromNamespaceParams::class) {

        override fun serialize(
            value: BranchFromNamespaceParams,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.string != null -> generator.writeObject(value.string)
                value.config != null -> generator.writeObject(value.config)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid BranchFromNamespaceParams")
            }
        }
    }

    class BranchFromNamespaceConfig
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val sourceNamespace: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("source_namespace")
            @ExcludeMissing
            sourceNamespace: JsonField<String> = JsonMissing.of()
        ) : this(sourceNamespace, mutableMapOf())

        /**
         * The namespace to create an instant, copy-on-write clone of.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sourceNamespace(): String = sourceNamespace.getRequired("source_namespace")

        /**
         * Returns the raw JSON value of [sourceNamespace].
         *
         * Unlike [sourceNamespace], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("source_namespace")
        @ExcludeMissing
        fun _sourceNamespace(): JsonField<String> = sourceNamespace

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
             * Returns a mutable builder for constructing an instance of
             * [BranchFromNamespaceConfig].
             *
             * The following fields are required:
             * ```java
             * .sourceNamespace()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [BranchFromNamespaceConfig]. */
        class Builder internal constructor() {

            private var sourceNamespace: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(branchFromNamespaceConfig: BranchFromNamespaceConfig) = apply {
                sourceNamespace = branchFromNamespaceConfig.sourceNamespace
                additionalProperties = branchFromNamespaceConfig.additionalProperties.toMutableMap()
            }

            /** The namespace to create an instant, copy-on-write clone of. */
            fun sourceNamespace(sourceNamespace: String) =
                sourceNamespace(JsonField.of(sourceNamespace))

            /**
             * Sets [Builder.sourceNamespace] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sourceNamespace] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sourceNamespace(sourceNamespace: JsonField<String>) = apply {
                this.sourceNamespace = sourceNamespace
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

            /**
             * Returns an immutable instance of [BranchFromNamespaceConfig].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .sourceNamespace()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): BranchFromNamespaceConfig =
                BranchFromNamespaceConfig(
                    checkRequired("sourceNamespace", sourceNamespace),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): BranchFromNamespaceConfig = apply {
            if (validated) {
                return@apply
            }

            sourceNamespace()
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
        internal fun validity(): Int = (if (sourceNamespace.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is BranchFromNamespaceConfig &&
                sourceNamespace == other.sourceNamespace &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(sourceNamespace, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "BranchFromNamespaceConfig{sourceNamespace=$sourceNamespace, additionalProperties=$additionalProperties}"
    }
}
