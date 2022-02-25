package com.damla.intershipproject2.api

import com.damla.intershipproject2.api.nowPlayingModel.NowPlaying
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepository @Inject constructor(private val service: MovieService) {

    suspend fun getNowPlaying() = service.getNowplayingMovies()
    suspend fun getPopular() = service.getPopularMovies()
    suspend fun getDetail(movieID: Int) = service.getMovieDetail(movieID)

}