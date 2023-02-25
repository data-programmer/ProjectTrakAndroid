package com.kingsland.contributors.data.source

import com.kingsland.core.database.dao.ContributorDao
import com.kingsland.core.database.dto.ContributorDto

class ContributorDataSource(
    private val contributorDao: ContributorDao
) {
    fun getAllContributors(): List<ContributorDto> = contributorDao.getAllContributors()
    fun insertContributor(contributorDto: ContributorDto) { contributorDao.insertContributor(contributorDto) }
    fun updateContributor(contributorDto: ContributorDto) { contributorDao.updateContributor(contributorDto) }
    fun deleteContributor(contributorDto: ContributorDto) { contributorDao.deleteContributor(contributorDto) }
}
