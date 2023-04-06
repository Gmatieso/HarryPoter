package com.example.harrypotter.navigation.graphs

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.harrypotter.core.presentation.viewmodel.CoreViewModel
import com.example.harrypotter.navigation.NavConstants
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RootNavGraph(
    navHostController: NavHostController,
    coreViewModel: CoreViewModel,
    modalSheetState: ModalBottomSheetState,
    scope: CoroutineScope
) {

    NavHost(
        navController = navHostController,
        startDestination = NavConstants.SPLASH_ROUTE
    ) {

        mainNavGraph(
            navHostController = navHostController,
            coreViewModel = coreViewModel,
            modalSheetState = modalSheetState,
            scope = scope
        )

        splashNavGraph(
            navHostController = navHostController
        )

    }
}