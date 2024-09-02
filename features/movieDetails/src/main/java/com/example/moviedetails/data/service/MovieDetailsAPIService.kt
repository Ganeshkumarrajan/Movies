package com.example.moviedetails.data.service

import com.example.common.NetWorkConstants
import com.example.moviedetails.data.model.MovieDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailsAPIService {
    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = NetWorkConstants.API_KEY,
        @Query("language") language: String = NetWorkConstants.LANGUAGE,
    ): MovieDetail
}