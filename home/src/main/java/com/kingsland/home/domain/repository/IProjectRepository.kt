package com.kingsland.home.domain.repository

import com.kingsland.home.domain.model.ProjectDomain

interface IProjectRepository {
    fun getAllProjects(): List<ProjectDomain>
    fun getProjectById(projectId: Int): ProjectDomain
    fun insertProject(project: ProjectDomain)
    fun updateProject(project: ProjectDomain)
    fun deleteProject(project: ProjectDomain)
}