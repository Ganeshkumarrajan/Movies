package com.example.moviedetails.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.moviedetails.presentation.viewModel.MovieDetailsViewModel


@Composable
fun MovieDetailsScreen(movieId: Int, onNavigateBack: () -> Unit) {

    val viewModel: MovieDetailsViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    MovieDetailsContent(
        state = state,
        onNavigateBack = onNavigateBack, onRetry = {
            viewModel.onEvent(MovieDetailsEvents.GetMovieDetails(movieId))
        }
    )
}

sealed class MovieDetailsEvents {
    data class GetMovieDetails(val movieID: Int) : MovieDetailsEvents()
}