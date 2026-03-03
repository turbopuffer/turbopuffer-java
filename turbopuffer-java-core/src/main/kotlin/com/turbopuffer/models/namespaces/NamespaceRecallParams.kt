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
import com.turbopuffer.core.Params
import com.turbopuffer.core.http.Headers
import com.turbopuffer.core.http.QueryParams
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Evaluate recall. */
class NamespaceRecallParams
private constructor(
    private val namespace: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun namespace(): Optional<String> = Optional.ofNullable(namespace)

    /**
     * Filter by attributes. Same syntax as the query endpoint.
     *
     * This arbitrary value can be deserialized into a custom type using the `convert` method:
     * ```java
     * MyClass myObject = namespaceRecallParams.filters().convert(MyClass.class);
     * ```
     */
    fun _filters(): JsonValue = body._filters()

    /**
     * Include ground truth data (query vectors and true nearest neighbors) in the response.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun includeGroundTruth(): Optional<Boolean> = body.includeGroundTruth()

    /**
     * The number of searches to run.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun num(): Optional<Long> = body.num()

    /**
     * Search for `top_k` nearest neighbors.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun topK(): Optional<Long> = body.topK()

    /**
     * Returns the raw JSON value of [includeGroundTruth].
     *
     * Unlike [includeGroundTruth], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _includeGroundTruth(): JsonField<Boolean> = body._includeGroundTruth()

    /**
     * Returns the raw JSON value of [num].
     *
     * Unlike [num], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _num(): JsonField<Long> = body._num()

    /**
     * Returns the raw JSON value of [topK].
     *
     * Unlike [topK], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _topK(): JsonField<Long> = body._topK()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): NamespaceRecallParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [NamespaceRecallParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceRecallParams]. */
    class Builder internal constructor() {

        private var namespace: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(namespaceRecallParams: NamespaceRecallParams) = apply {
            namespace = namespaceRecallParams.namespace
            body = namespaceRecallParams.body.toBuilder()
            additionalHeaders = namespaceRecallParams.additionalHeaders.toBuilder()
            additionalQueryParams = namespaceRecallParams.additionalQueryParams.toBuilder()
        }

        fun namespace(namespace: String?) = apply { this.namespace = namespace }

        /** Alias for calling [Builder.namespace] with `namespace.orElse(null)`. */
        fun namespace(namespace: Optional<String>) = namespace(namespace.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [filters]
         * - [includeGroundTruth]
         * - [num]
         * - [topK]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Filter by attributes. Same syntax as the query endpoint. */
        fun filters(filters: JsonValue) = apply { body.filters(filters) }

        /** Include ground truth data (query vectors and true nearest neighbors) in the response. */
        fun includeGroundTruth(includeGroundTruth: Boolean) = apply {
            body.includeGroundTruth(includeGroundTruth)
        }

        /**
         * Sets [Builder.includeGroundTruth] to an arbitrary JSON value.
         *
         * You should usually call [Builder.includeGroundTruth] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun includeGroundTruth(includeGroundTruth: JsonField<Boolean>) = apply {
            body.includeGroundTruth(includeGroundTruth)
        }

        /** The number of searches to run. */
        fun num(num: Long) = apply { body.num(num) }

        /**
         * Sets [Builder.num] to an arbitrary JSON value.
         *
         * You should usually call [Builder.num] with a well-typed [Long] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun num(num: JsonField<Long>) = apply { body.num(num) }

        /** Search for `top_k` nearest neighbors. */
        fun topK(topK: Long) = apply { body.topK(topK) }

        /**
         * Sets [Builder.topK] to an arbitrary JSON value.
         *
         * You should usually call [Builder.topK] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun topK(topK: JsonField<Long>) = apply { body.topK(topK) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [NamespaceRecallParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): NamespaceRecallParams =
            NamespaceRecallParams(
                namespace,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> namespace ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val filters: JsonValue,
        private val includeGroundTruth: JsonField<Boolean>,
        private val num: JsonField<Long>,
        private val topK: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("filters") @ExcludeMissing filters: JsonValue = JsonMissing.of(),
            @JsonProperty("include_ground_truth")
            @ExcludeMissing
            includeGroundTruth: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("num") @ExcludeMissing num: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("top_k") @ExcludeMissing topK: JsonField<Long> = JsonMissing.of(),
        ) : this(filters, includeGroundTruth, num, topK, mutableMapOf())

        /**
         * Filter by attributes. Same syntax as the query endpoint.
         *
         * This arbitrary value can be deserialized into a custom type using the `convert` method:
         * ```java
         * MyClass myObject = body.filters().convert(MyClass.class);
         * ```
         */
        @JsonProperty("filters") @ExcludeMissing fun _filters(): JsonValue = filters

        /**
         * Include ground truth data (query vectors and true nearest neighbors) in the response.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun includeGroundTruth(): Optional<Boolean> =
            includeGroundTruth.getOptional("include_ground_truth")

        /**
         * The number of searches to run.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun num(): Optional<Long> = num.getOptional("num")

        /**
         * Search for `top_k` nearest neighbors.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun topK(): Optional<Long> = topK.getOptional("top_k")

        /**
         * Returns the raw JSON value of [includeGroundTruth].
         *
         * Unlike [includeGroundTruth], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("include_ground_truth")
        @ExcludeMissing
        fun _includeGroundTruth(): JsonField<Boolean> = includeGroundTruth

        /**
         * Returns the raw JSON value of [num].
         *
         * Unlike [num], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("num") @ExcludeMissing fun _num(): JsonField<Long> = num

        /**
         * Returns the raw JSON value of [topK].
         *
         * Unlike [topK], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("top_k") @ExcludeMissing fun _topK(): JsonField<Long> = topK

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var filters: JsonValue = JsonMissing.of()
            private var includeGroundTruth: JsonField<Boolean> = JsonMissing.of()
            private var num: JsonField<Long> = JsonMissing.of()
            private var topK: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                filters = body.filters
                includeGroundTruth = body.includeGroundTruth
                num = body.num
                topK = body.topK
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Filter by attributes. Same syntax as the query endpoint. */
            fun filters(filters: JsonValue) = apply { this.filters = filters }

            /**
             * Include ground truth data (query vectors and true nearest neighbors) in the response.
             */
            fun includeGroundTruth(includeGroundTruth: Boolean) =
                includeGroundTruth(JsonField.of(includeGroundTruth))

            /**
             * Sets [Builder.includeGroundTruth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.includeGroundTruth] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun includeGroundTruth(includeGroundTruth: JsonField<Boolean>) = apply {
                this.includeGroundTruth = includeGroundTruth
            }

            /** The number of searches to run. */
            fun num(num: Long) = num(JsonField.of(num))

            /**
             * Sets [Builder.num] to an arbitrary JSON value.
             *
             * You should usually call [Builder.num] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun num(num: JsonField<Long>) = apply { this.num = num }

            /** Search for `top_k` nearest neighbors. */
            fun topK(topK: Long) = topK(JsonField.of(topK))

            /**
             * Sets [Builder.topK] to an arbitrary JSON value.
             *
             * You should usually call [Builder.topK] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun topK(topK: JsonField<Long>) = apply { this.topK = topK }

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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(filters, includeGroundTruth, num, topK, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            includeGroundTruth()
            num()
            topK()
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
        internal fun validity(): Int =
            (if (includeGroundTruth.asKnown().isPresent) 1 else 0) +
                (if (num.asKnown().isPresent) 1 else 0) +
                (if (topK.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                filters == other.filters &&
                includeGroundTruth == other.includeGroundTruth &&
                num == other.num &&
                topK == other.topK &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(filters, includeGroundTruth, num, topK, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{filters=$filters, includeGroundTruth=$includeGroundTruth, num=$num, topK=$topK, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is NamespaceRecallParams &&
            namespace == other.namespace &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(namespace, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "NamespaceRecallParams{namespace=$namespace, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
