package com.kingsland.projecttrakandroid.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kingsland.contributors.presentation.ContributorsScreen
import com.kingsland.home.presentation.home.HomeScreen
import com.kingsland.projects.presentation.project.ProjectsScreen
import com.kingsland.projecttrakandroid.model.ScaffoldConfig

@Composable
fun ProjectTrakNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    scaffoldConfig: ScaffoldConfig,
    startDestination: Screen = Screen.Home,
) {
    NavHost(
        modifier = modifier.padding(horizontal = 12.dp),
        navController = navController,
        startDestination = startDestination.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                navController = navController,
                viewModel = hiltViewModel()
            )
        }
        composable(Screen.Projects.route) {
            ProjectsScreen(
                navController = navController,
                viewModel = hiltViewModel()
            )
        }
        composable(Screen.Contributors.route) {
            ContributorsScreen(
                navController = navController,
            )
        }
    }
}
