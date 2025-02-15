package com.project.randomimagegenerator.presentation.state

import com.project.randomimagegenerator.data.model.RandomImageGenModel

/**
 * Represents the UI state for random image generation.
 *
 * This state class is used in the ViewModel to hold the current state of
 * the random image fetching process, including loading status, data, and errors.
 *
 * @param loading Indicates whether the request is currently in progress.
 * @param randomImageGen Holds the fetched random image data if the request is successful.
 * @param error Contains an error message in case of a failure.
 */
data class RandomImageGenState (
    val loading: Boolean = false,
    val randomImageGen: RandomImageGenModel? = null,
    val error: String = ""
)