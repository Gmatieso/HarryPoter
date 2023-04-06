package com.example.harrypotter.navigation.graphs.inner_graphs

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.harrypotter.core.presentation.viewmodel.CoreViewModel
import com.example.harrypotter.feature_houses.presentation.HousesScreen
import com.example.harrypotter.feature_home.presentation.HomeScreen
import com.example.harrypotter.feature_settings.presentation.SettingsScreen
import com.example.harrypotter.navigation.screens.BottomNavScreens
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainInnerGraph(
    mainNavHostController: NavHostController,
    navHostController: NavHostController,
    coreViewModel: CoreViewModel,
    modalSheetState: ModalBottomSheetState,
    scope: CoroutineScope
) {

    NavHost(
        navController = navHostController,
        startDestination = BottomNavScreens.Home.route
    ) {

        composable(route = BottomNavScreens.Home.route) {
            HomeScreen(
                mainNavHostController,
                navHostController,
                coreViewModel,
                state = modalSheetState,
                scope = scope
            )
        }

        composable(route = BottomNavScreens.Houses.route) {
            HousesScreen(
                navHostController,
                coreVM = coreViewModel,
                state = modalSheetState,
                scope = scope
            )
        }

        composable(route = BottomNavScreens.Settings.route) {
            SettingsScreen(navHostController, mainNavHostController)
        }

    }

}