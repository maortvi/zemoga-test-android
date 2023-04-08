package com.example.zemogatest.ui.recipedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zemogatest.ui.navigation.AppDirections.RecipeDetail.Companion.getRecipeTitle
import com.example.zemogatest.ui.utils.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel
@Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val title = savedStateHandle.getRecipeTitle()

    var screenModel by savedStateHandle.mutableStateOf(RecipeDetailScreenModel())
        private set

    init {
        loadInfo()
    }

    private fun loadInfo() = viewModelScope.launch {
        screenModel = screenModel.copy(
            title = title
        )
    }
}
