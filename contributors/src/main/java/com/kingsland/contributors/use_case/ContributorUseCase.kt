package com.kingsland.contributors.use_case

import com.kingsland.contributors.domain.model.ContributorDomain
import com.kingsland.contributors.domain.repository.IContributorRepository

class ContributorUseCase(
    private val contributorRepository: IContributorRepository
) {
    fun getAllContributors(): List<ContributorDomain> = contributorRepository.getAllContributors()
    fun insertContributor(contributor: ContributorDomain) { contributorRepository.insertContributor(contributor) }
    fun updateContributor(contributor: ContributorDomain) { contributorRepository.updateContributor(contributor) }
    fun deleteContributor(contributor: ContributorDomain) { contributorRepository.deleteContributor(contributor) }
}
