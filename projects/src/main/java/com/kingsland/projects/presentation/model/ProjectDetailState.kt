package com.kingsland.projects.presentation.model

sealed class ProjectDetailState {
    object Loading : ProjectDetailState()
    data class Loaded(val project: Project) : ProjectDetailState()
    data class Error(val message: String) : ProjectDetailState()
}
