package com.kingsland.projects.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import com.kingsland.core.ui.viewmodel.BaseViewModel
import com.kingsland.projects.domain.usecase.ProjectUseCase
import com.kingsland.projects.presentation.model.ProjectEditState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProjectDetailViewModel @Inject constructor(
    private val projectUseCase: ProjectUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private val _projectEditState = MutableStateFlow<ProjectEditState>(ProjectEditState.Loading)
    val projectEditState: StateFlow<ProjectEditState> = _projectEditState

    val title = mutableStateOf("")
    val priority = mutableStateOf("")
    val description = mutableStateOf("")

    private val _hasProjectBeenSaved = MutableStateFlow(false)
    val hasProjectBeenSaved: StateFlow<Boolean> = _hasProjectBeenSaved

    private var existingProjectId: Int? = null

    init {
        savedStateHandle.get<Int>("projectId")?.let { projectId ->
            if (projectId != -1) {
                this.existingProjectId = projectId
                getProjectById(projectId)
            } else {
                _projectEditState.value = ProjectEditState.Edit
            }
        }
    }

    private fun getProjectById(projectId: Int) {
        execute(
            action = { projectUseCase.getProjectById(projectId) },
            onSuccess = { project ->
                _projectEditState.value = ProjectEditState.Edit
                title.value = project.title
                priority.value = project.priority.toString()
                description.value = project.description
            },
            onFailure = {
                _projectEditState.value = ProjectEditState.Error(it.message ?: "")
            }
        )
    }

    fun saveProject() {
        execute(
            action = {  },
            onSuccess = {  },
            onFailure = {  }
        )
    }

}