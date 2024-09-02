package com.example.moviedetails.presentation.viewModel

import androidx.lifecycle.SavedStateHandle
import com.example.common.Result
import com.example.moviedetails.presentation.model.MovieDetailsUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.NetWorkConstants.MOVIE_ID
import com.example.moviedetails.domain.usecase.MovieDetailsUseCases
import com.example.moviedetails.mapper.MovieDetailUIMapper
import com.example.moviedetails.presentation.ui.MovieDetailsEvents
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieDetailsUseCase: MovieDetailsUseCases,
    savedStateHandle: SavedStateHandle,
    private val mapper: MovieDetailUIMapper

) : ViewModel() {
    private val _state = MutableStateFlow<MovieDetailsUIState>(MovieDetailsUIState.Loading)
    val state: StateFlow<MovieDetailsUIState> = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = MovieDetailsUIState.Loading,
    )

    init {
        savedStateHandle.get<Int>(MOVIE_ID)?.let {
            onEvent(MovieDetailsEvents.GetMovieDetails(it))
        }
    }


    fun onEvent(event: MovieDetailsEvents) {
        when (event) {
            is MovieDetailsEvents.GetMovieDetails -> {
                viewModelScope.launch {
                    getMovies(event.movieID)
                }

            }
        }

    }

    private fun getMovies(movieId: Int) {
        viewModelScope.launch {
            movieDetailsUseCase.getMovieDetailsUseCase(movieId).onEach {
                _state.value = when (it) {
                    is Result.Error -> {
                        MovieDetailsUIState.Error(it.exception.message ?: "")
                    }

                    is Result.Success -> {
                        MovieDetailsUIState.Success(mapper.toUiModel(it.data))
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

}
