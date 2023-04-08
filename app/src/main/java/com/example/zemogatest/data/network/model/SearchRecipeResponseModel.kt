package com.example.zemogatest.data.network.model

import com.example.zemogatest.domain.model.RecipeModel
import kotlinx.serialization.Serializable

@Serializable
data class SearchRecipeResponseModel(
    val results: List<RecipeModel>
)