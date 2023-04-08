package com.example.zemogatest.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun DefaultListView(
    titles: List<String>,
    onItemClick: (String) -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        itemsIndexed(titles) { _, item ->
            DefaultItemView(
                title = item,
                onItemClick = { onItemClick(item) }
            )
            Divider(color = Color.LightGray)
        }
    }

}
