package com.example.zemogatest.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class UserModel(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
)
