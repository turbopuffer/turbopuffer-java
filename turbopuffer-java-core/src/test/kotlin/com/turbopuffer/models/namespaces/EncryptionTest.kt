// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import com.turbopuffer.errors.TurbopufferInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class EncryptionTest {

    @Test
    fun ofCustomerManaged() {
        val customerManaged = Encryption.CustomerManaged.builder().keyName("key_name").build()

        val encryption = Encryption.ofCustomerManaged(customerManaged)

        assertThat(encryption.customerManaged()).contains(customerManaged)
        assertThat(encryption.default_()).isEmpty
    }

    @Test
    fun ofCustomerManagedRoundtrip() {
        val jsonMapper = jsonMapper()
        val encryption =
            Encryption.ofCustomerManaged(
                Encryption.CustomerManaged.builder().keyName("key_name").build()
            )

        val roundtrippedEncryption =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(encryption),
                jacksonTypeRef<Encryption>(),
            )

        assertThat(roundtrippedEncryption).isEqualTo(encryption)
    }

    @Test
    fun ofDefault() {
        val encryption = Encryption.ofDefault()

        assertThat(encryption.customerManaged()).isEmpty
        assertThat(encryption.default_()).contains(JsonValue.from(mapOf("mode" to "default")))
    }

    @Test
    fun ofDefaultRoundtrip() {
        val jsonMapper = jsonMapper()
        val encryption = Encryption.ofDefault()

        val roundtrippedEncryption =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(encryption),
                jacksonTypeRef<Encryption>(),
            )

        assertThat(roundtrippedEncryption).isEqualTo(encryption)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val encryption = jsonMapper().convertValue(testCase.value, jacksonTypeRef<Encryption>())

        val e = assertThrows<TurbopufferInvalidDataException> { encryption.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
