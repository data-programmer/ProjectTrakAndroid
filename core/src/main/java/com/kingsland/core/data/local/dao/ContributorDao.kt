package com.kingsland.core.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kingsland.core.data.local.dto.Contributor

@Dao
interface ContributorDao {
    @Query("select * from Contributor")
    fun getAllContributors(): List<Contributor>

    @Query("select * from Contributor where projectId == (:projectId)")
    fun getAllContributorsByProject(projectId: Int): List<Contributor>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContributor(contributor: Contributor)

    @Update
    fun updateContributor(contributor: Contributor)

    @Delete
    fun deleteContributor(contributor: Contributor)
}