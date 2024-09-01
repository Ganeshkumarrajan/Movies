package com.example.movielist.domain.usecase

import androidx.paging.PagingData
import com.example.movielist.domain.repository.MovieRepository
import com.example.movielist.domain.model.MovieDomain
import kotlinx.coroutines.flow.Flow

class GetMoviesUseCase(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): Flow<PagingData<MovieDomain>> {
        return movieRepository.getMovies()
    }
}