package com.example.moviedetails.presentation

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import com.example.common.mapper.UIMapper
import com.example.common.utils.Result
import com.example.moviedetails.data.repository.MovieDetailsRepositoryImpl
import com.example.moviedetails.domain.model.MovieDetailsDomain
import com.example.moviedetails.domain.usecase.GetMovieDetailsUseCase
import com.example.moviedetails.domain.usecase.MovieDetailsUseCases
import com.example.moviedetails.presentation.model.MovieDetailsUIState
import com.example.moviedetails.presentation.model.MovieDetailsUi
import com.example.moviedetails.presentation.ui.MovieDetailsEvents
import com.example.moviedetails.presentation.viewModel.MovieDetailsViewModel
import com.example.moviedetails.utils.MainDispatcherRule
import com.example.moviedetails.utils.mockMovieDetailsDomain
import com.example.moviedetails.utils.mockMovieDetailsUI
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.every
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MovieDetailsViewModelTestDTO {

    @get:Rule(order = 0)
    val mockkRule = MockKRule(this)

    @get:Rule(order = 1)
    val mainDispatcherRule = MainDispatcherRule(StandardTestDispatcher())

    private lateinit var viewModel: MovieDetailsViewModel
    private var useCases: MovieDetailsUseCases = mockk()
    private var mapper: UIMapper<MovieDetailsDomain, MovieDetailsUi> = mockk()
    private var movieDetailsRepository: MovieDetailsRepositoryImpl = mockk()
    private val movieID = 1
    private val savedStateHandle: SavedStateHandle = SavedStateHandle()

    @Before
    fun setUp() {

        coEvery {
            useCases.getMovieDetailsUseCase
        } returns GetMovieDetailsUseCase(movieDetailsRepository)


        viewModel = MovieDetailsViewModel(
            useCases, savedStateHandle, mapper
        )

    }


    @Test
    fun `test initial state is Loading`() = runTest {
        viewModel.state.test {
            val item = awaitItem()
            assertThat(item).isEqualTo(MovieDetailsUIState.Loading)
        }
    }

    @Test
    fun `when viewModel invoked with valid movieID verify it returns valid UIState`() = runTest {
        coEvery {
            useCases.getMovieDetailsUseCase(movieID)
        } returns flow {
            emit(Result.Success(mockMovieDetailsDomain))
        }

        every {
            mapper.toUiModel(mockMovieDetailsDomain)
        } returns mockMovieDetailsUI

        viewModel.onEvent(MovieDetailsEvents.GetMovieDetails(movieID))

        viewModel.state.test {
            assertThat(awaitItem()).isEqualTo(MovieDetailsUIState.Loading)
            val nextItem = awaitItem()
            assertThat(nextItem).isEqualTo(MovieDetailsUIState.Success(mockMovieDetailsUI))
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `when viewModel invoked with movieID and error in API call verify it returns error`() =
        runTest {
            val exception = Exception("Error")

            coEvery {
                useCases.getMovieDetailsUseCase(movieID)
            } returns flow {
                emit(Result.Error(exception))
            }

            viewModel = MovieDetailsViewModel(
                useCases, savedStateHandle, mapper
            )

            viewModel.onEvent(MovieDetailsEvents.GetMovieDetails(movieID))

            viewModel.state.test {
                assertThat(awaitItem()).isEqualTo(MovieDetailsUIState.Loading)
                val errorState = awaitItem()
                assertThat(errorState).isEqualTo(MovieDetailsUIState.Error(exception.message ?: ""))
                cancelAndIgnoreRemainingEvents()
            }
        }

    @After
    fun tearDown() {
        clearAllMocks()
    }

}
