package com.example.zemogatest.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.zemogatest.domain.model.CommentModel

@Composable
fun CommentsListView(
    comments: List<CommentModel>,
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        itemsIndexed(comments) { _, item ->
            CommentItemView(
                comment = item,
            )
            Divider(color = Color.LightGray)
        }
    }

}