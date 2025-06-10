// A straightforward example of storing and retrieving documents via vector
// similarity search using async operations.
//
// Run this example with: gradle run -Pcom.turbopuffer.example=WriteAndQueryAsync
package com.turbopuffer.example;

import com.turbopuffer.client.okhttp.TurbopufferOkHttpClientAsync;
import com.turbopuffer.core.JsonObject;
import com.turbopuffer.core.JsonValue;
import com.turbopuffer.errors.TurbopufferServiceException;
import com.turbopuffer.models.namespaces.DistanceMetric;
import com.turbopuffer.models.namespaces.DocumentRow;
import com.turbopuffer.models.namespaces.NamespaceDeleteAllParams;
import com.turbopuffer.models.namespaces.NamespaceGetSchemaParams;
import com.turbopuffer.models.namespaces.NamespaceQueryParams;
import com.turbopuffer.models.namespaces.NamespaceWriteParams;
import com.turbopuffer.models.namespaces.NamespaceWriteParams.Operation.WriteDocuments;
import com.turbopuffer.models.namespaces.NamespaceWriteParams.Operation.WriteDocuments.Schema;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class WriteAndQueryAsync {

    public static void main(String[] args) {
        var client = TurbopufferOkHttpClientAsync.builder().fromEnv().build();

        var namespace = "turbopuffer-java-write-and-query-async-test";
        System.out.printf("Operating on namespace: %s\n", namespace);

        // Delete the namespace if it already exists.
        try {
            client.namespaces()
                    .deleteAll(NamespaceDeleteAllParams.builder()
                            .namespace(namespace)
                            .build())
                    .join(); // Wait for delete to complete before proceeding
        } catch (Exception e) {
            if (e.getCause() instanceof TurbopufferServiceException && 
                ((TurbopufferServiceException) e.getCause()).statusCode() == 404) {
                System.out.println("Namespace not found, continuing");
            } else {
                System.out.println("Error is fatal, exiting");
                System.exit(1);
            }
        }

        // Upsert some documents.
        var upsertResult = client.namespaces()
                .write(NamespaceWriteParams.builder()
                        .namespace(namespace)
                        .operation(WriteDocuments.builder()
                                .addUpsertRow(DocumentRow.builder()
                                        .id("b3ff34ea-87bb-469c-a854-9cb7e3713fc3")
                                        .putAdditionalProperty("vector", JsonValue.from(Arrays.asList(1.0, 2.0, 3.0)))
                                        .putAdditionalProperty("name", JsonValue.from("Luke"))
                                        .putAdditionalProperty("age", JsonValue.from(32))
                                        .build())
                                .addUpsertRow(DocumentRow.builder()
                                        .id("580d4471-9a9b-44fb-b59d-637ade604f72")
                                        .putAdditionalProperty("vector", JsonValue.from(Arrays.asList(4.0, 5.0, 6.0)))
                                        .putAdditionalProperty("name", JsonValue.from("Leia"))
                                        .putAdditionalProperty("age", JsonValue.from(28))
                                        .build())
                                .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                                .schema(Schema.builder()
                                        .putAdditionalProperty("id", JsonValue.from("uuid"))
                                        .putAdditionalProperty(
                                                "name",
                                                JsonValue.from(
                                                        JsonObject.of(Map.of("type", "string", "filterable", false))))
                                        .putAdditionalProperty("age", JsonValue.from("uint"))
                                        .build())
                                .build())
                        .build())
                .join();
        System.out.printf("Upsert status: %s\n", upsertResult.status());

        // Set up futures for a vector query and get schema concurrently.
        var queryFuture = client.namespaces()
                .query(NamespaceQueryParams.builder()
                        .namespace(namespace)
                        .vector(Arrays.asList(3.0, 4.0, 5.0))
                        .includeAttributes(true)
                        .includeVectors(true)
                        .filters(JsonValue.from(
                                List.of("And", List.of(List.of("age", "Gt", 30), List.of("age", "Lt", 35)))))
                        .build());

        var schemaFuture = client.namespaces()
                .getSchema(
                        NamespaceGetSchemaParams.builder().namespace(namespace).build());

        // Wait for both operations to complete.
        CompletableFuture.allOf(queryFuture, schemaFuture).join();

        // Get and print results.
        System.out.printf("Query result:\n%s\n", queryFuture.join());
        System.out.printf("Schema:\n%s\n", schemaFuture.join());

        // Patch one document.
        var patchResult = client.namespaces()
                .write(NamespaceWriteParams.builder()
                        .namespace(namespace)
                        .operation(WriteDocuments.builder()
                                .addPatchRow(DocumentRow.builder()
                                        .id("580d4471-9a9b-44fb-b59d-637ade604f72")
                                        .putAdditionalProperty("age", JsonValue.from(82))
                                        .build())
                                .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                                .build())
                        .build())
                .join();
        System.out.printf("Patch status: %s\n", patchResult.status());

        // Do a non-vector query to see the patched results.
        var query2Result = client.namespaces()
                .query(NamespaceQueryParams.builder()
                        .namespace(namespace)
                        .includeAttributes(true)
                        .build())
                .join();
        System.out.printf("Query result:\n%s\n", query2Result);
    }
} 