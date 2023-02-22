package com.kingsland.core.domain.repository

import com.kingsland.core.domain.model.ContributorDomain

interface IContributorRepository {
    suspend fun getAllContributors(): List<ContributorDomain>
    suspend fun insertContributor(contributorDto: ContributorDomain)
    suspend fun updateContributor(contributorDto: ContributorDomain)
    suspend fun deleteContributor(contributorDto: ContributorDomain)
}