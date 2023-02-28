package com.kingsland.projects.data.repository

import com.kingsland.projects.convertTaskDtoToDomain
import com.kingsland.projects.convertToDomain
import com.kingsland.projects.data.source.TaskDataSource
import com.kingsland.projects.domain.model.TaskDomain
import com.kingsland.projects.domain.repository.ITaskRepository
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val taskDataSource: TaskDataSource
) : ITaskRepository {
    override fun getAllTasks(): List<TaskDomain> = taskDataSource.getAllTasks().convertTaskDtoToDomain()
    override fun getAllTasksByProjectId(projectId: Int): List<TaskDomain> = taskDataSource.getAllTasksByProjectId(projectId).convertTaskDtoToDomain()
    override fun getAllTasksByContributorId(contributorId: Int): List<TaskDomain> = taskDataSource.getAllTasksByContributorId(contributorId).convertTaskDtoToDomain()
    override fun insertTask(task: TaskDomain) { taskDataSource.insertTask(task.convertToDomain()) }
    override fun updateTask(task: TaskDomain) { taskDataSource.updateTask(task.convertToDomain()) }
    override fun deleteTask(task: TaskDomain) { taskDataSource.deleteTask(task.convertToDomain()) }
}
