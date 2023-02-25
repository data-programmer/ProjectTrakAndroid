package com.kingsland.contributors.domain.repository

import com.kingsland.contributors.domain.model.ContributorDomain

interface IContributorRepository {
    fun getAllContributors(): List<ContributorDomain>
    fun insertContributor(contributor: ContributorDomain)
    fun updateContributor(contributor: ContributorDomain)
    fun deleteContributor(contributor: ContributorDomain)
}