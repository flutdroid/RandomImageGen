package com.project.randomimagegenerator.presentation.state

import com.project.randomimagegenerator.data.model.RandomImageGenEntity
import com.project.randomimagegenerator.data.model.RandomImageGenModel

/**
 * Represents the UI state for fetching multiple random images.
 *
 * This state class is used in the ViewModel to hold the current state of
 * retrieving multiple stored random images from the database, including
 * loading status, the list of images, and any errors encountered.
 *
 * @param loading Indicates whether the request is currently in progress.
 * @param randomImagesGen Holds the list of random images retrieved from the database.
 * @param error Contains an error message in case of a failure.
 */

data class RandomImagesGenState (
    val loading: Boolean = false,
    val randomImagesGen: List<RandomImageGenEntity> = emptyList(),
    val error: String = ""
)