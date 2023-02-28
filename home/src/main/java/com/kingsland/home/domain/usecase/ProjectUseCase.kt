package com.kingsland.home.domain.usecase

import com.kingsland.home.convertProjectDomainToAndroid
import com.kingsland.home.domain.repository.IProjectRepository
import com.kingsland.home.presentation.model.Project
import javax.inject.Inject

class ProjectUseCase @Inject constructor(
    private val projectRepository: IProjectRepository
) {
    fun getAllProjects(): List<Project> = projectRepository
        .getAllProjects()
        .convertProjectDomainToAndroid()
}
