package com.example.moviedetails.di

import com.example.moviedetails.domain.repository.MovieDetailsRepository
import com.example.moviedetails.domain.usecase.GetMovieDetailsUseCase
import com.example.moviedetails.domain.usecase.MovieDetailsUseCases
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
    fun provideMovieDetailsUseCases(
        movieRepository: MovieDetailsRepository,
    ): MovieDetailsUseCases {
        return MovieDetailsUseCases(
            getMovieDetailsUseCase = GetMovieDetailsUseCase(
                movieDetailsRepository = movieRepository
            )
        )
    }
}
