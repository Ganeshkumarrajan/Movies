package com.example.movielist.di

import com.example.movielist.domain.usecase.MoviesUseCases
import com.example.movielist.domain.repository.MovieRepository
import com.example.movielist.domain.usecase.GetMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideMoviesUseCases(
        movieRepository: MovieRepository,
    ): MoviesUseCases {
        return MoviesUseCases(
            getMoviesUseCase = GetMoviesUseCase(
                movieRepository = movieRepository
            )
        )
    }
}
