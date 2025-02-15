package com.project.randomimagegenerator.presentation.random_image_gen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.randomimagegenerator.common.Resource
import com.project.randomimagegenerator.data.model.RandomImageGenEntity
import com.project.randomimagegenerator.data.model.RandomImageGenModel
import com.project.randomimagegenerator.domain.use_case.RandomImageGenUseCase
import com.project.randomimagegenerator.presentation.state.RandomImageGenState
import com.project.randomimagegenerator.presentation.state.RandomImagesGenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * ViewModel for managing random dog image generation and local storage operations.
 *
 * This ViewModel interacts with the [RandomImageGenUseCase] to fetch images from an API,
 * store them in a local database, and retrieve previously generated images.
 *
 * @property randomImageGenUseCase The use case that handles image generation and storage logic.
 */

@HiltViewModel
class RandomImageGenViewModel @Inject constructor(private val randomImageGenUseCase: RandomImageGenUseCase) :
    ViewModel() {

    private val _state = mutableStateOf(RandomImageGenState())
    val state: State<RandomImageGenState> = _state

    private val _randomImagesState = mutableStateOf(RandomImagesGenState())
    val randomImagesState: State<RandomImagesGenState> = _randomImagesState

    init {
        getAllImagesFromDb()
    }

    fun getRandomImage() {
        randomImageGenUseCase.getRandomImage().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = RandomImageGenState(loading = true)
                }

                is Resource.Success -> {
                    _state.value = RandomImageGenState(
                        randomImageGen = result.data ?: RandomImageGenModel("Anmol", "Success")
                    )
                }

                is Resource.Error -> {
                    _state.value = RandomImageGenState(error = result.message ?: "unexpected error")

                }
            }
        }.launchIn(viewModelScope)
    }

    fun addRandomImageGenToRD(imageUrl: String) {
        randomImageGenUseCase.addRandomImageToRD(RandomImageGenEntity(imageUrl = imageUrl))
            .launchIn(viewModelScope)
    }

    private fun getAllImagesFromDb() {
        randomImageGenUseCase.getAllRandomImagesFromDb().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _randomImagesState.value = RandomImagesGenState(loading = true)
                }

                is Resource.Success -> {
                    _randomImagesState.value =
                        RandomImagesGenState(randomImagesGen = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _randomImagesState.value =
                        RandomImagesGenState(error = result.message ?: "unexpected error")

                }
            }
        }.launchIn(viewModelScope)
    }

    fun deleteAllImages() {
        randomImageGenUseCase.deleteAllImages().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _randomImagesState.value = RandomImagesGenState(loading = true)
                }

                is Resource.Success -> {
                    _randomImagesState.value = RandomImagesGenState(randomImagesGen = emptyList())

                }

                is Resource.Error -> {
                    _randomImagesState.value =
                        RandomImagesGenState(error = result.message ?: "unexpected error")

                }
            }
        }.launchIn(viewModelScope)
    }
}