// A performance test example demonstrating concurrent operations using the async API.
// This example writes data to 100 namespaces and makes 1000 concurrent queries
// while monitoring total execution time and peak memory usage.
//
// Run this example with: ./gradlew run -Pcom.turbopuffer.example=ConcurrentPerformance
package com.turbopuffer.example;

import com.turbopuffer.client.TurbopufferClientAsync;
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClientAsync;
import com.turbopuffer.core.JsonValue;
import com.turbopuffer.errors.NotFoundException;
import com.turbopuffer.models.namespaces.DistanceMetric;
import com.turbopuffer.models.namespaces.DocumentRow;
import com.turbopuffer.models.namespaces.NamespaceDeleteAllParams;
import com.turbopuffer.models.namespaces.NamespaceQueryParams;
import com.turbopuffer.models.namespaces.NamespaceWriteParams;
import com.turbopuffer.models.namespaces.NamespaceWriteParams.Operation.WriteDocuments;
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
            client.namespaces()
                    .deleteAll(NamespaceDeleteAllParams.builder()
                            .namespace(namespace)
                            .build())
                    .join();
        } catch (Exception e) {
            if (!(e.getCause() instanceof NotFoundException)) {
                throw e;
            }
        }

        var documents = new ArrayList<DocumentRow>();
        var documentIdBase = (int) (Math.random() * 10000);
        for (int i = 0; i < 5; i++) {
            documents.add(DocumentRow.builder()
                    .id(String.format("doc-%d", documentIdBase + i))
                    .putAdditionalProperty("vector", JsonValue.from(generateRandomVector()))
                    .build());
        }
        client.namespaces()
                .write(NamespaceWriteParams.builder()
                        .namespace(namespace)
                        .operation(WriteDocuments.builder()
                                .upsertRows(documents)
                                .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                                .build())
                        .build())
                .join();
    }

    private static void query(TurbopufferClientAsync client, int namespaceIndex) {
        var namespace = getNamespace(namespaceIndex);
        var queryResult = client.namespaces()
                .query(NamespaceQueryParams.builder()
                        .namespace(namespace)
                        .vector(generateRandomVector())
                        .topK(2)
                        .includeAttributes(true)
                        .build())
                .join();
        if (queryResult.size() != 2) {
            throw new RuntimeException(String.format(
                    "Query returned %d results for namespace %s; expected 5", queryResult.size(), namespace));
        }
    }

    private static List<Double> generateRandomVector() {
        var vector = new ArrayList<Double>();
        for (int i = 0; i < VECTOR_DIMENSIONS; i++) {
            vector.add(Math.random() * 2 - 1);
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
