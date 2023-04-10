package com.example.zemogatest.ui.postslist

import androidx.lifecycle.SavedStateHandle
import com.example.zemogatest.BaseTest
import com.example.zemogatest.domain.model.PostModel
import com.example.zemogatest.domain.repository.JsonPlaceholderRepository
import com.example.zemogatest.domain.usecase.ClearPostsListUseCase
import com.example.zemogatest.domain.usecase.LoadPostsListUseCase
import com.example.zemogatest.domain.usecase.ReloadPostsListUseCase
import com.example.zemogatest.domain.usecase.base.UseCaseResult
import com.example.zemogatest.ui.navigation.NavigationManager
import com.example.zemogatest.ui.utils.mockListOfPosts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.kotlin.whenever

class PostsListViewModelTest : BaseTest() {

    @Mock
    lateinit var navigationManager: NavigationManager

    @Mock
    lateinit var jsonPlaceholderRepository: JsonPlaceholderRepository

    private lateinit var loadPostsListUseCase: LoadPostsListUseCase
    private lateinit var reloadPostsListUseCase: ReloadPostsListUseCase
    private lateinit var clearPostsListUseCase: ClearPostsListUseCase
    private lateinit var postsListViewModel: PostsListViewModel

    @Before
    fun setup() {
        loadPostsListUseCase = LoadPostsListUseCase(
            Dispatchers.Unconfined,
            jsonPlaceholderRepository
        )
        reloadPostsListUseCase = ReloadPostsListUseCase(
            Dispatchers.Unconfined,
            jsonPlaceholderRepository
        )
        clearPostsListUseCase = ClearPostsListUseCase(
            Dispatchers.Unconfined,
            jsonPlaceholderRepository
        )
        postsListViewModel = PostsListViewModel(
            savedStateHandle = SavedStateHandle(mutableMapOf()),
            navigationManager = navigationManager,
            loadPostsListUseCase = loadPostsListUseCase,
            reloadPostsListUseCase = reloadPostsListUseCase,
            clearPostsListUseCase = clearPostsListUseCase
        )
    }

    @Test
    fun `test get the posts list`() = runTest {
        whenever(jsonPlaceholderRepository.loadPostsFromDatabase()).thenReturn(emptyList())
        whenever(jsonPlaceholderRepository.loadPostsFromApi()).thenReturn(mockListOfPosts)

        postsListViewModel.loadPostsList()
        val postsList = loadPostsListUseCase.invoke(params = Unit)

        delay(2_000)
        assert(postsList is UseCaseResult.Success<List<PostModel>>)
    }

    @Test
    fun `test reload the posts list`() = runTest {
        whenever(jsonPlaceholderRepository.loadPostsFromApi()).thenReturn(mockListOfPosts)
        whenever(jsonPlaceholderRepository.loadPostsFromDatabase()).thenReturn(mockListOfPosts)

        postsListViewModel.onReloadPostsClick()
        val postsList = loadPostsListUseCase.invoke(params = Unit)

        delay(2_000)
        assert(postsList is UseCaseResult.Success<List<PostModel>>)
    }

    @Test
    fun `test clear posts except favorites`() = runTest {
        whenever(jsonPlaceholderRepository.loadPostsFromDatabase()).thenReturn(mockListOfPosts)

        postsListViewModel.onClearPostsClick()
        val postsList = loadPostsListUseCase.invoke(params = Unit)

        delay(2_000)
        assert(postsList is UseCaseResult.Success<List<PostModel>>)
    }
}