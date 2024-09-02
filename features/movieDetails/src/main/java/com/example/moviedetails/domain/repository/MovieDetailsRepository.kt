package com.example.moviedetails.domain.repository

import com.example.common.utils.Result
import com.example.moviedetails.domain.model.MovieDetailsDomain
import kotlinx.coroutines.flow.Flow

interface MovieDetailsRepository {
    suspend fun getMovieDetailsById(movieId: Int): Flow<Result<MovieDetailsDomain>>
}
