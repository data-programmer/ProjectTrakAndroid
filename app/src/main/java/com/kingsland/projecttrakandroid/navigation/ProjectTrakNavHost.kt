package com.kingsland.projecttrakandroid.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kingsland.home.presentation.home.HomeScreen

@Composable
fun ProjectTrakNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screens.Home.name
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screens.Home.name) {
            HomeScreen(
                navController = navController,
            )
        }
        composable(Screens.Project.name) {

        }
        composable(Screens.Contributor.name) {

        }
    }
}