package com.kingsland.home.domain.usecase

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import com.kingsland.home.convertStatisticDomainToAndroid
import com.kingsland.home.data.repository.StatisticRepository
import com.kingsland.home.presentation.model.Statistic
import javax.inject.Inject

class StatisticUseCase @Inject constructor(
    private val statisticRepository: StatisticRepository
) {
    fun getAllStatistics(): List<Statistic> = statisticRepository
        .getAllStatistics()
        .convertStatisticDomainToAndroid(
            iconList = listOf(
                Icons.Filled.Star,
                Icons.Filled.Home,
                Icons.Filled.Build
            )
        )
}