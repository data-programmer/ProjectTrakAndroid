package com.kingsland.home.domain.repository

import com.kingsland.home.domain.model.TaskDomain

interface ITaskRepository {
    fun getAllTasks(): List<TaskDomain>
    fun getAllTasksByProjectId(projectId: Int): List<TaskDomain>
    fun getAllTasksByContributorId(contributorId: Int): List<TaskDomain>
    fun insertTask(task: TaskDomain)
    fun updateTask(task: TaskDomain)
    fun deleteTask(task: TaskDomain)
}