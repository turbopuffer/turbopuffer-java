// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.errors

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.turbopuffer.core.ExcludeMissing
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.NoAutoDetect
import com.turbopuffer.core.immutableEmptyMap
import com.turbopuffer.core.toImmutable
import java.util.Objects

@NoAutoDetect
class TurbopufferError
@JsonCreator
private constructor(
    @JsonAnyGetter
    @ExcludeMissing
    @JsonAnySetter
    @get:JvmName("additionalProperties")
    val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
) {

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [TurbopufferError]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TurbopufferError]. */
    class Builder internal constructor() {

        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(turbopufferError: TurbopufferError) = apply {
            additionalProperties = turbopufferError.additionalProperties.toMutableMap()
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

        fun build(): TurbopufferError = TurbopufferError(additionalProperties.toImmutable())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TurbopufferError && additionalProperties == other.additionalProperties /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(additionalProperties) /* spotless:on */

    override fun toString() = "TurbopufferError{additionalProperties=$additionalProperties}"
}
