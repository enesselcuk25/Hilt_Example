package com.eneselcuk.bookprojectexample.data.remote.apiService

import com.eneselcuk.bookprojectexample.data.remote.model.AllDogs
import retrofit2.http.GET
import retrofit2.http.Path


//https://dog.ceo/api/breed/hound/images
//https://dog.ceo/api/breeds/list/all

interface DogApi {

    @GET("{a}/{b}/{c}")
    suspend fun getDog(
        @Path("a") bread:String?,
        @Path("b") hound:String?,
        @Path("c") images:String?,
        ): AllDogs

}