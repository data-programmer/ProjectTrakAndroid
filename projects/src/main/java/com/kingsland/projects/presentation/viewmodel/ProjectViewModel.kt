package com.kingsland.projects.presentation.viewmodel

import com.kingsland.core.ui.viewmodel.BaseViewModel
import com.kingsland.projects.domain.usecase.ProjectUseCase
import com.kingsland.projects.presentation.model.ProjectState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProjectViewModel @Inject constructor(
    private val projectUseCase: ProjectUseCase
) : BaseViewModel() {

    private val _projectState = MutableStateFlow<ProjectState>(ProjectState.Loading)
    val projectState: StateFlow<ProjectState> = _projectState

    init {
        getProjects()
    }

    fun getProjects() {
        execute(
            action = {
                _projectState.value = ProjectState.Loading
                projectUseCase.getAllProjects()
            },
            onSuccess = { projects ->
                when (projects.isEmpty()) {
                    true -> { _projectState.value = ProjectState.Empty }
                    false -> {
                        _projectState.value = ProjectState.Loaded(
                            projects = projects
                        )
                    }
                }
            },
            onFailure = {
                _projectState.value = ProjectState.Error(it.message ?: "")
            }
        )
    }

}
