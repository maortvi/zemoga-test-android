package com.example.zemogatest.ui.postdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zemogatest.domain.usecase.GetPostCommentsUseCase
import com.example.zemogatest.domain.usecase.GetUserInfoUseCase
import com.example.zemogatest.domain.usecase.base.UseCaseResult
import com.example.zemogatest.ui.navigation.AppDirections.PostDetails.Companion.getPost
import com.example.zemogatest.ui.utils.mockListOfComments
import com.example.zemogatest.ui.utils.mockUser
import com.example.zemogatest.ui.utils.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel
@Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val getPostCommentsUseCase: GetPostCommentsUseCase,
) : ViewModel() {

    private val post = savedStateHandle.getPost()

    var screenModel by savedStateHandle.mutableStateOf(PostsDetailsScreenModel())
        private set

    init {
        loadPostInfo()
        loadUserInfo()
        loadPostComments()
    }

    private fun loadPostInfo() = viewModelScope.launch {
        screenModel = screenModel.copy(
            title = post.title,
            body = post.body
        )
    }

    private fun loadUserInfo() = viewModelScope.launch {
        when (val result = getUserInfoUseCase.invoke(post.userId)) {
            is UseCaseResult.Success -> {
                screenModel = screenModel.copy(
                    user = result.data
                )
            }
            is UseCaseResult.Error -> {
                // TODO: Display error dialog to the user
                screenModel = screenModel.copy(
                    user = mockUser
                )
            }
        }
    }

    private fun loadPostComments() = viewModelScope.launch {
        when (val result = getPostCommentsUseCase.invoke(post.id)) {
            is UseCaseResult.Success -> {
                screenModel = screenModel.copy(
                    comments = result.data
                )
            }
            is UseCaseResult.Error -> {
                // TODO: Display error dialog to the user
                screenModel = screenModel.copy(
                    comments = mockListOfComments
                )
            }
        }
    }

}
