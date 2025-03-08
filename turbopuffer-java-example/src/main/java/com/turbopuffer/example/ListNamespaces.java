// A simple example that lists all extant namespaces.
//
// Run this example with: gradle run -Pcom.turbopuffer.example=ListNamespaces
package com.turbopuffer.example;

import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;
import com.turbopuffer.models.NamespaceListParams;

public class ListNamespaces {

    public static void main(String[] args) {
        var client = TurbopufferOkHttpClient.builder()
                .fromEnv()
                .build();

        var namespaces = client.namespaces().list(NamespaceListParams.builder().build());
        for (var namespace : namespaces.autoPager()) {
            System.out.println(namespace.id());
        }
    }
}
