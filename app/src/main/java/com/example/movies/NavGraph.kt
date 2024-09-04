package com.example.movies

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.common.navigation.Screen
import com.example.moviedetails.presentation.ui.addMovieDetailsScreen
import com.example.movielist.presentaiton.ui.addMoviesScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.MoviesScreen.route,
    ) {
        addMoviesScreen(navController)
        addMovieDetailsScreen(navController)
    }
}
