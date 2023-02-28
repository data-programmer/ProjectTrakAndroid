package com.kingsland.home.presentation.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.kingsland.core.ui.components.Empty
import com.kingsland.home.R
import com.kingsland.core.ui.components.Error
import com.kingsland.home.presentation.home.view.HomeLoaded
import com.kingsland.core.ui.components.Loading
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
        is HomeState.Loading -> { Loading() }
        is HomeState.Empty -> {
            Empty(
                imageVector = Icons.Filled.Create,
                message = stringResource(R.string.empty_message)
            )
        }
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
        is HomeState.Error -> {
            Error(
                imageVector = Icons.Filled.Close,
                message = stringResource(R.string.error_message),
                buttonText = stringResource(R.string.try_again),
                onClick = { viewModel.getHomeData() }
            )
        }
    }
}
