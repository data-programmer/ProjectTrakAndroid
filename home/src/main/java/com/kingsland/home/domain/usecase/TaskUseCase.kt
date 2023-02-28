package com.kingsland.home.domain.usecase

import com.kingsland.home.convertTaskDomainToAndroid
import com.kingsland.home.domain.repository.ITaskRepository
import com.kingsland.home.presentation.model.Task
import javax.inject.Inject

class TaskUseCase @Inject constructor(
    private val taskRepository: ITaskRepository
) {
    fun getTasksByStatus(status: Int): List<Task> = taskRepository
        .getTasksByStatus(status)
        .convertTaskDomainToAndroid()
}
