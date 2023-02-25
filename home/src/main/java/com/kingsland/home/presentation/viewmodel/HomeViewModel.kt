package com.kingsland.home.presentation.viewmodel

import com.kingsland.core.ui.viewmodel.BaseViewModel
import com.kingsland.home.data.repository.ProjectRepository
import com.kingsland.home.data.repository.TaskRepository
import com.kingsland.home.presentation.model.HomeState
import com.kingsland.home.presentation.model.Project
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(
    private val projectRepository: ProjectRepository,
    private val taskRepository: TaskRepository
) : BaseViewModel() {

    private val _homeState = MutableStateFlow<HomeState>(HomeState.Loading)
    val homeState: StateFlow<HomeState> = _homeState

    init {

    }

    private suspend fun demo() {
        val d = executeAsync(action = projectRepository::getAllProjects)
        val projects = d.await()
    }

    private fun getProjects() {
        execute(
            action = {
                // TODO: Hook up with use case function
            },
            onSuccess = { projects ->

            },
            onFailure = {
                _homeState.value = HomeState.Error(it.localizedMessage ?: "")
            }
        )
    }

    private fun getInProgressTasks() {
        execute(
            action = {
                // TODO: Hook up with use case function
            },
            onSuccess = { tasks ->

            },
            onFailure = {
                _homeState.value = HomeState.Error(it.localizedMessage ?: "")
            }
        )
    }

    private fun getBacklogTasks() {
        execute(
            action = {
                // TODO: Hook up with use case function
            },
            onSuccess = { tasks ->

            },
            onFailure = {
                _homeState.value = HomeState.Error(it.localizedMessage ?: "")
            }
        )
    }
}