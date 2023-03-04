package com.kingsland.home

import androidx.compose.ui.graphics.vector.ImageVector
import com.kingsland.home.domain.model.TaskDomain
import com.kingsland.home.domain.model.ProjectDomain
import com.kingsland.core.database.dto.ProjectDto
import com.kingsland.core.database.dto.StatisticDto
import com.kingsland.core.database.dto.TaskDto
import com.kingsland.home.domain.model.StatisticDomain
import com.kingsland.home.presentation.model.Project
import com.kingsland.home.presentation.model.Statistic
import com.kingsland.home.presentation.model.Task

fun ProjectDto.convertToSource() = ProjectDomain(
    id = id ?: -1,
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

fun StatisticDto.convertToDomain() = StatisticDomain(
    label = label,
    data = data
)

fun StatisticDomain.convertToAndroid(icon: ImageVector) = Statistic(
    label = label,
    data = data,
    icon = icon
)

fun List<StatisticDto>.convertStatisticDtoToDomain() = map {
    it.convertToDomain()
}

fun List<StatisticDomain>.convertStatisticDomainToAndroid(
    iconList: List<ImageVector>
) = mapIndexed { index, statisticDomain ->
    statisticDomain.convertToAndroid(icon = iconList[index])
}
