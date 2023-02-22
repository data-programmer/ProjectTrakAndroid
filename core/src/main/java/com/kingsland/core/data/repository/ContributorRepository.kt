package com.kingsland.core.data.repository

import com.kingsland.core.convertContributorDtosToDomain
import com.kingsland.core.convertToSource
import com.kingsland.core.data.local.dto.ContributorDto
import com.kingsland.core.data.source.ContributorDataSource
import com.kingsland.core.domain.model.ContributorDomain
import com.kingsland.core.domain.repository.IContributorRepository

class ContributorRepository(
    private val contributorDataSource: ContributorDataSource
) : IContributorRepository {
    override suspend fun getAllContributors(): List<ContributorDomain> = contributorDataSource.getAllContributors().convertContributorDtosToDomain()
    override suspend fun insertContributor(contributorDto: ContributorDomain) { contributorDataSource.insertContributor(contributorDto.convertToSource()) }
    override suspend fun updateContributor(contributorDto: ContributorDomain) { contributorDataSource.updateContributor(contributorDto.convertToSource()) }
    override suspend fun deleteContributor(contributorDto: ContributorDomain) { contributorDataSource.deleteContributor(contributorDto.convertToSource()) }
}
