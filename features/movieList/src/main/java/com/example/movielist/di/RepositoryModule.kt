package com.example.movielist.di

import com.example.common.mapper.DomainMapper
import com.example.common.mapper.UIMapper
import com.example.movielist.data.mapper.MovieListMapper
import com.example.movielist.data.model.ResultDTO
import com.example.movielist.data.repository.MovieRepositoryImpl
import com.example.movielist.data.service.MovieListAPIService
import com.example.movielist.domain.model.MovieDomain
import com.example.movielist.domain.repository.MovieRepository
import com.example.movielist.presentaiton.mapper.MovieListUIMapper
import com.example.movielist.presentaiton.model.MovieUIModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        moviesService: MovieListAPIService,
        mapper: MovieListMapper
    ): MovieRepository {
        return MovieRepositoryImpl(
            apiService = moviesService,
            defaultDispatcher = Dispatchers.IO,
            mapper,
        )
    }

    @Provides
    @Singleton
    fun provideMapper(): DomainMapper<ResultDTO, MovieDomain> {
        return MovieListMapper()
    }

    @Provides
    @Singleton
    fun provideUIMapper(): UIMapper<MovieDomain, MovieUIModel> {
        return MovieListUIMapper()
    }

}