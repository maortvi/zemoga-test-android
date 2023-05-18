package com.example.zemogatest.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.zemogatest.R
import com.example.zemogatest.domain.model.DataModel
import com.example.zemogatest.domain.model.PostModel

@Composable
fun DefaultItemView(
    modifier: Modifier = Modifier,
    post: DataModel,
    onItemClick: (PostModel) -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 30.dp,
                    end = 30.dp,
                    top = 10.dp,
                    bottom = 10.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = post.title,
                modifier = modifier
                    .weight(1F)
                    .padding(
                        end = 5.dp
                    )
            )

            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = stringResource(R.string.favorite_content_description),
                tint = Color.LightGray
            )
        }

    }

}
