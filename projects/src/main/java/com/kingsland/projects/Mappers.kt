package com.kingsland.projects

import com.kingsland.core.database.dto.ProjectDto
import com.kingsland.core.database.dto.TaskDto
import com.kingsland.projects.domain.model.ProjectDomain
import com.kingsland.projects.domain.model.TaskDomain
import com.kingsland.projects.presentation.model.Project
import com.kingsland.projects.presentation.model.Task

fun ProjectDto.convertToDomain() = ProjectDomain(
    id = id ?: -1,
    title = name,
    priority = priority,
    description = description,
    dateCreated = dateCreated
)

fun List<ProjectDto>.convertProjectDtoToDomain() = map {
    it.convertToDomain()
}

fun ProjectDomain.convertToDomain() = ProjectDto(
    id = id,
    name = title,
    priority = priority,
    description = description,
    dateCreated = dateCreated
)

fun Project.convertToDomain() = ProjectDomain(
    id = id ?: -1,
    title = title,
    priority = priority,
    description = description,
    dateCreated = dateCreated
)

fun ProjectDomain.convertToAndroid() = Project(
    id = id,
    title = title,
    priority = priority,
    description = description,
    dateCreated = dateCreated
)

fun List<ProjectDomain>.convertProjectDomainToAndroid() = map {
    it.convertToAndroid()
}


fun TaskDto.convertToDomain() = TaskDomain(
    id = id,
    title = title,
    date = date,
    description = text,
    priority = priority,
    statusDomain = status,
    projectId = projectId,
    contributorId = contributorId
)

fun List<TaskDto>.convertTaskDtoToDomain() = map {
    it.convertToDomain()
}

fun TaskDomain.convertToAndroid() = Task(
    id = id,
    title = title,
    dateCreated = date,
    description = description,
    priority = priority,
    status = statusDomain,
    projectId = projectId,
    contributorId = contributorId
)

fun List<TaskDomain>.convertTaskDomainToAndroid() = map {
    it.convertToAndroid()
}

fun Task.convertToDomain() = TaskDomain(
    id = id,
    title = title,
    date = dateCreated,
    description = description,
    priority = priority,
    statusDomain = status,
    projectId = projectId,
    contributorId = contributorId
)

fun TaskDomain.convertToDomain() = TaskDto(
    id = id,
    title = title,
    date = date,
    text = description,
    priority = priority,
    status = statusDomain,
    projectId = projectId,
    contributorId = contributorId
)
