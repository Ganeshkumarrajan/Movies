package com.example.movielist.presentaiton.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.common.Screen

fun NavGraphBuilder.moviesScreen(navController: NavController) {
    composable(Screen.MoviesScreen.route) {
        MoviesScreen(
            onNavigateDetailScreen = { id ->
                navController.navigate(Screen.DetailScreen.route + "/${id}")
            }
        )
    }
}