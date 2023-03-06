package com.kingsland.projects.presentation.edit

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kingsland.core.ui.components.Error
import com.kingsland.core.ui.components.Loading
import com.kingsland.projects.R
import com.kingsland.projects.presentation.edit.component.ProjectEdit
import com.kingsland.projects.presentation.model.ProjectEditState
import com.kingsland.projects.presentation.viewmodel.ProjectEditViewModel

@Composable
fun ProjectEditScreen(
    projectId: Int,
    navController: NavController,
    viewModel: ProjectEditViewModel = hiltViewModel()
) {
    val projectEditState = viewModel.projectEditState.collectAsState()
    when (projectEditState.value) {
        is ProjectEditState.Loading -> { Loading() }
        is ProjectEditState.Edit, ProjectEditState.Create -> {
            ProjectEdit(
                navController = navController,
                viewModel = viewModel
            )
        }
        is ProjectEditState.Error -> {
            Error(
                imageVector = Icons.Filled.Close,
                message = stringResource(R.string.pro_detail_error_message),
                buttonText = stringResource(R.string.pro_detail_go_back),
                onClick = { navController.popBackStack() }
            )
        }
    }
}
