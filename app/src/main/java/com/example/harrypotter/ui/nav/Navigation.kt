package com.example.harrypotter.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.harrypotter.ui.screens.DetailScreen
import com.example.harrypotter.ui.screens.HomeScreen
import com.example.harrypotter.ui.vm.HarryPotterViewModel
import com.example.harrypotter.util.Constants.Companion.KEY_HOUSE_ID
import com.example.harrypotter.util.Constants.Screens.DETAIL_SCREEN
import com.example.harrypotter.util.Constants.Screens.HOME_SCREEN

sealed class Screens (val route: String) {
    object  Home: Screens(route = HOME_SCREEN)
    object  Details: Screens(route = DETAIL_SCREEN)
}

//Setting up NavHost
@Composable
fun SetupNavHost(navController: NavHostController, harryPotterViewModel: HarryPotterViewModel) {

    NavHost(navController = navController, startDestination = Screens.Home.route) {

        composable(route = Screens.Home.route) {
            HomeScreen(harryPotterViewModel = harryPotterViewModel , navController = navController)
        }

        composable(route = Screens.Details.route + "/{$KEY_HOUSE_ID}") { backStackEntry ->
            DetailScreen(id = backStackEntry.arguments?.getString(KEY_HOUSE_ID)?: "1", harryPotterViewModel = harryPotterViewModel , navController = navController)
        }

    }

}