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

/** The performance information for a query. */
class QueryPerformance
private constructor(
    private val approxNamespaceSize: JsonField<Long>,
    private val cacheHitRatio: JsonField<Double>,
    private val cacheTemperature: JsonField<String>,
    private val exhaustiveSearchCount: JsonField<Long>,
    private val queryExecutionMs: JsonField<Long>,
    private val serverTotalMs: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("approx_namespace_size")
        @ExcludeMissing
        approxNamespaceSize: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("cache_hit_ratio")
        @ExcludeMissing
        cacheHitRatio: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("cache_temperature")
        @ExcludeMissing
        cacheTemperature: JsonField<String> = JsonMissing.of(),
        @JsonProperty("exhaustive_search_count")
        @ExcludeMissing
        exhaustiveSearchCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("query_execution_ms")
        @ExcludeMissing
        queryExecutionMs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("server_total_ms")
        @ExcludeMissing
        serverTotalMs: JsonField<Long> = JsonMissing.of(),
    ) : this(
        approxNamespaceSize,
        cacheHitRatio,
        cacheTemperature,
        exhaustiveSearchCount,
        queryExecutionMs,
        serverTotalMs,
        mutableMapOf(),
    )

    /**
     * the approximate number of documents in the namespace.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun approxNamespaceSize(): Long = approxNamespaceSize.getRequired("approx_namespace_size")

    /**
     * The ratio of cache hits to total cache lookups.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun cacheHitRatio(): Double = cacheHitRatio.getRequired("cache_hit_ratio")

    /**
     * A qualitative description of the cache hit ratio (`hot`, `warm`, or `cold`).
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun cacheTemperature(): String = cacheTemperature.getRequired("cache_temperature")

    /**
     * The number of unindexed documents processed by the query.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun exhaustiveSearchCount(): Long = exhaustiveSearchCount.getRequired("exhaustive_search_count")

    /**
     * Request time measured on the server, excluding time spent waiting due to the namespace
     * concurrency limit.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun queryExecutionMs(): Long = queryExecutionMs.getRequired("query_execution_ms")

    /**
     * Request time measured on the server, including time spent waiting for other queries to
     * complete if the namespace was at its concurrency limit.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun serverTotalMs(): Long = serverTotalMs.getRequired("server_total_ms")

    /**
     * Returns the raw JSON value of [approxNamespaceSize].
     *
     * Unlike [approxNamespaceSize], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("approx_namespace_size")
    @ExcludeMissing
    fun _approxNamespaceSize(): JsonField<Long> = approxNamespaceSize

    /**
     * Returns the raw JSON value of [cacheHitRatio].
     *
     * Unlike [cacheHitRatio], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cache_hit_ratio")
    @ExcludeMissing
    fun _cacheHitRatio(): JsonField<Double> = cacheHitRatio

    /**
     * Returns the raw JSON value of [cacheTemperature].
     *
     * Unlike [cacheTemperature], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("cache_temperature")
    @ExcludeMissing
    fun _cacheTemperature(): JsonField<String> = cacheTemperature

    /**
     * Returns the raw JSON value of [exhaustiveSearchCount].
     *
     * Unlike [exhaustiveSearchCount], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("exhaustive_search_count")
    @ExcludeMissing
    fun _exhaustiveSearchCount(): JsonField<Long> = exhaustiveSearchCount

    /**
     * Returns the raw JSON value of [queryExecutionMs].
     *
     * Unlike [queryExecutionMs], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("query_execution_ms")
    @ExcludeMissing
    fun _queryExecutionMs(): JsonField<Long> = queryExecutionMs

    /**
     * Returns the raw JSON value of [serverTotalMs].
     *
     * Unlike [serverTotalMs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("server_total_ms")
    @ExcludeMissing
    fun _serverTotalMs(): JsonField<Long> = serverTotalMs

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
         * Returns a mutable builder for constructing an instance of [QueryPerformance].
         *
         * The following fields are required:
         * ```java
         * .approxNamespaceSize()
         * .cacheHitRatio()
         * .cacheTemperature()
         * .exhaustiveSearchCount()
         * .queryExecutionMs()
         * .serverTotalMs()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [QueryPerformance]. */
    class Builder internal constructor() {

        private var approxNamespaceSize: JsonField<Long>? = null
        private var cacheHitRatio: JsonField<Double>? = null
        private var cacheTemperature: JsonField<String>? = null
        private var exhaustiveSearchCount: JsonField<Long>? = null
        private var queryExecutionMs: JsonField<Long>? = null
        private var serverTotalMs: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(queryPerformance: QueryPerformance) = apply {
            approxNamespaceSize = queryPerformance.approxNamespaceSize
            cacheHitRatio = queryPerformance.cacheHitRatio
            cacheTemperature = queryPerformance.cacheTemperature
            exhaustiveSearchCount = queryPerformance.exhaustiveSearchCount
            queryExecutionMs = queryPerformance.queryExecutionMs
            serverTotalMs = queryPerformance.serverTotalMs
            additionalProperties = queryPerformance.additionalProperties.toMutableMap()
        }

        /** the approximate number of documents in the namespace. */
        fun approxNamespaceSize(approxNamespaceSize: Long) =
            approxNamespaceSize(JsonField.of(approxNamespaceSize))

        /**
         * Sets [Builder.approxNamespaceSize] to an arbitrary JSON value.
         *
         * You should usually call [Builder.approxNamespaceSize] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun approxNamespaceSize(approxNamespaceSize: JsonField<Long>) = apply {
            this.approxNamespaceSize = approxNamespaceSize
        }

        /** The ratio of cache hits to total cache lookups. */
        fun cacheHitRatio(cacheHitRatio: Double) = cacheHitRatio(JsonField.of(cacheHitRatio))

        /**
         * Sets [Builder.cacheHitRatio] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cacheHitRatio] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun cacheHitRatio(cacheHitRatio: JsonField<Double>) = apply {
            this.cacheHitRatio = cacheHitRatio
        }

        /** A qualitative description of the cache hit ratio (`hot`, `warm`, or `cold`). */
        fun cacheTemperature(cacheTemperature: String) =
            cacheTemperature(JsonField.of(cacheTemperature))

        /**
         * Sets [Builder.cacheTemperature] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cacheTemperature] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun cacheTemperature(cacheTemperature: JsonField<String>) = apply {
            this.cacheTemperature = cacheTemperature
        }

        /** The number of unindexed documents processed by the query. */
        fun exhaustiveSearchCount(exhaustiveSearchCount: Long) =
            exhaustiveSearchCount(JsonField.of(exhaustiveSearchCount))

        /**
         * Sets [Builder.exhaustiveSearchCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.exhaustiveSearchCount] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun exhaustiveSearchCount(exhaustiveSearchCount: JsonField<Long>) = apply {
            this.exhaustiveSearchCount = exhaustiveSearchCount
        }

        /**
         * Request time measured on the server, excluding time spent waiting due to the namespace
         * concurrency limit.
         */
        fun queryExecutionMs(queryExecutionMs: Long) =
            queryExecutionMs(JsonField.of(queryExecutionMs))

        /**
         * Sets [Builder.queryExecutionMs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.queryExecutionMs] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun queryExecutionMs(queryExecutionMs: JsonField<Long>) = apply {
            this.queryExecutionMs = queryExecutionMs
        }

        /**
         * Request time measured on the server, including time spent waiting for other queries to
         * complete if the namespace was at its concurrency limit.
         */
        fun serverTotalMs(serverTotalMs: Long) = serverTotalMs(JsonField.of(serverTotalMs))

        /**
         * Sets [Builder.serverTotalMs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.serverTotalMs] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun serverTotalMs(serverTotalMs: JsonField<Long>) = apply {
            this.serverTotalMs = serverTotalMs
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
         * Returns an immutable instance of [QueryPerformance].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .approxNamespaceSize()
         * .cacheHitRatio()
         * .cacheTemperature()
         * .exhaustiveSearchCount()
         * .queryExecutionMs()
         * .serverTotalMs()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): QueryPerformance =
            QueryPerformance(
                checkRequired("approxNamespaceSize", approxNamespaceSize),
                checkRequired("cacheHitRatio", cacheHitRatio),
                checkRequired("cacheTemperature", cacheTemperature),
                checkRequired("exhaustiveSearchCount", exhaustiveSearchCount),
                checkRequired("queryExecutionMs", queryExecutionMs),
                checkRequired("serverTotalMs", serverTotalMs),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): QueryPerformance = apply {
        if (validated) {
            return@apply
        }

        approxNamespaceSize()
        cacheHitRatio()
        cacheTemperature()
        exhaustiveSearchCount()
        queryExecutionMs()
        serverTotalMs()
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
        (if (approxNamespaceSize.asKnown().isPresent) 1 else 0) +
            (if (cacheHitRatio.asKnown().isPresent) 1 else 0) +
            (if (cacheTemperature.asKnown().isPresent) 1 else 0) +
            (if (exhaustiveSearchCount.asKnown().isPresent) 1 else 0) +
            (if (queryExecutionMs.asKnown().isPresent) 1 else 0) +
            (if (serverTotalMs.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is QueryPerformance &&
            approxNamespaceSize == other.approxNamespaceSize &&
            cacheHitRatio == other.cacheHitRatio &&
            cacheTemperature == other.cacheTemperature &&
            exhaustiveSearchCount == other.exhaustiveSearchCount &&
            queryExecutionMs == other.queryExecutionMs &&
            serverTotalMs == other.serverTotalMs &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            approxNamespaceSize,
            cacheHitRatio,
            cacheTemperature,
            exhaustiveSearchCount,
            queryExecutionMs,
            serverTotalMs,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "QueryPerformance{approxNamespaceSize=$approxNamespaceSize, cacheHitRatio=$cacheHitRatio, cacheTemperature=$cacheTemperature, exhaustiveSearchCount=$exhaustiveSearchCount, queryExecutionMs=$queryExecutionMs, serverTotalMs=$serverTotalMs, additionalProperties=$additionalProperties}"
}
