package com.project.randomimagegenerator.domain.use_case

import com.project.randomimagegenerator.common.Resource
import com.project.randomimagegenerator.data.model.RandomImageGenEntity
import com.project.randomimagegenerator.data.model.RandomImageGenModel
import com.project.randomimagegenerator.domain.repository.RandomImageGenRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Use case class for handling random image generation logic.
 *
 * This class acts as an intermediary between the repository and the ViewModel,
 * handling business logic related to fetching, caching, and managing images.
 *
 * @param randomImageGenRepo The repository responsible for data operations.
 */

class RandomImageGenUseCase @Inject constructor(private val randomImageGenRepo: RandomImageGenRepo) {

    fun getRandomImage(): Flow<Resource<RandomImageGenModel>> = flow {
        try {
            emit(Resource.Loading())
            val randomImageGen = randomImageGenRepo.getRandomImageGenerator()
            emit(Resource.Success(randomImageGen))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "unexpected error"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "No internet connection"))
        }
    }

    fun addRandomImageToRD(randomImageGenEntity: RandomImageGenEntity): Flow<Resource<RandomImageGenEntity>> =
        flow {
            try {
                emit(Resource.Loading())
                randomImageGenRepo.addRandomImageGen(randomImageGenEntity = randomImageGenEntity)
                randomImageGenRepo.latest20Images()
                emit(Resource.Success(randomImageGenEntity))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "Unexpected error"))
            } catch (e: IOException) {
                emit(Resource.Error("No internet connection error"))
            }
        }

    fun getAllRandomImagesFromDb(): Flow<Resource<List<RandomImageGenEntity>>> = flow {
        try {
            emit(Resource.Loading())
            val listOfRandomImages = randomImageGenRepo.getAllRandomImagesFromDb()
            emit(Resource.Success(listOfRandomImages))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "unexpected error"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "No internet connection error"))
        }
    }

    fun deleteAllImages(): Flow<Resource<Unit>> = flow {
        try {
            emit(Resource.Loading())
            val list = randomImageGenRepo.deleteAllImages()
            emit(Resource.Success(Unit))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "unexpected error"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "No internet connection error"))
        }
    }
}