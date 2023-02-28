package com.kingsland.home.data.repository

import com.kingsland.home.convertStatisticDtoToDomain
import com.kingsland.home.data.source.StatisticDataSource
import com.kingsland.home.domain.model.StatisticDomain
import com.kingsland.home.domain.repository.IStatisticRepository
import javax.inject.Inject

class StatisticRepository @Inject constructor(
    private val statisticDataSource: StatisticDataSource
): IStatisticRepository {
    override fun getAllStatistics(): List<StatisticDomain> = statisticDataSource
        .getAllStatistics()
        .convertStatisticDtoToDomain()
}