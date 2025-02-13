// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.turbopuffer.api.core.ExcludeMissing
import com.turbopuffer.api.core.JsonField
import com.turbopuffer.api.core.JsonMissing
import com.turbopuffer.api.core.JsonValue
import com.turbopuffer.api.core.NoAutoDetect
import com.turbopuffer.api.core.immutableEmptyMap
import com.turbopuffer.api.core.toImmutable
import java.util.Objects
import java.util.Optional

@NoAutoDetect
class NamespaceUpsertResponse
@JsonCreator
private constructor(
    @JsonProperty("status")
    @ExcludeMissing
    private val status: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun status(): Optional<String> = Optional.ofNullable(status.getNullable("status"))

    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): NamespaceUpsertResponse = apply {
        if (validated) {
            return@apply
        }

        status()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceUpsertResponse]. */
    class Builder internal constructor() {

        private var status: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(namespaceUpsertResponse: NamespaceUpsertResponse) = apply {
            status = namespaceUpsertResponse.status
            additionalProperties = namespaceUpsertResponse.additionalProperties.toMutableMap()
        }

        fun status(status: String) = status(JsonField.of(status))

        fun status(status: JsonField<String>) = apply { this.status = status }

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

        fun build(): NamespaceUpsertResponse =
            NamespaceUpsertResponse(status, additionalProperties.toImmutable())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is NamespaceUpsertResponse && status == other.status && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(status, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "NamespaceUpsertResponse{status=$status, additionalProperties=$additionalProperties}"
}
