package com.kingsland.core.data.local.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "projectId") val projectId: Int
)