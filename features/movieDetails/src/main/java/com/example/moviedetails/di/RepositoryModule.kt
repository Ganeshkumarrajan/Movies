package com.example.moviedetails.di

import com.example.common.mapper.DomainMapper
import com.example.common.mapper.UIMapper
import com.example.moviedetails.data.mapper.MovieDetailsDomainMapper
import com.example.moviedetails.data.model.MovieDetail
import com.example.moviedetails.data.repository.MovieDetailsRepositoryImpl
import com.example.moviedetails.data.service.MovieDetailsAPIService
import com.example.moviedetails.domain.model.MovieDetailsDomain
import com.example.moviedetails.domain.repository.MovieDetailsRepository
import com.example.moviedetails.presentation.mapper.MovieDetailUIMapper
import com.example.moviedetails.presentation.model.MovieDetailsUi

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

    @Provides
    @Singleton
    fun provideMovieDetailsUIMapper(): UIMapper<@JvmSuppressWildcards MovieDetailsDomain, MovieDetailsUi> {
        return MovieDetailUIMapper()
    }
}