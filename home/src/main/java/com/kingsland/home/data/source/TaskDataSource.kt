package com.kingsland.home.data.source

import com.kingsland.core.database.dao.TaskDao
import com.kingsland.core.database.dto.TaskDto
import javax.inject.Inject

class TaskDataSource @Inject constructor(
    private val taskDao: TaskDao
) {
    fun getTasksByStatus(status: Int): List<TaskDto> = taskDao.getTasksByStatus(status)
}
