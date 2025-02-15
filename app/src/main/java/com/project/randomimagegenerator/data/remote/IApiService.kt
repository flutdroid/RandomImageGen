package com.project.randomimagegenerator.data.remote

import com.project.randomimagegenerator.data.model.RandomImageGenModel
import retrofit2.http.GET

/**
 * Retrofit service interface for fetching random dog images from an API.
 *
 * This interface defines a single API endpoint to retrieve a random dog image.
 */

interface IApiService {

    /**
     * Fetches a random dog image from the API.
     *
     * @return [RandomImageGenModel] containing the image URL and status.
     */
    @GET("/api/breeds/image/random")
    suspend fun getRandomDogImage(): RandomImageGenModel
}