package com.kingsland.core

import com.kingsland.core.data.local.dto.ContributorDto
import com.kingsland.core.data.local.dto.ProjectDto
import com.kingsland.core.data.local.dto.TaskDto
import com.kingsland.core.domain.model.ContributorDomain
import com.kingsland.core.domain.model.ProjectDomain
import com.kingsland.core.domain.model.TaskDomain

fun TaskDto.convertToDomain(): TaskDomain = TaskDomain(
    id = this.id,
    title = this.title,
    date = this.date,
    text = this.text,
    priority = this.priority,
    statusDomain = this.status,
    projectId = this.projectId,
    contributorId = this.contributorId
)

fun TaskDomain.convertToSource(): TaskDto = TaskDto(
    id = this.id,
    title = this.title,
    date = this.date,
    text = this.text,
    priority = this.priority,
    status = this.statusDomain,
    projectId = this.projectId,
    contributorId = this.contributorId
)

fun List<TaskDto>.convertTaskDtosToDomain(): List<TaskDomain> = map { taskDto ->
    taskDto.convertToDomain()
}

fun ProjectDto.convertToDomain(): ProjectDomain = ProjectDomain(
    id = this.id,
    name = this.name,
    priority = this.priority,
    dateCreated = this.dateCreated
)

fun ProjectDomain.convertToSource(): ProjectDto = ProjectDto(
    id = this.id,
    name = this.name,
    priority = this.priority,
    dateCreated = this.dateCreated
)

fun List<ProjectDto>.convertProjectDtosToDomain(): List<ProjectDomain> = map { projectDto ->
    projectDto.convertToDomain()
}

fun ContributorDto.convertToDomain(): ContributorDomain = ContributorDomain(
    id = this.id,
    name = this.name,
    role = this.role,
    projectId = this.projectId
)

fun ContributorDomain.convertToSource(): ContributorDto = ContributorDto(
    id = this.id,
    name = this.name,
    role = this.role,
    projectId = this.projectId
)

fun List<ContributorDto>.convertContributorDtosToDomain() = map { contributorDto ->
    contributorDto.convertToDomain()
}
