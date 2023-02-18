package com.kingsland.core.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kingsland.core.data.local.dto.Project

@Dao
interface ProjectDao {
    @Query("select * from Project")
    fun getAllProjects(): List<Project>

    @Query("select * from Project where id in (:id)")
    fun getProjectById(id: String): Project

    @Query("select * from Project where id in (:id)")
    fun getContributorsProjects(id: String): List<Project>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProject(project: Project)

    @Update
    fun updateProject(project: Project)

    @Delete
    fun deleteProject(project: Project)
}