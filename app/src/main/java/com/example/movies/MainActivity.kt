package com.example.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.common.navigation.Screen
import com.example.moviedetails.presentation.ui.movieDetailsScreen
import com.example.movielist.presentaiton.ui.moviesScreen
import com.example.uielement.theme.MoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
                val navController = rememberNavController()

                NavGraph(
                    navController = navController,
                )
            }
        }
    }
}


@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.MoviesScreen.route,

        ) {
        moviesScreen(navController)
        movieDetailsScreen(navController)
    }
}
