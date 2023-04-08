package com.example.zemogatest.ui.recipedetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RecipeDetailScreen(
    viewModel: RecipeDetailViewModel = hiltViewModel(),
) {

    val screenModel = viewModel.screenModel

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = screenModel.title)
    }

}