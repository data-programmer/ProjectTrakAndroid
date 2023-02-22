package com.kingsland.core.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kingsland.core.data.local.dto.ProjectDto

@Dao
interface ProjectDao {
    @Query("select * from Project")
    fun getAllProjects(): List<ProjectDto>

    @Query("select * from Project where id in (:id)")
    fun getProjectById(id: Int): ProjectDto

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProject(projectDto: ProjectDto)

    @Update
    fun updateProject(projectDto: ProjectDto)

    @Delete
    fun deleteProject(projectDto: ProjectDto)
}