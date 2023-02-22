package com.kingsland.core.domain.repository

import com.kingsland.core.domain.model.TaskDomain

interface ITaskRepository {
    suspend fun getAllTasks(): List<TaskDomain>
    suspend fun getAllTasksByProjectId(projectId: Int): List<TaskDomain>
    suspend fun getAllTasksByContributorId(contributorId: Int): List<TaskDomain>
    suspend fun insertTask(taskDto: TaskDomain)
    suspend fun updateTask(taskDto: TaskDomain)
    suspend fun deleteTask(taskDto: TaskDomain)
}