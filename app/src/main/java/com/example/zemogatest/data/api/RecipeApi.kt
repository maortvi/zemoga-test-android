package com.example.zemogatest.data.api

import com.example.zemogatest.data.network.model.RecipesResponseModel
import com.example.zemogatest.data.network.model.SearchRecipeResponseModel

interface RecipeApi {

    suspend fun loadRandomRecipes(): RecipesResponseModel

    suspend fun searchRecipe(recipe: String): SearchRecipeResponseModel

}
