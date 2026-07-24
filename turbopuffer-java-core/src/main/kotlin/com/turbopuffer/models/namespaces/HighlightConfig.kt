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
import kotlin.jvm.optionals.getOrNull

/** Additional (optional) parameters for the Highlight compute expression. */
class HighlightConfig
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val fragmentBy: JsonField<HighlightFragmentBy>,
    private val fragmentLimit: JsonField<Long>,
    private val includeOffsets: JsonField<HighlightOffsetUnits>,
    private val rankFragmentsBy: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("fragment_by")
        @ExcludeMissing
        fragmentBy: JsonField<HighlightFragmentBy> = JsonMissing.of(),
        @JsonProperty("fragment_limit")
        @ExcludeMissing
        fragmentLimit: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("include_offsets")
        @ExcludeMissing
        includeOffsets: JsonField<HighlightOffsetUnits> = JsonMissing.of(),
        @JsonProperty("rank_fragments_by")
        @ExcludeMissing
        rankFragmentsBy: JsonValue = JsonMissing.of(),
    ) : this(fragmentBy, fragmentLimit, includeOffsets, rankFragmentsBy, mutableMapOf())

    /**
     * How to split a text attribute into fragments for highlighting.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fragmentBy(): Optional<HighlightFragmentBy> = fragmentBy.getOptional("fragment_by")

    /**
     * The maximum number of fragments to return. Defaults to `3`.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fragmentLimit(): Optional<Long> = fragmentLimit.getOptional("fragment_limit")

    /**
     * The units to report highlighted fragment offsets in.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun includeOffsets(): Optional<HighlightOffsetUnits> =
        includeOffsets.getOptional("include_offsets")

    /**
     * How to rank candidate fragments within the attribute before selecting the top
     * `fragment_limit`. Defaults to the query's `rank_by`.
     *
     * This arbitrary value can be deserialized into a custom type using the `convert` method:
     * ```java
     * MyClass myObject = highlightConfig.rankFragmentsBy().convert(MyClass.class);
     * ```
     */
    @JsonProperty("rank_fragments_by")
    @ExcludeMissing
    fun _rankFragmentsBy(): JsonValue = rankFragmentsBy

    /**
     * Returns the raw JSON value of [fragmentBy].
     *
     * Unlike [fragmentBy], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fragment_by")
    @ExcludeMissing
    fun _fragmentBy(): JsonField<HighlightFragmentBy> = fragmentBy

    /**
     * Returns the raw JSON value of [fragmentLimit].
     *
     * Unlike [fragmentLimit], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fragment_limit")
    @ExcludeMissing
    fun _fragmentLimit(): JsonField<Long> = fragmentLimit

    /**
     * Returns the raw JSON value of [includeOffsets].
     *
     * Unlike [includeOffsets], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("include_offsets")
    @ExcludeMissing
    fun _includeOffsets(): JsonField<HighlightOffsetUnits> = includeOffsets

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

        /** Returns a mutable builder for constructing an instance of [HighlightConfig]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [HighlightConfig]. */
    class Builder internal constructor() {

        private var fragmentBy: JsonField<HighlightFragmentBy> = JsonMissing.of()
        private var fragmentLimit: JsonField<Long> = JsonMissing.of()
        private var includeOffsets: JsonField<HighlightOffsetUnits> = JsonMissing.of()
        private var rankFragmentsBy: JsonValue = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(highlightConfig: HighlightConfig) = apply {
            fragmentBy = highlightConfig.fragmentBy
            fragmentLimit = highlightConfig.fragmentLimit
            includeOffsets = highlightConfig.includeOffsets
            rankFragmentsBy = highlightConfig.rankFragmentsBy
            additionalProperties = highlightConfig.additionalProperties.toMutableMap()
        }

        /** How to split a text attribute into fragments for highlighting. */
        fun fragmentBy(fragmentBy: HighlightFragmentBy) = fragmentBy(JsonField.of(fragmentBy))

        /**
         * Sets [Builder.fragmentBy] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fragmentBy] with a well-typed [HighlightFragmentBy]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun fragmentBy(fragmentBy: JsonField<HighlightFragmentBy>) = apply {
            this.fragmentBy = fragmentBy
        }

        /** The maximum number of fragments to return. Defaults to `3`. */
        fun fragmentLimit(fragmentLimit: Long) = fragmentLimit(JsonField.of(fragmentLimit))

        /**
         * Sets [Builder.fragmentLimit] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fragmentLimit] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun fragmentLimit(fragmentLimit: JsonField<Long>) = apply {
            this.fragmentLimit = fragmentLimit
        }

        /** The units to report highlighted fragment offsets in. */
        fun includeOffsets(includeOffsets: HighlightOffsetUnits) =
            includeOffsets(JsonField.of(includeOffsets))

        /**
         * Sets [Builder.includeOffsets] to an arbitrary JSON value.
         *
         * You should usually call [Builder.includeOffsets] with a well-typed [HighlightOffsetUnits]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun includeOffsets(includeOffsets: JsonField<HighlightOffsetUnits>) = apply {
            this.includeOffsets = includeOffsets
        }

        /**
         * How to rank candidate fragments within the attribute before selecting the top
         * `fragment_limit`. Defaults to the query's `rank_by`.
         */
        fun rankFragmentsBy(rankFragmentsBy: JsonValue) = apply {
            this.rankFragmentsBy = rankFragmentsBy
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

        /**
         * Returns an immutable instance of [HighlightConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): HighlightConfig =
            HighlightConfig(
                fragmentBy,
                fragmentLimit,
                includeOffsets,
                rankFragmentsBy,
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
    fun validate(): HighlightConfig = apply {
        if (validated) {
            return@apply
        }

        fragmentBy().ifPresent { it.validate() }
        fragmentLimit()
        includeOffsets().ifPresent { it.validate() }
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
        (fragmentBy.asKnown().getOrNull()?.validity() ?: 0) +
            (if (fragmentLimit.asKnown().isPresent) 1 else 0) +
            (includeOffsets.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is HighlightConfig &&
            fragmentBy == other.fragmentBy &&
            fragmentLimit == other.fragmentLimit &&
            includeOffsets == other.includeOffsets &&
            rankFragmentsBy == other.rankFragmentsBy &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            fragmentBy,
            fragmentLimit,
            includeOffsets,
            rankFragmentsBy,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "HighlightConfig{fragmentBy=$fragmentBy, fragmentLimit=$fragmentLimit, includeOffsets=$includeOffsets, rankFragmentsBy=$rankFragmentsBy, additionalProperties=$additionalProperties}"
}
