package com.example.zemogatest.domain.model

import kotlinx.serialization.Serializable

@Serializable
class ChildrenModel(
    val kind: String,
    val data: DataModel
)