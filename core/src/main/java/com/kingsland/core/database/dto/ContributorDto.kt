package com.kingsland.core.database.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contributor")
data class ContributorDto(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "role") val role: String,
    @ColumnInfo(name = "projectId") val projectId: Int
)
