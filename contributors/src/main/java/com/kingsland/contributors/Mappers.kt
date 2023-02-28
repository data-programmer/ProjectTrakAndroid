package com.kingsland.contributors

import com.kingsland.contributors.domain.model.ContributorDomain
import com.kingsland.contributors.presentation.model.Contributor
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

fun ContributorDomain.convertToAndroid() = Contributor(
    id = id,
    name = name,
    role = role,
    projectId = projectId
)

fun List<ContributorDomain>.convertContributorDomainToAndroid() = map {
    it.convertToAndroid()
}

fun Contributor.convertToDomain() = ContributorDomain(
    id = id,
    name = name,
    role = role,
    projectId = projectId
)
