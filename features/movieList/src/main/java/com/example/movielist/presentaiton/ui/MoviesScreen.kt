package com.example.movielist.presentaiton.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.movielist.presentaiton.viewModel.MoviesViewModel

@Composable
fun MoviesScreen(onNavigateDetailScreen: (String) -> Unit) {
    val viewModel: MoviesViewModel = hiltViewModel()
    val trendingMoviesPagingItem = viewModel.state.collectAsLazyPagingItems()

    MoviesContent(
        moviePagingItem = trendingMoviesPagingItem,
        onNavigateDetailScreen = onNavigateDetailScreen
    )
}
