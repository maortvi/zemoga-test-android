package com.example.zemogatest.domain.repository

import com.example.zemogatest.domain.model.CommentModel
import com.example.zemogatest.domain.model.PostModel
import com.example.zemogatest.domain.model.UserModel

interface JsonPlaceholderRepository {

    suspend fun loadPostsFromApi(): List<PostModel>

    suspend fun loadPostsFromDatabase(): List<PostModel>

    suspend fun insertPosts(posts: List<PostModel>)

    suspend fun clearNonFavoritePosts()

    suspend fun getUserInfo(id: Int): UserModel

    suspend fun getPostComments(postId: Int): List<CommentModel>

    suspend fun addPostToFavorites(postId: Int): Boolean

    suspend fun removePostFromFavorites(postId: Int): Boolean
    suspend fun deletePost(postId: Int): Boolean

}
