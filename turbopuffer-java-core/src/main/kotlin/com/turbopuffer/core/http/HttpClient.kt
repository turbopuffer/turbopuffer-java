@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.turbopuffer.core.http

import com.turbopuffer.core.RequestOptions
import java.lang.AutoCloseable
import java.util.concurrent.CompletableFuture

interface HttpClient : AutoCloseable {

    @JvmOverloads
    fun execute(
        request: HttpRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse

    @JvmOverloads
    fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>
}
