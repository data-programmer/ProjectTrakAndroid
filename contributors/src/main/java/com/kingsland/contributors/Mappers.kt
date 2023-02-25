package com.kingsland.contributors

import com.kingsland.contributors.domain.model.ContributorDomain
import com.kingsland.core.database.dto.ContributorDto

fun ContributorDto.convertToDomain() = ContributorDomain(
    id = id,
    name = name,
    role = role,
    projectId = projectId
)

fun List<ContributorDto>.convertToContributorDomain() = map {
    it.convertToDomain()
}

fun ContributorDomain.convertToSource() = ContributorDto(
    id = id,
    name = name,
    role = role,
    projectId = projectId
)
