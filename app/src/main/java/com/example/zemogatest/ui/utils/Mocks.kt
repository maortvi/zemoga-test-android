package com.example.zemogatest.ui.utils

import com.example.zemogatest.domain.model.ChildrenModel
import com.example.zemogatest.domain.model.CommentModel
import com.example.zemogatest.domain.model.DataModel
import com.example.zemogatest.domain.model.PostModel
import com.example.zemogatest.domain.model.UserModel

const val emptyString = ""
const val defaultId = 0

val mockPost = PostModel(
    userId = defaultId,
    id = defaultId,
    title = emptyString,
    body = emptyString,
    favorite = false
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

val mockChildrenModel = listOf(
    ChildrenModel("", DataModel("Title 1")),
    ChildrenModel("", DataModel("Title 2"))
)

val mockListOfComments = listOf(mockComment)
