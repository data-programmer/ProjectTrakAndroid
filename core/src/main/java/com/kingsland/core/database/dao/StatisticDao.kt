package com.kingsland.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kingsland.core.database.dto.StatisticDto

@Dao
interface StatisticDao {
    @Query("select * from Statistic")
    fun getAllStatistics(): List<StatisticDto>

    @Query("select * from Statistic where id = :id")
    fun getStatisticById(id: Int): StatisticDto

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStatistic(statisticDto: StatisticDto)

    @Update
    fun updateStatistic(statisticDto: StatisticDto)
}
