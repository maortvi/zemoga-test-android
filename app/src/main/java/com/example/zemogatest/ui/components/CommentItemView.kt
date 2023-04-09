package com.example.zemogatest.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.zemogatest.domain.model.CommentModel
import com.example.zemogatest.ui.theme.Typography

@Composable
fun CommentItemView(
    modifier: Modifier = Modifier,
    comment: CommentModel
) {

    Surface(
        modifier = modifier
            .fillMaxWidth()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 30.dp,
                    end = 30.dp,
                    top = 10.dp,
                    bottom = 10.dp
                ),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = comment.body)
            Text(
                modifier = Modifier
                    .padding(top = 5.dp),
                text = comment.name,
                style = Typography.caption
            )
            Text(
                text = comment.email,
                style = Typography.caption
            )
            Text(
                text = comment.id.toString(),
                style = Typography.overline
            )
        }
    }

}