package com.example.movielist.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.filter
import androidx.paging.map
import com.example.common.mapper.DomainMapper
import com.example.common.utils.NetWorkConstants
import com.example.movielist.data.service.MovieListAPIService
import com.example.movielist.data.datasource.MovieDataSource
import com.example.movielist.data.model.ResultDTO
import com.example.movielist.domain.model.MovieDomain
import com.example.movielist.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: MovieListAPIService,
    private val defaultDispatcher: CoroutineDispatcher,
    private val mapper: DomainMapper<ResultDTO, MovieDomain>

) : MovieRepository {
    override fun getMovies(): Flow<PagingData<MovieDomain>> {
        return Pager(
            config = PagingConfig(
                pageSize = NetWorkConstants.PAGE_SIZE,
            ),
            pagingSourceFactory = {
                MovieDataSource(
                    apiService = apiService,
                    defaultDispatcher = defaultDispatcher
                )
            },
        ).flow.map {
            //remove duplicate entries from api response
            val movieMap = mutableSetOf<Int>()
            it.filter { movie ->
                if (movieMap.contains(movie.id)) {
                    false
                } else {
                    movieMap.add(movie.id)
                }

            }.map { movie ->
                mapper.toDomain(movie)
            }
        }
    }
}