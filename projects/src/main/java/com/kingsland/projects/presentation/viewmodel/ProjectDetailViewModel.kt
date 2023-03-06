package com.kingsland.projects.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.kingsland.core.ui.viewmodel.BaseViewModel
import com.kingsland.projects.domain.usecase.ProjectUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProjectDetailViewModel @Inject constructor(
    private val projectUseCase: ProjectUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    // TODO: Add state

    private var existingProjectId: Int? = null

    init {
        savedStateHandle.get<Int>("projectId")?.let { projectId ->
            if (projectId != -1) {
                this.existingProjectId = projectId
                getProjectById(projectId)
            } else {

            }
        }
    }

    private fun getProjectById(projectId: Int) {

    }

}