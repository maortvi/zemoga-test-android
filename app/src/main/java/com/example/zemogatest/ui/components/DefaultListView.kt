package com.example.zemogatest.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.zemogatest.domain.model.PostModel

@Composable
fun DefaultListView(
    posts: List<PostModel>,
    onItemClick: (PostModel) -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        itemsIndexed(posts) { _, item ->
            DefaultItemView(
                post = item,
                onItemClick = onItemClick
            )
            Divider(color = Color.LightGray)
        }
    }

}
