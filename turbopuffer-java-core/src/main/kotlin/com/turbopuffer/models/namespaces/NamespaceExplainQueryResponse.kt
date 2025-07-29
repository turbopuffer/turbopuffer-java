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

/** The response to a successful query explain. */
class NamespaceExplainQueryResponse
private constructor(
    private val planText: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("plan_text") @ExcludeMissing planText: JsonField<String> = JsonMissing.of()
    ) : this(planText, mutableMapOf())

    /**
     * The textual representation of the query plan.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun planText(): Optional<String> = planText.getOptional("plan_text")

    /**
     * Returns the raw JSON value of [planText].
     *
     * Unlike [planText], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("plan_text") @ExcludeMissing fun _planText(): JsonField<String> = planText

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
         * [NamespaceExplainQueryResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceExplainQueryResponse]. */
    class Builder internal constructor() {

        private var planText: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(namespaceExplainQueryResponse: NamespaceExplainQueryResponse) = apply {
            planText = namespaceExplainQueryResponse.planText
            additionalProperties = namespaceExplainQueryResponse.additionalProperties.toMutableMap()
        }

        /** The textual representation of the query plan. */
        fun planText(planText: String) = planText(JsonField.of(planText))

        /**
         * Sets [Builder.planText] to an arbitrary JSON value.
         *
         * You should usually call [Builder.planText] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun planText(planText: JsonField<String>) = apply { this.planText = planText }

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
         * Returns an immutable instance of [NamespaceExplainQueryResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): NamespaceExplainQueryResponse =
            NamespaceExplainQueryResponse(planText, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): NamespaceExplainQueryResponse = apply {
        if (validated) {
            return@apply
        }

        planText()
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
    @JvmSynthetic internal fun validity(): Int = (if (planText.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is NamespaceExplainQueryResponse && planText == other.planText && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(planText, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "NamespaceExplainQueryResponse{planText=$planText, additionalProperties=$additionalProperties}"
}
