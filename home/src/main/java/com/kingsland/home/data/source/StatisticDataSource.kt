package com.kingsland.home.data.source

import com.kingsland.core.database.dao.StatisticDao
import com.kingsland.core.database.dto.StatisticDto
import javax.inject.Inject

class StatisticDataSource @Inject constructor(
    private val statisticDao: StatisticDao
) {
    fun getAllStatistics(): List<StatisticDto> = statisticDao.getAllStatistics()
}