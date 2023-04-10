package com.example.zemogatest.domain.usecase

import com.example.zemogatest.domain.di.IODispatcher
import com.example.zemogatest.domain.repository.JsonPlaceholderRepository
import com.example.zemogatest.domain.usecase.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class AddPostToFavoritesUseCase
@Inject constructor(
    @IODispatcher coroutineDispatcher: CoroutineDispatcher,
    private val jsonPlaceholderRepository: JsonPlaceholderRepository,
) : BaseUseCase<Int, Boolean>(coroutineDispatcher) {

    override suspend fun run(params: Int): Boolean =
        jsonPlaceholderRepository.addPostToFavorites(params)

}
