package com.example.zemogatest.ui.postslist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zemogatest.R
import com.example.zemogatest.ui.components.DefaultListView

@Composable
fun PostsListScreen(
    viewModel: PostsListViewModel = hiltViewModel(),
) {
    val screenModel = viewModel.screenModel

    LaunchedEffect(key1 = screenModel.posts) {
        if (screenModel.posts.isNotEmpty()) {
            viewModel.loadPostsList()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 5.dp,
                    start = 20.dp,
                    end = 20.dp
                ),
            onClick = viewModel::onReloadPostsClick
        ) {
            Text(text = stringResource(id = R.string.reload_posts))
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 20.dp,
                    end = 20.dp
                ),
            onClick = viewModel::onClearPostsClick,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.White
            )
        ) {
            Text(text = stringResource(id = R.string.clear_posts))
        }

        DefaultListView(
            posts = screenModel.posts,
            onItemClick = viewModel::onPostItemClick
        )

    }

}
