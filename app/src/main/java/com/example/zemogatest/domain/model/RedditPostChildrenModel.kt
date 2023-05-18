package com.example.zemogatest.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class RedditPostChildrenModel(
    val children: List<ChildrenModel>,
)
