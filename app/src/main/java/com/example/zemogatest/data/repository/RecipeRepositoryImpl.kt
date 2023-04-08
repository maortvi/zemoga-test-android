package com.example.zemogatest.data.repository

import com.example.zemogatest.data.api.RecipeApi
import com.example.zemogatest.domain.model.RecipeModel
import com.example.zemogatest.domain.repository.RecipeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RecipeRepositoryImpl(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val recipeApi: RecipeApi
) : RecipeRepository {

    override suspend fun loadRandomRecipes(): List<RecipeModel> =
        withContext(coroutineDispatcher) {
            recipeApi.loadRandomRecipes().recipes
        }

    override suspend fun searchRecipe(recipe: String): List<RecipeModel> =
        withContext(coroutineDispatcher) {
            recipeApi.searchRecipe(recipe).results
        }

}
