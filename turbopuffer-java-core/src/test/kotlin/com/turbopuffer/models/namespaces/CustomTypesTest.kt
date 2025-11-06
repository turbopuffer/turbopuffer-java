package com.turbopuffer.models.namespaces

import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient
import java.util.Optional
import java.util.Random
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomTypesTest {

    // We're not trying to exhaustively test JSON serialization of custom types
    // here. We're just doing a basic sanity check that these custom types have
    // usable toString() methods, which allows users to print/log/debug them.

    @Test
    fun filterToString() {
        val filter = Filter.and(Filter.eq("attr1", "value1"), Filter.eq("attr2", "value2"))
        assertThat(filter.toString())
            .isEqualTo("""["And",[["attr1","Eq","value1"],["attr2","Eq","value2"]]]""")
    }

    @Test
    fun rankByToString() {
        val rankBy = RankByText.product(2.0, RankByText.bm25("attr1", "quick brown fox"))
        assertThat(rankBy.toString())
            .isEqualTo("""["Product",2.0,["attr1","BM25","quick brown fox"]]""")
    }

    // Basic sanity check of the custom schema builder.
    @Test
    fun getSchema() {
        // If you introduce a new test that hits a real tpuf server, don't
        // copy/paste this block verbatim. Introduce a reusable class with a
        // setUp function that creates a new namespace and cleans it up after
        // the test. See: https://turbopuffer.com/docs/testing
        val tpuf = TurbopufferOkHttpClient.builder().fromEnv().region("gcp-us-central1").build()
        val rand = Random()
        val ns = tpuf.namespace(String.format("test-%016x%016x", rand.nextLong(), rand.nextLong()))

        // Create a basic namespace with a mildly interesting schema.
        ns.write(
            NamespaceWriteParams.builder()
                .addUpsertRow(
                    Row.builder().put("id", "b3ff34ea-87bb-469c-a854-9cb7e3713fc3").build()
                )
                .schema(
                    Schema.builder()
                        .put("id", AttributeSchemaConfig.builder().type("uuid").build())
                        .put(
                            "name",
                            AttributeSchemaConfig.builder().type("string").filterable(false).build(),
                        )
                        .put("age", AttributeSchemaConfig.builder().type("uint").build())
                        .build()
                )
                .build()
        )

        // Assert that when we fetch the schema from the server it matches what
        // we expect.
        val schema = ns.schema(NamespaceSchemaParams.builder().build())
        assertThat(schema.get("id")?.type()).isEqualTo("uuid")
        assertThat(schema.get("name")?.type()).isEqualTo("string")
        assertThat(schema.get("name")?.filterable()).isEqualTo(Optional.of(false))
        assertThat(schema.get("age")?.type()).isEqualTo("uint")
        assertThat(schema.get("age")?.filterable()).isEqualTo(Optional.of(true))
    }
}
