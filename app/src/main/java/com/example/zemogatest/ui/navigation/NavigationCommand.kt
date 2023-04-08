package com.example.zemogatest.ui.navigation

import android.os.Bundle
import androidx.navigation.NavOptionsBuilder

interface NavigationCommand {
    val args: Bundle?
    val navBuilder: NavOptionsBuilder.() -> Unit
}
