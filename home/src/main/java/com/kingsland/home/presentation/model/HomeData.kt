package com.kingsland.home.presentation.model

data class HomeData(
    val statistics: List<Statistic>,
    val projects: List<Project>,
    val inProgressTasks: List<Task>,
    val backlogTasks: List<Task>
) {
    fun isEmptyState(): Boolean = projects.isEmpty()
}
