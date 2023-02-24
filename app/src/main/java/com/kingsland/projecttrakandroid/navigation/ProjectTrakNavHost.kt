package com.kingsland.projecttrakandroid.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kingsland.contributors.presentation.ContributorsScreen
import com.kingsland.home.presentation.home.HomeScreen
import com.kingsland.home.presentation.viewmodel.HomeViewModel
import com.kingsland.projects.presentation.ProjectsScreen

@Composable
fun ProjectTrakNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: Screen = Screen.Home
) {
    NavHost(
        modifier = modifier.padding(horizontal = 12.dp),
        navController = navController,
        startDestination = startDestination.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                navController = navController,
                viewModel = viewModel()
            )
        }
        composable(Screen.Projects.route) {
            ProjectsScreen(
                navController = navController,
            )
        }
        composable(Screen.Contributors.route) {
            ContributorsScreen(
                navController = navController,
            )
        }
    }
}