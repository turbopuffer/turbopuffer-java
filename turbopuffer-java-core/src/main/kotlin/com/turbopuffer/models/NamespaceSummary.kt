// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.turbopuffer.core.ExcludeMissing
import com.turbopuffer.core.JsonField
import com.turbopuffer.core.JsonMissing
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.NoAutoDetect
import com.turbopuffer.core.immutableEmptyMap
import com.turbopuffer.core.toImmutable
import java.util.Objects
import java.util.Optional

/** A summary of a namespace. */
@NoAutoDetect
class NamespaceSummary
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("required") @ExcludeMissing private val required: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The namespace ID. */
    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    @JsonProperty("required") @ExcludeMissing fun _required(): JsonValue = required

    /** The namespace ID. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): NamespaceSummary = apply {
        if (validated) {
            return@apply
        }

        id()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceSummary]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var required: JsonValue = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(namespaceSummary: NamespaceSummary) = apply {
            id = namespaceSummary.id
            required = namespaceSummary.required
            additionalProperties = namespaceSummary.additionalProperties.toMutableMap()
        }

        /** The namespace ID. */
        fun id(id: String) = id(JsonField.of(id))

        /** The namespace ID. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun required(required: JsonValue) = apply { this.required = required }

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

        fun build(): NamespaceSummary =
            NamespaceSummary(id, required, additionalProperties.toImmutable())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is NamespaceSummary && id == other.id && required == other.required && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, required, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "NamespaceSummary{id=$id, required=$required, additionalProperties=$additionalProperties}"
}
