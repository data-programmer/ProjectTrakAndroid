package com.kingsland.projects.presentation.list

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kingsland.core.ui.components.EmptyButton
import com.kingsland.core.ui.components.Error
import com.kingsland.core.ui.components.Loading
import com.kingsland.projects.R
import com.kingsland.projects.presentation.list.component.ProjectsLoaded
import com.kingsland.projects.presentation.model.ProjectState
import com.kingsland.projects.presentation.navigation.ProjectScreen
import com.kingsland.projects.presentation.viewmodel.ProjectListViewModel

@Composable
fun ProjectList(
    navController: NavController,
    viewModel: ProjectListViewModel = hiltViewModel()
) {
    val projectState = viewModel.projectState.collectAsState()
    when (val state = projectState.value) {
        is ProjectState.Loading -> { Loading() }
        is ProjectState.Empty -> {
            EmptyButton(
                imageVector = Icons.Filled.Person,
                message = stringResource(R.string.pro_empty_message),
                buttonIcon = Icons.Filled.Add,
                onButtonClick = { navController.navigate("${ProjectScreen.ProjectEdit.route}/-1") }
            )
        }
        is ProjectState.Loaded -> {
            ProjectsLoaded(
                projects = state.projects,
                onProjectClick = { id -> navController.navigate("${ProjectScreen.ProjectDetail}/$id") },
                onButtonClick = { navController.navigate("${ProjectScreen.ProjectEdit.route}/-1") }
            )
        }
        is ProjectState.Error -> {
            Error(
                imageVector = Icons.Filled.Close,
                message = stringResource(R.string.pro_error_message),
                buttonText = stringResource(R.string.pro_try_again),
                onClick = { viewModel.getProjects() }
            )
        }
    }
}
