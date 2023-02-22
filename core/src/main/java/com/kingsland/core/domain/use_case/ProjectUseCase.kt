package com.kingsland.core.domain.use_case

import com.kingsland.core.domain.model.ProjectDomain
import com.kingsland.core.domain.repository.IProjectRepository

class ProjectUseCase(
    private val projectRepository: IProjectRepository
) {
    suspend fun getAllProjects(): List<ProjectDomain> = projectRepository.getAllProjects()
    suspend fun getProjectById(projectId: Int): ProjectDomain = projectRepository.getProjectById(projectId)
    suspend fun insertProject(project: ProjectDomain) { projectRepository.insertProject(project) }
    suspend fun updateProject(project: ProjectDomain) { projectRepository.updateProject(project) }
    suspend fun deleteProject(project: ProjectDomain) { projectRepository.deleteProject(project) }
}
