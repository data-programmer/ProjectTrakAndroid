package com.kingsland.home.domain.repository

import com.kingsland.home.domain.model.StatisticDomain

interface IStatisticRepository {
    fun getAllStatistics(): List<StatisticDomain>
}