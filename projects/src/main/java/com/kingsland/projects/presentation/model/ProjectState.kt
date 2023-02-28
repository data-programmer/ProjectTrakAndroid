package com.kingsland.projects.presentation.model

sealed class ProjectState {
    object Loading : ProjectState()
    object Empty : ProjectState()
    data class Loaded(val projects: List<Project>) : ProjectState()
    data class Error(val message: String) : ProjectState()
}
