package com.example.common

sealed class Screen(val route: String) {
    data object MoviesScreen : Screen("movies_screen")
    data object DetailScreen : Screen("detail_screen")
}