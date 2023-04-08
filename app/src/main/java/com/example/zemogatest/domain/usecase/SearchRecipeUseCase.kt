package com.example.zemogatest.domain.usecase

import com.example.zemogatest.domain.di.IODispatcher
import com.example.zemogatest.domain.model.RecipeModel
import com.example.zemogatest.domain.repository.RecipeRepository
import com.example.zemogatest.domain.usecase.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SearchRecipeUseCase
@Inject constructor(
    @IODispatcher
    coroutineDispatcher: CoroutineDispatcher,
    private val recipeRepository: RecipeRepository
) : BaseUseCase<String, List<RecipeModel>>(coroutineDispatcher) {

    override suspend fun run(params: String) =
        recipeRepository.searchRecipe(params)

}