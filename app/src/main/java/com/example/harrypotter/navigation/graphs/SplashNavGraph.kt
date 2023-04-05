package com.example.harrypotter.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.harrypotter.navigation.NavConstants
import com.example.harrypotter.navigation.screens.Screens
import com.example.harrypotter.presentation.SplashScreen


fun NavGraphBuilder.splashNavGraph(
    navHostController: NavHostController
) {
    navigation(
        startDestination = Screens.Splash.route,
        route = NavConstants.SPLASH_ROUTE
    ) {
        composable(route = Screens.Splash.route) {
            SplashScreen(
                navHostController
            )
        }
    }
}