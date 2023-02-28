package com.kingsland.projects.data.repository

import com.kingsland.projects.convertProjectDtoToDomain
import com.kingsland.projects.convertToDomain
import com.kingsland.projects.data.source.ProjectDataSource
import com.kingsland.projects.domain.model.ProjectDomain
import com.kingsland.projects.domain.repository.IProjectRepository
import javax.inject.Inject

class ProjectRepository @Inject constructor(
    private val projectDataSource: ProjectDataSource
) : IProjectRepository {
    override fun getAllProjects(): List<ProjectDomain> = projectDataSource.getAllProjects().convertProjectDtoToDomain()
    override fun getProjectById(projectId: Int): ProjectDomain = projectDataSource.getProjectById(projectId).convertToDomain()
    override fun insertProject(project: ProjectDomain) { projectDataSource.insertProject(project.convertToDomain()) }
    override fun updateProject(project: ProjectDomain) { projectDataSource.updateProject(project.convertToDomain()) }
    override fun deleteProject(project: ProjectDomain) { projectDataSource.deleteProject(project.convertToDomain()) }
}
