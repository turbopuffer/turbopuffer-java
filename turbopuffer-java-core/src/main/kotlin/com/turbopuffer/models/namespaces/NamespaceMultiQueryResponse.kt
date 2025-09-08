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

/** The result of a multi-query. */
class NamespaceMultiQueryResponse
private constructor(
    private val billing: JsonField<QueryBilling>,
    private val performance: JsonField<QueryPerformance>,
    private val results: JsonField<List<Result>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("billing")
        @ExcludeMissing
        billing: JsonField<QueryBilling> = JsonMissing.of(),
        @JsonProperty("performance")
        @ExcludeMissing
        performance: JsonField<QueryPerformance> = JsonMissing.of(),
        @JsonProperty("results") @ExcludeMissing results: JsonField<List<Result>> = JsonMissing.of(),
    ) : this(billing, performance, results, mutableMapOf())

    /**
     * The billing information for a query.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun billing(): QueryBilling = billing.getRequired("billing")

    /**
     * The performance information for a query.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun performance(): QueryPerformance = performance.getRequired("performance")

    /**
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun results(): List<Result> = results.getRequired("results")

    /**
     * Returns the raw JSON value of [billing].
     *
     * Unlike [billing], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("billing") @ExcludeMissing fun _billing(): JsonField<QueryBilling> = billing

    /**
     * Returns the raw JSON value of [performance].
     *
     * Unlike [performance], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("performance")
    @ExcludeMissing
    fun _performance(): JsonField<QueryPerformance> = performance

    /**
     * Returns the raw JSON value of [results].
     *
     * Unlike [results], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("results") @ExcludeMissing fun _results(): JsonField<List<Result>> = results

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
         * Returns a mutable builder for constructing an instance of [NamespaceMultiQueryResponse].
         *
         * The following fields are required:
         * ```java
         * .billing()
         * .performance()
         * .results()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceMultiQueryResponse]. */
    class Builder internal constructor() {

        private var billing: JsonField<QueryBilling>? = null
        private var performance: JsonField<QueryPerformance>? = null
        private var results: JsonField<MutableList<Result>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(namespaceMultiQueryResponse: NamespaceMultiQueryResponse) = apply {
            billing = namespaceMultiQueryResponse.billing
            performance = namespaceMultiQueryResponse.performance
            results = namespaceMultiQueryResponse.results.map { it.toMutableList() }
            additionalProperties = namespaceMultiQueryResponse.additionalProperties.toMutableMap()
        }

        /** The billing information for a query. */
        fun billing(billing: QueryBilling) = billing(JsonField.of(billing))

        /**
         * Sets [Builder.billing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.billing] with a well-typed [QueryBilling] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun billing(billing: JsonField<QueryBilling>) = apply { this.billing = billing }

        /** The performance information for a query. */
        fun performance(performance: QueryPerformance) = performance(JsonField.of(performance))

        /**
         * Sets [Builder.performance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.performance] with a well-typed [QueryPerformance] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun performance(performance: JsonField<QueryPerformance>) = apply {
            this.performance = performance
        }

        fun results(results: List<Result>) = results(JsonField.of(results))

        /**
         * Sets [Builder.results] to an arbitrary JSON value.
         *
         * You should usually call [Builder.results] with a well-typed `List<Result>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun results(results: JsonField<List<Result>>) = apply {
            this.results = results.map { it.toMutableList() }
        }

        /**
         * Adds a single [Result] to [results].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addResult(result: Result) = apply {
            results =
                (results ?: JsonField.of(mutableListOf())).also {
                    checkKnown("results", it).add(result)
                }
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
         * Returns an immutable instance of [NamespaceMultiQueryResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .billing()
         * .performance()
         * .results()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): NamespaceMultiQueryResponse =
            NamespaceMultiQueryResponse(
                checkRequired("billing", billing),
                checkRequired("performance", performance),
                checkRequired("results", results).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): NamespaceMultiQueryResponse = apply {
        if (validated) {
            return@apply
        }

        billing().validate()
        performance().validate()
        results().forEach { it.validate() }
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
            (results.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    class Result
    private constructor(
        private val aggregationGroups: JsonField<List<AggregationGroup>>,
        private val aggregations: JsonField<Aggregations>,
        private val rows: JsonField<List<Row>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("aggregation_groups")
            @ExcludeMissing
            aggregationGroups: JsonField<List<AggregationGroup>> = JsonMissing.of(),
            @JsonProperty("aggregations")
            @ExcludeMissing
            aggregations: JsonField<Aggregations> = JsonMissing.of(),
            @JsonProperty("rows") @ExcludeMissing rows: JsonField<List<Row>> = JsonMissing.of(),
        ) : this(aggregationGroups, aggregations, rows, mutableMapOf())

        /**
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun aggregationGroups(): Optional<List<AggregationGroup>> =
            aggregationGroups.getOptional("aggregation_groups")

        /**
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun aggregations(): Optional<Aggregations> = aggregations.getOptional("aggregations")

        /**
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun rows(): Optional<List<Row>> = rows.getOptional("rows")

        /**
         * Returns the raw JSON value of [aggregationGroups].
         *
         * Unlike [aggregationGroups], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("aggregation_groups")
        @ExcludeMissing
        fun _aggregationGroups(): JsonField<List<AggregationGroup>> = aggregationGroups

        /**
         * Returns the raw JSON value of [aggregations].
         *
         * Unlike [aggregations], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("aggregations")
        @ExcludeMissing
        fun _aggregations(): JsonField<Aggregations> = aggregations

        /**
         * Returns the raw JSON value of [rows].
         *
         * Unlike [rows], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("rows") @ExcludeMissing fun _rows(): JsonField<List<Row>> = rows

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

            /** Returns a mutable builder for constructing an instance of [Result]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Result]. */
        class Builder internal constructor() {

            private var aggregationGroups: JsonField<MutableList<AggregationGroup>>? = null
            private var aggregations: JsonField<Aggregations> = JsonMissing.of()
            private var rows: JsonField<MutableList<Row>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(result: Result) = apply {
                aggregationGroups = result.aggregationGroups.map { it.toMutableList() }
                aggregations = result.aggregations
                rows = result.rows.map { it.toMutableList() }
                additionalProperties = result.additionalProperties.toMutableMap()
            }

            fun aggregationGroups(aggregationGroups: List<AggregationGroup>) =
                aggregationGroups(JsonField.of(aggregationGroups))

            /**
             * Sets [Builder.aggregationGroups] to an arbitrary JSON value.
             *
             * You should usually call [Builder.aggregationGroups] with a well-typed
             * `List<AggregationGroup>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun aggregationGroups(aggregationGroups: JsonField<List<AggregationGroup>>) = apply {
                this.aggregationGroups = aggregationGroups.map { it.toMutableList() }
            }

            /**
             * Adds a single [AggregationGroup] to [aggregationGroups].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addAggregationGroup(aggregationGroup: AggregationGroup) = apply {
                aggregationGroups =
                    (aggregationGroups ?: JsonField.of(mutableListOf())).also {
                        checkKnown("aggregationGroups", it).add(aggregationGroup)
                    }
            }

            fun aggregations(aggregations: Aggregations) = aggregations(JsonField.of(aggregations))

            /**
             * Sets [Builder.aggregations] to an arbitrary JSON value.
             *
             * You should usually call [Builder.aggregations] with a well-typed [Aggregations] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun aggregations(aggregations: JsonField<Aggregations>) = apply {
                this.aggregations = aggregations
            }

            fun rows(rows: List<Row>) = rows(JsonField.of(rows))

            /**
             * Sets [Builder.rows] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rows] with a well-typed `List<Row>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun rows(rows: JsonField<List<Row>>) = apply {
                this.rows = rows.map { it.toMutableList() }
            }

            /**
             * Adds a single [Row] to [rows].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRow(row: Row) = apply {
                rows =
                    (rows ?: JsonField.of(mutableListOf())).also { checkKnown("rows", it).add(row) }
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
             * Returns an immutable instance of [Result].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Result =
                Result(
                    (aggregationGroups ?: JsonMissing.of()).map { it.toImmutable() },
                    aggregations,
                    (rows ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Result = apply {
            if (validated) {
                return@apply
            }

            aggregationGroups()
            aggregations().ifPresent { it.validate() }
            rows()
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
            (aggregationGroups.asKnown().getOrNull()?.size ?: 0) +
                (aggregations.asKnown().getOrNull()?.validity() ?: 0) +
                (rows.asKnown().getOrNull()?.size ?: 0)

        class Aggregations
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

                /** Returns a mutable builder for constructing an instance of [Aggregations]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Aggregations]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(aggregations: Aggregations) = apply {
                    additionalProperties = aggregations.additionalProperties.toMutableMap()
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Aggregations].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Aggregations = Aggregations(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): Aggregations = apply {
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

                return other is Aggregations && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Aggregations{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Result &&
                aggregationGroups == other.aggregationGroups &&
                aggregations == other.aggregations &&
                rows == other.rows &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(aggregationGroups, aggregations, rows, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Result{aggregationGroups=$aggregationGroups, aggregations=$aggregations, rows=$rows, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is NamespaceMultiQueryResponse &&
            billing == other.billing &&
            performance == other.performance &&
            results == other.results &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(billing, performance, results, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "NamespaceMultiQueryResponse{billing=$billing, performance=$performance, results=$results, additionalProperties=$additionalProperties}"
}
