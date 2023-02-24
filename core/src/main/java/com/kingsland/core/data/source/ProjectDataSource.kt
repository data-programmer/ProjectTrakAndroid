package com.kingsland.core.data.source

import com.kingsland.core.data.local.dao.ProjectDao
import com.kingsland.core.data.local.dto.ProjectDto

class ProjectDataSource(
    private val projectDao: ProjectDao
) {
    suspend fun getAllProjects(): List<ProjectDto> = projectDao.getAllProjects()
    suspend fun getProjectById(projectId: Int): ProjectDto = projectDao.getProjectById(projectId)
    suspend fun insertProject(projectDto: ProjectDto) { projectDao.insertProject(projectDto) }
    suspend fun updateProject(projectDto: ProjectDto) { projectDao.updateProject(projectDto) }
    suspend fun deleteProject(projectDto: ProjectDto) { projectDao.deleteProject(projectDto) }
}