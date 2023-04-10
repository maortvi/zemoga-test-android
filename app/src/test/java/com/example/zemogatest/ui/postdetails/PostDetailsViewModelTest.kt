package com.example.zemogatest.ui.postdetails

import androidx.lifecycle.SavedStateHandle
import com.example.zemogatest.BaseTest
import com.example.zemogatest.domain.model.CommentModel
import com.example.zemogatest.domain.model.UserModel
import com.example.zemogatest.domain.repository.JsonPlaceholderRepository
import com.example.zemogatest.domain.usecase.*
import com.example.zemogatest.domain.usecase.base.UseCaseResult
import com.example.zemogatest.ui.navigation.NavigationManager
import com.example.zemogatest.ui.utils.defaultId
import com.example.zemogatest.ui.utils.mockListOfComments
import com.example.zemogatest.ui.utils.mockPost
import com.example.zemogatest.ui.utils.mockUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.kotlin.whenever

class PostDetailsViewModelTest : BaseTest() {

    @Mock
    lateinit var navigationManager: NavigationManager

    @Mock
    lateinit var jsonPlaceholderRepository: JsonPlaceholderRepository

    private lateinit var getUserInfoUseCase: GetUserInfoUseCase
    private lateinit var getPostCommentsUseCase: GetPostCommentsUseCase
    private lateinit var addPostToFavoritesUseCase: AddPostToFavoritesUseCase
    private lateinit var removePostFromFavoritesUseCase: RemovePostFromFavoritesUseCase
    private lateinit var deletePostUseCase: DeletePostUseCase
    private lateinit var postDetailsViewModel: PostDetailsViewModel

    @Before
    fun setup() {
        getUserInfoUseCase = GetUserInfoUseCase(
            Dispatchers.Unconfined,
            jsonPlaceholderRepository
        )
        getPostCommentsUseCase = GetPostCommentsUseCase(
            Dispatchers.Unconfined,
            jsonPlaceholderRepository
        )
        addPostToFavoritesUseCase = AddPostToFavoritesUseCase(
            Dispatchers.Unconfined,
            jsonPlaceholderRepository
        )
        removePostFromFavoritesUseCase = RemovePostFromFavoritesUseCase(
            Dispatchers.Unconfined,
            jsonPlaceholderRepository
        )
        deletePostUseCase = DeletePostUseCase(
            Dispatchers.Unconfined,
            jsonPlaceholderRepository
        )

        postDetailsViewModel = PostDetailsViewModel(
            savedStateHandle = SavedStateHandle(
                mutableMapOf(
                    "post-model-key" to mockPost
                )
            ),
            navigationManager = navigationManager,
            getUserInfoUseCase = getUserInfoUseCase,
            getPostCommentsUseCase = getPostCommentsUseCase,
            addPostToFavoritesUseCase = addPostToFavoritesUseCase,
            removePostFromFavoritesUseCase = removePostFromFavoritesUseCase,
            deletePostUseCase = deletePostUseCase
        )
    }

    @Test
    fun `test get user info`() = runTest {
        whenever(jsonPlaceholderRepository.getUserInfo(defaultId)).thenReturn(mockUser)

        val userInfo = getUserInfoUseCase.invoke(defaultId)

        delay(2_000)
        assert(userInfo is UseCaseResult.Success<UserModel>)
    }

    @Test
    fun `test load post comments`() = runTest {
        whenever(jsonPlaceholderRepository.getPostComments(defaultId)).thenReturn(mockListOfComments)

        val comments = getPostCommentsUseCase.invoke(defaultId)

        delay(2_000)
        assert(comments is UseCaseResult.Success<List<CommentModel>>)
    }

    @Test
    fun `test add post to favorites`() = runTest {
        whenever(jsonPlaceholderRepository.addPostToFavorites(defaultId)).thenReturn(true)

        val favorite = addPostToFavoritesUseCase.invoke(params = defaultId)
        postDetailsViewModel.onFavoriteClick()

        delay(2_000)
        assert(favorite is UseCaseResult.Success<Boolean>)
    }

    @Test
    fun `test delete post`() = runTest {
        whenever(jsonPlaceholderRepository.deletePost(defaultId)).thenReturn(true)

        val delete = addPostToFavoritesUseCase.invoke(params = defaultId)
        postDetailsViewModel.onDeletePostClick()

        delay(2_000)
        assert(delete is UseCaseResult.Success<Boolean>)
    }
}
