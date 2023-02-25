package com.kingsland.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kingsland.core.database.dto.TaskDto

@Dao
interface TaskDao {
    @Query("select * from Task")
    fun getAllTasks(): List<TaskDto>

    @Query("select * from Task where projectId = :projectId")
    fun getAllTasksByProjectId(projectId: Int): List<TaskDto>

    @Query("select * from Task where contributorId = :contributorId")
    fun getAllTasksByContributorId(contributorId: Int): List<TaskDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(taskDto: TaskDto)

    @Update
    fun updateTask(taskDto: TaskDto)

    @Delete
    fun deleteTask(taskDto: TaskDto)

}