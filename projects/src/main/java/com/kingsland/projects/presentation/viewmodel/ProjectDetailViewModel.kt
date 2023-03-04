package com.kingsland.projects.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import com.kingsland.core.model.ScaffoldButtonState
import com.kingsland.core.ui.viewmodel.BaseViewModel
import com.kingsland.projects.domain.usecase.ProjectUseCase
import com.kingsland.projects.presentation.model.Project
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

    private val _hasSavedProject = MutableStateFlow(false)
    val hasSavedProject: StateFlow<Boolean> = _hasSavedProject

    private var existingProjectId: Int? = null

    val title: MutableState<String> = mutableStateOf("")
    val priority: MutableState<String> = mutableStateOf("")
    val description: MutableState<String> = mutableStateOf("")

    init {
        savedStateHandle.get<Int>("projectId")?.let { projectId ->
            if (projectId != -1) {
                this.existingProjectId = projectId
                getProjectById(projectId)
            } else {
                _projectEditState.value = ProjectEditState.Create
            }
        }
    }

    private fun getProjectById(projectId: Int) {
        execute(
            action = { projectUseCase.getProjectById(projectId) },
            onSuccess = { project ->
                _projectEditState.value = ProjectEditState.Edit
                title.value = project.title
                priority.value = project.priority
                description.value = project.description
            },
            onFailure = { _projectEditState.value = ProjectEditState.Error(it.message ?: "") }
        )
    }

    fun saveProject() {
        execute(
            action = {
                val project = Project(
                    id = existingProjectId,
                    title = title.value,
                    priority = priority.value,
                    description = description.value,
                    dateCreated = "" // TODO
                )
                when (_projectEditState.value) {
                    is ProjectEditState.Create -> { projectUseCase.insertProject(project) }
                    else -> { projectUseCase.updateProject(project) }
                }
            },
            onSuccess = { _hasSavedProject.value = true },
            onFailure = { _projectEditState.value = ProjectEditState.Error(it.message ?: "") }
        )
    }

}
