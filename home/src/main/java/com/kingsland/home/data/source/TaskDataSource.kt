package com.kingsland.home.data.source

import com.kingsland.core.database.dao.TaskDao
import com.kingsland.core.database.dto.TaskDto
import javax.inject.Inject

class TaskDataSource @Inject constructor(
    private val taskDao: TaskDao
) {
    fun getAllTasks(): List<TaskDto> = taskDao.getAllTasks()
    fun getAllTasksByProjectId(projectId: Int): List<TaskDto> = taskDao.getAllTasksByProjectId(projectId)
    fun getAllTasksByContributorId(contributorId: Int): List<TaskDto> = taskDao.getAllTasksByContributorId(contributorId)
    fun insertTask(taskDto: TaskDto) { taskDao.insertTask(taskDto) }
    fun updateTask(taskDto: TaskDto) { taskDao.updateTask(taskDto) }
    fun deleteTask(taskDto: TaskDto) { taskDao.deleteTask(taskDto) }
}
