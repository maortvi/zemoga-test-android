package com.example.zemogatest.data.di

import com.example.zemogatest.data.api.JsonPlaceholderApi
import com.example.zemogatest.data.network.api.KtorJsonPlaceholderApi
import com.example.zemogatest.data.repository.JsonPlaceholderRepositoryImpl
import com.example.zemogatest.database.dao.PostDao
import com.example.zemogatest.domain.di.IODispatcher
import com.example.zemogatest.domain.repository.JsonPlaceholderRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideJson(): Json {
        return Json {
            isLenient = true
            prettyPrint = true
            ignoreUnknownKeys = true
        }
    }

    @Provides
    @Singleton
    fun provideJsonPlaceholderRepository(
        @IODispatcher coroutineDispatcher: CoroutineDispatcher,
        jsonPlaceholderApi: JsonPlaceholderApi,
        postDao: PostDao
    ): JsonPlaceholderRepository {
        return JsonPlaceholderRepositoryImpl(
            coroutineDispatcher = coroutineDispatcher,
            jsonPlaceholderApi = jsonPlaceholderApi,
            postDao = postDao
        )
    }

    @Provides
    @Singleton
    fun provideJsonPlaceholderApi(
        @ZemogaHttpClient httpClient: HttpClient,
    ): JsonPlaceholderApi =
        KtorJsonPlaceholderApi(
            httpClient
        )

}
