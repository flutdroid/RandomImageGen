package com.project.randomimagegenerator.presentation.random_image_gen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.randomimagegenerator.R
import com.project.randomimagegenerator.presentation.ui.theme.buttonColor
import com.skydoves.landscapist.glide.GlideImage

/**
 * A Composable function that displays a screen for generating random dog images.
 *
 * This screen fetches a random dog image from an API and displays it using the GlideImage library.
 * It also includes a button to generate a new random dog image.
 * If an image is being loaded, a CircularProgressIndicator is displayed.
 *
 * @receiver Composable
 */


@Composable
fun GenerateDogsScreen() {
    val randomImageGenViewModel: RandomImageGenViewModel = hiltViewModel()
    val state = randomImageGenViewModel.state.value
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f)
        ) {
            if (state.randomImageGen?.message != null) {
                GlideImage(
                    imageModel = state.randomImageGen.message,
                    contentDescription = "Loaded Image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize(),
                    loading = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .size(30.dp)
                                    .align(Alignment.Center)
                            )
                        }
                    },
                    failure = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "Failed to Load",
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(16f / 9f),
                            contentScale = ContentScale.Fit
                        )
                    },
                )
            }
        }
        Button(onClick = {
            randomImageGenViewModel.getRandomImage()
        }, colors = ButtonDefaults.buttonColors(containerColor = buttonColor)) {
            Text("Generate Dogs", fontSize = 16.sp)
        }
    }

    LaunchedEffect(state.randomImageGen) {
        if (state.randomImageGen?.message?.isNotEmpty() == true) {
            randomImageGenViewModel.addRandomImageGenToRD(state.randomImageGen.message)
        }
    }
}