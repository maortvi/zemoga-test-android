package com.example.zemogatest.ui.searchrecipe

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zemogatest.domain.usecase.SearchRecipeUseCase
import com.example.zemogatest.domain.usecase.base.UseCaseResult
import com.example.zemogatest.ui.utils.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchRecipeViewModel
@Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val searchRecipeUseCase: SearchRecipeUseCase
) : ViewModel() {

    var screenModel by savedStateHandle.mutableStateOf(SearchRecipeScreenModel())
        private set

    fun onButtonClick() = viewModelScope.launch {
        when (val result = searchRecipeUseCase.invoke(screenModel.search)) {
            is UseCaseResult.Success -> {
                screenModel = screenModel.copy(
                    recipes = result.data.map {
                        it.title
                    }
                )
            }
            is UseCaseResult.Error -> {
                // TODO: Display error dialog to the user
                screenModel = screenModel.copy(
                    recipes = emptyList()
                )
            }
        }
    }

    fun onSearchTextFieldValueChange(search: String) = viewModelScope.launch {
        screenModel = screenModel.copy(search = search)
    }

    fun onRecipeItemClick(title: String) = viewModelScope.launch {
        // TODO: Not part of the test :)
    }

}
