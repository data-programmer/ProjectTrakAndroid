package com.kingsland.projects.domain.repository

import com.kingsland.projects.domain.model.ProjectDomain

interface IProjectRepository {
    fun getAllProjects(): List<ProjectDomain>
    fun getProjectById(projectId: Int): ProjectDomain
    fun insertProject(project: ProjectDomain)
    fun updateProject(project: ProjectDomain)
    fun deleteProject(project: ProjectDomain)
}