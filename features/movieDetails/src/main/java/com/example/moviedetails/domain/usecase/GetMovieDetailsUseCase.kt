package com.example.moviedetails.domain.usecase

import com.example.common.utils.Result
import com.example.moviedetails.domain.model.MovieDetailsDomain
import com.example.moviedetails.domain.repository.MovieDetailsRepository
import kotlinx.coroutines.flow.Flow

class GetMovieDetailsUseCase(
    private val movieDetailsRepository: MovieDetailsRepository,
) {
    suspend operator fun invoke(movieId: Int): Flow<Result<MovieDetailsDomain>> =
        movieDetailsRepository.getMovieDetailsById(movieId)
}
