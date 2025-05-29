// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import com.turbopuffer.errors.TurbopufferInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class AttributeSchemaTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofString() {
        val string = AttributeSchema.String.STRING

        val attributeSchema = AttributeSchema.ofString(string)

        assertThat(attributeSchema.string()).contains(string)
        assertThat(attributeSchema.uint()).isEmpty
        assertThat(attributeSchema.uuid()).isEmpty
        assertThat(attributeSchema.bool()).isEmpty
        assertThat(attributeSchema.datetime()).isEmpty
        assertThat(attributeSchema.stringArray()).isEmpty
        assertThat(attributeSchema.uintArray()).isEmpty
        assertThat(attributeSchema.uuidArray()).isEmpty
        assertThat(attributeSchema.datetimeArray()).isEmpty
        assertThat(attributeSchema.vector()).isEmpty
        assertThat(attributeSchema.config()).isEmpty
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofStringRoundtrip() {
        val jsonMapper = jsonMapper()
        val attributeSchema = AttributeSchema.ofString(AttributeSchema.String.STRING)

        val roundtrippedAttributeSchema =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeSchema),
                jacksonTypeRef<AttributeSchema>(),
            )

        assertThat(roundtrippedAttributeSchema).isEqualTo(attributeSchema)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofUint() {
        val uint = AttributeSchema.Uint.UINT

        val attributeSchema = AttributeSchema.ofUint(uint)

        assertThat(attributeSchema.string()).isEmpty
        assertThat(attributeSchema.uint()).contains(uint)
        assertThat(attributeSchema.uuid()).isEmpty
        assertThat(attributeSchema.bool()).isEmpty
        assertThat(attributeSchema.datetime()).isEmpty
        assertThat(attributeSchema.stringArray()).isEmpty
        assertThat(attributeSchema.uintArray()).isEmpty
        assertThat(attributeSchema.uuidArray()).isEmpty
        assertThat(attributeSchema.datetimeArray()).isEmpty
        assertThat(attributeSchema.vector()).isEmpty
        assertThat(attributeSchema.config()).isEmpty
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofUintRoundtrip() {
        val jsonMapper = jsonMapper()
        val attributeSchema = AttributeSchema.ofUint(AttributeSchema.Uint.UINT)

        val roundtrippedAttributeSchema =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeSchema),
                jacksonTypeRef<AttributeSchema>(),
            )

        assertThat(roundtrippedAttributeSchema).isEqualTo(attributeSchema)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofUuid() {
        val uuid = AttributeSchema.Uuid.UUID

        val attributeSchema = AttributeSchema.ofUuid(uuid)

        assertThat(attributeSchema.string()).isEmpty
        assertThat(attributeSchema.uint()).isEmpty
        assertThat(attributeSchema.uuid()).contains(uuid)
        assertThat(attributeSchema.bool()).isEmpty
        assertThat(attributeSchema.datetime()).isEmpty
        assertThat(attributeSchema.stringArray()).isEmpty
        assertThat(attributeSchema.uintArray()).isEmpty
        assertThat(attributeSchema.uuidArray()).isEmpty
        assertThat(attributeSchema.datetimeArray()).isEmpty
        assertThat(attributeSchema.vector()).isEmpty
        assertThat(attributeSchema.config()).isEmpty
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofUuidRoundtrip() {
        val jsonMapper = jsonMapper()
        val attributeSchema = AttributeSchema.ofUuid(AttributeSchema.Uuid.UUID)

        val roundtrippedAttributeSchema =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeSchema),
                jacksonTypeRef<AttributeSchema>(),
            )

        assertThat(roundtrippedAttributeSchema).isEqualTo(attributeSchema)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofBool() {
        val bool = AttributeSchema.Bool.BOOL

        val attributeSchema = AttributeSchema.ofBool(bool)

        assertThat(attributeSchema.string()).isEmpty
        assertThat(attributeSchema.uint()).isEmpty
        assertThat(attributeSchema.uuid()).isEmpty
        assertThat(attributeSchema.bool()).contains(bool)
        assertThat(attributeSchema.datetime()).isEmpty
        assertThat(attributeSchema.stringArray()).isEmpty
        assertThat(attributeSchema.uintArray()).isEmpty
        assertThat(attributeSchema.uuidArray()).isEmpty
        assertThat(attributeSchema.datetimeArray()).isEmpty
        assertThat(attributeSchema.vector()).isEmpty
        assertThat(attributeSchema.config()).isEmpty
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofBoolRoundtrip() {
        val jsonMapper = jsonMapper()
        val attributeSchema = AttributeSchema.ofBool(AttributeSchema.Bool.BOOL)

        val roundtrippedAttributeSchema =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeSchema),
                jacksonTypeRef<AttributeSchema>(),
            )

        assertThat(roundtrippedAttributeSchema).isEqualTo(attributeSchema)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofDatetime() {
        val datetime = AttributeSchema.Datetime.DATETIME

        val attributeSchema = AttributeSchema.ofDatetime(datetime)

        assertThat(attributeSchema.string()).isEmpty
        assertThat(attributeSchema.uint()).isEmpty
        assertThat(attributeSchema.uuid()).isEmpty
        assertThat(attributeSchema.bool()).isEmpty
        assertThat(attributeSchema.datetime()).contains(datetime)
        assertThat(attributeSchema.stringArray()).isEmpty
        assertThat(attributeSchema.uintArray()).isEmpty
        assertThat(attributeSchema.uuidArray()).isEmpty
        assertThat(attributeSchema.datetimeArray()).isEmpty
        assertThat(attributeSchema.vector()).isEmpty
        assertThat(attributeSchema.config()).isEmpty
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofDatetimeRoundtrip() {
        val jsonMapper = jsonMapper()
        val attributeSchema = AttributeSchema.ofDatetime(AttributeSchema.Datetime.DATETIME)

        val roundtrippedAttributeSchema =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeSchema),
                jacksonTypeRef<AttributeSchema>(),
            )

        assertThat(roundtrippedAttributeSchema).isEqualTo(attributeSchema)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofStringArray() {
        val stringArray = AttributeSchema.StringArray.STRING

        val attributeSchema = AttributeSchema.ofStringArray(stringArray)

        assertThat(attributeSchema.string()).isEmpty
        assertThat(attributeSchema.uint()).isEmpty
        assertThat(attributeSchema.uuid()).isEmpty
        assertThat(attributeSchema.bool()).isEmpty
        assertThat(attributeSchema.datetime()).isEmpty
        assertThat(attributeSchema.stringArray()).contains(stringArray)
        assertThat(attributeSchema.uintArray()).isEmpty
        assertThat(attributeSchema.uuidArray()).isEmpty
        assertThat(attributeSchema.datetimeArray()).isEmpty
        assertThat(attributeSchema.vector()).isEmpty
        assertThat(attributeSchema.config()).isEmpty
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofStringArrayRoundtrip() {
        val jsonMapper = jsonMapper()
        val attributeSchema = AttributeSchema.ofStringArray(AttributeSchema.StringArray.STRING)

        val roundtrippedAttributeSchema =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeSchema),
                jacksonTypeRef<AttributeSchema>(),
            )

        assertThat(roundtrippedAttributeSchema).isEqualTo(attributeSchema)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofUintArray() {
        val uintArray = AttributeSchema.UintArray.UINT

        val attributeSchema = AttributeSchema.ofUintArray(uintArray)

        assertThat(attributeSchema.string()).isEmpty
        assertThat(attributeSchema.uint()).isEmpty
        assertThat(attributeSchema.uuid()).isEmpty
        assertThat(attributeSchema.bool()).isEmpty
        assertThat(attributeSchema.datetime()).isEmpty
        assertThat(attributeSchema.stringArray()).isEmpty
        assertThat(attributeSchema.uintArray()).contains(uintArray)
        assertThat(attributeSchema.uuidArray()).isEmpty
        assertThat(attributeSchema.datetimeArray()).isEmpty
        assertThat(attributeSchema.vector()).isEmpty
        assertThat(attributeSchema.config()).isEmpty
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofUintArrayRoundtrip() {
        val jsonMapper = jsonMapper()
        val attributeSchema = AttributeSchema.ofUintArray(AttributeSchema.UintArray.UINT)

        val roundtrippedAttributeSchema =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeSchema),
                jacksonTypeRef<AttributeSchema>(),
            )

        assertThat(roundtrippedAttributeSchema).isEqualTo(attributeSchema)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofUuidArray() {
        val uuidArray = AttributeSchema.UuidArray.UUID

        val attributeSchema = AttributeSchema.ofUuidArray(uuidArray)

        assertThat(attributeSchema.string()).isEmpty
        assertThat(attributeSchema.uint()).isEmpty
        assertThat(attributeSchema.uuid()).isEmpty
        assertThat(attributeSchema.bool()).isEmpty
        assertThat(attributeSchema.datetime()).isEmpty
        assertThat(attributeSchema.stringArray()).isEmpty
        assertThat(attributeSchema.uintArray()).isEmpty
        assertThat(attributeSchema.uuidArray()).contains(uuidArray)
        assertThat(attributeSchema.datetimeArray()).isEmpty
        assertThat(attributeSchema.vector()).isEmpty
        assertThat(attributeSchema.config()).isEmpty
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofUuidArrayRoundtrip() {
        val jsonMapper = jsonMapper()
        val attributeSchema = AttributeSchema.ofUuidArray(AttributeSchema.UuidArray.UUID)

        val roundtrippedAttributeSchema =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeSchema),
                jacksonTypeRef<AttributeSchema>(),
            )

        assertThat(roundtrippedAttributeSchema).isEqualTo(attributeSchema)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofDatetimeArray() {
        val datetimeArray = AttributeSchema.DatetimeArray.DATETIME

        val attributeSchema = AttributeSchema.ofDatetimeArray(datetimeArray)

        assertThat(attributeSchema.string()).isEmpty
        assertThat(attributeSchema.uint()).isEmpty
        assertThat(attributeSchema.uuid()).isEmpty
        assertThat(attributeSchema.bool()).isEmpty
        assertThat(attributeSchema.datetime()).isEmpty
        assertThat(attributeSchema.stringArray()).isEmpty
        assertThat(attributeSchema.uintArray()).isEmpty
        assertThat(attributeSchema.uuidArray()).isEmpty
        assertThat(attributeSchema.datetimeArray()).contains(datetimeArray)
        assertThat(attributeSchema.vector()).isEmpty
        assertThat(attributeSchema.config()).isEmpty
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofDatetimeArrayRoundtrip() {
        val jsonMapper = jsonMapper()
        val attributeSchema =
            AttributeSchema.ofDatetimeArray(AttributeSchema.DatetimeArray.DATETIME)

        val roundtrippedAttributeSchema =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeSchema),
                jacksonTypeRef<AttributeSchema>(),
            )

        assertThat(roundtrippedAttributeSchema).isEqualTo(attributeSchema)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofVector() {
        val vector = "[321669910225]f16"

        val attributeSchema = AttributeSchema.ofVector(vector)

        assertThat(attributeSchema.string()).isEmpty
        assertThat(attributeSchema.uint()).isEmpty
        assertThat(attributeSchema.uuid()).isEmpty
        assertThat(attributeSchema.bool()).isEmpty
        assertThat(attributeSchema.datetime()).isEmpty
        assertThat(attributeSchema.stringArray()).isEmpty
        assertThat(attributeSchema.uintArray()).isEmpty
        assertThat(attributeSchema.uuidArray()).isEmpty
        assertThat(attributeSchema.datetimeArray()).isEmpty
        assertThat(attributeSchema.vector()).contains(vector)
        assertThat(attributeSchema.config()).isEmpty
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofVectorRoundtrip() {
        val jsonMapper = jsonMapper()
        val attributeSchema = AttributeSchema.ofVector("[321669910225]f16")

        val roundtrippedAttributeSchema =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeSchema),
                jacksonTypeRef<AttributeSchema>(),
            )

        assertThat(roundtrippedAttributeSchema).isEqualTo(attributeSchema)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofConfig() {
        val config =
            AttributeSchemaConfig.builder()
                .ann(true)
                .filterable(true)
                .fullTextSearch(true)
                .type(AttributeType.STRING)
                .build()

        val attributeSchema = AttributeSchema.ofConfig(config)

        assertThat(attributeSchema.string()).isEmpty
        assertThat(attributeSchema.uint()).isEmpty
        assertThat(attributeSchema.uuid()).isEmpty
        assertThat(attributeSchema.bool()).isEmpty
        assertThat(attributeSchema.datetime()).isEmpty
        assertThat(attributeSchema.stringArray()).isEmpty
        assertThat(attributeSchema.uintArray()).isEmpty
        assertThat(attributeSchema.uuidArray()).isEmpty
        assertThat(attributeSchema.datetimeArray()).isEmpty
        assertThat(attributeSchema.vector()).isEmpty
        assertThat(attributeSchema.config()).contains(config)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofConfigRoundtrip() {
        val jsonMapper = jsonMapper()
        val attributeSchema =
            AttributeSchema.ofConfig(
                AttributeSchemaConfig.builder()
                    .ann(true)
                    .filterable(true)
                    .fullTextSearch(true)
                    .type(AttributeType.STRING)
                    .build()
            )

        val roundtrippedAttributeSchema =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeSchema),
                jacksonTypeRef<AttributeSchema>(),
            )

        assertThat(roundtrippedAttributeSchema).isEqualTo(attributeSchema)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun incompatibleJsonShapeDeserializesToUnknown() {
        val value = JsonValue.from(listOf("invalid", "array"))
        val attributeSchema = jsonMapper().convertValue(value, jacksonTypeRef<AttributeSchema>())

        val e = assertThrows<TurbopufferInvalidDataException> { attributeSchema.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
