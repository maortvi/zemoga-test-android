package com.example.zemogatest.ui.searchrecipe

import android.os.Parcelable
import com.example.zemogatest.ui.utils.emptyString
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchRecipeScreenModel(
    val search: String = emptyString,
    val recipes: List<String> = emptyList()
) : Parcelable
