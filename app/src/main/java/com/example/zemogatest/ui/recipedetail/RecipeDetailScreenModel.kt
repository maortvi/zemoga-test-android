package com.example.zemogatest.ui.recipedetail

import android.os.Parcelable
import com.example.zemogatest.ui.utils.emptyString
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeDetailScreenModel(
    val title: String = emptyString
) : Parcelable
