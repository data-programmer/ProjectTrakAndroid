package com.kingsland.home.domain.usecase

import com.kingsland.home.domain.model.ProjectDomain
import com.kingsland.home.domain.repository.IProjectRepository
import javax.inject.Inject

class ProjectUseCase @Inject constructor(
    private val projectRepository: IProjectRepository
) {
    fun getAllProjects(): List<ProjectDomain> = projectRepository.getAllProjects()
    fun getProjectById(projectId: Int): ProjectDomain = projectRepository.getProjectById(projectId)
    fun insertProject(project: ProjectDomain) { projectRepository.insertProject(project) }
    fun updateProject(project: ProjectDomain) { projectRepository.updateProject(project) }
    fun deleteProject(project: ProjectDomain) { projectRepository.deleteProject(project) }
}
