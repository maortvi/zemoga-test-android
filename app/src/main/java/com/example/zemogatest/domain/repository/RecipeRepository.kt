package com.example.zemogatest.domain.repository

import com.example.zemogatest.domain.model.RecipeModel

interface RecipeRepository {

    suspend fun loadRandomRecipes(): List<RecipeModel>

    suspend fun searchRecipe(recipe: String): List<RecipeModel>

}
