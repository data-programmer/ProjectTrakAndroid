package com.kingsland.core.database.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Task")
data class TaskDto(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "status") val status: Int,
    @ColumnInfo(name = "priority") val priority: Int,
    @ColumnInfo(name = "projectId") val projectId: Int,
    @ColumnInfo(name = "contributorId") val contributorId: Int
)