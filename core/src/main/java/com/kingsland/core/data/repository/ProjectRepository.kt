package com.kingsland.core.data.repository

import com.kingsland.core.convertProjectDtosToDomain
import com.kingsland.core.convertToDomain
import com.kingsland.core.convertToSource
import com.kingsland.core.data.local.dto.ProjectDto
import com.kingsland.core.data.source.ProjectDataSource
import com.kingsland.core.domain.model.ProjectDomain
import com.kingsland.core.domain.repository.IProjectRepository

class ProjectRepository(
    private val projectDataSource: ProjectDataSource
) : IProjectRepository {
    override suspend fun getAllProjects(): List<ProjectDomain> = projectDataSource.getAllProjects().convertProjectDtosToDomain()
    override suspend fun getProjectById(projectId: Int): ProjectDomain = projectDataSource.getProjectById(projectId).convertToDomain()
    override suspend fun insertProject(projectDto: ProjectDomain) { projectDataSource.insertProject(projectDto.convertToSource()) }
    override suspend fun updateProject(projectDto: ProjectDomain) { projectDataSource.updateProject(projectDto.convertToSource()) }
    override suspend fun deleteProject(projectDto: ProjectDomain) { projectDataSource.deleteProject(projectDto.convertToSource()) }
}
