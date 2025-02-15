package com.project.randomimagegenerator.presentation.random_image_gen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.randomimagegenerator.presentation.Screen
import com.project.randomimagegenerator.presentation.ui.theme.buttonColor

/**
 * A Composable function that represents the Home Screen of the app.
 *
 * This screen provides navigation options to generate random dog images or view recently generated images.
 * It consists of a title and two buttons that navigate to respective screens.
 *
 * @param navController The navigation controller used to handle navigation between screens.
 * @receiver Composable
 */

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            "Random Generated Dogs!",
            fontSize = 24.sp,
            modifier = Modifier
                .wrapContentSize()
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                navController.navigate(Screen.GenerateDogsScreen.route)
            }, colors = ButtonDefaults.buttonColors(containerColor = buttonColor)) {
                Text("Generate Dogs!", fontSize = 16.sp)
            }
            Button(onClick = {
                navController.navigate(Screen.RecentGeneratedDogsScreen.route)
            },colors = ButtonDefaults.buttonColors(containerColor = buttonColor)) {
                Text("My Recently Generated Dogs!", fontSize = 16.sp)
            }
        }
    }
}