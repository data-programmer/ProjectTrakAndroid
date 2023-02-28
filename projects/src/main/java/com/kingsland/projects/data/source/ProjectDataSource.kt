package com.kingsland.projects.data.source

import com.kingsland.core.database.dao.ProjectDao
import com.kingsland.core.database.dto.ProjectDto

class ProjectDataSource(
    private val projectDao: ProjectDao
) {
    fun getAllProjects(): List<ProjectDto> = projectDao.getAllProjects()
    fun getProjectById(projectId: Int): ProjectDto = projectDao.getProjectById(projectId)
    fun insertProject(projectDto: ProjectDto) { projectDao.insertProject(projectDto) }
    fun updateProject(projectDto: ProjectDto) { projectDao.updateProject(projectDto) }
    fun deleteProject(projectDto: ProjectDto) { projectDao.deleteProject(projectDto) }
}
