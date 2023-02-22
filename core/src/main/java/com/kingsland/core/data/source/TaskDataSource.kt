package com.kingsland.core.data.source

import com.kingsland.core.data.local.dao.TaskDao
import com.kingsland.core.data.local.dto.TaskDto

class TaskDataSource(
    private val taskDao: TaskDao
) {
    suspend fun getAllTasks(): List<TaskDto> = taskDao.getAllTasks()
    suspend fun getAllTasksByProjectId(projectId: Int): List<TaskDto> = taskDao.getAllTasksByProjectId(projectId)
    suspend fun getAllTasksByContributorId(contributorId: Int): List<TaskDto> = taskDao.getAllTasksByContributorId(contributorId)
    suspend fun insertTask(taskDto: TaskDto) { taskDao.insertTask(taskDto) }
    suspend fun updateTask(taskDto: TaskDto) { taskDao.updateTask(taskDto) }
    suspend fun deleteTask(taskDto: TaskDto) { taskDao.deleteTask(taskDto) }
}
