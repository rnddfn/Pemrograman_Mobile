package com.example.scrollablelist

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()

    val viewModel: ItemViewModel = viewModel(
        factory = ItemViewModelFactory()
    )

    NavHost(navController = navController, startDestination = "home_Screen") {
        composable("home_Screen") {
            HomeScreen(navController, viewModel)
        }
        composable("detail_Screen") {
            DetailScreen(viewModel = viewModel, navController = navController)
        }
    }
}
