package com.example.zemogatest.ui.navigation

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavOptionsBuilder
import com.example.zemogatest.domain.model.PostModel

sealed class AppDirections(
    override val args: Bundle? = null,
    override val navBuilder: NavOptionsBuilder.() -> Unit = { launchSingleTop = true }
) : NavigationCommand {

    object Main : AppDirections(
        navBuilder = {
            launchSingleTop = true
            popUpTo(0) { inclusive = true }
        }
    )

    object PostsList : AppDirections(
        navBuilder = {
            launchSingleTop = false
            popUpTo(0) { inclusive = true }
        }
    )

    class PostDetails(post: PostModel) : AppDirections(
        args = bundleOf(POST_MODEL_KEY to post)
    ) {
        companion object {
            private const val POST_MODEL_KEY = "post-model-key"
            fun SavedStateHandle.getPost(): PostModel =
                this.get<PostModel>(POST_MODEL_KEY)!!
        }
    }

}
