@file:JvmName("JsonHandler")

package com.turbopuffer.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.http.HttpResponse
import com.turbopuffer.core.http.HttpResponse.Handler
import com.turbopuffer.errors.TurbopufferInvalidDataException

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw TurbopufferInvalidDataException("Error reading response", e)
            }
    }
