package com.kingsland.core.data.repository

import com.kingsland.core.convertTaskDtosToDomain
import com.kingsland.core.convertToSource
import com.kingsland.core.data.local.dto.TaskDto
import com.kingsland.core.data.source.TaskDataSource
import com.kingsland.core.domain.model.TaskDomain
import com.kingsland.core.domain.repository.ITaskRepository

class TaskRepository(
    private val taskDataSource: TaskDataSource
) : ITaskRepository {
    override suspend fun getAllTasks(): List<TaskDomain> = taskDataSource.getAllTasks().convertTaskDtosToDomain()
    override suspend fun getAllTasksByProjectId(projectId: Int): List<TaskDomain> = taskDataSource.getAllTasksByProjectId(projectId).convertTaskDtosToDomain()
    override suspend fun getAllTasksByContributorId(contributorId: Int): List<TaskDomain> = taskDataSource.getAllTasksByContributorId(contributorId).convertTaskDtosToDomain()
    override suspend fun insertTask(taskDto: TaskDomain) { taskDataSource.insertTask(taskDto.convertToSource()) }
    override suspend fun updateTask(taskDto: TaskDomain) { taskDataSource.updateTask(taskDto.convertToSource()) }
    override suspend fun deleteTask(taskDto: TaskDomain) { taskDataSource.deleteTask(taskDto.convertToSource()) }
}
