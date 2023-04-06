package com.example.harrypotter.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.harrypotter.core.domain.model.BottomSheetEvents
import com.example.harrypotter.core.domain.model.CharacterModel
import com.example.harrypotter.core.presentation.components.BottomSheet
import com.example.harrypotter.core.presentation.viewmodel.CoreViewModel
import com.example.harrypotter.feature_home.presentation.util.HomeConstants
import com.example.harrypotter.feature_settings.presentation.util.SettingsConstants
import com.example.harrypotter.navigation.graphs.RootNavGraph
import com.example.harrypotter.ui.theme.HarryPotterTheme
import com.example.harrypotter.feature_home.presentation.components.DetailBottomSheet
import com.example.harrypotter.feature_settings.presentation.viewmodel.SettingsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val settingsViewModel: SettingsViewModel = hiltViewModel()

            //  setting theme using datastore
            HarryPotterTheme(
                darkTheme = when (settingsViewModel.themeFlow.collectAsState(initial = "").value) {
                    SettingsConstants.themeOptions[0].title -> {
                        //  dark theme enabled
                        true
                    }
                    SettingsConstants.themeOptions[0].title -> {
                        //  dark theme disabled
                        false
                    }
                    SettingsConstants.themeOptions[0].title -> {
                        //  follow system enabled
                        isSystemInDarkTheme()
                    }
                    else -> {
                        isSystemInDarkTheme()
                    }
                }
            ) {

                val coreVM: CoreViewModel = hiltViewModel()

                BottomSheet(
                    sheetBackground = androidx.compose.material3.MaterialTheme.colorScheme.onPrimary,
                    topStartRadius = 0.dp,
                    topEndRadius = 0.dp,
                    sheetContent = { state, scope ->

                        when (coreVM.bottomSheetContent.value) {

                            HomeConstants.DETAILS_BOTTOM_SHEET -> {
                                DetailBottomSheet(
                                    character = coreVM.bottomSheetData.value as CharacterModel,
                                    onBackPressed = {
                                        //  close bottomsheet
                                        coreVM.onBottomSheetEvent(
                                            BottomSheetEvents.CloseBottomSheet(
                                            state = state,
                                            scope = scope
                                        ))
                                    }
                                )
                            }
                        }
                    },
                    sheetScope = { state, scope ->

                        RootNavGraph(
                            navHostController = rememberNavController(),
                            coreViewModel = coreVM,
                            modalSheetState = state,
                            scope = scope
                        )

                    },
                    closeBottomSheet = { state, scope ->
                        coreVM.onBottomSheetEvent(BottomSheetEvents.CloseBottomSheet(state, scope))
                    }
                )
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Called")
    }
}
