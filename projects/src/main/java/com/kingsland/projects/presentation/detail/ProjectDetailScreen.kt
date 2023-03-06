package com.kingsland.projects.presentation.detail

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kingsland.core.ui.components.Loading
import com.kingsland.projects.presentation.model.ProjectDetailState
import com.kingsland.projects.presentation.viewmodel.ProjectDetailViewModel
import com.kingsland.core.ui.components.Error
import com.kingsland.projects.R
import com.kingsland.projects.presentation.detail.component.ProjectDetailLoaded

@Composable
fun ProjectDetailScreen(
    projectId: Int,
    navController: NavController,
    viewModel: ProjectDetailViewModel = hiltViewModel()
) {
    val projectDetailState = viewModel.projectDetailState.collectAsState()
    when (val state = projectDetailState.value) {
        is ProjectDetailState.Loading -> { Loading() }
        is ProjectDetailState.Loaded -> {
            ProjectDetailLoaded(
                project = state.project,
                onProjectEdit = { navController.navigate("") },
                onProjectDelete = { navController.navigate("") }
            )
        }
        is ProjectDetailState.Error -> {
            Error(
                imageVector = Icons.Filled.Close,
                message = stringResource(R.string.pro_detail_error_message),
                buttonText = stringResource(R.string.pro_detail_go_back),
                onClick = { navController.popBackStack() }
            )
        }
    }
}
