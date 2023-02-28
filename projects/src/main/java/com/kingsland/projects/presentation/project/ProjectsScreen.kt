package com.kingsland.projects.presentation.project

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.kingsland.core.ui.components.Empty
import com.kingsland.core.ui.components.Loading
import com.kingsland.projects.R
import com.kingsland.projects.presentation.model.ProjectState
import com.kingsland.projects.presentation.project.component.ProjectsLoaded
import com.kingsland.projects.presentation.viewmodel.ProjectViewModel
import com.kingsland.core.ui.components.Error

@Composable
fun ProjectsScreen(
    navController: NavController,
    viewModel: ProjectViewModel
) {
    val projectState = viewModel.projectState.collectAsState()
    viewModel.getProjects()
    when (val state = projectState.value) {
        is ProjectState.Loading -> { Loading() }
        is ProjectState.Empty -> {
            Empty(
                imageVector = Icons.Filled.Create,
                message = stringResource(R.string.empty_message)
            )
        }
        is ProjectState.Loaded -> {
            ProjectsLoaded(
                projects = state.projects,
                onProjectClick = { id -> navController.navigate("projects/$id") }
            )
        }
        is ProjectState.Error -> {
            Error(
                imageVector = Icons.Filled.Close,
                message = stringResource(R.string.error_message),
                buttonText = stringResource(R.string.try_again),
                onClick = { viewModel.getProjects() }
            )
        }
    }
}
