package com.project.randomimagegenerator.common

/**
 * A sealed class that represents the state of a resource being loaded.
 *
 * This class is used to encapsulate API responses or any asynchronous operations
 * and handle success, error, and loading states in a structured way.
 *
 * @param T The type of data that this resource holds.
 */

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}