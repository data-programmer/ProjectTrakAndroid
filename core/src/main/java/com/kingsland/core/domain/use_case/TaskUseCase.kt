package com.kingsland.core.domain.use_case

import com.kingsland.core.domain.model.TaskDomain
import com.kingsland.core.domain.repository.ITaskRepository

class TaskUseCase(
    private val taskRepository: ITaskRepository
) {
    suspend fun getAllTasks(): List<TaskDomain> = taskRepository.getAllTasks()
    suspend fun getAllTasksByProjectId(projectId: Int): List<TaskDomain> = taskRepository.getAllTasksByProjectId(projectId)
    suspend fun getAllTasksByContributorId(contributorId: Int): List<TaskDomain> = taskRepository.getAllTasksByContributorId(contributorId)
    suspend fun insertTask(task: TaskDomain) { taskRepository.insertTask(task) }
    suspend fun updateTask(task: TaskDomain) { taskRepository.updateTask(task) }
    suspend fun deleteTask(task: TaskDomain) { taskRepository.deleteTask(task) }
}
