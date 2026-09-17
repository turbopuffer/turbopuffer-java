// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.BaseDeserializer
import com.turbopuffer.core.BaseSerializer
import com.turbopuffer.core.ExcludeMissing
import com.turbopuffer.core.JsonField
import com.turbopuffer.core.JsonMissing
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.checkRequired
import com.turbopuffer.core.getOrThrow
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The current status of a copy operation. */
@JsonDeserialize(using = CopyFromNamespaceOperation.Deserializer::class)
@JsonSerialize(using = CopyFromNamespaceOperation.Serializer::class)
class CopyFromNamespaceOperation
private constructor(
    private val running: Running? = null,
    private val finished: Finished? = null,
    private val _json: JsonValue? = null,
) {

    fun running(): Optional<Running> = Optional.ofNullable(running)

    fun finished(): Optional<Finished> = Optional.ofNullable(finished)

    fun isRunning(): Boolean = running != null

    fun isFinished(): Boolean = finished != null

    fun asRunning(): Running = running.getOrThrow("running")

    fun asFinished(): Finished = finished.getOrThrow("finished")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.turbopuffer.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = copyFromNamespaceOperation.accept(new CopyFromNamespaceOperation.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitRunning(Running running) {
     *         return Optional.of(running.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws TurbopufferInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
     *   and the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            running != null -> visitor.visitRunning(running)
            finished != null -> visitor.visitFinished(finished)
            else -> visitor.unknown(_json)
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
    fun validate(): CopyFromNamespaceOperation = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitRunning(running: Running) {
                    running.validate()
                }

                override fun visitFinished(finished: Finished) {
                    finished.validate()
                }
            }
        )
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
        accept(
            object : Visitor<Int> {
                override fun visitRunning(running: Running) = running.validity()

                override fun visitFinished(finished: Finished) = finished.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CopyFromNamespaceOperation &&
            running == other.running &&
            finished == other.finished
    }

    override fun hashCode(): Int = Objects.hash(running, finished)

    override fun toString(): String =
        when {
            running != null -> "CopyFromNamespaceOperation{running=$running}"
            finished != null -> "CopyFromNamespaceOperation{finished=$finished}"
            _json != null -> "CopyFromNamespaceOperation{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid CopyFromNamespaceOperation")
        }

    companion object {

        @JvmStatic fun ofRunning(running: Running) = CopyFromNamespaceOperation(running = running)

        @JvmStatic
        fun ofFinished(finished: Finished) = CopyFromNamespaceOperation(finished = finished)
    }

    /**
     * An interface that defines how to map each variant of [CopyFromNamespaceOperation] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        fun visitRunning(running: Running): T

        fun visitFinished(finished: Finished): T

        /**
         * Maps an unknown variant of [CopyFromNamespaceOperation] to a value of type [T].
         *
         * An instance of [CopyFromNamespaceOperation] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws TurbopufferInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw TurbopufferInvalidDataException("Unknown CopyFromNamespaceOperation: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<CopyFromNamespaceOperation>(CopyFromNamespaceOperation::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): CopyFromNamespaceOperation {
            val json = JsonValue.fromJsonNode(node)
            val status = json.asObject().getOrNull()?.get("status")?.asString()?.getOrNull()

            when (status) {
                "running" -> {
                    return tryDeserialize(node, jacksonTypeRef<Running>())?.let {
                        CopyFromNamespaceOperation(running = it, _json = json)
                    } ?: CopyFromNamespaceOperation(_json = json)
                }
                "finished" -> {
                    return tryDeserialize(node, jacksonTypeRef<Finished>())?.let {
                        CopyFromNamespaceOperation(finished = it, _json = json)
                    } ?: CopyFromNamespaceOperation(_json = json)
                }
            }

            return CopyFromNamespaceOperation(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<CopyFromNamespaceOperation>(CopyFromNamespaceOperation::class) {

        override fun serialize(
            value: CopyFromNamespaceOperation,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.running != null -> generator.writeObject(value.running)
                value.finished != null -> generator.writeObject(value.finished)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid CopyFromNamespaceOperation")
            }
        }
    }

    class Running
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val startTime: JsonField<OffsetDateTime>,
        private val status: JsonValue,
        private val progress: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("start_time")
            @ExcludeMissing
            startTime: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonValue = JsonMissing.of(),
            @JsonProperty("progress") @ExcludeMissing progress: JsonField<String> = JsonMissing.of(),
        ) : this(startTime, status, progress, mutableMapOf())

        /**
         * The time at which the operation started.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun startTime(): OffsetDateTime = startTime.getRequired("start_time")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("running")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonValue = status

        /**
         * A freeform description of the operation's progress. May be absent, and its format may
         * change.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun progress(): Optional<String> = progress.getOptional("progress")

        /**
         * Returns the raw JSON value of [startTime].
         *
         * Unlike [startTime], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("start_time")
        @ExcludeMissing
        fun _startTime(): JsonField<OffsetDateTime> = startTime

        /**
         * Returns the raw JSON value of [progress].
         *
         * Unlike [progress], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("progress") @ExcludeMissing fun _progress(): JsonField<String> = progress

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
             * Returns a mutable builder for constructing an instance of [Running].
             *
             * The following fields are required:
             * ```java
             * .startTime()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Running]. */
        class Builder internal constructor() {

            private var startTime: JsonField<OffsetDateTime>? = null
            private var status: JsonValue = JsonValue.from("running")
            private var progress: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(running: Running) = apply {
                startTime = running.startTime
                status = running.status
                progress = running.progress
                additionalProperties = running.additionalProperties.toMutableMap()
            }

            /** The time at which the operation started. */
            fun startTime(startTime: OffsetDateTime) = startTime(JsonField.of(startTime))

            /**
             * Sets [Builder.startTime] to an arbitrary JSON value.
             *
             * You should usually call [Builder.startTime] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun startTime(startTime: JsonField<OffsetDateTime>) = apply {
                this.startTime = startTime
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("running")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonValue) = apply { this.status = status }

            /**
             * A freeform description of the operation's progress. May be absent, and its format may
             * change.
             */
            fun progress(progress: String) = progress(JsonField.of(progress))

            /**
             * Sets [Builder.progress] to an arbitrary JSON value.
             *
             * You should usually call [Builder.progress] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun progress(progress: JsonField<String>) = apply { this.progress = progress }

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
             * Returns an immutable instance of [Running].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .startTime()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Running =
                Running(
                    checkRequired("startTime", startTime),
                    status,
                    progress,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws TurbopufferInvalidDataException if any value type in this object doesn't match
         *   its expected type.
         */
        fun validate(): Running = apply {
            if (validated) {
                return@apply
            }

            startTime()
            _status().let {
                if (it != JsonValue.from("running")) {
                    throw TurbopufferInvalidDataException("'status' is invalid, received $it")
                }
            }
            progress()
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
            (if (startTime.asKnown().isPresent) 1 else 0) +
                status.let { if (it == JsonValue.from("running")) 1 else 0 } +
                (if (progress.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Running &&
                startTime == other.startTime &&
                status == other.status &&
                progress == other.progress &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(startTime, status, progress, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Running{startTime=$startTime, status=$status, progress=$progress, additionalProperties=$additionalProperties}"
    }

    class Finished
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val finishTime: JsonField<OffsetDateTime>,
        private val result: JsonField<CopyFromNamespaceOperationResult>,
        private val startTime: JsonField<OffsetDateTime>,
        private val status: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("finish_time")
            @ExcludeMissing
            finishTime: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("result")
            @ExcludeMissing
            result: JsonField<CopyFromNamespaceOperationResult> = JsonMissing.of(),
            @JsonProperty("start_time")
            @ExcludeMissing
            startTime: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonValue = JsonMissing.of(),
        ) : this(finishTime, result, startTime, status, mutableMapOf())

        /**
         * The time at which the operation finished.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun finishTime(): OffsetDateTime = finishTime.getRequired("finish_time")

        /**
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun result(): CopyFromNamespaceOperationResult = result.getRequired("result")

        /**
         * The time at which the operation started.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun startTime(): OffsetDateTime = startTime.getRequired("start_time")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("finished")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonValue = status

        /**
         * Returns the raw JSON value of [finishTime].
         *
         * Unlike [finishTime], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("finish_time")
        @ExcludeMissing
        fun _finishTime(): JsonField<OffsetDateTime> = finishTime

        /**
         * Returns the raw JSON value of [result].
         *
         * Unlike [result], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("result")
        @ExcludeMissing
        fun _result(): JsonField<CopyFromNamespaceOperationResult> = result

        /**
         * Returns the raw JSON value of [startTime].
         *
         * Unlike [startTime], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("start_time")
        @ExcludeMissing
        fun _startTime(): JsonField<OffsetDateTime> = startTime

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
             * Returns a mutable builder for constructing an instance of [Finished].
             *
             * The following fields are required:
             * ```java
             * .finishTime()
             * .result()
             * .startTime()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Finished]. */
        class Builder internal constructor() {

            private var finishTime: JsonField<OffsetDateTime>? = null
            private var result: JsonField<CopyFromNamespaceOperationResult>? = null
            private var startTime: JsonField<OffsetDateTime>? = null
            private var status: JsonValue = JsonValue.from("finished")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(finished: Finished) = apply {
                finishTime = finished.finishTime
                result = finished.result
                startTime = finished.startTime
                status = finished.status
                additionalProperties = finished.additionalProperties.toMutableMap()
            }

            /** The time at which the operation finished. */
            fun finishTime(finishTime: OffsetDateTime) = finishTime(JsonField.of(finishTime))

            /**
             * Sets [Builder.finishTime] to an arbitrary JSON value.
             *
             * You should usually call [Builder.finishTime] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun finishTime(finishTime: JsonField<OffsetDateTime>) = apply {
                this.finishTime = finishTime
            }

            fun result(result: CopyFromNamespaceOperationResult) = result(JsonField.of(result))

            /**
             * Sets [Builder.result] to an arbitrary JSON value.
             *
             * You should usually call [Builder.result] with a well-typed
             * [CopyFromNamespaceOperationResult] value instead. This method is primarily for
             * setting the field to an undocumented or not yet supported value.
             */
            fun result(result: JsonField<CopyFromNamespaceOperationResult>) = apply {
                this.result = result
            }

            /**
             * Alias for calling [result] with
             * `CopyFromNamespaceOperationResult.ofSuccess(success)`.
             */
            fun result(success: CopyFromNamespaceOperationResult.Success) =
                result(CopyFromNamespaceOperationResult.ofSuccess(success))

            /**
             * Alias for calling [result] with `CopyFromNamespaceOperationResult.ofError(error)`.
             */
            fun result(error: CopyFromNamespaceOperationResult.Error) =
                result(CopyFromNamespaceOperationResult.ofError(error))

            /** The time at which the operation started. */
            fun startTime(startTime: OffsetDateTime) = startTime(JsonField.of(startTime))

            /**
             * Sets [Builder.startTime] to an arbitrary JSON value.
             *
             * You should usually call [Builder.startTime] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun startTime(startTime: JsonField<OffsetDateTime>) = apply {
                this.startTime = startTime
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("finished")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonValue) = apply { this.status = status }

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
             * Returns an immutable instance of [Finished].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .finishTime()
             * .result()
             * .startTime()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Finished =
                Finished(
                    checkRequired("finishTime", finishTime),
                    checkRequired("result", result),
                    checkRequired("startTime", startTime),
                    status,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws TurbopufferInvalidDataException if any value type in this object doesn't match
         *   its expected type.
         */
        fun validate(): Finished = apply {
            if (validated) {
                return@apply
            }

            finishTime()
            result().validate()
            startTime()
            _status().let {
                if (it != JsonValue.from("finished")) {
                    throw TurbopufferInvalidDataException("'status' is invalid, received $it")
                }
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
            (if (finishTime.asKnown().isPresent) 1 else 0) +
                (result.asKnown().getOrNull()?.validity() ?: 0) +
                (if (startTime.asKnown().isPresent) 1 else 0) +
                status.let { if (it == JsonValue.from("finished")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Finished &&
                finishTime == other.finishTime &&
                result == other.result &&
                startTime == other.startTime &&
                status == other.status &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(finishTime, result, startTime, status, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Finished{finishTime=$finishTime, result=$result, startTime=$startTime, status=$status, additionalProperties=$additionalProperties}"
    }
}
