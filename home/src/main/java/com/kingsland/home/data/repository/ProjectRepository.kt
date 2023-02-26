package com.kingsland.home.data.repository

import com.kingsland.home.convertProjectDtoToDomain
import com.kingsland.home.convertToSource
import com.kingsland.home.data.source.ProjectDataSource
import com.kingsland.home.domain.model.ProjectDomain
import com.kingsland.home.domain.repository.IProjectRepository
import javax.inject.Inject

class ProjectRepository @Inject constructor(
    private val projectDataSource: ProjectDataSource
) : IProjectRepository {
    override fun getAllProjects(): List<ProjectDomain> = projectDataSource.getAllProjects().convertProjectDtoToDomain()
    override fun getProjectById(projectId: Int): ProjectDomain = projectDataSource.getProjectById(projectId).convertToSource()
    override fun insertProject(project: ProjectDomain) { projectDataSource.insertProject(project.convertToSource()) }
    override fun updateProject(project: ProjectDomain) { projectDataSource.updateProject(project.convertToSource()) }
    override fun deleteProject(project: ProjectDomain) { projectDataSource.deleteProject(project.convertToSource()) }
}
