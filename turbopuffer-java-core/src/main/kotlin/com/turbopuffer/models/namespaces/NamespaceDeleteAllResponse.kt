// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.turbopuffer.core.ExcludeMissing
import com.turbopuffer.core.JsonMissing
import com.turbopuffer.core.JsonValue
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects

/** The response to a successful namespace deletion request. */
class NamespaceDeleteAllResponse
private constructor(
    private val status: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("status") @ExcludeMissing status: JsonValue = JsonMissing.of()
    ) : this(status, mutableMapOf())

    /**
     * The status of the request.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("OK")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonValue = status

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
         * Returns a mutable builder for constructing an instance of [NamespaceDeleteAllResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceDeleteAllResponse]. */
    class Builder internal constructor() {

        private var status: JsonValue = JsonValue.from("OK")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(namespaceDeleteAllResponse: NamespaceDeleteAllResponse) = apply {
            status = namespaceDeleteAllResponse.status
            additionalProperties = namespaceDeleteAllResponse.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("OK")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun status(status: JsonValue) = apply { this.status = status }

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
         * Returns an immutable instance of [NamespaceDeleteAllResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): NamespaceDeleteAllResponse =
            NamespaceDeleteAllResponse(status, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): NamespaceDeleteAllResponse = apply {
        if (validated) {
            return@apply
        }

        _status().let {
            if (it != JsonValue.from("OK")) {
                throw TurbopufferInvalidDataException("'status' is invalid, received $it")
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int = status.let { if (it == JsonValue.from("OK")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is NamespaceDeleteAllResponse &&
            status == other.status &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(status, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "NamespaceDeleteAllResponse{status=$status, additionalProperties=$additionalProperties}"
}
