package com.example.zemogatest.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class RedditPostParent(
    val kind: String,
    val data: RedditPostChildrenModel
)
