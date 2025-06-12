package com.example.retrofit.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.retrofit.presentation.detail.DetailScreen
import com.example.retrofit.presentation.home.HomeScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home_screen",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home_screen") {
                HomeScreen(navController = navController)
            }

            composable("detail_screen/{movieId}") { backStackEntry ->
                val movieId = backStackEntry.arguments?.getString("movieId")?.toIntOrNull() ?: 0
                DetailScreen(
                    movieId = movieId,
                    navController = navController,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}