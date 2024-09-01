package com.example.movielist.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movielist.data.service.MovieListAPIService
import com.example.movielist.data.model.ResultDTO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class MovieDataSource(
    private val apiService: MovieListAPIService,
    private val defaultDispatcher: CoroutineDispatcher,
) : PagingSource<Int, ResultDTO>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultDTO> {
        val page = params.key ?: 1
        val prevKey = if (page == 1) null else page - 1
        val nextKey = page + 1
        return try {
            withContext(defaultDispatcher) {
                val response = apiService.getListOfTrendingMovies(page = page)
                LoadResult.Page(
                    data = response.results ?: emptyList(),
                    nextKey = nextKey,
                    prevKey = prevKey
                )
            }

        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ResultDTO>): Int? {
        return state.anchorPosition
    }
}