package com.kingsland.projects.domain.repository

import com.kingsland.projects.domain.model.ProjectDomain

interface IProjectRepository {
    suspend fun getAllProjects(): List<ProjectDomain>
    suspend fun getProjectById(projectId: Int): ProjectDomain
    suspend fun insertProject(project: ProjectDomain)
    suspend fun updateProject(project: ProjectDomain)
    suspend fun deleteProject(project: ProjectDomain)
}