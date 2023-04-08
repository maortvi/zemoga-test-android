package com.example.zemogatest.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ExceptionModel(
    val code: Int? = null,
    val message: String
)
