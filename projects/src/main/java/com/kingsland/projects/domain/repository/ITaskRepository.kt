package com.kingsland.projects.domain.repository

import com.kingsland.projects.domain.model.TaskDomain

interface ITaskRepository {
    suspend fun getAllTasks(): List<TaskDomain>
    suspend fun getAllTasksByProjectId(projectId: Int): List<TaskDomain>
    suspend fun getAllTasksByContributorId(contributorId: Int): List<TaskDomain>
    suspend fun insertTask(task: TaskDomain)
    suspend fun updateTask(task: TaskDomain)
    suspend fun deleteTask(task: TaskDomain)
}