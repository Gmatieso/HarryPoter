package com.example.harrypotter.feature_main_screen.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.canopas.lib.showcase.IntroShowCaseScaffold
import com.example.harrypotter.core.presentation.viewmodel.CoreViewModel
import com.example.harrypotter.feature_main_screen.presentation.bottom_nav.MainBottomNav
import com.example.harrypotter.navigation.graphs.inner_graphs.MainInnerGraph
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navHostController: NavHostController,
    coreVM: CoreViewModel,
    state: ModalBottomSheetState,
    scope: CoroutineScope
) {

    val navController = rememberNavController()
    val context = LocalContext.current

    var showAppIntro by remember {
        mutableStateOf(false)
    }

    IntroShowCaseScaffold(
        showIntroShowCase = showAppIntro,
        onShowCaseCompleted = { showAppIntro = false }
    ) {

        Scaffold(
            bottomBar = {
                MainBottomNav(navHostController = navController)
            }
        ) { contentPadding ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .padding(contentPadding)
            ) {
                //  navgraph for the bottom sheets
                MainInnerGraph(
                    mainNavHostController = navHostController,
                    navHostController = navController,
                    coreViewModel = coreVM,
                    modalSheetState = state,
                    scope = scope
                )
            }

        }

    }

}