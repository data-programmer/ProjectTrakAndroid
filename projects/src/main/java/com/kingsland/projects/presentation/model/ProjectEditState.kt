package com.kingsland.projects.presentation.model

sealed class ProjectEditState {
    object Loading : ProjectEditState()
    object Edit : ProjectEditState()
    data class Error(val message: String) : ProjectEditState()
}
