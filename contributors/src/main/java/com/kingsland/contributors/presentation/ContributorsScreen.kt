package com.kingsland.contributors.presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ContributorsScreen(
    navController: NavController
) {
    Text("This is the contributors screen")
}

@Composable
@Preview(showBackground = true)
fun ContributorsScreenPreview() {
    ContributorsScreen(rememberNavController())
}