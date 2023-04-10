package com.example.zemogatest.domain.usecase

import com.example.zemogatest.domain.di.IODispatcher
import com.example.zemogatest.domain.model.PostModel
import com.example.zemogatest.domain.repository.JsonPlaceholderRepository
import com.example.zemogatest.domain.usecase.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ReloadPostsListUseCase
@Inject constructor(
    @IODispatcher coroutineDispatcher: CoroutineDispatcher,
    private val jsonPlaceholderRepository: JsonPlaceholderRepository,
) : BaseUseCase<Unit, List<PostModel>>(coroutineDispatcher) {

    override suspend fun run(params: Unit): List<PostModel> {
        var posts = jsonPlaceholderRepository.loadPostsFromApi()
        if (posts.isNotEmpty()) {
            jsonPlaceholderRepository.clearNonFavoritePosts()
            jsonPlaceholderRepository.insertPosts(posts)
        }
        return jsonPlaceholderRepository.loadPostsFromDatabase()
    }

}
