package com.example.zemogatest.ui.searchrecipe

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zemogatest.R
import com.example.zemogatest.ui.components.DefaultListView

@Composable
fun SearchRecipeScreen(
    viewModel: SearchRecipeViewModel = hiltViewModel()
) {

    val screenModel = viewModel.screenModel

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = screenModel.search,
            onValueChange = viewModel::onSearchTextFieldValueChange,
            label = { Text(text = stringResource(id = R.string.search_recipe)) },
            placeholder = { Text(text = stringResource(id = R.string.search_recipe_placeholder)) },
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp),
            onClick = viewModel::onButtonClick
        ) {
            Text(text = stringResource(id = R.string.search_recipe))
        }

        DefaultListView(
            titles = screenModel.recipes,
            onItemClick = viewModel::onRecipeItemClick
        )
    }

}
