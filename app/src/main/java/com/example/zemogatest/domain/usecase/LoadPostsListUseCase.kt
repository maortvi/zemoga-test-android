package com.example.zemogatest.domain.usecase

import com.example.zemogatest.domain.di.IODispatcher
import com.example.zemogatest.domain.model.PostModel
import com.example.zemogatest.domain.repository.JsonPlaceholderRepository
import com.example.zemogatest.domain.usecase.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class LoadPostsListUseCase
@Inject constructor(
    @IODispatcher coroutineDispatcher: CoroutineDispatcher,
    private val jsonPlaceholderRepository: JsonPlaceholderRepository,
) : BaseUseCase<Unit, List<PostModel>>(coroutineDispatcher) {

    override suspend fun run(params: Unit): List<PostModel> {
        var posts = jsonPlaceholderRepository.loadPostsFromDatabase()
        if (posts.isEmpty()) {
            jsonPlaceholderRepository.clearPosts()
            posts = jsonPlaceholderRepository.loadPostsFromApi()
            jsonPlaceholderRepository.insertPosts(posts)
        }
        return posts
    }


}

