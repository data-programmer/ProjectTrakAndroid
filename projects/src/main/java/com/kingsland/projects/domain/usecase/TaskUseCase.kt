package com.kingsland.projects.domain.usecase

import com.kingsland.projects.convertTaskDomainToAndroid
import com.kingsland.projects.convertToDomain
import com.kingsland.projects.domain.model.TaskDomain
import com.kingsland.projects.domain.repository.ITaskRepository
import com.kingsland.projects.presentation.model.Task
import javax.inject.Inject

class TaskUseCase @Inject constructor(
    private val taskRepository: ITaskRepository
) {
    suspend fun getAllTasks(): List<Task> = taskRepository.getAllTasks().convertTaskDomainToAndroid()
    suspend fun getAllTasksByProjectId(projectId: Int): List<Task> = taskRepository.getAllTasksByProjectId(projectId).convertTaskDomainToAndroid()
    suspend fun getAllTasksByContributorId(contributorId: Int): List<Task> = taskRepository.getAllTasksByContributorId(contributorId).convertTaskDomainToAndroid()
    suspend fun insertTask(task: Task) { taskRepository.insertTask(task.convertToDomain()) }
    suspend fun updateTask(task: Task) { taskRepository.updateTask(task.convertToDomain()) }
    suspend fun deleteTask(task: Task) { taskRepository.deleteTask(task.convertToDomain()) }
}
