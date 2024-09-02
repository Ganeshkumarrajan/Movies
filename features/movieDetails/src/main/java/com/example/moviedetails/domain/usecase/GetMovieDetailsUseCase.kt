package com.example.moviedetails.domain.usecase

import com.example.moviedetails.domain.model.MovieDetailsDomain
import kotlinx.coroutines.flow.Flow
import com.example.common.utils.Result
import com.example.moviedetails.domain.repository.MovieDetailsRepository

class GetMovieDetailsUseCase(
    private val movieDetailsRepository: MovieDetailsRepository,
) {
    suspend operator fun invoke(movieId: Int): Flow<Result<MovieDetailsDomain>> = movieDetailsRepository.getMovieDetailsById(movieId)
}
