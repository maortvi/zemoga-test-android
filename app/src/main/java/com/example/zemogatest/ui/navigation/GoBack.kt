package com.example.zemogatest.ui.navigation

import android.os.Bundle
import androidx.navigation.NavOptionsBuilder

object GoBack : NavigationCommand {
    override val args: Bundle? = null
    override val navBuilder: NavOptionsBuilder.() -> Unit = {}
}
