package com.example.moviedetails.di

import com.example.common.DomainMapper
import com.example.moviedetails.data.mapper.MovieDetailsDomainMapper
import com.example.moviedetails.data.model.MovieDetail
import com.example.moviedetails.data.repository.MovieDetailsRepositoryImpl
import com.example.moviedetails.data.service.MovieDetailsAPIService
import com.example.moviedetails.domain.model.MovieDetailsDomain
import com.example.moviedetails.domain.repository.MovieDetailsRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieDetailsRepository(
        moviesDetailsService: MovieDetailsAPIService,
        mapper: MovieDetailsDomainMapper
    ): MovieDetailsRepository {
        return MovieDetailsRepositoryImpl(
            movieDetailsAPIService = moviesDetailsService,
            mapper = mapper
        )
    }

    @Provides
    @Singleton
    fun provideMovieDetailsMapper(): DomainMapper<MovieDetail, MovieDetailsDomain> {
        return MovieDetailsDomainMapper()
    }
}