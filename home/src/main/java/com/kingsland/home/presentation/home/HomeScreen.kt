package com.kingsland.home.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.kingsland.home.presentation.home.view.HomeEmpty
import com.kingsland.home.presentation.home.view.HomeError
import com.kingsland.home.presentation.home.view.HomeLoaded
import com.kingsland.home.presentation.home.view.HomeLoading
import com.kingsland.home.presentation.model.HomeState
import com.kingsland.home.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel
) {
    val homeState = viewModel.homeState.collectAsState()
    // TODO: Consider a refresh of some type
    viewModel.getHomeData()
    // TODO
    when (val state = homeState.value) {
        is HomeState.Loading -> { HomeLoading() }
        is HomeState.Empty -> { HomeEmpty() }
        is HomeState.Loaded -> {
            HomeLoaded(
                statistics = state.statistics,
                projects = state.projects,
                tasksInProgress = state.inProgressTasks,
                backlogTasks = state.backlogTasks,
                onProjectClick = { id -> navController.navigate("projects/$id") },
                onTaskClick = { id -> navController.navigate("task/$id") },
            )
        }
        is HomeState.Error -> { HomeError { viewModel.getHomeData() } }
    }
}
