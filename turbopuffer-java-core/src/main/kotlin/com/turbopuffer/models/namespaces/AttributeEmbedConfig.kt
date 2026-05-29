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
import com.turbopuffer.core.checkRequired
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** Configuration options for automatic embedding. */
class AttributeEmbedConfig
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val model: JsonField<String>,
    private val attribute: JsonField<String>,
    private val dims: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("attribute") @ExcludeMissing attribute: JsonField<String> = JsonMissing.of(),
        @JsonProperty("dims") @ExcludeMissing dims: JsonField<Long> = JsonMissing.of(),
    ) : this(model, attribute, dims, mutableMapOf())

    /**
     * The model to use for embedding. See our documentation for a list of models supported in each
     * region.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = model.getRequired("model")

    /**
     * The name of an existing vector attribute to store embeddings in. If omitted, turbopuffer will
     * generate a computed vector attribute named `$embed_<attribute>`.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun attribute(): Optional<String> = attribute.getOptional("attribute")

    /**
     * The dimensionality to embed at. If not set, will pick the default for this model. If you're
     * storing embeddings in an existing attribute, this can be omitted, and may not be set to a
     * value other than the dimensions of that attribute.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun dims(): Optional<Long> = dims.getOptional("dims")

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

    /**
     * Returns the raw JSON value of [attribute].
     *
     * Unlike [attribute], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("attribute") @ExcludeMissing fun _attribute(): JsonField<String> = attribute

    /**
     * Returns the raw JSON value of [dims].
     *
     * Unlike [dims], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("dims") @ExcludeMissing fun _dims(): JsonField<Long> = dims

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
         * Returns a mutable builder for constructing an instance of [AttributeEmbedConfig].
         *
         * The following fields are required:
         * ```java
         * .model()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AttributeEmbedConfig]. */
    class Builder internal constructor() {

        private var model: JsonField<String>? = null
        private var attribute: JsonField<String> = JsonMissing.of()
        private var dims: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(attributeEmbedConfig: AttributeEmbedConfig) = apply {
            model = attributeEmbedConfig.model
            attribute = attributeEmbedConfig.attribute
            dims = attributeEmbedConfig.dims
            additionalProperties = attributeEmbedConfig.additionalProperties.toMutableMap()
        }

        /**
         * The model to use for embedding. See our documentation for a list of models supported in
         * each region.
         */
        fun model(model: String) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /**
         * The name of an existing vector attribute to store embeddings in. If omitted, turbopuffer
         * will generate a computed vector attribute named `$embed_<attribute>`.
         */
        fun attribute(attribute: String) = attribute(JsonField.of(attribute))

        /**
         * Sets [Builder.attribute] to an arbitrary JSON value.
         *
         * You should usually call [Builder.attribute] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun attribute(attribute: JsonField<String>) = apply { this.attribute = attribute }

        /**
         * The dimensionality to embed at. If not set, will pick the default for this model. If
         * you're storing embeddings in an existing attribute, this can be omitted, and may not be
         * set to a value other than the dimensions of that attribute.
         */
        fun dims(dims: Long) = dims(JsonField.of(dims))

        /**
         * Sets [Builder.dims] to an arbitrary JSON value.
         *
         * You should usually call [Builder.dims] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun dims(dims: JsonField<Long>) = apply { this.dims = dims }

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
         * Returns an immutable instance of [AttributeEmbedConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .model()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AttributeEmbedConfig =
            AttributeEmbedConfig(
                checkRequired("model", model),
                attribute,
                dims,
                additionalProperties.toMutableMap(),
            )
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
    fun validate(): AttributeEmbedConfig = apply {
        if (validated) {
            return@apply
        }

        model()
        attribute()
        dims()
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
        (if (model.asKnown().isPresent) 1 else 0) +
            (if (attribute.asKnown().isPresent) 1 else 0) +
            (if (dims.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AttributeEmbedConfig &&
            model == other.model &&
            attribute == other.attribute &&
            dims == other.dims &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(model, attribute, dims, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AttributeEmbedConfig{model=$model, attribute=$attribute, dims=$dims, additionalProperties=$additionalProperties}"
}
