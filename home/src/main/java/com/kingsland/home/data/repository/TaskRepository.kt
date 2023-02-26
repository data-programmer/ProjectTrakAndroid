package com.kingsland.home.data.repository

import com.kingsland.home.convertTaskDtoToDomain
import com.kingsland.home.convertToSource
import com.kingsland.home.data.source.TaskDataSource
import com.kingsland.home.domain.model.TaskDomain
import com.kingsland.home.domain.repository.ITaskRepository
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val taskDataSource: TaskDataSource
) : ITaskRepository {
    override fun getAllTasks(): List<TaskDomain> = taskDataSource.getAllTasks().convertTaskDtoToDomain()
    override fun getAllTasksByProjectId(projectId: Int): List<TaskDomain> = taskDataSource.getAllTasksByProjectId(projectId).convertTaskDtoToDomain()
    override fun getAllTasksByContributorId(contributorId: Int): List<TaskDomain> = taskDataSource.getAllTasksByContributorId(contributorId).convertTaskDtoToDomain()
    override fun insertTask(task: TaskDomain) { taskDataSource.insertTask(task.convertToSource()) }
    override fun updateTask(task: TaskDomain) { taskDataSource.updateTask(task.convertToSource()) }
    override fun deleteTask(task: TaskDomain) { taskDataSource.deleteTask(task.convertToSource()) }
}
