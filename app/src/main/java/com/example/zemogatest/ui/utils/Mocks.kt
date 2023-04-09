package com.example.zemogatest.ui.utils

import com.example.zemogatest.domain.model.CommentModel
import com.example.zemogatest.domain.model.PostModel
import com.example.zemogatest.domain.model.UserModel

const val emptyString = ""
const val defaultId = 0

val mockPost = PostModel(
    userId = defaultId,
    id = defaultId,
    title = emptyString,
    body = emptyString,
)

val mockUser = UserModel(
    id = defaultId,
    name = emptyString,
    username = emptyString,
    email = emptyString
)

val mockComment = CommentModel(
    postId = defaultId,
    id = defaultId,
    name = emptyString,
    email = emptyString,
    body = emptyString
)

val mockListOfPosts = listOf(mockPost)

val mockListOfComments = listOf(mockComment)
