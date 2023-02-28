package com.kingsland.projects.domain.usecase

import com.kingsland.projects.convertProjectDomainToAndroid
import com.kingsland.projects.convertToAndroid
import com.kingsland.projects.convertToDomain
import com.kingsland.projects.domain.model.ProjectDomain
import com.kingsland.projects.domain.repository.IProjectRepository
import com.kingsland.projects.presentation.model.Project
import javax.inject.Inject

class ProjectUseCase @Inject constructor(
    private val projectRepository: IProjectRepository
) {
    fun getAllProjects(): List<Project> = projectRepository.getAllProjects().convertProjectDomainToAndroid()
    fun getProjectById(projectId: Int): Project = projectRepository.getProjectById(projectId).convertToAndroid()
    fun insertProject(project: Project) { projectRepository.insertProject(project.convertToDomain()) }
    fun updateProject(project: Project) { projectRepository.updateProject(project.convertToDomain()) }
    fun deleteProject(project: Project) { projectRepository.deleteProject(project.convertToDomain()) }
}
