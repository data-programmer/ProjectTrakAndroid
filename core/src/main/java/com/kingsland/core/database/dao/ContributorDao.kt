package com.kingsland.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kingsland.core.database.dto.ContributorDto

@Dao
interface ContributorDao {
    @Query("select * from Contributor")
    fun getAllContributors(): List<ContributorDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContributor(contributorDto: ContributorDto)

    @Update
    fun updateContributor(contributorDto: ContributorDto)

    @Delete
    fun deleteContributor(contributorDto: ContributorDto)
}