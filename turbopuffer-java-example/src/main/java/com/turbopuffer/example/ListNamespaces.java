// A simple example that lists all extant namespaces.
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
        for (var namespace : namespaces.autoPager()) {
            System.out.println(namespace.id());
        }
    }
}
