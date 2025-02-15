package com.project.randomimagegenerator.di

import android.content.Context
import androidx.room.Room
import com.project.randomimagegenerator.common.Constants
import com.project.randomimagegenerator.data.AppDatabase
import com.project.randomimagegenerator.data.local.RandomImageGenDao
import com.project.randomimagegenerator.data.remote.IApiService
import com.project.randomimagegenerator.data.repository.RandomImageGenRepoImpl
import com.project.randomimagegenerator.domain.repository.RandomImageGenRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Dagger-Hilt module that provides dependencies for the application.
 *
 * This module ensures that necessary components such as the API service,
 * Room database, DAO, and repository are available for dependency injection.
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCryptoApiService(): IApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IApiService::class.java)
    }

    @Provides
    fun provideBookDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "randomImageGenApp"
    ).build()

    @Provides
    fun provideRandomImageDao(
        randomImageDb: AppDatabase
    ) = randomImageDb.randomImageGenDao()

    @Provides
    @Singleton
    fun providesCryptoRepository(
        apiService: IApiService,
        randomImageGenDao: RandomImageGenDao
    ): RandomImageGenRepo {
        return RandomImageGenRepoImpl(
            iApiService = apiService,
            randomImageGenDao = randomImageGenDao
        )
    }
}