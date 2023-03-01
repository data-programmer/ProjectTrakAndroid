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
import com.kingsland.contributors.presentation.contributor.ContributorsScreen
import com.kingsland.projecttrakandroid.model.ScaffoldState
import com.kingsland.home.presentation.home.HomeScreen
import com.kingsland.projects.presentation.edit.ProjectEditScreen
import com.kingsland.projects.presentation.project.ProjectsScreen

@Composable
fun ProjectTrakNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
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
        composable(Screen.Projects.route) {
            // TODO: Pass this to composable
            scaffoldState.value = ScaffoldState(
                floatingActionButtonAction = { /* navController.navigate("${Screen.EditProject.route}/-1") */ }
            )
            ProjectsScreen(navController = navController)
        }
        composable(Screen.Contributors.route) {
            scaffoldState.value = ScaffoldState(
                floatingActionButtonAction = {  }
            )
            ContributorsScreen(navController = navController)
        }
        // TODO: Might need to use nested graph navigation for projects
//        composable(
//            route = "${Screen.EditProject.route}/{projectId}",
//            arguments = listOf(
//                navArgument(name = "projectId") {
//                    type = NavType.IntType
//                    defaultValue = -1
//                }
//            ),
//        ) { backStackEntry ->
//            val projectId = backStackEntry.arguments?.getInt("projectId") ?: -1
//            scaffoldState.value = ScaffoldState(
//                isFloatingActionButtonVisible = false
//            )
//            ProjectEditScreen(
//                projectId = projectId,
//                navController = navController
//            )
//        }
    }
}
