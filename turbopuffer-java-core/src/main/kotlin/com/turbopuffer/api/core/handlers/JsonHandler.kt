@file:JvmName("JsonHandler")

package com.turbopuffer.api.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.api.core.http.HttpResponse
import com.turbopuffer.api.core.http.HttpResponse.Handler
import com.turbopuffer.api.errors.TurbopufferException

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T {
            try {
                return jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw TurbopufferException("Error reading response", e)
            }
        }
    }
