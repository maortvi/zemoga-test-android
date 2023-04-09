package com.example.zemogatest.ui.postslist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zemogatest.ui.components.DefaultListView

@Composable
fun PostsListScreen(
    viewModel: PostsListViewModel = hiltViewModel(),
) {
    val screenModel = viewModel.screenModel

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultListView(
            posts = screenModel.posts,
            onItemClick = viewModel::onPostItemClick
        )
    }

}
