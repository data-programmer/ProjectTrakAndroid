package com.kingsland.projecttrakandroid.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.kingsland.contributors.presentation.contributor.ContributorsScreen
import com.kingsland.home.presentation.home.HomeScreen
import com.kingsland.projects.presentation.detail.ProjectDetailScreen
import com.kingsland.projects.presentation.edit.ProjectEditScreen
import com.kingsland.projects.presentation.navigation.ProjectScreen
import com.kingsland.projects.presentation.list.ProjectList
import com.kingsland.projecttrakandroid.model.ScaffoldState

@Composable
fun ProjectTrakNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    // TODO: Temp solution
    scaffoldState: MutableState<ScaffoldState>,
    startDestination: Screen = Screen.Home,
) {
    // TODO: Clean this up
    NavHost(
        modifier = modifier.padding(horizontal = 12.dp),
        navController = navController,
        startDestination = startDestination.route
    ) {
        composable(Screen.Home.route) {
            scaffoldState.value = ScaffoldState(
                isFloatingActionButtonVisible = false
            )
            HomeScreen(navController = navController)
        }
        composable(Screen.Contributors.route) {
            scaffoldState.value = ScaffoldState(
                floatingActionButtonAction = {  }
            )
            ContributorsScreen(navController = navController)
        }
        // TODO: Separate these out later
        navigation(
            startDestination = ProjectScreen.ProjectList.route,
            route = Screen.Projects.route
        ) {
            composable(ProjectScreen.ProjectList.route) {
                scaffoldState.value = ScaffoldState(
                    floatingActionButtonAction = { navController.navigate("${ProjectScreen.ProjectEdit.route}/-1") }
                )
                ProjectList(navController = navController)
            }
            composable(
                route = "${ProjectScreen.ProjectDetail.route}/{projectId}",
                arguments = listOf(
                    navArgument(name = "projectId") {
                        type = NavType.IntType
                        defaultValue = -1
                    }
                )
            ) { backStackEntry ->
                scaffoldState.value = ScaffoldState(
                    isFloatingActionButtonVisible = false
                )
                val projectId = backStackEntry.arguments?.getInt("projectId") ?: -1
                ProjectDetailScreen(
                    projectId = projectId,
                    navController = navController
                )
            }
            composable(
                route = "${ProjectScreen.ProjectEdit.route}/{projectId}",
                arguments = listOf(
                    navArgument(name = "projectId") {
                        type = NavType.IntType
                        defaultValue = -1
                    }
                )
            ) { backStackEntry ->
                scaffoldState.value = ScaffoldState(
                    isFloatingActionButtonVisible = false
                )
                val projectId = backStackEntry.arguments?.getInt("projectId") ?: -1
                scaffoldState.value = ScaffoldState(
                    isFloatingActionButtonVisible = false
                )
                ProjectEditScreen(
                    projectId = projectId,
                    navController = navController
                )
            }
        }
    }
}
