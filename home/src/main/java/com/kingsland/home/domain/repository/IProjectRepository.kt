package com.kingsland.home.domain.repository

import com.kingsland.home.domain.model.ProjectDomain

interface IProjectRepository {
    fun getAllProjects(): List<ProjectDomain>
}