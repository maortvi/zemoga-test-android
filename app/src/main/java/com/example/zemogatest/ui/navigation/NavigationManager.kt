package com.example.zemogatest.ui.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigationManager @Inject constructor() {

    private val _commands = MutableSharedFlow<NavigationCommand>()
    val commands: SharedFlow<NavigationCommand>
        get() = _commands

    suspend fun navigate(direction: NavigationCommand) {
        _commands.emit(direction)
    }

    suspend fun navigateBack() {
        _commands.emit(GoBack)
    }
}
