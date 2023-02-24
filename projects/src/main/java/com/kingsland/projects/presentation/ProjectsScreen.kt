package com.kingsland.projects.presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProjectsScreen(
    navController: NavController
) {
    Text("This is the Projects scree!")
}

@Composable
@Preview(showBackground = true)
fun ProjectsScreenPreview() {
    ProjectsScreen(rememberNavController())
}