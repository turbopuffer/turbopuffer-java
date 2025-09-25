// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.turbopuffer.core.ExcludeMissing
import com.turbopuffer.core.JsonField
import com.turbopuffer.core.JsonMissing
import com.turbopuffer.core.JsonValue
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** The response to a successful cache warm request. */
class NamespaceHintCacheWarmResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val status: JsonValue,
    private val message: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("status") @ExcludeMissing status: JsonValue = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
    ) : this(status, message, mutableMapOf())

    /**
     * The status of the request.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("ACCEPTED")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonValue = status

    /**
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun message(): Optional<String> = message.getOptional("message")

    /**
     * Returns the raw JSON value of [message].
     *
     * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

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
         * [NamespaceHintCacheWarmResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceHintCacheWarmResponse]. */
    class Builder internal constructor() {

        private var status: JsonValue = JsonValue.from("ACCEPTED")
        private var message: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(namespaceHintCacheWarmResponse: NamespaceHintCacheWarmResponse) = apply {
            status = namespaceHintCacheWarmResponse.status
            message = namespaceHintCacheWarmResponse.message
            additionalProperties =
                namespaceHintCacheWarmResponse.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("ACCEPTED")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun status(status: JsonValue) = apply { this.status = status }

        fun message(message: String) = message(JsonField.of(message))

        /**
         * Sets [Builder.message] to an arbitrary JSON value.
         *
         * You should usually call [Builder.message] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun message(message: JsonField<String>) = apply { this.message = message }

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
         * Returns an immutable instance of [NamespaceHintCacheWarmResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): NamespaceHintCacheWarmResponse =
            NamespaceHintCacheWarmResponse(status, message, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): NamespaceHintCacheWarmResponse = apply {
        if (validated) {
            return@apply
        }

        _status().let {
            if (it != JsonValue.from("ACCEPTED")) {
                throw TurbopufferInvalidDataException("'status' is invalid, received $it")
            }
        }
        message()
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
        status.let { if (it == JsonValue.from("ACCEPTED")) 1 else 0 } +
            (if (message.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is NamespaceHintCacheWarmResponse &&
            status == other.status &&
            message == other.message &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(status, message, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "NamespaceHintCacheWarmResponse{status=$status, message=$message, additionalProperties=$additionalProperties}"
}
