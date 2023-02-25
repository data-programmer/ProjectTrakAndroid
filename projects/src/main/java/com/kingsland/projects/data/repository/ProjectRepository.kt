package com.kingsland.projects.data.repository

import com.kingsland.projects.convertProjectDtoToDomain
import com.kingsland.projects.convertToSource
import com.kingsland.projects.data.source.ProjectDataSource
import com.kingsland.projects.domain.model.ProjectDomain
import com.kingsland.projects.domain.repository.IProjectRepository

class ProjectRepository(
    private val projectDataSource: ProjectDataSource
) : IProjectRepository {
    override suspend fun getAllProjects(): List<ProjectDomain> = projectDataSource.getAllProjects().convertProjectDtoToDomain()
    override suspend fun getProjectById(projectId: Int): ProjectDomain = projectDataSource.getProjectById(projectId).convertToSource()
    override suspend fun insertProject(project: ProjectDomain) { projectDataSource.insertProject(project.convertToSource()) }
    override suspend fun updateProject(project: ProjectDomain) { projectDataSource.updateProject(project.convertToSource()) }
    override suspend fun deleteProject(project: ProjectDomain) { projectDataSource.deleteProject(project.convertToSource()) }
}
