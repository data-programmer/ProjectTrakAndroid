package com.kingsland.projects.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.kingsland.core.ui.viewmodel.BaseViewModel
import com.kingsland.projects.domain.usecase.ProjectUseCase
import com.kingsland.projects.presentation.model.ProjectDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProjectDetailViewModel @Inject constructor(
    private val projectUseCase: ProjectUseCase,
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private val _projectDetailState = MutableStateFlow<ProjectDetailState>(ProjectDetailState.Loading)
    val projectDetailState: StateFlow<ProjectDetailState> = _projectDetailState

    private val _hasProjectBeenSaved = MutableStateFlow(false)
    val hasProjectBeenSaved: StateFlow<Boolean> = _hasProjectBeenSaved

    private var existingProjectId: Int? = null

    init {
        savedStateHandle.get<Int>("projectId")?.let { projectId ->
            if (projectId != -1) {
                this.existingProjectId = projectId
                getProjectById(projectId)
            } else {
                _projectDetailState.value = ProjectDetailState.Edit()
            }
        }
    }

    private fun getProjectById(projectId: Int) {
        execute(
            action = { projectUseCase.getProjectById(projectId) },
            onSuccess = { project ->
                _projectDetailState.value = ProjectDetailState.Edit(
                    title = project.title,
                    priority = project.priority,
                    description = project.description,
                    dateCreated = project.dateCreated
                )
            },
            onFailure = {
                _projectDetailState.value = ProjectDetailState.Error(it.message ?: "")
            }
        )
    }

}