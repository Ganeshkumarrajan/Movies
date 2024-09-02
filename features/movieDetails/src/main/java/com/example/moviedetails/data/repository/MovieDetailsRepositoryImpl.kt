package com.example.moviedetails.data.repository

import com.example.common.mapper.DomainMapper
import com.example.common.utils.Result
import com.example.moviedetails.data.model.MovieDetail
import com.example.moviedetails.data.service.MovieDetailsAPIService
import com.example.moviedetails.domain.model.MovieDetailsDomain
import com.example.moviedetails.domain.repository.MovieDetailsRepository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(
    private val movieDetailsAPIService: MovieDetailsAPIService,
    private val mapper: DomainMapper<MovieDetail, MovieDetailsDomain>,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : MovieDetailsRepository {
    override suspend fun getMovieDetailsById(movieId: Int): Flow<Result<MovieDetailsDomain>> = flow {
        try {
            val r = movieDetailsAPIService.getMovieDetails(movieId = movieId)
            val result = mapper.toDomain(r)
            emit(Result.Success(result))
        } catch (e: HttpException) {
            emit(Result.Error(e))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }.flowOn(dispatcher)
}
