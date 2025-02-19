// Upserts several large batches of documents and prints the total time taken.
//
// Run this example with: gradle run -Pcom.turbopuffer.example=BulkUpsert
package com.turbopuffer.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;
import com.turbopuffer.models.DistanceMetric;
import com.turbopuffer.models.DocumentRow;
import com.turbopuffer.models.NamespaceUpsertParams;
import com.turbopuffer.models.NamespaceUpsertParams.Documents.UpsertRowBased;

public class BulkUpsert {

    private static final int NUM_BATCHES = 10;
    private static final int BATCH_SIZE = 100;
    private static final int VECTOR_DIM = 1024;

    public static void main(String[] args) {
        var client = TurbopufferOkHttpClient.builder()
                .fromEnv()
                .build();

        var namespace = "turbopuffer-java-bulk-upsert-test2";
        System.out.printf("Operating on namespace: %s\n", namespace);

        long startTime = System.currentTimeMillis();

        Random random = new Random();

        for (int batch = 0; batch < NUM_BATCHES; batch++) {
            List<DocumentRow> documents = new ArrayList<>(BATCH_SIZE);

            for (int i = 0; i < BATCH_SIZE; i++) {
                int id = batch * BATCH_SIZE + i;
                List<Double> vector = new ArrayList<>(VECTOR_DIM);
                for (int j = 0; j < VECTOR_DIM; j++) {
                    vector.add(random.nextDouble());
                }

                documents.add(DocumentRow.builder()
                        .id(String.valueOf(id))
                        .vector(vector)
                        .build());
            }

            var upsert = client.namespaces().upsert(NamespaceUpsertParams.builder()
                    .namespace(namespace)
                    .documents(UpsertRowBased.builder()
                            .upserts(documents)
                            .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                            .build())
                    .build());

            System.out.printf("Batch %d complete, status: %s\n", batch + 1, upsert.status());
        }

        long endTime = System.currentTimeMillis();
        double totalTimeSeconds = (endTime - startTime) / 1000.0;
        System.out.printf("Total time: %.2f seconds\n", totalTimeSeconds);

    }
}
