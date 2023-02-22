package com.kingsland.core.domain.repository

import com.kingsland.core.data.local.dto.ProjectDto
import com.kingsland.core.domain.model.ProjectDomain

interface IProjectRepository {
    suspend fun getAllProjects(): List<ProjectDomain>
    suspend fun getProjectById(projectId: Int): ProjectDomain
    suspend fun insertProject(projectDto: ProjectDomain)
    suspend fun updateProject(projectDto: ProjectDomain)
    suspend fun deleteProject(projectDto: ProjectDomain)
}