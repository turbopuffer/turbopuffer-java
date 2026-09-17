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
import kotlin.jvm.optionals.getOrNull

@JsonDeserialize(using = CopyFromNamespaceOperationResult.Deserializer::class)
@JsonSerialize(using = CopyFromNamespaceOperationResult.Serializer::class)
class CopyFromNamespaceOperationResult
private constructor(
    private val success: Success? = null,
    private val error: Error? = null,
    private val _json: JsonValue? = null,
) {

    fun success(): Optional<Success> = Optional.ofNullable(success)

    fun error(): Optional<Error> = Optional.ofNullable(error)

    fun isSuccess(): Boolean = success != null

    fun isError(): Boolean = error != null

    fun asSuccess(): Success = success.getOrThrow("success")

    fun asError(): Error = error.getOrThrow("error")

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
     * Optional<String> result = copyFromNamespaceOperationResult.accept(new CopyFromNamespaceOperationResult.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitSuccess(Success success) {
     *         return Optional.of(success.toString());
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
            success != null -> visitor.visitSuccess(success)
            error != null -> visitor.visitError(error)
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
    fun validate(): CopyFromNamespaceOperationResult = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitSuccess(success: Success) {
                    success.validate()
                }

                override fun visitError(error: Error) {
                    error.validate()
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
                override fun visitSuccess(success: Success) = success.validity()

                override fun visitError(error: Error) = error.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CopyFromNamespaceOperationResult &&
            success == other.success &&
            error == other.error
    }

    override fun hashCode(): Int = Objects.hash(success, error)

    override fun toString(): String =
        when {
            success != null -> "CopyFromNamespaceOperationResult{success=$success}"
            error != null -> "CopyFromNamespaceOperationResult{error=$error}"
            _json != null -> "CopyFromNamespaceOperationResult{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid CopyFromNamespaceOperationResult")
        }

    companion object {

        @JvmStatic
        fun ofSuccess(success: Success) = CopyFromNamespaceOperationResult(success = success)

        @JvmStatic fun ofError(error: Error) = CopyFromNamespaceOperationResult(error = error)
    }

    /**
     * An interface that defines how to map each variant of [CopyFromNamespaceOperationResult] to a
     * value of type [T].
     */
    interface Visitor<out T> {

        fun visitSuccess(success: Success): T

        fun visitError(error: Error): T

        /**
         * Maps an unknown variant of [CopyFromNamespaceOperationResult] to a value of type [T].
         *
         * An instance of [CopyFromNamespaceOperationResult] can contain an unknown variant if it
         * was deserialized from data that doesn't match any known variant. For example, if the SDK
         * is on an older version than the API, then the API may respond with new variants that the
         * SDK is unaware of.
         *
         * @throws TurbopufferInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw TurbopufferInvalidDataException("Unknown CopyFromNamespaceOperationResult: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<CopyFromNamespaceOperationResult>(
            CopyFromNamespaceOperationResult::class
        ) {

        override fun ObjectCodec.deserialize(node: JsonNode): CopyFromNamespaceOperationResult {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<Success>())?.let {
                            CopyFromNamespaceOperationResult(success = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<Error>())?.let {
                            CopyFromNamespaceOperationResult(error = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> CopyFromNamespaceOperationResult(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer :
        BaseSerializer<CopyFromNamespaceOperationResult>(CopyFromNamespaceOperationResult::class) {

        override fun serialize(
            value: CopyFromNamespaceOperationResult,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.success != null -> generator.writeObject(value.success)
                value.error != null -> generator.writeObject(value.error)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid CopyFromNamespaceOperationResult")
            }
        }
    }

    class Success
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val success: JsonField<WriteResult>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("success")
            @ExcludeMissing
            success: JsonField<WriteResult> = JsonMissing.of()
        ) : this(success, mutableMapOf())

        /**
         * The response to a successful write request.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun success(): WriteResult = success.getRequired("success")

        /**
         * Returns the raw JSON value of [success].
         *
         * Unlike [success], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("success") @ExcludeMissing fun _success(): JsonField<WriteResult> = success

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
             * Returns a mutable builder for constructing an instance of [Success].
             *
             * The following fields are required:
             * ```java
             * .success()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Success]. */
        class Builder internal constructor() {

            private var success: JsonField<WriteResult>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(success: Success) = apply {
                this.success = success.success
                additionalProperties = success.additionalProperties.toMutableMap()
            }

            /** The response to a successful write request. */
            fun success(success: WriteResult) = success(JsonField.of(success))

            /**
             * Sets [Builder.success] to an arbitrary JSON value.
             *
             * You should usually call [Builder.success] with a well-typed [WriteResult] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun success(success: JsonField<WriteResult>) = apply { this.success = success }

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
             * Returns an immutable instance of [Success].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .success()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Success =
                Success(checkRequired("success", success), additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws TurbopufferInvalidDataException if any value type in this object doesn't match
         *   its expected type.
         */
        fun validate(): Success = apply {
            if (validated) {
                return@apply
            }

            success().validate()
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
        internal fun validity(): Int = (success.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Success &&
                success == other.success &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(success, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Success{success=$success, additionalProperties=$additionalProperties}"
    }

    class Error
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val error: JsonField<OperationError>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("error")
            @ExcludeMissing
            error: JsonField<OperationError> = JsonMissing.of()
        ) : this(error, mutableMapOf())

        /**
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun error(): OperationError = error.getRequired("error")

        /**
         * Returns the raw JSON value of [error].
         *
         * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<OperationError> = error

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
             * Returns a mutable builder for constructing an instance of [Error].
             *
             * The following fields are required:
             * ```java
             * .error()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Error]. */
        class Builder internal constructor() {

            private var error: JsonField<OperationError>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(error: Error) = apply {
                this.error = error.error
                additionalProperties = error.additionalProperties.toMutableMap()
            }

            fun error(error: OperationError) = error(JsonField.of(error))

            /**
             * Sets [Builder.error] to an arbitrary JSON value.
             *
             * You should usually call [Builder.error] with a well-typed [OperationError] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun error(error: JsonField<OperationError>) = apply { this.error = error }

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
             * Returns an immutable instance of [Error].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .error()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Error =
                Error(checkRequired("error", error), additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws TurbopufferInvalidDataException if any value type in this object doesn't match
         *   its expected type.
         */
        fun validate(): Error = apply {
            if (validated) {
                return@apply
            }

            error().validate()
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
        @JvmSynthetic internal fun validity(): Int = (error.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Error &&
                error == other.error &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(error, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Error{error=$error, additionalProperties=$additionalProperties}"
    }
}
