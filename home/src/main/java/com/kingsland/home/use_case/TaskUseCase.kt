package com.kingsland.home.use_case

import com.kingsland.home.domain.model.TaskDomain
import com.kingsland.home.domain.repository.ITaskRepository

class TaskUseCase(
    private val taskRepository: ITaskRepository
) {
    fun getAllTasks(): List<TaskDomain> = taskRepository.getAllTasks()
    fun getAllTasksByProjectId(projectId: Int): List<TaskDomain> = taskRepository.getAllTasksByProjectId(projectId)
    fun getAllTasksByContributorId(contributorId: Int): List<TaskDomain> = taskRepository.getAllTasksByContributorId(contributorId)
    fun insertTask(task: TaskDomain) { taskRepository.insertTask(task) }
    fun updateTask(task: TaskDomain) { taskRepository.updateTask(task) }
    fun deleteTask(task: TaskDomain) { taskRepository.deleteTask(task) }
}
