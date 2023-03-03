package com.kingsland.projects.presentation.navigation

sealed class ProjectScreen (
    val route: String,
) {
    object ProjectList : ProjectScreen("projectList")
    object ProjectDetail : ProjectScreen("projectDetail")
    object ProjectEdit : ProjectScreen("projectEdit")
}
