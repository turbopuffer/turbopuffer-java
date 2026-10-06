// A simple example that lists the first few namespaces.
//
// Run this example with: ./gradlew run -Pcom.turbopuffer.example=ListNamespaces
package com.turbopuffer.example;

import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;

public class ListNamespaces {

    public static void main(String[] args) {
        var client = TurbopufferOkHttpClient.builder()
                .fromEnv()
                // pick the right region: https://turbopuffer.com/docs/regions
                .region("gcp-us-central1")
                .build();

        var namespaces = client.namespaces();
        // An org can hold a huge number of namespaces, so stop after the first few.
        namespaces.autoPager().stream().limit(10).forEach(namespace -> System.out.println(namespace.id()));
    }
}
