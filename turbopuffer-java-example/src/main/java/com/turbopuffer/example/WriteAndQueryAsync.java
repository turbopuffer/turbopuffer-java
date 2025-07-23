// A straightforward example of storing and retrieving documents via vector
// similarity search.
//
// Run this example with: ./gradlew run -Pcom.turbopuffer.example=WriteAndQueryAsync
package com.turbopuffer.example;

import com.turbopuffer.client.TurbopufferClientAsync;
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClientAsync;
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
import com.turbopuffer.models.namespaces.Row;
import com.turbopuffer.models.namespaces.Schema;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class WriteAndQueryAsync {

    public static void main(String[] args) {
        var client = TurbopufferOkHttpClientAsync.builder()
                .fromEnv()
                // pick the right region: https://turbopuffer.com/docs/regions
                .region("gcp-us-central1")
                .build();

        try {
            run(client);
        } finally {
            // When done using the async client, we need to close it to shut
            // down the underlying executor or Java will keep the program alive
            // forever.
            client.close();
        }
    }

    public static void run(TurbopufferClientAsync client) {
        var namespace = "turbopuffer-java-write-and-query-async-test";
        System.out.printf("Operating on namespace: %s\n", namespace);

        // Delete the namespace if it already exists.
        try {
            client.namespace(namespace)
                    .deleteAll(NamespaceDeleteAllParams.builder()
                            .namespace(namespace)
                            .build())
                    .join();
        } catch (CompletionException e) {
            if (e.getCause() instanceof NotFoundException) {
                System.out.println("Namespace not found, continuing");
            } else {
                throw e;
            }
        }

        // Upsert some documents.
        var upsert = client.namespace(namespace)
                .write(NamespaceWriteParams.builder()
                        .namespace(namespace)
                        .addUpsertRow(Row.builder()
                                .put("id", "b3ff34ea-87bb-469c-a854-9cb7e3713fc3")
                                .put("vector", Arrays.asList(1.0, 2.0, 3.0))
                                .put("name", "Luke")
                                .put("age", 32)
                                .build())
                        .addUpsertRow(Row.builder()
                                .put("id", "580d4471-9a9b-44fb-b59d-637ade604f72")
                                .put("vector", Arrays.asList(4.0, 5.0, 6.0))
                                .put("name", "Leia")
                                .put("age", 28)
                                .build())
                        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                        .schema(Schema.builder()
                                .put(
                                        "id",
                                        AttributeSchemaConfig.builder()
                                                .type("uuid")
                                                .build())
                                .put(
                                        "name",
                                        AttributeSchemaConfig.builder()
                                                .type("string")
                                                .filterable(false)
                                                .build())
                                .put(
                                        "age",
                                        AttributeSchemaConfig.builder()
                                                .type("uint")
                                                .build())
                                .build())
                        .build())
                .join();
        System.out.printf("Rows upserted: %d\n", upsert.rowsUpserted().get());

        // Set up to run a vector query and schema inspection concurrently.
        var queryFuture = client.namespace(namespace)
                .query(NamespaceQueryParams.builder()
                        .rankBy(RankBy.vector("vector", List.of(3.0f, 4.0f, 5.0f)))
                        .topK(10)
                        .includeAttributes(true)
                        .filters(Filter.and(Filter.gt("age", 30), Filter.lt("age", 35)))
                        .build());
        var schemaFuture = client.namespace(namespace)
                .schema(NamespaceSchemaParams.builder().namespace(namespace).build());

        // Wait for both operations to complete.
        CompletableFuture.allOf(queryFuture, schemaFuture).join();

        // Get and print results.
        System.out.printf("Query result:\n%s\n", queryFuture.join());
        System.out.printf("Schema:\n%s\n", schemaFuture.join());

        // Patch one document.
        var patch = client.namespace(namespace)
                .write(NamespaceWriteParams.builder()
                        .namespace(namespace)
                        .addPatchRow(Row.builder()
                                .put("id", "580d4471-9a9b-44fb-b59d-637ade604f72")
                                .put("age", 82)
                                .build())
                        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                        .build())
                .join();
        System.out.printf("Rows patched: %d\n", patch.rowsPatched().get());

        // Do a non-vector query to see the patched results.
        var query2 = client.namespace(namespace)
                .query(NamespaceQueryParams.builder()
                        .namespace(namespace)
                        .rankBy(RankBy.attribute("id", RankByAttributeOrder.ASC))
                        .topK(10)
                        .includeAttributes(true)
                        .build())
                .join();
        System.out.printf("Query result:\n%s\n", query2);
    }
}
