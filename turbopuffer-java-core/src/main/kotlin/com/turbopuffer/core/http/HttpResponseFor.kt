package com.turbopuffer.core.http

import java.io.InputStream

interface HttpResponseFor<T> : HttpResponse {

    fun parse(): T
}

@JvmSynthetic
internal fun <T> HttpResponse.parseable(parse: () -> T): HttpResponseFor<T> = lazilyParsed {
    observedParse(parse)
}

/**
 * Like [parseable] for a streamed response, which the caller reads so its request doesn't finish.
 */
@JvmSynthetic
internal fun <T> HttpResponse.streamParseable(parse: () -> T): HttpResponseFor<T> =
    lazilyParsed(parse)

private fun <T> HttpResponse.lazilyParsed(parse: () -> T): HttpResponseFor<T> =
    object : HttpResponseFor<T> {

        private val parsed: T by lazy { parse() }

        override fun parse(): T = parsed

        override fun statusCode(): Int = this@lazilyParsed.statusCode()

        override fun headers(): Headers = this@lazilyParsed.headers()

        override fun body(): InputStream = this@lazilyParsed.body()

        override fun close() = this@lazilyParsed.close()
    }
