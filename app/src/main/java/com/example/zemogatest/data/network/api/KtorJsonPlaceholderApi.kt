package com.example.zemogatest.data.network.api

import com.example.zemogatest.data.api.JsonPlaceholderApi
import com.example.zemogatest.domain.model.CommentModel
import com.example.zemogatest.domain.model.PostModel
import com.example.zemogatest.domain.model.RedditPostParent
import com.example.zemogatest.domain.model.UserModel
import io.ktor.client.*
import io.ktor.client.request.*

class KtorJsonPlaceholderApi(
    private val client: HttpClient
) : JsonPlaceholderApi {

    override suspend fun loadPosts(): RedditPostParent {
        return client.get(path = "/popular.json")
    }

    override suspend fun getUserInfo(id: Int): UserModel {
        return client.get(path = "/users/$id")
    }

    override suspend fun getPostComments(postId: Int): List<CommentModel> {
        return client.get(path = "/posts/$postId/comments")
    }

}
