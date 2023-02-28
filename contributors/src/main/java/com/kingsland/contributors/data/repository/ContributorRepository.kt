package com.kingsland.contributors.data.repository

import com.kingsland.contributors.convertToContributorDomain
import com.kingsland.contributors.convertToSource
import com.kingsland.contributors.data.source.ContributorDataSource
import com.kingsland.contributors.domain.model.ContributorDomain
import com.kingsland.contributors.domain.repository.IContributorRepository
import javax.inject.Inject

class ContributorRepository @Inject constructor(
    private val contributorDataSource: ContributorDataSource
) : IContributorRepository {
    override fun getAllContributors(): List<ContributorDomain> = contributorDataSource.getAllContributors().convertToContributorDomain()
    override fun insertContributor(contributor: ContributorDomain) { contributorDataSource.insertContributor(contributor.convertToSource()) }
    override fun updateContributor(contributor: ContributorDomain) { contributorDataSource.updateContributor(contributor.convertToSource()) }
    override fun deleteContributor(contributor: ContributorDomain) { contributorDataSource.deleteContributor(contributor.convertToSource()) }
}
