package com.kingsland.home.presentation.model

sealed class HomeState {
    object Empty : HomeState()
    object Loading : HomeState()
    data class Loaded(
        val statistics: List<Statistic>,
        val projects: List<Project>,
        val inProgressTasks: List<Task>,
        val backlogTasks: List<Task>
    ) : HomeState()
    data class Error(val message: String) : HomeState()
}
