package com.kingsland.contributors.presentation.contributor

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kingsland.contributors.presentation.viewmodel.ContributorViewModel

@Composable
fun ContributorsScreen(
    navController: NavController,
    viewModel: ContributorViewModel
) {
    Text("This is the contributors screen")
}
