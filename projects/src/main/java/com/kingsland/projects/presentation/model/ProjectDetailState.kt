package com.kingsland.projects.presentation.model

sealed class ProjectDetailState {
    object Loading : ProjectDetailState()
    object Loaded : ProjectDetailState()
    data class Error(val message: String) : ProjectDetailState()
}
