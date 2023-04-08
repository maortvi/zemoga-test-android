package com.example.zemogatest.domain.usecase.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class BaseUseCase<in Params, Type>(
    private val coroutineDispatcher: CoroutineDispatcher
) : suspend (Params) -> UseCaseResult<Type> where Type : Any? {

    abstract suspend fun run(params: Params): Type

    override suspend fun invoke(params: Params): UseCaseResult<Type> =
        withContext(coroutineDispatcher) {
            try {
                UseCaseResult.Success(run(params))
            } catch (e: Exception) {
                UseCaseResult.Error(e)
            }
        }

}

sealed interface UseCaseResult<out Type> where Type : Any? {
    data class Success<Type>(val data: Type) : UseCaseResult<Type>
    data class Error(val t: Throwable) : UseCaseResult<Nothing>
}
