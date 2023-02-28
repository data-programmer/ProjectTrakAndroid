package com.kingsland.projects.data.repository

import com.kingsland.projects.convertTaskDtoToDomain
import com.kingsland.projects.convertToDomain
import com.kingsland.projects.data.source.TaskDataSource
import com.kingsland.projects.domain.model.TaskDomain
import com.kingsland.projects.domain.repository.ITaskRepository

class TaskRepository(
    private val taskDataSource: TaskDataSource
) : ITaskRepository {
    override suspend fun getAllTasks(): List<TaskDomain> = taskDataSource.getAllTasks().convertTaskDtoToDomain()
    override suspend fun getAllTasksByProjectId(projectId: Int): List<TaskDomain> = taskDataSource.getAllTasksByProjectId(projectId).convertTaskDtoToDomain()
    override suspend fun getAllTasksByContributorId(contributorId: Int): List<TaskDomain> = taskDataSource.getAllTasksByContributorId(contributorId).convertTaskDtoToDomain()
    override suspend fun insertTask(task: TaskDomain) { taskDataSource.insertTask(task.convertToDomain()) }
    override suspend fun updateTask(task: TaskDomain) { taskDataSource.updateTask(task.convertToDomain()) }
    override suspend fun deleteTask(task: TaskDomain) { taskDataSource.deleteTask(task.convertToDomain()) }
}
