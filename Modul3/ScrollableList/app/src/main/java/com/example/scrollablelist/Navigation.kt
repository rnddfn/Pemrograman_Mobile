package com.example.scrollablelist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val viewModel = ItemViewModel()

    NavHost(navController = navController, startDestination = "home_Screen") {
        composable("home_Screen") {
            HomeScreen(navController, viewModel)
        }
        composable("detail_Screen") {
            val item = viewModel.selectedItem.collectAsState().value
            item?.let {
                DetailScreen(itemData = it, navController = navController)
            }
        }
    }
}
