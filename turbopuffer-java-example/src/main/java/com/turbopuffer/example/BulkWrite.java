// Upserts several large batches of documents and prints the total time taken.
//
// Run this example with: ./gradlew run -Pcom.turbopuffer.example=BulkWrite
package com.turbopuffer.example;

import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;
import com.turbopuffer.models.namespaces.Columns;
import com.turbopuffer.models.namespaces.DistanceMetric;
import com.turbopuffer.models.namespaces.NamespaceWriteParams;
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
        var client = TurbopufferOkHttpClient.builder()
                .fromEnv()
                // pick the right region: https://turbopuffer.com/docs/regions
                .region("gcp-us-central1")
                .build();

        var namespace = "turbopuffer-java-bulk-upsert-test";
        System.out.printf("Operating on namespace: %s\n", namespace);

        long startTime = System.currentTimeMillis();

        Random random = new Random();

        for (int batch = 0; batch < NUM_BATCHES; batch++) {
            long batchStartTime = System.currentTimeMillis();

            List<Integer> ids = new ArrayList<>(BATCH_SIZE);
            List<List<Double>> vectors = new ArrayList<>(BATCH_SIZE);

            for (int i = 0; i < BATCH_SIZE; i++) {
                int id = batch * BATCH_SIZE + i;
                List<Double> vector = new ArrayList<>(VECTOR_DIM);
                for (int j = 0; j < VECTOR_DIM; j++) {
                    vector.add(random.nextDouble());
                }

                ids.add(id);
                vectors.add(vector);
            }

            var upsert = client.namespace(namespace)
                    .write(NamespaceWriteParams.builder()
                            .upsertColumns(Columns.builder()
                                    .put("id", ids)
                                    .put("vector", vectors)
                                    .build())
                            .distanceMetric(DistanceMetric.COSINE_DISTANCE)
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
