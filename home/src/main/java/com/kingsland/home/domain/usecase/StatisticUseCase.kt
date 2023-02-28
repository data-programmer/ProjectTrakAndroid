package com.kingsland.home.domain.usecase

import com.kingsland.home.presentation.model.Statistic
import javax.inject.Inject

class StatisticUseCase @Inject constructor(

) {
    fun getAllStatistics(): List<Statistic> = ...
}