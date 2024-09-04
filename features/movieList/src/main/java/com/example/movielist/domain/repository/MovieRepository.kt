package com.example.movielist.domain.repository

import androidx.paging.PagingData
import com.example.movielist.domain.model.MovieDomain
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovies(): Flow<PagingData<MovieDomain>>
}
