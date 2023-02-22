package com.kingsland.core.data.source

import com.kingsland.core.data.local.dao.ContributorDao
import com.kingsland.core.data.local.dto.ContributorDto

class ContributorDataSource(
    private val contributorDao: ContributorDao
) {
    suspend fun getAllContributors(): List<ContributorDto> = contributorDao.getAllContributors()
    suspend fun insertContributor(contributorDto: ContributorDto) { contributorDao.insertContributor(contributorDto) }
    suspend fun updateContributor(contributorDto: ContributorDto) { contributorDao.updateContributor(contributorDto) }
    suspend fun deleteContributor(contributorDto: ContributorDto) { contributorDao.deleteContributor(contributorDto) }
}
