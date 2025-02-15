package com.project.randomimagegenerator.presentation.random_image_gen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.randomimagegenerator.presentation.ui.theme.buttonColor
import com.skydoves.landscapist.glide.GlideImage

/**
 * A Composable function that displays a list of recently generated dog images.
 *
 * This screen fetches and displays previously generated dog images from the local Room database.
 * The images are displayed in a horizontally scrollable list (LazyRow), and there is a button
 * to clear all saved images.
 *
 * @receiver Composable
 */

@Composable
fun RecentGeneratedDogsScreen() {
    val viewGenModel: RandomImageGenViewModel = hiltViewModel()
    val state = viewGenModel.randomImagesState.value
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f),
        ) {
            items(state.randomImagesGen) {
                GlideImage(
                    imageModel = it.imageUrl ?: "empty",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f)
                        .padding(horizontal = 8.dp),
                    contentDescription = "Loaded Image",
                    contentScale = ContentScale.Crop,
                    loading = {
                        CircularProgressIndicator(modifier = Modifier.fillMaxWidth())
                    },
                )
            }
        }
        Button(
            onClick = { viewGenModel.deleteAllImages() },
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
        ) {
            Text("Clear Dogs!", fontSize = 16.sp)
        }
    }
}