package com.example.moviedetails.data


import com.example.common.mapper.DomainMapper
import com.example.common.utils.Result
import com.example.moviedetails.data.model.MovieDetailDTO
import com.example.moviedetails.data.repository.MovieDetailsRepositoryImpl
import com.example.moviedetails.data.service.MovieDetailsAPIService
import com.example.moviedetails.domain.model.MovieDetailsDomain
import com.example.moviedetails.utils.mockMovieDetailDTO
import com.example.moviedetails.utils.mockMovieDetailsDomain
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response


@ExperimentalCoroutinesApi
class MovieDetailsRepositoryImplTest {

    private val movieDetailsAPIService: MovieDetailsAPIService = mockk()
    private val mapper: DomainMapper<MovieDetailDTO, MovieDetailsDomain> = mockk()
    private lateinit var repository: MovieDetailsRepositoryImpl
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        repository = MovieDetailsRepositoryImpl(movieDetailsAPIService, mapper, testDispatcher)
    }

    @Test
    fun `getMovieDetailsById should return Success when API call is successful`() = runTest {
        val movieId = 1
        val movieDetail = mockMovieDetailDTO
        val movieDetailsDomain = mockMovieDetailsDomain

        coEvery { movieDetailsAPIService.getMovieDetails(movieId) } returns movieDetail
        every { mapper.toDomain(movieDetail) } returns movieDetailsDomain

        val result = repository.getMovieDetailsById(movieId).first()

        assertEquals(Result.Success(movieDetailsDomain), result)
    }

    @Test
    fun `getMovieDetailsById should return Error when API call fails`() = runTest {
        val movieId = 1
        val errorResponse = Response.error<MovieDetailDTO>(404, "Not Found".toResponseBody())
        val httpException = HttpException(errorResponse)

        coEvery { movieDetailsAPIService.getMovieDetails(movieId) } throws httpException

        val result = repository.getMovieDetailsById(movieId).first()

        assertEquals(Result.Error(httpException), result)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
