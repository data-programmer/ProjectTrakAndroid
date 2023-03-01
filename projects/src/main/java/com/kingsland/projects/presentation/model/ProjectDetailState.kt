package com.kingsland.projects.presentation.model

sealed class ProjectDetailState {
    object Loading : ProjectDetailState()
    data class Edit(
        var title: String = "",
        var isTitleHintVisible: Boolean = true,
        var priority: Int = 1,
        var isPriorityHintVisible: Boolean = true,
        var description: String = "",
        var isDescriptionHintVisible: Boolean = true,
        var dateCreated: String = ""
    ) : ProjectDetailState()
    data class Error(val message: String) : ProjectDetailState()
}
