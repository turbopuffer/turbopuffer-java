// A straightforward example of storing and retrieving documents via vector
// similarity search.
//
// Run this example with: ./gradlew run -Pcom.turbopuffer.example=WriteAndQuery
package com.turbopuffer.example;

import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;
import com.turbopuffer.core.JsonValue;
import com.turbopuffer.errors.NotFoundException;
import com.turbopuffer.models.namespaces.AttributeSchemaConfig;
import com.turbopuffer.models.namespaces.DistanceMetric;
import com.turbopuffer.models.namespaces.Filter;
import com.turbopuffer.models.namespaces.NamespaceDeleteAllParams;
import com.turbopuffer.models.namespaces.NamespaceQueryParams;
import com.turbopuffer.models.namespaces.NamespaceSchemaParams;
import com.turbopuffer.models.namespaces.NamespaceWriteParams;
import com.turbopuffer.models.namespaces.RankBy;
import com.turbopuffer.models.namespaces.RankByAttributeOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WriteAndQuery {

    public static void main(String[] args) {
        var client = TurbopufferOkHttpClient.builder()
                .fromEnv()
                // pick the right region: https://turbopuffer.com/docs/regions
                .region("gcp-us-central1")
                .build();

        var namespace = "turbopuffer-java-write-and-query-test";
        System.out.printf("Operating on namespace: %s\n", namespace);

        // Delete the namespace if it already exists.
        try {
            client.namespace(namespace)
                    .deleteAll(NamespaceDeleteAllParams.builder()
                            .namespace(namespace)
                            .build());
        } catch (NotFoundException e) {
            System.out.println("Namespace not found, continuing");
        }

        // Upsert some documents.
        var upsert = client.namespace(namespace)
                .write(NamespaceWriteParams.builder()
                        .namespace(namespace)
                        .addUpsertRow(Map.of(
                                "id", JsonValue.from("b3ff34ea-87bb-469c-a854-9cb7e3713fc3"),
                                "vector", JsonValue.from(Arrays.asList(1.0, 2.0, 3.0)),
                                "name", JsonValue.from("Luke"),
                                "age", JsonValue.from(32)))
                        .addUpsertRow(Map.of(
                                "id", JsonValue.from("580d4471-9a9b-44fb-b59d-637ade604f72"),
                                "vector", JsonValue.from(Arrays.asList(4.0, 5.0, 6.0)),
                                "name", JsonValue.from("Leia"),
                                "age", JsonValue.from(28)))
                        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                        .schema(Map.of(
                                "id",
                                AttributeSchemaConfig.builder().type("uuid").build(),
                                "name",
                                AttributeSchemaConfig.builder()
                                        .type("string")
                                        .filterable(false)
                                        .build(),
                                "age",
                                AttributeSchemaConfig.builder().type("uint").build()))
                        .build());
        System.out.printf("Upsert status: %s\n", upsert.status());

        // Do a vector query.
        var query = client.namespace(namespace)
                .query(NamespaceQueryParams.builder()
                        .rankBy(RankBy.vector("vector", List.of(3.0f, 4.0f, 5.0f)))
                        .topK(10)
                        .includeAttributes(true)
                        .filters(Filter.and(
                                List.of(Filter.gt("age", JsonValue.from(30)), Filter.lt("age", JsonValue.from(35)))))
                        .build());
        System.out.printf("Query result:\n%s\n", query);

        // Print the schema.
        var schema = client.namespace(namespace)
                .schema(NamespaceSchemaParams.builder().namespace(namespace).build());
        System.out.printf("Schema:\n%s\n", schema);

        // Patch one document.
        var patch = client.namespace(namespace)
                .write(NamespaceWriteParams.builder()
                        .namespace(namespace)
                        .addPatchRow(Map.of(
                                "id", JsonValue.from("580d4471-9a9b-44fb-b59d-637ade604f72"),
                                "age", JsonValue.from(82)))
                        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                        .build());
        System.out.printf("Patch status: %s\n", patch.status());

        // Do a non-vector query to see the patched results.
        var query2 = client.namespace(namespace)
                .query(NamespaceQueryParams.builder()
                        .namespace(namespace)
                        .rankBy(RankBy.attribute("id", RankByAttributeOrder.ASC))
                        .topK(10)
                        .includeAttributes(true)
                        .build());
        System.out.printf("Query result:\n%s\n", query2);
    }
}
