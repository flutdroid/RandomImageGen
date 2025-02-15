package com.project.randomimagegenerator.data.model

/**
 * Model class representing the response from the random image generation API.
 *
 * This class holds the image URL and the status of the API response.
 *
 * @property message The URL of the generated random image.
 * @property status The status of the API response (e.g., "Success", "Error").
 */

data class RandomImageGenModel(
    val message: String,
    val status: String
)