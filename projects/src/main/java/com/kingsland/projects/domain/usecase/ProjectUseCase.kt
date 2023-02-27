package com.kingsland.projects.domain.usecase

import com.kingsland.projects.domain.model.ProjectDomain
import com.kingsland.projects.domain.repository.IProjectRepository

class ProjectUseCase(
    private val projectRepository: IProjectRepository
) {
    suspend fun getAllProjects(): List<ProjectDomain> = projectRepository.getAllProjects()
    suspend fun getProjectById(projectId: Int): ProjectDomain = projectRepository.getProjectById(projectId)
    suspend fun insertProject(project: ProjectDomain) { projectRepository.insertProject(project) }
    suspend fun updateProject(project: ProjectDomain) { projectRepository.updateProject(project) }
    suspend fun deleteProject(project: ProjectDomain) { projectRepository.deleteProject(project) }
}
