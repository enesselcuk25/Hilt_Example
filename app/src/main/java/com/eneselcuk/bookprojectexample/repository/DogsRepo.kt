package com.eneselcuk.bookprojectexample.repository

import com.eneselcuk.bookprojectexample.data.remote.apiService.DogApi
import com.eneselcuk.bookprojectexample.data.remote.model.AllDogs
import com.eneselcuk.bookprojectexample.util.Resource


class DogsRepo(private val api: DogApi) {

    suspend fun getDog(): Resource<AllDogs> {
        val response = try {
            api.getDog("breed", "hound", "images")
        } catch (ex: Exception) {
            return Resource.Error(ex.message, null)
        }
        return Resource.Success(response)
    }
}