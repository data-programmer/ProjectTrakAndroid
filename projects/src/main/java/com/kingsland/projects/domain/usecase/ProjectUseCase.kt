package com.kingsland.projects.domain.usecase

import com.kingsland.projects.convertProjectDomainToAndroid
import com.kingsland.projects.convertToAndroid
import com.kingsland.projects.convertToDomain
import com.kingsland.projects.domain.model.ProjectDomain
import com.kingsland.projects.domain.repository.IProjectRepository
import com.kingsland.projects.presentation.model.Project

class ProjectUseCase(
    private val projectRepository: IProjectRepository
) {
    suspend fun getAllProjects(): List<Project> = projectRepository.getAllProjects().convertProjectDomainToAndroid()
    suspend fun getProjectById(projectId: Int): Project = projectRepository.getProjectById(projectId).convertToAndroid()
    suspend fun insertProject(project: Project) { projectRepository.insertProject(project.convertToDomain()) }
    suspend fun updateProject(project: Project) { projectRepository.updateProject(project.convertToDomain()) }
    suspend fun deleteProject(project: Project) { projectRepository.deleteProject(project.convertToDomain()) }
}
