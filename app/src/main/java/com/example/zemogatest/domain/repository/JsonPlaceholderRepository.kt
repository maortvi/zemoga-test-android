package com.example.zemogatest.domain.repository

import com.example.zemogatest.domain.model.CommentModel
import com.example.zemogatest.domain.model.PostModel
import com.example.zemogatest.domain.model.UserModel

interface JsonPlaceholderRepository {

    suspend fun loadPosts(): List<PostModel>

    suspend fun getUserInfo(id: Int): UserModel

    suspend fun getPostComments(postId: Int): List<CommentModel>

}
