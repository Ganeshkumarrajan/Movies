package com.example.common.navigation

import com.example.common.utils.NetWorkConstants.MOVIE_ID

sealed class Screen(val route: String) {
    data object MoviesScreen : Screen("movies_screen")
    data object DetailScreen : Screen("detail_screen") {
        const val ROUTE_WITH_ARGUMENT: String = "detail_screen/{$MOVIE_ID}"
        fun createRoute(movieId: String): String = "detail_screen/$movieId"
    }
}
