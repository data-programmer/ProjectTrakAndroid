package com.kingsland.core.data.local.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Project(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val projectName: String,
    @ColumnInfo(name = "dateCreated") val dateCreated: String
)
