package com.kingsland.projects

import com.kingsland.core.database.dto.ProjectDto
import com.kingsland.core.database.dto.TaskDto
import com.kingsland.projects.domain.model.ProjectDomain
import com.kingsland.projects.domain.model.TaskDomain

fun ProjectDto.convertToSource() = ProjectDomain(
    id = id,
    name = name,
    priority = priority,
    dateCreated = dateCreated
)

fun List<ProjectDto>.convertProjectDtoToDomain() = map {
    it.convertToSource()
}

fun ProjectDomain.convertToSource() = ProjectDto(
    id = id,
    name = name,
    priority = priority,
    dateCreated = dateCreated
)

fun TaskDto.convertToSource() = TaskDomain(
    id = id,
    title = title,
    date = date,
    text = text,
    priority = priority,
    statusDomain = status,
    projectId = projectId,
    contributorId = contributorId
)

fun List<TaskDto>.convertTaskDtoToDomain() = map {
    it.convertToSource()
}

fun TaskDomain.convertToSource() = TaskDto(
    id = id,
    title = title,
    date = date,
    text = text,
    priority = priority,
    status = statusDomain,
    projectId = projectId,
    contributorId = contributorId
)
