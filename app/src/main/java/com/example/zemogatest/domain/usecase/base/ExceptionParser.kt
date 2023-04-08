package com.example.zemogatest.domain.usecase.base

import com.example.zemogatest.domain.model.ExceptionModel
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

private val JsonParser = Json { ignoreUnknownKeys = true }

fun parseServerExceptionResponse(response: String): Exception {
    return try {
        val error = JsonParser.decodeFromString<ExceptionModel>(response)
        when (error.code) {
            else -> Exception(error.message)
        }
    } catch (exception: Exception) {
        exception
    }

}
