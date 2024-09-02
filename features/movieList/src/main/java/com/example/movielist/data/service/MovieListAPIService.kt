package com.example.movielist.data.service

import com.example.common.utils.NetWorkConstants
import com.example.movielist.data.model.MovieDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieListAPIService {

    @GET("discover/movie")
    suspend fun getListOfTrendingMovies(
        @Query("api_key") apiKey: String = NetWorkConstants.API_KEY,
        @Query("language") language: String = NetWorkConstants.LANGUAGE,
        @Query("page") page: Int = 1
    ): MovieDTO
}