package com.turbopuffer.models.namespaces

import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ComputeAttributesTest {

    @Test
    fun serializesEveryVariant() {
        val jsonMapper = jsonMapper()

        // VectorDist: attr="vec", "VectorDist", vector=[0.5]
        val vectorDist: ComputeAttributes = ComputeAttributes.vectorDist("vec", listOf(0.5f))
        assertThat(jsonMapper.writeValueAsString(vectorDist))
            .isEqualTo("""["vec","VectorDist",[0.5]]""")

        // Highlight: "Highlight", attr="body"
        val highlight: ComputeAttributes = ComputeAttributes.highlight("body")
        assertThat(jsonMapper.writeValueAsString(highlight)).isEqualTo("""["Highlight","body"]""")

        // HighlightWithConfig: "Highlight", "body", config (empty)
        val highlightWithConfig: ComputeAttributes =
            ComputeAttributes.highlight("body", HighlightConfigParams.builder().build())
        assertThat(jsonMapper.writeValueAsString(highlightWithConfig))
            .isEqualTo("""["Highlight","body",{}]""")

        // Score / RankBy: ANN attr="vec", vector=[0.5]
        val rankBy: ComputeAttributes = RankBy.ann("vec", listOf(0.5f))
        assertThat(jsonMapper.writeValueAsString(rankBy)).isEqualTo("""["vec","ANN",[0.5]]""")
    }
}
