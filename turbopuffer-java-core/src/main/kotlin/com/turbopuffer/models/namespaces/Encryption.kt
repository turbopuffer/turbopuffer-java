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

/** The encryption configuration for a namespace. */
@JsonDeserialize(using = Encryption.Deserializer::class)
@JsonSerialize(using = Encryption.Serializer::class)
class Encryption
private constructor(
    private val customerManaged: CustomerManaged? = null,
    private val default_: JsonValue? = null,
    private val _json: JsonValue? = null,
) {

    /** Encrypt the namespace with a customer-managed encryption key (CMEK). */
    fun customerManaged(): Optional<CustomerManaged> = Optional.ofNullable(customerManaged)

    /** Use the default server-side encryption (SSE). */
    fun default_(): Optional<JsonValue> = Optional.ofNullable(default_)

    fun isCustomerManaged(): Boolean = customerManaged != null

    fun isDefault(): Boolean = default_ != null

    /** Encrypt the namespace with a customer-managed encryption key (CMEK). */
    fun asCustomerManaged(): CustomerManaged = customerManaged.getOrThrow("customerManaged")

    /** Use the default server-side encryption (SSE). */
    fun asDefault(): JsonValue = default_.getOrThrow("default_")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            customerManaged != null -> visitor.visitCustomerManaged(customerManaged)
            default_ != null -> visitor.visitDefault(default_)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): Encryption = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitCustomerManaged(customerManaged: CustomerManaged) {
                    customerManaged.validate()
                }

                override fun visitDefault(default_: JsonValue) {
                    default_.let {
                        if (it != JsonValue.from(mapOf("mode" to "default"))) {
                            throw TurbopufferInvalidDataException(
                                "'default_' is invalid, received $it"
                            )
                        }
                    }
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
                override fun visitCustomerManaged(customerManaged: CustomerManaged) =
                    customerManaged.validity()

                override fun visitDefault(default_: JsonValue) =
                    default_.let { if (it == JsonValue.from(mapOf("mode" to "default"))) 1 else 0 }

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Encryption &&
            customerManaged == other.customerManaged &&
            default_ == other.default_
    }

    override fun hashCode(): Int = Objects.hash(customerManaged, default_)

    override fun toString(): String =
        when {
            customerManaged != null -> "Encryption{customerManaged=$customerManaged}"
            default_ != null -> "Encryption{default_=$default_}"
            _json != null -> "Encryption{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid Encryption")
        }

    companion object {

        /** Encrypt the namespace with a customer-managed encryption key (CMEK). */
        @JvmStatic
        fun ofCustomerManaged(customerManaged: CustomerManaged) =
            Encryption(customerManaged = customerManaged)

        /** Use the default server-side encryption (SSE). */
        @JvmStatic
        fun ofDefault() = Encryption(default_ = JsonValue.from(mapOf("mode" to "default")))
    }

    /** An interface that defines how to map each variant of [Encryption] to a value of type [T]. */
    interface Visitor<out T> {

        /** Encrypt the namespace with a customer-managed encryption key (CMEK). */
        fun visitCustomerManaged(customerManaged: CustomerManaged): T

        /** Use the default server-side encryption (SSE). */
        fun visitDefault(default_: JsonValue): T

        /**
         * Maps an unknown variant of [Encryption] to a value of type [T].
         *
         * An instance of [Encryption] can contain an unknown variant if it was deserialized from
         * data that doesn't match any known variant. For example, if the SDK is on an older version
         * than the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws TurbopufferInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw TurbopufferInvalidDataException("Unknown Encryption: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<Encryption>(Encryption::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): Encryption {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { Encryption(default_ = it, _json = json) }
                            ?.takeIf { it.isValid() },
                        tryDeserialize(node, jacksonTypeRef<CustomerManaged>())?.let {
                            Encryption(customerManaged = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> Encryption(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<Encryption>(Encryption::class) {

        override fun serialize(
            value: Encryption,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.customerManaged != null -> generator.writeObject(value.customerManaged)
                value.default_ != null -> generator.writeObject(value.default_)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid Encryption")
            }
        }
    }

    /** Encrypt the namespace with a customer-managed encryption key (CMEK). */
    class CustomerManaged
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val keyName: JsonField<String>,
        private val mode: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("key_name") @ExcludeMissing keyName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("mode") @ExcludeMissing mode: JsonValue = JsonMissing.of(),
        ) : this(keyName, mode, mutableMapOf())

        /**
         * The identifier of the CMEK key to use for encryption. For GCP, the fully-qualified
         * resource name of the key. For AWS, the ARN of the key.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun keyName(): String = keyName.getRequired("key_name")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("customer-managed")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("mode") @ExcludeMissing fun _mode(): JsonValue = mode

        /**
         * Returns the raw JSON value of [keyName].
         *
         * Unlike [keyName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("key_name") @ExcludeMissing fun _keyName(): JsonField<String> = keyName

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
             * Returns a mutable builder for constructing an instance of [CustomerManaged].
             *
             * The following fields are required:
             * ```java
             * .keyName()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CustomerManaged]. */
        class Builder internal constructor() {

            private var keyName: JsonField<String>? = null
            private var mode: JsonValue = JsonValue.from("customer-managed")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(customerManaged: CustomerManaged) = apply {
                keyName = customerManaged.keyName
                mode = customerManaged.mode
                additionalProperties = customerManaged.additionalProperties.toMutableMap()
            }

            /**
             * The identifier of the CMEK key to use for encryption. For GCP, the fully-qualified
             * resource name of the key. For AWS, the ARN of the key.
             */
            fun keyName(keyName: String) = keyName(JsonField.of(keyName))

            /**
             * Sets [Builder.keyName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.keyName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun keyName(keyName: JsonField<String>) = apply { this.keyName = keyName }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("customer-managed")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mode(mode: JsonValue) = apply { this.mode = mode }

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
             * Returns an immutable instance of [CustomerManaged].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .keyName()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): CustomerManaged =
                CustomerManaged(
                    checkRequired("keyName", keyName),
                    mode,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): CustomerManaged = apply {
            if (validated) {
                return@apply
            }

            keyName()
            _mode().let {
                if (it != JsonValue.from("customer-managed")) {
                    throw TurbopufferInvalidDataException("'mode' is invalid, received $it")
                }
            }
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
            (if (keyName.asKnown().isPresent) 1 else 0) +
                mode.let { if (it == JsonValue.from("customer-managed")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CustomerManaged &&
                keyName == other.keyName &&
                mode == other.mode &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(keyName, mode, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CustomerManaged{keyName=$keyName, mode=$mode, additionalProperties=$additionalProperties}"
    }
}
