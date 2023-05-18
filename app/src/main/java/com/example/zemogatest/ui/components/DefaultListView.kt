package com.example.zemogatest.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.zemogatest.domain.model.ChildrenModel
import com.example.zemogatest.domain.model.PostModel

@Composable
fun DefaultListView(
    posts: List<ChildrenModel>,
    onItemClick: (PostModel) -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        itemsIndexed(posts) { _, item ->
            DefaultItemView(
                post = item.data,
                onItemClick = onItemClick
            )
            Divider(color = Color.LightGray)
        }
    }

}
