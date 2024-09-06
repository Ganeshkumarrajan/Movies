package com.example.movielist.domain.usecase

import androidx.paging.PagingData
import com.example.movielist.domain.model.MovieDomain
import com.example.movielist.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMoviesUseCase(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(): Flow<PagingData<MovieDomain>> {
        return movieRepository.getMovies()
    }
}
