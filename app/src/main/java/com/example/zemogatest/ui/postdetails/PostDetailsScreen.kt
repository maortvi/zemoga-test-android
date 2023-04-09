package com.example.zemogatest.ui.postdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zemogatest.ui.components.CommentsListView
import com.example.zemogatest.ui.theme.Typography

@Composable
fun PostDetailsScreen(
    viewModel: PostDetailsViewModel = hiltViewModel(),
) {

    val screenModel = viewModel.screenModel

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 30.dp,
                end = 30.dp,
                top = 10.dp
            )
    ) {
        Text(
            text = screenModel.title,
            fontWeight = FontWeight.Bold,
            style = Typography.h5
        )
        Text(
            modifier = Modifier
                .padding(top = 5.dp),
            text = screenModel.body
        )
        Text(
            modifier = Modifier
                .padding(top = 5.dp),
            text = screenModel.user.name,
            style = Typography.caption
        )
        Text(
            text = screenModel.user.username,
            style = Typography.caption
        )
        Text(
            text = screenModel.user.email,
            style = Typography.caption
        )
        Divider(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    bottom = 8.dp
                ),
            color = Color.LightGray
        )
        CommentsListView(comments = screenModel.comments)
    }

}