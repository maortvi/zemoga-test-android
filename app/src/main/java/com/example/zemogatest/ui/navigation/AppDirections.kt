package com.example.zemogatest.ui.navigation

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavOptionsBuilder

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

    object RecipesList : AppDirections(
        navBuilder = {
            launchSingleTop = true
            popUpTo(0) { inclusive = true }
        }
    )

    object SearchRecipe : AppDirections()

    class RecipeDetail(title: String) : AppDirections(
        args = bundleOf(RecipeTitleId to title)
    ) {
        companion object {
            private const val RecipeTitleId = "recipe_title_id"
            fun SavedStateHandle.getRecipeTitle(): String =
                this.get<String>(RecipeTitleId)!!
        }
    }

}
