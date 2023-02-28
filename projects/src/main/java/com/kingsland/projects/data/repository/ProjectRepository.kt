package com.kingsland.projects.data.repository

import com.kingsland.projects.convertProjectDtoToDomain
import com.kingsland.projects.convertToDomain
import com.kingsland.projects.data.source.ProjectDataSource
import com.kingsland.projects.domain.model.ProjectDomain
import com.kingsland.projects.domain.repository.IProjectRepository

class ProjectRepository(
    private val projectDataSource: ProjectDataSource
) : IProjectRepository {
    override suspend fun getAllProjects(): List<ProjectDomain> = projectDataSource.getAllProjects().convertProjectDtoToDomain()
    override suspend fun getProjectById(projectId: Int): ProjectDomain = projectDataSource.getProjectById(projectId).convertToDomain()
    override suspend fun insertProject(project: ProjectDomain) { projectDataSource.insertProject(project.convertToDomain()) }
    override suspend fun updateProject(project: ProjectDomain) { projectDataSource.updateProject(project.convertToDomain()) }
    override suspend fun deleteProject(project: ProjectDomain) { projectDataSource.deleteProject(project.convertToDomain()) }
}
