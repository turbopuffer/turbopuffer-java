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
import com.turbopuffer.core.checkKnown
import com.turbopuffer.core.checkRequired
import com.turbopuffer.core.toImmutable
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The result of a query. */
class NamespaceQueryResponse
private constructor(
    private val billing: JsonField<Billing>,
    private val performance: JsonField<Performance>,
    private val aggregations: JsonField<List<Aggregation>>,
    private val rows: JsonField<List<DocumentRow>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("billing") @ExcludeMissing billing: JsonField<Billing> = JsonMissing.of(),
        @JsonProperty("performance")
        @ExcludeMissing
        performance: JsonField<Performance> = JsonMissing.of(),
        @JsonProperty("aggregations")
        @ExcludeMissing
        aggregations: JsonField<List<Aggregation>> = JsonMissing.of(),
        @JsonProperty("rows") @ExcludeMissing rows: JsonField<List<DocumentRow>> = JsonMissing.of(),
    ) : this(billing, performance, aggregations, rows, mutableMapOf())

    /**
     * The billing information for a query.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun billing(): Billing = billing.getRequired("billing")

    /**
     * The performance information for a query.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun performance(): Performance = performance.getRequired("performance")

    /**
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun aggregations(): Optional<List<Aggregation>> = aggregations.getOptional("aggregations")

    /**
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun rows(): Optional<List<DocumentRow>> = rows.getOptional("rows")

    /**
     * Returns the raw JSON value of [billing].
     *
     * Unlike [billing], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("billing") @ExcludeMissing fun _billing(): JsonField<Billing> = billing

    /**
     * Returns the raw JSON value of [performance].
     *
     * Unlike [performance], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("performance")
    @ExcludeMissing
    fun _performance(): JsonField<Performance> = performance

    /**
     * Returns the raw JSON value of [aggregations].
     *
     * Unlike [aggregations], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("aggregations")
    @ExcludeMissing
    fun _aggregations(): JsonField<List<Aggregation>> = aggregations

    /**
     * Returns the raw JSON value of [rows].
     *
     * Unlike [rows], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("rows") @ExcludeMissing fun _rows(): JsonField<List<DocumentRow>> = rows

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
         * Returns a mutable builder for constructing an instance of [NamespaceQueryResponse].
         *
         * The following fields are required:
         * ```java
         * .billing()
         * .performance()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceQueryResponse]. */
    class Builder internal constructor() {

        private var billing: JsonField<Billing>? = null
        private var performance: JsonField<Performance>? = null
        private var aggregations: JsonField<MutableList<Aggregation>>? = null
        private var rows: JsonField<MutableList<DocumentRow>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(namespaceQueryResponse: NamespaceQueryResponse) = apply {
            billing = namespaceQueryResponse.billing
            performance = namespaceQueryResponse.performance
            aggregations = namespaceQueryResponse.aggregations.map { it.toMutableList() }
            rows = namespaceQueryResponse.rows.map { it.toMutableList() }
            additionalProperties = namespaceQueryResponse.additionalProperties.toMutableMap()
        }

        /** The billing information for a query. */
        fun billing(billing: Billing) = billing(JsonField.of(billing))

        /**
         * Sets [Builder.billing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.billing] with a well-typed [Billing] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun billing(billing: JsonField<Billing>) = apply { this.billing = billing }

        /** The performance information for a query. */
        fun performance(performance: Performance) = performance(JsonField.of(performance))

        /**
         * Sets [Builder.performance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.performance] with a well-typed [Performance] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun performance(performance: JsonField<Performance>) = apply {
            this.performance = performance
        }

        fun aggregations(aggregations: List<Aggregation>) = aggregations(JsonField.of(aggregations))

        /**
         * Sets [Builder.aggregations] to an arbitrary JSON value.
         *
         * You should usually call [Builder.aggregations] with a well-typed `List<Aggregation>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun aggregations(aggregations: JsonField<List<Aggregation>>) = apply {
            this.aggregations = aggregations.map { it.toMutableList() }
        }

        /**
         * Adds a single [Aggregation] to [aggregations].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAggregation(aggregation: Aggregation) = apply {
            aggregations =
                (aggregations ?: JsonField.of(mutableListOf())).also {
                    checkKnown("aggregations", it).add(aggregation)
                }
        }

        fun rows(rows: List<DocumentRow>) = rows(JsonField.of(rows))

        /**
         * Sets [Builder.rows] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rows] with a well-typed `List<DocumentRow>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun rows(rows: JsonField<List<DocumentRow>>) = apply {
            this.rows = rows.map { it.toMutableList() }
        }

        /**
         * Adds a single [DocumentRow] to [rows].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRow(row: DocumentRow) = apply {
            rows = (rows ?: JsonField.of(mutableListOf())).also { checkKnown("rows", it).add(row) }
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
         * Returns an immutable instance of [NamespaceQueryResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .billing()
         * .performance()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): NamespaceQueryResponse =
            NamespaceQueryResponse(
                checkRequired("billing", billing),
                checkRequired("performance", performance),
                (aggregations ?: JsonMissing.of()).map { it.toImmutable() },
                (rows ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): NamespaceQueryResponse = apply {
        if (validated) {
            return@apply
        }

        billing().validate()
        performance().validate()
        aggregations().ifPresent { it.forEach { it.validate() } }
        rows().ifPresent { it.forEach { it.validate() } }
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
        (billing.asKnown().getOrNull()?.validity() ?: 0) +
            (performance.asKnown().getOrNull()?.validity() ?: 0) +
            (aggregations.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (rows.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /** The billing information for a query. */
    class Billing
    private constructor(
        private val billableLogicalBytesQueried: JsonField<Long>,
        private val billableLogicalBytesReturned: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("billable_logical_bytes_queried")
            @ExcludeMissing
            billableLogicalBytesQueried: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("billable_logical_bytes_returned")
            @ExcludeMissing
            billableLogicalBytesReturned: JsonField<Long> = JsonMissing.of(),
        ) : this(billableLogicalBytesQueried, billableLogicalBytesReturned, mutableMapOf())

        /**
         * The number of billable logical bytes queried from the namespace.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun billableLogicalBytesQueried(): Long =
            billableLogicalBytesQueried.getRequired("billable_logical_bytes_queried")

        /**
         * The number of billable logical bytes returned from the query.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun billableLogicalBytesReturned(): Long =
            billableLogicalBytesReturned.getRequired("billable_logical_bytes_returned")

        /**
         * Returns the raw JSON value of [billableLogicalBytesQueried].
         *
         * Unlike [billableLogicalBytesQueried], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("billable_logical_bytes_queried")
        @ExcludeMissing
        fun _billableLogicalBytesQueried(): JsonField<Long> = billableLogicalBytesQueried

        /**
         * Returns the raw JSON value of [billableLogicalBytesReturned].
         *
         * Unlike [billableLogicalBytesReturned], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("billable_logical_bytes_returned")
        @ExcludeMissing
        fun _billableLogicalBytesReturned(): JsonField<Long> = billableLogicalBytesReturned

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
             * Returns a mutable builder for constructing an instance of [Billing].
             *
             * The following fields are required:
             * ```java
             * .billableLogicalBytesQueried()
             * .billableLogicalBytesReturned()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Billing]. */
        class Builder internal constructor() {

            private var billableLogicalBytesQueried: JsonField<Long>? = null
            private var billableLogicalBytesReturned: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(billing: Billing) = apply {
                billableLogicalBytesQueried = billing.billableLogicalBytesQueried
                billableLogicalBytesReturned = billing.billableLogicalBytesReturned
                additionalProperties = billing.additionalProperties.toMutableMap()
            }

            /** The number of billable logical bytes queried from the namespace. */
            fun billableLogicalBytesQueried(billableLogicalBytesQueried: Long) =
                billableLogicalBytesQueried(JsonField.of(billableLogicalBytesQueried))

            /**
             * Sets [Builder.billableLogicalBytesQueried] to an arbitrary JSON value.
             *
             * You should usually call [Builder.billableLogicalBytesQueried] with a well-typed
             * [Long] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun billableLogicalBytesQueried(billableLogicalBytesQueried: JsonField<Long>) = apply {
                this.billableLogicalBytesQueried = billableLogicalBytesQueried
            }

            /** The number of billable logical bytes returned from the query. */
            fun billableLogicalBytesReturned(billableLogicalBytesReturned: Long) =
                billableLogicalBytesReturned(JsonField.of(billableLogicalBytesReturned))

            /**
             * Sets [Builder.billableLogicalBytesReturned] to an arbitrary JSON value.
             *
             * You should usually call [Builder.billableLogicalBytesReturned] with a well-typed
             * [Long] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun billableLogicalBytesReturned(billableLogicalBytesReturned: JsonField<Long>) =
                apply {
                    this.billableLogicalBytesReturned = billableLogicalBytesReturned
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
             * Returns an immutable instance of [Billing].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .billableLogicalBytesQueried()
             * .billableLogicalBytesReturned()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Billing =
                Billing(
                    checkRequired("billableLogicalBytesQueried", billableLogicalBytesQueried),
                    checkRequired("billableLogicalBytesReturned", billableLogicalBytesReturned),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Billing = apply {
            if (validated) {
                return@apply
            }

            billableLogicalBytesQueried()
            billableLogicalBytesReturned()
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
            (if (billableLogicalBytesQueried.asKnown().isPresent) 1 else 0) +
                (if (billableLogicalBytesReturned.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Billing && billableLogicalBytesQueried == other.billableLogicalBytesQueried && billableLogicalBytesReturned == other.billableLogicalBytesReturned && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(billableLogicalBytesQueried, billableLogicalBytesReturned, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Billing{billableLogicalBytesQueried=$billableLogicalBytesQueried, billableLogicalBytesReturned=$billableLogicalBytesReturned, additionalProperties=$additionalProperties}"
    }

    /** The performance information for a query. */
    class Performance
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
        fun exhaustiveSearchCount(): Long =
            exhaustiveSearchCount.getRequired("exhaustive_search_count")

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
         * Unlike [approxNamespaceSize], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("approx_namespace_size")
        @ExcludeMissing
        fun _approxNamespaceSize(): JsonField<Long> = approxNamespaceSize

        /**
         * Returns the raw JSON value of [cacheHitRatio].
         *
         * Unlike [cacheHitRatio], this method doesn't throw if the JSON field has an unexpected
         * type.
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
         * Unlike [exhaustiveSearchCount], this method doesn't throw if the JSON field has an
         * unexpected type.
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
         * Unlike [serverTotalMs], this method doesn't throw if the JSON field has an unexpected
         * type.
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
             * Returns a mutable builder for constructing an instance of [Performance].
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

        /** A builder for [Performance]. */
        class Builder internal constructor() {

            private var approxNamespaceSize: JsonField<Long>? = null
            private var cacheHitRatio: JsonField<Double>? = null
            private var cacheTemperature: JsonField<String>? = null
            private var exhaustiveSearchCount: JsonField<Long>? = null
            private var queryExecutionMs: JsonField<Long>? = null
            private var serverTotalMs: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(performance: Performance) = apply {
                approxNamespaceSize = performance.approxNamespaceSize
                cacheHitRatio = performance.cacheHitRatio
                cacheTemperature = performance.cacheTemperature
                exhaustiveSearchCount = performance.exhaustiveSearchCount
                queryExecutionMs = performance.queryExecutionMs
                serverTotalMs = performance.serverTotalMs
                additionalProperties = performance.additionalProperties.toMutableMap()
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
             * You should usually call [Builder.cacheHitRatio] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * You should usually call [Builder.exhaustiveSearchCount] with a well-typed [Long]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun exhaustiveSearchCount(exhaustiveSearchCount: JsonField<Long>) = apply {
                this.exhaustiveSearchCount = exhaustiveSearchCount
            }

            /**
             * Request time measured on the server, excluding time spent waiting due to the
             * namespace concurrency limit.
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
             * Request time measured on the server, including time spent waiting for other queries
             * to complete if the namespace was at its concurrency limit.
             */
            fun serverTotalMs(serverTotalMs: Long) = serverTotalMs(JsonField.of(serverTotalMs))

            /**
             * Sets [Builder.serverTotalMs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.serverTotalMs] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Returns an immutable instance of [Performance].
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
            fun build(): Performance =
                Performance(
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

        fun validate(): Performance = apply {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
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

            return /* spotless:off */ other is Performance && approxNamespaceSize == other.approxNamespaceSize && cacheHitRatio == other.cacheHitRatio && cacheTemperature == other.cacheTemperature && exhaustiveSearchCount == other.exhaustiveSearchCount && queryExecutionMs == other.queryExecutionMs && serverTotalMs == other.serverTotalMs && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(approxNamespaceSize, cacheHitRatio, cacheTemperature, exhaustiveSearchCount, queryExecutionMs, serverTotalMs, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Performance{approxNamespaceSize=$approxNamespaceSize, cacheHitRatio=$cacheHitRatio, cacheTemperature=$cacheTemperature, exhaustiveSearchCount=$exhaustiveSearchCount, queryExecutionMs=$queryExecutionMs, serverTotalMs=$serverTotalMs, additionalProperties=$additionalProperties}"
    }

    class Aggregation
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Aggregation]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Aggregation]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(aggregation: Aggregation) = apply {
                additionalProperties = aggregation.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Aggregation].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Aggregation = Aggregation(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Aggregation = apply {
            if (validated) {
                return@apply
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Aggregation && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Aggregation{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is NamespaceQueryResponse && billing == other.billing && performance == other.performance && aggregations == other.aggregations && rows == other.rows && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(billing, performance, aggregations, rows, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "NamespaceQueryResponse{billing=$billing, performance=$performance, aggregations=$aggregations, rows=$rows, additionalProperties=$additionalProperties}"
}
