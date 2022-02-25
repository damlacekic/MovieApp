package com.damla.intershipproject2.di

import com.damla.intershipproject2.api.ApiRepository
import com.damla.intershipproject2.api.Constant
import com.damla.intershipproject2.api.Constant.Companion.BASE_URL
import com.damla.intershipproject2.api.MovieService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {


    @Singleton
    @Provides
    fun provideRetrofitService(): MovieService = Retrofit.Builder()
        .baseUrl(BASE_URL).addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            )
        ).build().create(MovieService::class.java)



    @Singleton
    @Provides
    fun provideApiRepository(
        service : MovieService
    ):ApiRepository{
        return ApiRepository(service)
    }





}