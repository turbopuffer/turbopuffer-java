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
class NamespaceRetrieveResponse
@JsonCreator
private constructor(
    @JsonProperty("approx_count")
    @ExcludeMissing
    private val approxCount: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("dimensions")
    @ExcludeMissing
    private val dimensions: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("name") @ExcludeMissing private val name: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun approxCount(): Optional<Long> = Optional.ofNullable(approxCount.getNullable("approx_count"))

    fun dimensions(): Optional<Long> = Optional.ofNullable(dimensions.getNullable("dimensions"))

    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    @JsonProperty("approx_count") @ExcludeMissing fun _approxCount(): JsonField<Long> = approxCount

    @JsonProperty("dimensions") @ExcludeMissing fun _dimensions(): JsonField<Long> = dimensions

    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): NamespaceRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        approxCount()
        dimensions()
        name()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceRetrieveResponse]. */
    class Builder internal constructor() {

        private var approxCount: JsonField<Long> = JsonMissing.of()
        private var dimensions: JsonField<Long> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(namespaceRetrieveResponse: NamespaceRetrieveResponse) = apply {
            approxCount = namespaceRetrieveResponse.approxCount
            dimensions = namespaceRetrieveResponse.dimensions
            name = namespaceRetrieveResponse.name
            additionalProperties = namespaceRetrieveResponse.additionalProperties.toMutableMap()
        }

        fun approxCount(approxCount: Long) = approxCount(JsonField.of(approxCount))

        fun approxCount(approxCount: JsonField<Long>) = apply { this.approxCount = approxCount }

        fun dimensions(dimensions: Long) = dimensions(JsonField.of(dimensions))

        fun dimensions(dimensions: JsonField<Long>) = apply { this.dimensions = dimensions }

        fun name(name: String) = name(JsonField.of(name))

        fun name(name: JsonField<String>) = apply { this.name = name }

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

        fun build(): NamespaceRetrieveResponse =
            NamespaceRetrieveResponse(
                approxCount,
                dimensions,
                name,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is NamespaceRetrieveResponse && approxCount == other.approxCount && dimensions == other.dimensions && name == other.name && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(approxCount, dimensions, name, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "NamespaceRetrieveResponse{approxCount=$approxCount, dimensions=$dimensions, name=$name, additionalProperties=$additionalProperties}"
}
