package com.example.zemogatest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.zemogatest.ui.navigation.AppDirections
import com.example.zemogatest.ui.navigation.GoBack
import com.example.zemogatest.ui.navigation.NavigationManager
import com.example.zemogatest.ui.navigation.navigationGraph
import com.example.zemogatest.ui.theme.ZemogaTestTheme
import com.example.zemogatest.ui.utils.navigate
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var destination = AppDirections.Main::class.toString()

        setContent {
            ZemogaTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppScreen(
                        navigationManager = navigationManager,
                        destination = destination
                    )
                }
            }
        }
    }
}

@Composable
fun AppScreen(
    navigationManager: NavigationManager,
    destination: String
) {
    val navController = rememberNavController()
    val backPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    LaunchedEffect(LocalContext.current.applicationContext) {
        navigationManager.commands.collect { command ->
            when (command) {
                GoBack -> backPressedDispatcher?.onBackPressed()
                else -> {
                    navController.navigate(
                        route = command::class.toString(),
                        args = command.args,
                        navOptions = navOptions(command.navBuilder)
                    )
                }
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = destination,
    ) {
        navigationGraph()
    }

}
