package com.example.zemogatest.data.api

import com.example.zemogatest.domain.model.CommentModel
import com.example.zemogatest.domain.model.PostModel
import com.example.zemogatest.domain.model.UserModel

interface JsonPlaceholderApi {

    suspend fun loadPosts(): List<PostModel>

    suspend fun getUserInfo(id: Int): UserModel

    suspend fun getPostComments(postId: Int): List<CommentModel>

}
