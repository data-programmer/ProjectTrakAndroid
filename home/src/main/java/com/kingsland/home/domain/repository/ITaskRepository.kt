package com.kingsland.home.domain.repository

import com.kingsland.home.domain.model.TaskDomain

interface ITaskRepository {
    fun getTasksByStatus(status: Int): List<TaskDomain>
}