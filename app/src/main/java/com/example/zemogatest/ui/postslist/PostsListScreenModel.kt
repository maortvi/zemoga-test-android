package com.example.zemogatest.ui.postslist

import android.os.Parcelable
import com.example.zemogatest.domain.model.ChildrenModel
import com.example.zemogatest.ui.utils.mockChildrenModel
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class PostsListScreenModel(
    val posts: List<@RawValue ChildrenModel> = mockChildrenModel
) : Parcelable
