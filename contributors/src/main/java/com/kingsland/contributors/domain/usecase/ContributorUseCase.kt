package com.kingsland.contributors.domain.usecase

import com.kingsland.contributors.convertContributorDomainToAndroid
import com.kingsland.contributors.convertToDomain
import com.kingsland.contributors.domain.repository.IContributorRepository
import com.kingsland.contributors.presentation.model.Contributor
import javax.inject.Inject

class ContributorUseCase @Inject constructor(
    private val contributorRepository: IContributorRepository
) {
    fun getAllContributors(): List<Contributor> = contributorRepository.getAllContributors().convertContributorDomainToAndroid()
    fun insertContributor(contributor: Contributor) { contributorRepository.insertContributor(contributor.convertToDomain()) }
    fun updateContributor(contributor: Contributor) { contributorRepository.updateContributor(contributor.convertToDomain()) }
    fun deleteContributor(contributor: Contributor) { contributorRepository.deleteContributor(contributor.convertToDomain()) }
}
