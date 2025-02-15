package com.project.randomimagegenerator.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.randomimagegenerator.presentation.random_image_gen.GenerateDogsScreen
import com.project.randomimagegenerator.presentation.random_image_gen.HomeScreen
import com.project.randomimagegenerator.presentation.random_image_gen.RecentGeneratedDogsScreen
import com.project.randomimagegenerator.presentation.ui.theme.RandomImageGeneratorTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * The main entry point of the application.
 *
 * This activity sets up Jetpack Compose UI and manages navigation between different screens.
 */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomImageGeneratorTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.HomeScreen.route
                ) {
                    composable(route = Screen.HomeScreen.route) { HomeScreen(navController) }
                    composable(route = Screen.RecentGeneratedDogsScreen.route) { RecentGeneratedDogsScreen() }
                    composable(route = Screen.GenerateDogsScreen.route) { GenerateDogsScreen() }
                }
            }
        }
    }
}
