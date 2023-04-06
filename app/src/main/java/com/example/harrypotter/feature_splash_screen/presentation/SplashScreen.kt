package com.example.harrypotter.feature_splash_screen.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.airbnb.lottie.Lottie
import com.example.harrypotter.core.presentation.components.Lottie
//import com.airbnb.lottie.Lottie
import com.example.harrypotter.navigation.Direction
import com.example.harrypotter.navigation.NavConstants
import kotlinx.coroutines.delay
import com.example.harrypotter.R

@Composable
fun SplashScreen(
    mainNavHostController: NavHostController
) {

    val direction = Direction(mainNavHostController)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Lottie(
            rawFile = R.raw.magician_nobg,
            isPlaying = true,
            iterations = Int.MAX_VALUE,
            modifier = Modifier
                .size(300.dp)
        )
        
        Spacer(modifier = Modifier.height(24.dp))

        //  text
        Text(
            text = "Hogwarts",
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier
                .wrapContentSize()
        )
    }

    LaunchedEffect(true) {
        delay(3000)

        //  navigate to home screen
        direction.navigateToRoute(
            NavConstants.MAIN_ROUTE,
            NavConstants.SPLASH_ROUTE
        )
    }
}














