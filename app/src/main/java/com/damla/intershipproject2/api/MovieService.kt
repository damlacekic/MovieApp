package com.damla.intershipproject2.api

import com.damla.intershipproject2.api.detailModel.Detail
import com.damla.intershipproject2.api.nowPlayingModel.NowPlaying
import com.damla.intershipproject2.api.popularModel.Popular
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("now_playing?api_key=0562a21d4783415360efdb12ffb2eea0&language=en-US")
    suspend fun getNowplayingMovies(): NowPlaying

    @GET("popular?api_key=0562a21d4783415360efdb12ffb2eea0&language=en-US")
    suspend fun getPopularMovies() : Popular

    @GET("{movie_id}?api_key=0562a21d4783415360efdb12ffb2eea0&language=en-US")
    suspend fun getMovieDetail(@Path("movie_id") movie_id : Int) :Detail

}