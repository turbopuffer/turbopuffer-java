// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.BaseDeserializer
import com.turbopuffer.core.BaseSerializer
import com.turbopuffer.core.Enum
import com.turbopuffer.core.JsonField
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.allMaxBy
import com.turbopuffer.core.getOrThrow
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Objects
import java.util.Optional

/** The schema for an attribute attached to a document. */
@JsonDeserialize(using = AttributeSchema.Deserializer::class)
@JsonSerialize(using = AttributeSchema.Serializer::class)
class AttributeSchema
private constructor(
    private val string: String? = null,
    private val uint: Uint? = null,
    private val uuid: Uuid? = null,
    private val bool: Bool? = null,
    private val datetime: Datetime? = null,
    private val stringArray: StringArray? = null,
    private val uintArray: UintArray? = null,
    private val uuidArray: UuidArray? = null,
    private val datetimeArray: DatetimeArray? = null,
    private val vector: String? = null,
    private val config: AttributeSchemaConfig? = null,
    private val _json: JsonValue? = null,
) {

    /** A string. */
    fun string(): Optional<String> = Optional.ofNullable(string)

    /** An unsigned integer. */
    fun uint(): Optional<Uint> = Optional.ofNullable(uint)

    /** A UUID. */
    fun uuid(): Optional<Uuid> = Optional.ofNullable(uuid)

    /** A boolean. */
    fun bool(): Optional<Bool> = Optional.ofNullable(bool)

    /** A date and time. */
    fun datetime(): Optional<Datetime> = Optional.ofNullable(datetime)

    /** An array of strings. */
    fun stringArray(): Optional<StringArray> = Optional.ofNullable(stringArray)

    /** An array of unsigned integers. */
    fun uintArray(): Optional<UintArray> = Optional.ofNullable(uintArray)

    /** An array of UUIDs. */
    fun uuidArray(): Optional<UuidArray> = Optional.ofNullable(uuidArray)

    /** An array of date and time values. */
    fun datetimeArray(): Optional<DatetimeArray> = Optional.ofNullable(datetimeArray)

    /** A vector embedding of a specific dimensionality and element width. */
    fun vector(): Optional<String> = Optional.ofNullable(vector)

    /** Detailed configuration for an attribute attached to a document. */
    fun config(): Optional<AttributeSchemaConfig> = Optional.ofNullable(config)

    fun isString(): Boolean = string != null

    fun isUint(): Boolean = uint != null

    fun isUuid(): Boolean = uuid != null

    fun isBool(): Boolean = bool != null

    fun isDatetime(): Boolean = datetime != null

    fun isStringArray(): Boolean = stringArray != null

    fun isUintArray(): Boolean = uintArray != null

    fun isUuidArray(): Boolean = uuidArray != null

    fun isDatetimeArray(): Boolean = datetimeArray != null

    fun isVector(): Boolean = vector != null

    fun isConfig(): Boolean = config != null

    /** A string. */
    fun asString(): String = string.getOrThrow("string")

    /** An unsigned integer. */
    fun asUint(): Uint = uint.getOrThrow("uint")

    /** A UUID. */
    fun asUuid(): Uuid = uuid.getOrThrow("uuid")

    /** A boolean. */
    fun asBool(): Bool = bool.getOrThrow("bool")

    /** A date and time. */
    fun asDatetime(): Datetime = datetime.getOrThrow("datetime")

    /** An array of strings. */
    fun asStringArray(): StringArray = stringArray.getOrThrow("stringArray")

    /** An array of unsigned integers. */
    fun asUintArray(): UintArray = uintArray.getOrThrow("uintArray")

    /** An array of UUIDs. */
    fun asUuidArray(): UuidArray = uuidArray.getOrThrow("uuidArray")

    /** An array of date and time values. */
    fun asDatetimeArray(): DatetimeArray = datetimeArray.getOrThrow("datetimeArray")

    /** A vector embedding of a specific dimensionality and element width. */
    fun asVector(): String = vector.getOrThrow("vector")

    /** Detailed configuration for an attribute attached to a document. */
    fun asConfig(): AttributeSchemaConfig = config.getOrThrow("config")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            string != null -> visitor.visitString(string)
            uint != null -> visitor.visitUint(uint)
            uuid != null -> visitor.visitUuid(uuid)
            bool != null -> visitor.visitBool(bool)
            datetime != null -> visitor.visitDatetime(datetime)
            stringArray != null -> visitor.visitStringArray(stringArray)
            uintArray != null -> visitor.visitUintArray(uintArray)
            uuidArray != null -> visitor.visitUuidArray(uuidArray)
            datetimeArray != null -> visitor.visitDatetimeArray(datetimeArray)
            vector != null -> visitor.visitVector(vector)
            config != null -> visitor.visitConfig(config)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): AttributeSchema = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitString(string: String) {
                    string.validate()
                }

                override fun visitUint(uint: Uint) {
                    uint.validate()
                }

                override fun visitUuid(uuid: Uuid) {
                    uuid.validate()
                }

                override fun visitBool(bool: Bool) {
                    bool.validate()
                }

                override fun visitDatetime(datetime: Datetime) {
                    datetime.validate()
                }

                override fun visitStringArray(stringArray: StringArray) {
                    stringArray.validate()
                }

                override fun visitUintArray(uintArray: UintArray) {
                    uintArray.validate()
                }

                override fun visitUuidArray(uuidArray: UuidArray) {
                    uuidArray.validate()
                }

                override fun visitDatetimeArray(datetimeArray: DatetimeArray) {
                    datetimeArray.validate()
                }

                override fun visitVector(vector: String) {}

                override fun visitConfig(config: AttributeSchemaConfig) {
                    config.validate()
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
                override fun visitString(string: String) = string.validity()

                override fun visitUint(uint: Uint) = uint.validity()

                override fun visitUuid(uuid: Uuid) = uuid.validity()

                override fun visitBool(bool: Bool) = bool.validity()

                override fun visitDatetime(datetime: Datetime) = datetime.validity()

                override fun visitStringArray(stringArray: StringArray) = stringArray.validity()

                override fun visitUintArray(uintArray: UintArray) = uintArray.validity()

                override fun visitUuidArray(uuidArray: UuidArray) = uuidArray.validity()

                override fun visitDatetimeArray(datetimeArray: DatetimeArray) =
                    datetimeArray.validity()

                override fun visitVector(vector: String) = 1

                override fun visitConfig(config: AttributeSchemaConfig) = config.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AttributeSchema && string == other.string && uint == other.uint && uuid == other.uuid && bool == other.bool && datetime == other.datetime && stringArray == other.stringArray && uintArray == other.uintArray && uuidArray == other.uuidArray && datetimeArray == other.datetimeArray && vector == other.vector && config == other.config /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, uint, uuid, bool, datetime, stringArray, uintArray, uuidArray, datetimeArray, vector, config) /* spotless:on */

    override fun toString(): String =
        when {
            string != null -> "AttributeSchema{string=$string}"
            uint != null -> "AttributeSchema{uint=$uint}"
            uuid != null -> "AttributeSchema{uuid=$uuid}"
            bool != null -> "AttributeSchema{bool=$bool}"
            datetime != null -> "AttributeSchema{datetime=$datetime}"
            stringArray != null -> "AttributeSchema{stringArray=$stringArray}"
            uintArray != null -> "AttributeSchema{uintArray=$uintArray}"
            uuidArray != null -> "AttributeSchema{uuidArray=$uuidArray}"
            datetimeArray != null -> "AttributeSchema{datetimeArray=$datetimeArray}"
            vector != null -> "AttributeSchema{vector=$vector}"
            config != null -> "AttributeSchema{config=$config}"
            _json != null -> "AttributeSchema{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AttributeSchema")
        }

    companion object {

        /** A string. */
        @JvmStatic fun ofString(string: String) = AttributeSchema(string = string)

        /** An unsigned integer. */
        @JvmStatic fun ofUint(uint: Uint) = AttributeSchema(uint = uint)

        /** A UUID. */
        @JvmStatic fun ofUuid(uuid: Uuid) = AttributeSchema(uuid = uuid)

        /** A boolean. */
        @JvmStatic fun ofBool(bool: Bool) = AttributeSchema(bool = bool)

        /** A date and time. */
        @JvmStatic fun ofDatetime(datetime: Datetime) = AttributeSchema(datetime = datetime)

        /** An array of strings. */
        @JvmStatic
        fun ofStringArray(stringArray: StringArray) = AttributeSchema(stringArray = stringArray)

        /** An array of unsigned integers. */
        @JvmStatic fun ofUintArray(uintArray: UintArray) = AttributeSchema(uintArray = uintArray)

        /** An array of UUIDs. */
        @JvmStatic fun ofUuidArray(uuidArray: UuidArray) = AttributeSchema(uuidArray = uuidArray)

        /** An array of date and time values. */
        @JvmStatic
        fun ofDatetimeArray(datetimeArray: DatetimeArray) =
            AttributeSchema(datetimeArray = datetimeArray)

        /** A vector embedding of a specific dimensionality and element width. */
        @JvmStatic fun ofVector(vector: String) = AttributeSchema(vector = vector)

        /** Detailed configuration for an attribute attached to a document. */
        @JvmStatic fun ofConfig(config: AttributeSchemaConfig) = AttributeSchema(config = config)
    }

    /**
     * An interface that defines how to map each variant of [AttributeSchema] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** A string. */
        fun visitString(string: String): T

        /** An unsigned integer. */
        fun visitUint(uint: Uint): T

        /** A UUID. */
        fun visitUuid(uuid: Uuid): T

        /** A boolean. */
        fun visitBool(bool: Bool): T

        /** A date and time. */
        fun visitDatetime(datetime: Datetime): T

        /** An array of strings. */
        fun visitStringArray(stringArray: StringArray): T

        /** An array of unsigned integers. */
        fun visitUintArray(uintArray: UintArray): T

        /** An array of UUIDs. */
        fun visitUuidArray(uuidArray: UuidArray): T

        /** An array of date and time values. */
        fun visitDatetimeArray(datetimeArray: DatetimeArray): T

        /** A vector embedding of a specific dimensionality and element width. */
        fun visitVector(vector: String): T

        /** Detailed configuration for an attribute attached to a document. */
        fun visitConfig(config: AttributeSchemaConfig): T

        /**
         * Maps an unknown variant of [AttributeSchema] to a value of type [T].
         *
         * An instance of [AttributeSchema] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws TurbopufferInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw TurbopufferInvalidDataException("Unknown AttributeSchema: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<AttributeSchema>(AttributeSchema::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AttributeSchema {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            AttributeSchema(string = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<Uint>())?.let {
                            AttributeSchema(uint = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<Uuid>())?.let {
                            AttributeSchema(uuid = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<Bool>())?.let {
                            AttributeSchema(bool = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<Datetime>())?.let {
                            AttributeSchema(datetime = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<StringArray>())?.let {
                            AttributeSchema(stringArray = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<UintArray>())?.let {
                            AttributeSchema(uintArray = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<UuidArray>())?.let {
                            AttributeSchema(uuidArray = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<DatetimeArray>())?.let {
                            AttributeSchema(datetimeArray = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<AttributeSchemaConfig>())?.let {
                            AttributeSchema(config = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            AttributeSchema(vector = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from array).
                0 -> AttributeSchema(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<AttributeSchema>(AttributeSchema::class) {

        override fun serialize(
            value: AttributeSchema,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.string != null -> generator.writeObject(value.string)
                value.uint != null -> generator.writeObject(value.uint)
                value.uuid != null -> generator.writeObject(value.uuid)
                value.bool != null -> generator.writeObject(value.bool)
                value.datetime != null -> generator.writeObject(value.datetime)
                value.stringArray != null -> generator.writeObject(value.stringArray)
                value.uintArray != null -> generator.writeObject(value.uintArray)
                value.uuidArray != null -> generator.writeObject(value.uuidArray)
                value.datetimeArray != null -> generator.writeObject(value.datetimeArray)
                value.vector != null -> generator.writeObject(value.vector)
                value.config != null -> generator.writeObject(value.config)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AttributeSchema")
            }
        }
    }

    /** A string. */
    class String @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val STRING = of("string")

            @JvmStatic fun of(value: String) = String(JsonField.of(value))
        }

        /** An enum containing [String]'s known values. */
        enum class Known {
            STRING
        }

        /**
         * An enum containing [String]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [String] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            STRING,
            /** An enum member indicating that [String] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                STRING -> Value.STRING
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                STRING -> Known.STRING
                else -> throw TurbopufferInvalidDataException("Unknown String: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                TurbopufferInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): String = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is String && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** An unsigned integer. */
    class Uint @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val UINT = of("uint")

            @JvmStatic fun of(value: String) = Uint(JsonField.of(value))
        }

        /** An enum containing [Uint]'s known values. */
        enum class Known {
            UINT
        }

        /**
         * An enum containing [Uint]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Uint] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            UINT,
            /** An enum member indicating that [Uint] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                UINT -> Value.UINT
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                UINT -> Known.UINT
                else -> throw TurbopufferInvalidDataException("Unknown Uint: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                TurbopufferInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): Uint = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Uint && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** A UUID. */
    class Uuid @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val UUID = of("uuid")

            @JvmStatic fun of(value: String) = Uuid(JsonField.of(value))
        }

        /** An enum containing [Uuid]'s known values. */
        enum class Known {
            UUID
        }

        /**
         * An enum containing [Uuid]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Uuid] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            UUID,
            /** An enum member indicating that [Uuid] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                UUID -> Value.UUID
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                UUID -> Known.UUID
                else -> throw TurbopufferInvalidDataException("Unknown Uuid: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                TurbopufferInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): Uuid = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Uuid && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** A boolean. */
    class Bool @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val BOOL = of("bool")

            @JvmStatic fun of(value: String) = Bool(JsonField.of(value))
        }

        /** An enum containing [Bool]'s known values. */
        enum class Known {
            BOOL
        }

        /**
         * An enum containing [Bool]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Bool] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            BOOL,
            /** An enum member indicating that [Bool] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                BOOL -> Value.BOOL
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                BOOL -> Known.BOOL
                else -> throw TurbopufferInvalidDataException("Unknown Bool: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                TurbopufferInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): Bool = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Bool && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** A date and time. */
    class Datetime @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val DATETIME = of("datetime")

            @JvmStatic fun of(value: String) = Datetime(JsonField.of(value))
        }

        /** An enum containing [Datetime]'s known values. */
        enum class Known {
            DATETIME
        }

        /**
         * An enum containing [Datetime]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Datetime] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            DATETIME,
            /** An enum member indicating that [Datetime] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                DATETIME -> Value.DATETIME
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                DATETIME -> Known.DATETIME
                else -> throw TurbopufferInvalidDataException("Unknown Datetime: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                TurbopufferInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): Datetime = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Datetime && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** An array of strings. */
    class StringArray @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val STRING = of("[]string")

            @JvmStatic fun of(value: String) = StringArray(JsonField.of(value))
        }

        /** An enum containing [StringArray]'s known values. */
        enum class Known {
            STRING
        }

        /**
         * An enum containing [StringArray]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [StringArray] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            STRING,
            /**
             * An enum member indicating that [StringArray] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                STRING -> Value.STRING
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                STRING -> Known.STRING
                else -> throw TurbopufferInvalidDataException("Unknown StringArray: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                TurbopufferInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): StringArray = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is StringArray && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** An array of unsigned integers. */
    class UintArray @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val UINT = of("[]uint")

            @JvmStatic fun of(value: String) = UintArray(JsonField.of(value))
        }

        /** An enum containing [UintArray]'s known values. */
        enum class Known {
            UINT
        }

        /**
         * An enum containing [UintArray]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [UintArray] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            UINT,
            /**
             * An enum member indicating that [UintArray] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                UINT -> Value.UINT
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                UINT -> Known.UINT
                else -> throw TurbopufferInvalidDataException("Unknown UintArray: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                TurbopufferInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): UintArray = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is UintArray && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** An array of UUIDs. */
    class UuidArray @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val UUID = of("[]uuid")

            @JvmStatic fun of(value: String) = UuidArray(JsonField.of(value))
        }

        /** An enum containing [UuidArray]'s known values. */
        enum class Known {
            UUID
        }

        /**
         * An enum containing [UuidArray]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [UuidArray] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            UUID,
            /**
             * An enum member indicating that [UuidArray] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                UUID -> Value.UUID
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                UUID -> Known.UUID
                else -> throw TurbopufferInvalidDataException("Unknown UuidArray: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                TurbopufferInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): UuidArray = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is UuidArray && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** An array of date and time values. */
    class DatetimeArray @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val DATETIME = of("[]datetime")

            @JvmStatic fun of(value: String) = DatetimeArray(JsonField.of(value))
        }

        /** An enum containing [DatetimeArray]'s known values. */
        enum class Known {
            DATETIME
        }

        /**
         * An enum containing [DatetimeArray]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [DatetimeArray] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            DATETIME,
            /**
             * An enum member indicating that [DatetimeArray] was instantiated with an unknown
             * value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                DATETIME -> Value.DATETIME
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                DATETIME -> Known.DATETIME
                else -> throw TurbopufferInvalidDataException("Unknown DatetimeArray: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                TurbopufferInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): DatetimeArray = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is DatetimeArray && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }
}
