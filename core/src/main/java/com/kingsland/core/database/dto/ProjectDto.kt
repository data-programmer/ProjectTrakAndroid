package com.kingsland.core.database.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Project")
data class ProjectDto(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "priority") val priority: Int,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "dateCreated") val dateCreated: String
)
