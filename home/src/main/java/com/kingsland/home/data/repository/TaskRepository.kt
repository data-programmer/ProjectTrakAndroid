package com.kingsland.home.data.repository

import com.kingsland.home.convertTaskDtoToDomain
import com.kingsland.home.data.source.TaskDataSource
import com.kingsland.home.domain.model.TaskDomain
import com.kingsland.home.domain.repository.ITaskRepository
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val taskDataSource: TaskDataSource
) : ITaskRepository {
    override fun getTasksByStatus(status: Int): List<TaskDomain> = taskDataSource
        .getTasksByStatus(status)
        .convertTaskDtoToDomain()
}
