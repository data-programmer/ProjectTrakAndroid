package com.kingsland.home.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.kingsland.home.presentation.home.view.HomeEmpty
import com.kingsland.home.presentation.home.view.HomeError
import com.kingsland.home.presentation.home.view.HomeLoaded
import com.kingsland.home.presentation.home.view.HomeLoading
import com.kingsland.home.presentation.model.HomeState
import com.kingsland.home.presentation.model.Project
import com.kingsland.home.presentation.model.Statistic
import com.kingsland.home.presentation.model.Task
import com.kingsland.home.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel
) {
    val state = viewModel.homeState.collectAsState()
    when (val stateValue = state.value) {
        is HomeState.Loading -> { HomeLoading() }
        is HomeState.Empty -> { HomeEmpty() }
        is HomeState.Loaded -> {
            // TODO: Use stateValue
            HomeLoaded(
                statistics = Statistic.getTestStats(),
                projects = Project.getTestData(),
                tasksInProgress = Task.getTestData(),
                backlogTasks = Task.getTestData(),
                onProjectClick = { id -> navController.navigate("projects/$id") },
                onTaskClick = { id -> navController.navigate("task/$id") },
            )
        }
        is HomeState.Error -> { HomeError() }
    }
}
