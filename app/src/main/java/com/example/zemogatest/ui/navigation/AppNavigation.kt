package com.example.zemogatest.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.zemogatest.ui.postdetails.PostDetailsScreen
import com.example.zemogatest.ui.postslist.PostsListScreen

fun NavGraphBuilder.navigationGraph() {
    navigation(
        startDestination = AppDirections.PostsList::class.toString(),
        route = AppDirections.Main::class.toString()
    ) {
        composable(
            route = AppDirections.PostsList::class.toString()
        ) {
            PostsListScreen()
        }
        composable(
            route = AppDirections.PostDetails::class.toString()
        ) {
            PostDetailsScreen()
        }
    }
}
