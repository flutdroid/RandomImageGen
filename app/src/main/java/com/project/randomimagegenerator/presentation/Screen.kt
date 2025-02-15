package com.project.randomimagegenerator.presentation

/**
 * Sealed class representing the different screens in the application.
 *
 * @property route The unique navigation route for each screen.
 */

sealed class Screen(val route: String) {
    data object HomeScreen: Screen("home_screen")
    data object GenerateDogsScreen: Screen("generated_dogs_screen")
    data object RecentGeneratedDogsScreen: Screen("recent_generated_dogs_screen")
}