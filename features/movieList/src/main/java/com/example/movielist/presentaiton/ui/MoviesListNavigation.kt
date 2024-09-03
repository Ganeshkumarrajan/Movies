package com.example.movielist.presentaiton.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.common.navigation.Screen
import com.example.movielist.presentaiton.navigation.MoviesScreen


fun NavGraphBuilder.addMoviesScreen(navController: NavController) {
    composable(Screen.MoviesScreen.route) {
        MoviesScreen(
            onNavigateDetailScreen = { id ->
                navController.navigate(Screen.DetailScreen.createRoute(id))
            }
        )
    }
}