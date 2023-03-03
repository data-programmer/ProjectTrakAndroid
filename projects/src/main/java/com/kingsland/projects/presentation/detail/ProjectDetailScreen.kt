package com.kingsland.projects.presentation.detail

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kingsland.projects.presentation.viewmodel.ProjectDetailViewModel

@Composable
fun ProjectDetailScreen(
    projectId: Int,
    navController: NavController,
    viewModel: ProjectDetailViewModel = hiltViewModel()
) {

}
