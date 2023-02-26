package com.kingsland.home.data.source

import com.kingsland.projecttrakandroid.database.dao.ProjectDao
import com.kingsland.projecttrakandroid.database.dto.ProjectDto
import javax.inject.Inject

class ProjectDataSource @Inject constructor(
    private val projectDao: ProjectDao
) {
    fun getAllProjects(): List<ProjectDto> = projectDao.getAllProjects()
    fun getProjectById(projectId: Int): ProjectDto = projectDao.getProjectById(projectId)
    fun insertProject(projectDto: ProjectDto) { projectDao.insertProject(projectDto) }
    fun updateProject(projectDto: ProjectDto) { projectDao.updateProject(projectDto) }
    fun deleteProject(projectDto: ProjectDto) { projectDao.deleteProject(projectDto) }
}
