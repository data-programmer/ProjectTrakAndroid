package com.kingsland.home.data.repository

import com.kingsland.home.convertProjectDtoToDomain
import com.kingsland.home.data.source.ProjectDataSource
import com.kingsland.home.domain.model.ProjectDomain
import com.kingsland.home.domain.repository.IProjectRepository
import javax.inject.Inject

class ProjectRepository @Inject constructor(
    private val projectDataSource: ProjectDataSource
) : IProjectRepository {
    override fun getAllProjects(): List<ProjectDomain> = projectDataSource
        .getAllProjects()
        .convertProjectDtoToDomain()
}
