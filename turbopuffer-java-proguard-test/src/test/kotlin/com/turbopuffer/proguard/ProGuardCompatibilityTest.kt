// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient
import com.turbopuffer.core.jsonMapper
import com.turbopuffer.models.NamespaceSummary
import com.turbopuffer.models.namespaces.DistanceMetric
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @BeforeAll
        @JvmStatic
        fun setUp() {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream("META-INF/proguard/turbopuffer-java-core.pro")

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client =
            TurbopufferOkHttpClient.builder().apiKey("tpuf_A1...").region("gcp-us-central1").build()

        assertThat(client).isNotNull()
        assertThat(client.namespace("test")).isNotNull()
    }

    @Test
    fun namespaceSummaryRoundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceSummary = NamespaceSummary.builder().id("id").build()

        val roundtrippedNamespaceSummary =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceSummary),
                jacksonTypeRef<NamespaceSummary>(),
            )

        assertThat(roundtrippedNamespaceSummary).isEqualTo(namespaceSummary)
    }

    @Test
    fun distanceMetricRoundtrip() {
        val jsonMapper = jsonMapper()
        val distanceMetric = DistanceMetric.COSINE_DISTANCE

        val roundtrippedDistanceMetric =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(distanceMetric),
                jacksonTypeRef<DistanceMetric>(),
            )

        assertThat(roundtrippedDistanceMetric).isEqualTo(distanceMetric)
    }
}
