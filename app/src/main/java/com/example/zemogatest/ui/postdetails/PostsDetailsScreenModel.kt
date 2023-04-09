package com.example.zemogatest.ui.postdetails

import android.os.Parcelable
import com.example.zemogatest.domain.model.CommentModel
import com.example.zemogatest.domain.model.UserModel
import com.example.zemogatest.ui.utils.emptyString
import com.example.zemogatest.ui.utils.mockListOfComments
import com.example.zemogatest.ui.utils.mockUser
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class PostsDetailsScreenModel(
    val title: String = emptyString,
    val body: String = emptyString,
    val user: @RawValue UserModel = mockUser,
    val comments: List<@RawValue CommentModel> = mockListOfComments
) : Parcelable
