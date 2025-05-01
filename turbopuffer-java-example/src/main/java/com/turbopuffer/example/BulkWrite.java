// Upserts several large batches of documents and prints the total time taken.
//
// Run this example with: ./gradlew run -Pcom.turbopuffer.example=BulkWrite
package com.turbopuffer.example;

import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;
import com.turbopuffer.core.JsonValue;
import com.turbopuffer.models.namespaces.DistanceMetric;
import com.turbopuffer.models.namespaces.DocumentRow;
import com.turbopuffer.models.namespaces.NamespaceWriteParams;
import com.turbopuffer.models.namespaces.NamespaceWriteParams.Operation.WriteDocuments;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BulkWrite {

    private static final int NUM_BATCHES = 10;
    private static final int VECTOR_DIM = 1024;

    // Batch size is tuned to produce 32MB payloads. This achieves the maximum
    // discount (50%) without being close to the limit (256MB).
    private static final int BATCH_SIZE = 1500;

    public static void main(String[] args) {
        var client = TurbopufferOkHttpClient.builder().fromEnv().build();

        var namespace = "turbopuffer-java-bulk-upsert-test";
        System.out.printf("Operating on namespace: %s\n", namespace);

        long startTime = System.currentTimeMillis();

        Random random = new Random();

        for (int batch = 0; batch < NUM_BATCHES; batch++) {
            long batchStartTime = System.currentTimeMillis();

            List<DocumentRow> documents = new ArrayList<>(BATCH_SIZE);

            for (int i = 0; i < BATCH_SIZE; i++) {
                int id = batch * BATCH_SIZE + i;
                List<Double> vector = new ArrayList<>(VECTOR_DIM);
                for (int j = 0; j < VECTOR_DIM; j++) {
                    vector.add(random.nextDouble());
                }

                documents.add(DocumentRow.builder()
                        .id(String.valueOf(id))
                        .putAdditionalProperty("vector", JsonValue.from(vector))
                        .build());
            }

            var upsert = client.namespaces()
                    .write(NamespaceWriteParams.builder()
                            .namespace(namespace)
                            .operation(WriteDocuments.builder()
                                    .upsertRows(documents)
                                    .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                                    .build())
                            .build());

            var batchEndTime = System.currentTimeMillis();
            var batchSeconds = (batchEndTime - batchStartTime) / 1000.0;

            System.out.printf(
                    "Batch %d complete, status: %s, time: %.2f seconds\n", batch + 1, upsert.status(), batchSeconds);
        }

        long endTime = System.currentTimeMillis();
        double totalTimeSeconds = (endTime - startTime) / 1000.0;
        System.out.printf("Total time: %.2f seconds\n", totalTimeSeconds);
    }
}
