package com.project.randomimagegenerator.domain.repository

import com.project.randomimagegenerator.data.model.RandomImageGenEntity
import com.project.randomimagegenerator.data.model.RandomImageGenModel

/**
 * Repository interface for handling random image generation operations.
 *
 * This interface defines methods for fetching, storing, and managing
 * random images using both network and local database sources.
 */

interface RandomImageGenRepo {

    suspend fun getRandomImageGenerator(): RandomImageGenModel

    suspend fun addRandomImageGen(randomImageGenEntity: RandomImageGenEntity)

    suspend fun getAllRandomImagesFromDb(): List<RandomImageGenEntity>

    suspend fun deleteAllImages()

    suspend fun latest20Images()
}