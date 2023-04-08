package com.example.zemogatest.data.di

import com.example.zemogatest.data.api.RecipeApi
import com.example.zemogatest.data.network.api.KtorRecipeApi
import com.example.zemogatest.data.repository.RecipeRepositoryImpl
import com.example.zemogatest.domain.di.IODispatcher
import com.example.zemogatest.domain.repository.RecipeRepository
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
    fun provideRecipeRepository(
        @IODispatcher coroutineDispatcher: CoroutineDispatcher,
        recipeApi: RecipeApi,
    ): RecipeRepository {
        return RecipeRepositoryImpl(
            coroutineDispatcher = coroutineDispatcher,
            recipeApi = recipeApi,
        )
    }

    @Provides
    @Singleton
    fun provideRecipeApi(
        @EmpowermentLabsHttpClient httpClient: HttpClient,
    ): RecipeApi =
        KtorRecipeApi(
            httpClient
        )
}