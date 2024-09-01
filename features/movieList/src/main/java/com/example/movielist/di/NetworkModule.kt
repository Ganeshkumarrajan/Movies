package com.example.movielist.di

import com.example.movielist.data.service.MovieListAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
     fun provideApiService(retrofit: Retrofit): MovieListAPIService =
        retrofit.create(MovieListAPIService::class.java)

}