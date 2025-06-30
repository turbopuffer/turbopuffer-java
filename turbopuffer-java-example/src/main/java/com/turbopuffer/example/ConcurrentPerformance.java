// A performance test example demonstrating concurrent operations using the async API.
// This example writes data to 100 namespaces and makes 1000 concurrent queries
// while monitoring total execution time and peak memory usage.
//
// Run this example with: ./gradlew run -Pcom.turbopuffer.example=ConcurrentPerformance
package com.turbopuffer.example;

import com.turbopuffer.client.TurbopufferClientAsync;
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClientAsync;
import com.turbopuffer.errors.NotFoundException;
import com.turbopuffer.models.namespaces.DistanceMetric;
import com.turbopuffer.models.namespaces.NamespaceDeleteAllParams;
import com.turbopuffer.models.namespaces.NamespaceQueryParams;
import com.turbopuffer.models.namespaces.NamespaceWriteParams;
import com.turbopuffer.models.namespaces.RankBy;
import com.turbopuffer.models.namespaces.Row;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class ConcurrentPerformance {

    // This test generates a number of concurrent requests, so it's helpful
    // to use a higher value for max concurrent requests than the default (64).
    private static final int MAX_CONCURRENT_REQUESTS = 128;
    private static final int NUM_NAMESPACES = 128;
    private static final int NUM_WRITES = 512;
    private static final int NUM_QUERIES = 512;
    private static final int VECTOR_DIMENSIONS = 1024;
    private static final String NAMESPACE_PREFIX = "turbopuffer-java-concurrent-performance-";

    public static void main(String[] args) throws Exception {
        System.out.printf("Max concurrent requests: %d\n", MAX_CONCURRENT_REQUESTS);
        System.out.printf("Number of namespaces: %d\n", NUM_NAMESPACES);
        System.out.printf("Number of writes: %d\n", NUM_WRITES);
        System.out.printf("Number of queries: %d\n", NUM_QUERIES);
        System.out.printf("Vector dimensions: %d\n", VECTOR_DIMENSIONS);
        System.out.println();

        var initialPeakMemory = getPeakMemory();

        var client = TurbopufferOkHttpClientAsync.builder()
                .fromEnv()
                // pick the right region: https://turbopuffer.com/docs/regions
                .region("gcp-us-central1")
                .maxRequests(MAX_CONCURRENT_REQUESTS)
                .build();
        var executor = Executors.newCachedThreadPool();

        System.out.println("Writing data...");
        var writeStartTime = System.currentTimeMillis();
        CompletableFuture<Void>[] writeFutures = new CompletableFuture[NUM_WRITES];
        for (int i = 0; i < NUM_WRITES; i++) {
            final var namespaceIndex = i % NUM_NAMESPACES;
            var future = CompletableFuture.runAsync(() -> write(client, namespaceIndex), executor);
            writeFutures[i] = future;
            Thread.sleep(25); // simulate a 25ms delay between write requests arriving
        }
        CompletableFuture.allOf(writeFutures).join();
        var writeEndTime = System.currentTimeMillis();

        System.out.println("Querying data...");
        var queryStartTime = System.currentTimeMillis();
        CompletableFuture<Void>[] queryFutures = new CompletableFuture[NUM_QUERIES];
        for (int i = 0; i < NUM_QUERIES; i++) {
            final var namespaceIndex = i % NUM_NAMESPACES;
            var future = CompletableFuture.runAsync(() -> query(client, namespaceIndex), executor);
            queryFutures[i] = future;
            Thread.sleep(25); // simulate a 25ms delay between query requests arriving
        }
        CompletableFuture.allOf(queryFutures).join();
        var queryEndTime = System.currentTimeMillis();

        client.close();
        executor.shutdown();

        System.out.printf("Write execution time: %d ms\n", writeEndTime - writeStartTime);
        System.out.printf("Query execution time: %d ms\n", queryEndTime - queryStartTime);
        System.out.printf("Initial peak memory: %d MB\n", initialPeakMemory / (1024 * 1024));
        System.out.printf("Ending peak memory: %d MB\n", getPeakMemory() / (1024 * 1024));
    }

    private static void write(TurbopufferClientAsync client, int namespaceIndex) {
        var namespace = getNamespace(namespaceIndex);

        try {
            client.namespace(namespace)
                    .deleteAll(NamespaceDeleteAllParams.builder()
                            .namespace(namespace)
                            .build())
                    .join();
        } catch (Exception e) {
            if (!(e.getCause() instanceof NotFoundException)) {
                throw e;
            }
        }

        var rows = new ArrayList<Row>();
        var documentIdBase = (int) (Math.random() * 10000);
        for (int i = 0; i < 5; i++) {
            rows.add(Row.builder()
                    .put("id", String.format("doc-%d", documentIdBase + i))
                    .put("vector", generateRandomVector())
                    .build());
        }
        client.namespace(namespace)
                .write(NamespaceWriteParams.builder()
                        .upsertRows(rows)
                        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                        .build())
                .join();
    }

    private static void query(TurbopufferClientAsync client, int namespaceIndex) {
        var namespace = getNamespace(namespaceIndex);
        var queryResult = client.namespace(namespace)
                .query(NamespaceQueryParams.builder()
                        .rankBy(RankBy.vector("vector", generateRandomVector()))
                        .topK(2)
                        .includeAttributes(true)
                        .build())
                .join();
        if (queryResult.rows().get().size() != 2) {
            throw new RuntimeException(String.format(
                    "Query returned %d results for namespace %s; expected 5",
                    queryResult.rows().get().size(), namespace));
        }
    }

    private static List<Float> generateRandomVector() {
        var vector = new ArrayList<Float>();
        for (int i = 0; i < VECTOR_DIMENSIONS; i++) {
            vector.add((float) (Math.random() * 2 - 1));
        }
        return vector;
    }

    private static String getNamespace(int namespaceIndex) {
        return NAMESPACE_PREFIX + namespaceIndex;
    }

    private static long getPeakMemory() {
        var peakMemory = 0;
        for (MemoryPoolMXBean memoryPoolMXBean : ManagementFactory.getMemoryPoolMXBeans()) {
            peakMemory += memoryPoolMXBean.getPeakUsage().getUsed();
        }
        return peakMemory;
    }
}
