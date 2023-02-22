package com.kingsland.core.domain.use_case

import com.kingsland.core.domain.model.ContributorDomain
import com.kingsland.core.domain.repository.IContributorRepository

class ContributorUseCase(
    private val contributorRepository: IContributorRepository
) {
    suspend fun getAllContributors(): List<ContributorDomain> = contributorRepository.getAllContributors()
    suspend fun insertContributor(contributor: ContributorDomain) { contributorRepository.insertContributor(contributor) }
    suspend fun updateContributor(contributor: ContributorDomain) { contributorRepository.updateContributor(contributor) }
    suspend fun deleteContributor(contributor: ContributorDomain) { contributorRepository.deleteContributor(contributor) }
}
