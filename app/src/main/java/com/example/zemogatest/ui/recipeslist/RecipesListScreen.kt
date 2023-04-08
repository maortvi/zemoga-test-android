package com.example.zemogatest.ui.recipeslist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zemogatest.R
import com.example.zemogatest.ui.components.DefaultListView

@Composable
fun RecipesListScreen(
    viewModel: RecipesListViewModel = hiltViewModel(),
) {
    val screenModel = viewModel.screenModel

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultListView(
            titles = screenModel.recipes,
            onItemClick = viewModel::onRecipeItemClick
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 5.dp,
                    end = 5.dp
                ),
            onClick = viewModel::onSearchClick
        ) {
            Text(text = stringResource(id = R.string.search_recipe))
        }

    }
}
