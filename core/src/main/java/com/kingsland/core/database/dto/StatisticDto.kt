package com.kingsland.core.database.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Statistic")
data class StatisticDto(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "label") val label: String,
    @ColumnInfo(name = "data") val data: Int
)
