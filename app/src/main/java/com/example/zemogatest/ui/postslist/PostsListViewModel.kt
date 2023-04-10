package com.example.zemogatest.ui.postslist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zemogatest.domain.model.PostModel
import com.example.zemogatest.domain.usecase.LoadPostsListUseCase
import com.example.zemogatest.domain.usecase.base.UseCaseResult
import com.example.zemogatest.ui.navigation.AppDirections
import com.example.zemogatest.ui.navigation.NavigationManager
import com.example.zemogatest.ui.utils.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsListViewModel
@Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val navigationManager: NavigationManager,
    private val loadPostsListUseCase: LoadPostsListUseCase
) : ViewModel() {

    var screenModel by savedStateHandle.mutableStateOf(PostsListScreenModel())
        private set

    fun loadPostsList() = viewModelScope.launch {
        when (val result = loadPostsListUseCase.invoke(Unit)) {
            is UseCaseResult.Success -> {
                screenModel = screenModel.copy(
                    posts = result.data
                )
            }
            is UseCaseResult.Error -> {
                // TODO: Display error dialog to the user
                screenModel = screenModel.copy(
                    posts = emptyList()
                )
            }
        }
    }

    fun onPostItemClick(post: PostModel) = viewModelScope.launch {
        navigationManager.navigate(AppDirections.PostDetails(post))
    }

}
