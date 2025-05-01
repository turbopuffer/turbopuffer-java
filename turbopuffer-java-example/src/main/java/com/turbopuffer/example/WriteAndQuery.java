// A straightforward example of storing and retrieving documents via vector
// similarity search.
//
// Run this example with: gradle run -Pcom.turbopuffer.example=UpsertAndQuery
package com.turbopuffer.example;

import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;
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

public class WriteAndQuery {

    public static void main(String[] args) {
        var client = TurbopufferOkHttpClient.builder().fromEnv().build();

        var namespace = "turbopuffer-java-upsert-and-query-test";
        System.out.printf("Operating on namespace: %s\n", namespace);

        // Delete the namespace if it already exists.
        try {
            client.namespaces()
                    .deleteAll(NamespaceDeleteAllParams.builder()
                            .namespace(namespace)
                            .build());
        } catch (TurbopufferServiceException e) {
            if (e.statusCode() == 404) {
                System.out.println("Namespace not found, continuing");
            } else {
                System.out.println("Error is fatal, exiting");
                System.exit(1);
            }
        }

        // Upsert some documents.
        var upsert = client.namespaces()
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
                                // TODO: provide a schema builder with typed values.
                                .schema(Schema.builder()
                                        .putAdditionalProperty("id", JsonValue.from("uuid"))
                                        .putAdditionalProperty(
                                                "name",
                                                JsonValue.from(
                                                        JsonObject.of(Map.of("type", "string", "filterable", false))))
                                        .putAdditionalProperty("age", JsonValue.from("uint"))
                                        .build())
                                .build())
                        .build());
        System.out.printf("Upsert status: %s\n", upsert.status());

        // Do a vector query.
        var query = client.namespaces()
                .query(NamespaceQueryParams.builder()
                        .namespace(namespace)
                        .vector(Arrays.asList(3.0, 4.0, 5.0))
                        .includeAttributes(true)
                        .includeVectors(true)
                        .filters(JsonValue.from(
                                List.of("And", List.of(List.of("age", "Gt", 30), List.of("age", "Lt", 35)))))
                        .build());
        System.out.printf("Query result:\n%s\n", query);

        // Print the schema.
        var schema = client.namespaces()
                .getSchema(
                        NamespaceGetSchemaParams.builder().namespace(namespace).build());
        System.out.printf("Schema:\n%s\n", schema);

        // Patch one document.
        var patch = client.namespaces()
                .write(NamespaceWriteParams.builder()
                        .namespace(namespace)
                        .operation(WriteDocuments.builder()
                                .addPatchRow(DocumentRow.builder()
                                        .id("580d4471-9a9b-44fb-b59d-637ade604f72")
                                        .putAdditionalProperty("age", JsonValue.from(82))
                                        .build())
                                .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                                .build())
                        .build());
        System.out.printf("Patch status: %s\n", patch.status());

        // Do a non-vector query to see the patched results.
        var query2 = client.namespaces()
                .query(NamespaceQueryParams.builder()
                        .namespace(namespace)
                        .includeAttributes(true)
                        .build());
        System.out.printf("Query result:\n%s\n", query2);
    }
}
