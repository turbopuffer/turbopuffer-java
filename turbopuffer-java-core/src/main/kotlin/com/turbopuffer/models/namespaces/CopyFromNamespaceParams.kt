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

/** The namespace to copy documents from. */
@JsonDeserialize(using = CopyFromNamespaceParams.Deserializer::class)
@JsonSerialize(using = CopyFromNamespaceParams.Serializer::class)
class CopyFromNamespaceParams
private constructor(
    private val string: String? = null,
    private val config: CopyFromNamespaceConfig? = null,
    private val _json: JsonValue? = null,
) {

    /** The namespace to copy documents from. */
    fun string(): Optional<String> = Optional.ofNullable(string)

    fun config(): Optional<CopyFromNamespaceConfig> = Optional.ofNullable(config)

    fun isString(): Boolean = string != null

    fun isConfig(): Boolean = config != null

    /** The namespace to copy documents from. */
    fun asString(): String = string.getOrThrow("string")

    fun asConfig(): CopyFromNamespaceConfig = config.getOrThrow("config")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            string != null -> visitor.visitString(string)
            config != null -> visitor.visitConfig(config)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): CopyFromNamespaceParams = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitString(string: String) {}

                override fun visitConfig(config: CopyFromNamespaceConfig) {
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

                override fun visitConfig(config: CopyFromNamespaceConfig) = config.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CopyFromNamespaceParams && string == other.string && config == other.config
    }

    override fun hashCode(): Int = Objects.hash(string, config)

    override fun toString(): String =
        when {
            string != null -> "CopyFromNamespaceParams{string=$string}"
            config != null -> "CopyFromNamespaceParams{config=$config}"
            _json != null -> "CopyFromNamespaceParams{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid CopyFromNamespaceParams")
        }

    companion object {

        /** The namespace to copy documents from. */
        @JvmStatic fun ofString(string: String) = CopyFromNamespaceParams(string = string)

        @JvmStatic
        fun ofConfig(config: CopyFromNamespaceConfig) = CopyFromNamespaceParams(config = config)
    }

    /**
     * An interface that defines how to map each variant of [CopyFromNamespaceParams] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        /** The namespace to copy documents from. */
        fun visitString(string: String): T

        fun visitConfig(config: CopyFromNamespaceConfig): T

        /**
         * Maps an unknown variant of [CopyFromNamespaceParams] to a value of type [T].
         *
         * An instance of [CopyFromNamespaceParams] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws TurbopufferInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw TurbopufferInvalidDataException("Unknown CopyFromNamespaceParams: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<CopyFromNamespaceParams>(CopyFromNamespaceParams::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): CopyFromNamespaceParams {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<CopyFromNamespaceConfig>())?.let {
                            CopyFromNamespaceParams(config = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            CopyFromNamespaceParams(string = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> CopyFromNamespaceParams(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer :
        BaseSerializer<CopyFromNamespaceParams>(CopyFromNamespaceParams::class) {

        override fun serialize(
            value: CopyFromNamespaceParams,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.string != null -> generator.writeObject(value.string)
                value.config != null -> generator.writeObject(value.config)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid CopyFromNamespaceParams")
            }
        }
    }

    class CopyFromNamespaceConfig
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val sourceNamespace: JsonField<String>,
        private val sourceApiKey: JsonField<String>,
        private val sourceRegion: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("source_namespace")
            @ExcludeMissing
            sourceNamespace: JsonField<String> = JsonMissing.of(),
            @JsonProperty("source_api_key")
            @ExcludeMissing
            sourceApiKey: JsonField<String> = JsonMissing.of(),
            @JsonProperty("source_region")
            @ExcludeMissing
            sourceRegion: JsonField<String> = JsonMissing.of(),
        ) : this(sourceNamespace, sourceApiKey, sourceRegion, mutableMapOf())

        /**
         * The namespace to copy documents from.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sourceNamespace(): String = sourceNamespace.getRequired("source_namespace")

        /**
         * (Optional) An API key for the organization containing the source namespace
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun sourceApiKey(): Optional<String> = sourceApiKey.getOptional("source_api_key")

        /**
         * (Optional) The region of the source namespace.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun sourceRegion(): Optional<String> = sourceRegion.getOptional("source_region")

        /**
         * Returns the raw JSON value of [sourceNamespace].
         *
         * Unlike [sourceNamespace], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("source_namespace")
        @ExcludeMissing
        fun _sourceNamespace(): JsonField<String> = sourceNamespace

        /**
         * Returns the raw JSON value of [sourceApiKey].
         *
         * Unlike [sourceApiKey], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("source_api_key")
        @ExcludeMissing
        fun _sourceApiKey(): JsonField<String> = sourceApiKey

        /**
         * Returns the raw JSON value of [sourceRegion].
         *
         * Unlike [sourceRegion], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("source_region")
        @ExcludeMissing
        fun _sourceRegion(): JsonField<String> = sourceRegion

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
             * Returns a mutable builder for constructing an instance of [CopyFromNamespaceConfig].
             *
             * The following fields are required:
             * ```java
             * .sourceNamespace()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CopyFromNamespaceConfig]. */
        class Builder internal constructor() {

            private var sourceNamespace: JsonField<String>? = null
            private var sourceApiKey: JsonField<String> = JsonMissing.of()
            private var sourceRegion: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(copyFromNamespaceConfig: CopyFromNamespaceConfig) = apply {
                sourceNamespace = copyFromNamespaceConfig.sourceNamespace
                sourceApiKey = copyFromNamespaceConfig.sourceApiKey
                sourceRegion = copyFromNamespaceConfig.sourceRegion
                additionalProperties = copyFromNamespaceConfig.additionalProperties.toMutableMap()
            }

            /** The namespace to copy documents from. */
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

            /** (Optional) An API key for the organization containing the source namespace */
            fun sourceApiKey(sourceApiKey: String) = sourceApiKey(JsonField.of(sourceApiKey))

            /**
             * Sets [Builder.sourceApiKey] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sourceApiKey] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sourceApiKey(sourceApiKey: JsonField<String>) = apply {
                this.sourceApiKey = sourceApiKey
            }

            /** (Optional) The region of the source namespace. */
            fun sourceRegion(sourceRegion: String) = sourceRegion(JsonField.of(sourceRegion))

            /**
             * Sets [Builder.sourceRegion] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sourceRegion] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sourceRegion(sourceRegion: JsonField<String>) = apply {
                this.sourceRegion = sourceRegion
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
             * Returns an immutable instance of [CopyFromNamespaceConfig].
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
            fun build(): CopyFromNamespaceConfig =
                CopyFromNamespaceConfig(
                    checkRequired("sourceNamespace", sourceNamespace),
                    sourceApiKey,
                    sourceRegion,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): CopyFromNamespaceConfig = apply {
            if (validated) {
                return@apply
            }

            sourceNamespace()
            sourceApiKey()
            sourceRegion()
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
            (if (sourceNamespace.asKnown().isPresent) 1 else 0) +
                (if (sourceApiKey.asKnown().isPresent) 1 else 0) +
                (if (sourceRegion.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CopyFromNamespaceConfig &&
                sourceNamespace == other.sourceNamespace &&
                sourceApiKey == other.sourceApiKey &&
                sourceRegion == other.sourceRegion &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(sourceNamespace, sourceApiKey, sourceRegion, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CopyFromNamespaceConfig{sourceNamespace=$sourceNamespace, sourceApiKey=$sourceApiKey, sourceRegion=$sourceRegion, additionalProperties=$additionalProperties}"
    }
}
