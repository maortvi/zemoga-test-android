package com.example.zemogatest.data.repository

import com.example.zemogatest.data.api.JsonPlaceholderApi
import com.example.zemogatest.database.dao.PostDao
import com.example.zemogatest.database.entity.PostEntity
import com.example.zemogatest.domain.model.CommentModel
import com.example.zemogatest.domain.model.PostModel
import com.example.zemogatest.domain.model.UserModel
import com.example.zemogatest.domain.repository.JsonPlaceholderRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class JsonPlaceholderRepositoryImpl(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val jsonPlaceholderApi: JsonPlaceholderApi,
    private val postDao: PostDao
) : JsonPlaceholderRepository {

    override suspend fun loadPostsFromApi(): List<PostModel> =
        withContext(coroutineDispatcher) {
            jsonPlaceholderApi.loadPosts()
        }

    override suspend fun loadPostsFromDatabase(): List<PostModel> =
        withContext(coroutineDispatcher) {
            postDao.getPosts().map {
                it.toDomain()
            }
        }

    override suspend fun insertPosts(posts: List<PostModel>) =
        withContext(coroutineDispatcher) {
            postDao.insertPosts(posts.map {
                it.toPostEntity()
            })
        }

    override suspend fun clearNonFavoritePosts() =
        withContext(coroutineDispatcher) {
            postDao.deleteNonFavoritePosts()
        }

    override suspend fun getUserInfo(id: Int): UserModel =
        withContext(coroutineDispatcher) {
            jsonPlaceholderApi.getUserInfo(id)
        }

    override suspend fun getPostComments(postId: Int): List<CommentModel> =
        withContext(coroutineDispatcher) {
            jsonPlaceholderApi.getPostComments(postId)
        }

    override suspend fun addPostToFavorites(postId: Int): Boolean =
        withContext(coroutineDispatcher) {
            val result = postDao.addPostToFavorites(postId)
            when {
                result >= 1 -> true
                else -> false
            }
        }

    override suspend fun removePostFromFavorites(postId: Int): Boolean =
        withContext(coroutineDispatcher) {
            val result = postDao.removePostFromFavorites(postId)
            when {
                result >= 1 -> true
                else -> false
            }
        }

    override suspend fun deletePost(postId: Int): Boolean =
        withContext(coroutineDispatcher) {
            val result = postDao.deletePost(postId)
            when {
                result >= 1 -> true
                else -> false
            }
        }

    private fun PostEntity.toDomain(): PostModel = PostModel(
        id = id,
        userId = userId,
        title = title,
        body = body,
        favorite = favorite
    )

    private fun PostModel.toPostEntity(): PostEntity = PostEntity(
        id = id,
        userId = userId,
        title = title,
        body = body,
        favorite = favorite
    )

}
