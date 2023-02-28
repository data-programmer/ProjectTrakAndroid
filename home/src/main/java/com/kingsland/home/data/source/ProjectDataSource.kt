package com.kingsland.home.data.source

import com.kingsland.core.database.dao.ProjectDao
import com.kingsland.core.database.dto.ProjectDto
import javax.inject.Inject

class ProjectDataSource @Inject constructor(
    private val projectDao: ProjectDao
) {
    fun getAllProjects(): List<ProjectDto> = projectDao.getAllProjects()
}
