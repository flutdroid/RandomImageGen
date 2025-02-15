package com.project.randomimagegenerator.data.repository

import com.project.randomimagegenerator.data.local.RandomImageGenDao
import com.project.randomimagegenerator.data.model.RandomImageGenEntity
import com.project.randomimagegenerator.data.model.RandomImageGenModel
import com.project.randomimagegenerator.data.remote.IApiService
import com.project.randomimagegenerator.domain.repository.RandomImageGenRepo
import javax.inject.Inject

/**
 * Implementation of the `RandomImageGenRepo` interface.
 *
 * This repository provides methods for fetching random dog images from an API
 * and managing them in a local Room database.
 *
 * @property iApiService The API service for fetching images.
 * @property randomImageGenDao The DAO for database operations.
 */

class RandomImageGenRepoImpl @Inject constructor(
    private val iApiService: IApiService,
    private val randomImageGenDao: RandomImageGenDao
) :
    RandomImageGenRepo {
    override suspend fun getRandomImageGenerator(): RandomImageGenModel {
        return iApiService.getRandomDogImage()
    }

    override suspend fun addRandomImageGen(randomImageGenEntity: RandomImageGenEntity) {
        return randomImageGenDao.addRandomImageGen(randomImageGenEntity = randomImageGenEntity)
    }

    override suspend fun getAllRandomImagesFromDb(): List<RandomImageGenEntity> {
        return randomImageGenDao.getAllRandomImages()
    }

    override suspend fun deleteAllImages() {
        return randomImageGenDao.deleteAllImages()
    }

    override suspend fun latest20Images() {
        return randomImageGenDao.latest20Images()
    }
}