package com.example.movielist.presentaiton.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.movielist.presentaiton.model.MovieUIModel
import com.example.movielist.domain.usecase.MoviesUseCases
import com.example.movielist.presentaiton.mapper.MovieListUIMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesUseCases: MoviesUseCases,
    private val uiMapper: MovieListUIMapper,
) : ViewModel() {

    private val _state = MutableStateFlow<PagingData<MovieUIModel>>(PagingData.empty())
    val state: StateFlow<PagingData<MovieUIModel>> = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = PagingData.empty(),
    )

    init {
        getMovies()
    }

    private fun getMovies() {
        moviesUseCases.getMoviesUseCase().cachedIn(viewModelScope).onEach {
            _state.value = it.map { movie -> uiMapper.toUiModel(movie) }
        }.launchIn(viewModelScope)
    }

}


