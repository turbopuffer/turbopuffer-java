@file:JvmName("PrepareRequest")

package com.turbopuffer.core

import com.turbopuffer.core.http.HttpRequest
import java.util.concurrent.CompletableFuture

@JvmSynthetic
internal fun HttpRequest.prepare(clientOptions: ClientOptions, params: Params): HttpRequest {
    val builder = toBuilder()
        .putAllQueryParams(clientOptions.queryParams)
        .replaceAllQueryParams(params._queryParams())
        .putAllHeaders(clientOptions.headers)
        .replaceAllHeaders(params._headers())
    
    // If compression is disabled, set Accept-Encoding to identity to prevent server from compressing responses
    if (!clientOptions.compression) {
        builder.replaceHeaders("Accept-Encoding", "identity")
    }
    
    return builder.build()
}

@JvmSynthetic
internal fun HttpRequest.prepareAsync(
    clientOptions: ClientOptions,
    params: Params,
): CompletableFuture<HttpRequest> =
    // This async version exists to make it easier to add async specific preparation logic in the
    // future.
    CompletableFuture.completedFuture(prepare(clientOptions, params))
