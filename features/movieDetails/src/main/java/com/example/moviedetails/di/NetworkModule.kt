package com.example.moviedetails.di

import com.example.moviedetails.data.service.MovieDetailsAPIService
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
    fun provideMoviesDetailsService(retrofit: Retrofit): MovieDetailsAPIService =
        retrofit.create(MovieDetailsAPIService::class.java)
}
