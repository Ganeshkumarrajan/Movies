package com.example.moviedetails.presentation.ui


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.common.navigation.Screen.DetailScreen.ROUTE_WITH_ARGUMENT
import com.example.common.utils.NetWorkConstants.MOVIE_ID

fun NavGraphBuilder.addMovieDetailsScreen(navController: NavController) {
    composable(
        route =ROUTE_WITH_ARGUMENT,
        arguments = listOf(navArgument(MOVIE_ID) { type = NavType.IntType })
    ) {
        val movieId = it.arguments?.getInt(MOVIE_ID) ?: return@composable
        MovieDetailsScreen(
            movieId = movieId,
            onNavigateBack = { navController.popBackStack() }
        )
    }
}
