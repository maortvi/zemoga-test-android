package com.example.zemogatest.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class PostModel(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
    val favorite: Boolean = false
) : Parcelable
