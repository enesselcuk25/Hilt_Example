package com.eneselcuk.bookprojectexample.di

import com.eneselcuk.bookprojectexample.data.remote.apiService.DogApi
import com.eneselcuk.bookprojectexample.repository.DogsRepo
import com.eneselcuk.bookprojectexample.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun repository(api: DogApi) = DogsRepo(api)

    @Provides
    fun bookApi(): DogApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(DogApi::class.java)
    }

}