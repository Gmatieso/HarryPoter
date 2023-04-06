package com.example.harrypotter.feature_main_screen.presentation.bottom_nav

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.example.harrypotter.navigation.screens.BottomNavScreens

@Composable
fun RowScope.MainBottomNavItem(
    navHostController: NavHostController,
    currentDestination: NavDestination?,
    screen: BottomNavScreens
) {

    NavigationBarItem(

        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,

        onClick = {
            navHostController.navigate(route = screen.route) {
                popUpTo(BottomNavScreens.Home.route)
                launchSingleTop = true
            }
        },

        alwaysShowLabel = true,

        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Bottom Nav Icon"
            )
        },

        label = {
            Text(
                text = screen.title,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                fontWeight = FontWeight.SemiBold
            )
        },

        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = MaterialTheme.colorScheme.primary,
            selectedTextColor = MaterialTheme.colorScheme.secondary,
            indicatorColor = MaterialTheme.colorScheme.tertiary
        )
    )

}
































