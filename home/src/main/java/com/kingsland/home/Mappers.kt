package com.kingsland.home

import com.kingsland.home.domain.model.TaskDomain
import com.kingsland.home.domain.model.ProjectDomain
import com.kingsland.core.database.dto.ProjectDto
import com.kingsland.core.database.dto.TaskDto
import com.kingsland.home.presentation.model.Project
import com.kingsland.home.presentation.model.Task

fun ProjectDto.convertToSource() = ProjectDomain(
    id = id,
    name = name,
    priority = priority,
    description = description,
    dateCreated = dateCreated
)

fun List<ProjectDto>.convertProjectDtoToDomain() = map {
    it.convertToSource()
}

fun ProjectDomain.convertToSource() = ProjectDto(
    id = id,
    name = name,
    priority = priority,
    description = description,
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

fun Project.convertToDomain() = ProjectDomain(
    id = id,
    name = title,
    priority = priority,
    description = description,
    dateCreated = dateCreated
)

fun ProjectDomain.convertToAndroid() = Project(
    id = id,
    title = name,
    priority = priority,
    description = description,
    dateCreated = dateCreated
)

fun List<ProjectDomain>.convertProjectDomainToAndroid() = map {
    it.convertToAndroid()
}

fun Task.convertToDomain() = TaskDomain(
    id = id,
    title = title,
    date = dateCreated,
    text = description,
    priority = priority,
    statusDomain = status,
    projectId = projectId,
    contributorId = contributorId
)

fun TaskDomain.convertToAndroid() = Task(
    id = id,
    title = title,
    dateCreated = date,
    description = text,
    priority = priority,
    status = statusDomain,
    projectId = projectId,
    contributorId = contributorId
)

fun List<TaskDomain>.convertTaskDomainToAndroid() = map {
    it.convertToAndroid()
}
