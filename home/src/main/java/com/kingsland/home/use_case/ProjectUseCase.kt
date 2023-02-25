package com.kingsland.home.use_case

import com.kingsland.home.domain.model.ProjectDomain
import com.kingsland.home.domain.repository.IProjectRepository

class ProjectUseCase(
    private val projectRepository: IProjectRepository
) {
    fun getAllProjects(): List<ProjectDomain> = projectRepository.getAllProjects()
    fun getProjectById(projectId: Int): ProjectDomain = projectRepository.getProjectById(projectId)
    fun insertProject(project: ProjectDomain) { projectRepository.insertProject(project) }
    fun updateProject(project: ProjectDomain) { projectRepository.updateProject(project) }
    fun deleteProject(project: ProjectDomain) { projectRepository.deleteProject(project) }
}
