package com.example.zemogatest.ui.postslist

import android.os.Parcelable
import com.example.zemogatest.domain.model.PostModel
import com.example.zemogatest.ui.utils.mockListOfPosts
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class PostsListScreenModel(
    val posts: List<@RawValue PostModel> = mockListOfPosts
) : Parcelable
