package com.example.zemogatest.data.repository

import com.example.zemogatest.data.api.JsonPlaceholderApi
import com.example.zemogatest.domain.model.CommentModel
import com.example.zemogatest.domain.model.PostModel
import com.example.zemogatest.domain.model.UserModel
import com.example.zemogatest.domain.repository.JsonPlaceholderRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class JsonPlaceholderRepositoryImpl(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val jsonPlaceholderApi: JsonPlaceholderApi
) : JsonPlaceholderRepository {

    override suspend fun loadPosts(): List<PostModel> =
        withContext(coroutineDispatcher) {
            jsonPlaceholderApi.loadPosts()
        }

    override suspend fun getUserInfo(id: Int): UserModel =
        withContext(coroutineDispatcher) {
            jsonPlaceholderApi.getUserInfo(id)
        }

    override suspend fun getPostComments(postId: Int): List<CommentModel> =
        withContext(coroutineDispatcher) {
            jsonPlaceholderApi.getPostComments(postId)
        }

}
