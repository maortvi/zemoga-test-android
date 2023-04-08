package com.example.zemogatest.data.network.api

import com.example.zemogatest.data.api.RecipeApi
import com.example.zemogatest.data.network.model.RecipesResponseModel
import com.example.zemogatest.data.network.model.SearchRecipeResponseModel
import io.ktor.client.*
import io.ktor.client.request.*

class KtorRecipeApi(
    private val client: HttpClient
) : RecipeApi {

    override suspend fun loadRandomRecipes(): RecipesResponseModel {
        return client.get(path = "/random") {
            parameter("number", 5)
        }
    }

    override suspend fun searchRecipe(recipe: String): SearchRecipeResponseModel {
        return client.get(path = "/complexSearch") {
            parameter("query", recipe)
        }
    }

}
