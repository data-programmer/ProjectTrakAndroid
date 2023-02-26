package com.kingsland.home

import com.kingsland.home.domain.model.TaskDomain
import com.kingsland.home.domain.model.ProjectDomain
import com.kingsland.projecttrakandroid.database.dto.ProjectDto
import com.kingsland.projecttrakandroid.database.dto.TaskDto

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