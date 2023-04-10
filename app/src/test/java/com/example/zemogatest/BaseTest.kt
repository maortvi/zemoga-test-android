package com.example.zemogatest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
open class BaseTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private var closeable: AutoCloseable? = null

    @Before
    fun openMocks() {
        closeable = MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @After
    @Throws(Exception::class)
    fun releaseMocks() {
        closeable?.close()
        Dispatchers.resetMain()
    }

}
