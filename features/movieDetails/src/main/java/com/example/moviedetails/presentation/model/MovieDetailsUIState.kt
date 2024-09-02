package com.example.moviedetails.presentation.model

sealed class MovieDetailsUIState {
    data object Loading : MovieDetailsUIState()
    data class Success(val data: MovieDetailsUi) : MovieDetailsUIState()
    data class Error(val message: String) : MovieDetailsUIState()
}
