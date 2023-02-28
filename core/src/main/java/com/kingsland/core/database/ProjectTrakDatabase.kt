package com.kingsland.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kingsland.core.database.dao.ContributorDao
import com.kingsland.core.database.dao.ProjectDao
import com.kingsland.core.database.dao.StatisticDao
import com.kingsland.core.database.dao.TaskDao
import com.kingsland.core.database.dto.ContributorDto
import com.kingsland.core.database.dto.ProjectDto
import com.kingsland.core.database.dto.StatisticDto
import com.kingsland.core.database.dto.TaskDto

@Database(
    entities = [
        ProjectDto::class,
        TaskDto::class,
        ContributorDto::class,
        StatisticDto::class
    ],
    version = 1,
    exportSchema = false
)
abstract class ProjectTrakDatabase : RoomDatabase() {
    abstract fun projectDao(): ProjectDao
    abstract fun taskDao(): TaskDao
    abstract fun contributorDao(): ContributorDao
    abstract fun statisticDao(): StatisticDao

    companion object {
        private var instance: ProjectTrakDatabase? = null
        private const val DB_NAME = "projecttrak.db"

        fun getInstance(context: Context): ProjectTrakDatabase {
            synchronized(ProjectTrakDatabase::class.java) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context = context,
                        klass = ProjectTrakDatabase::class.java,
                        name = DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance as ProjectTrakDatabase
            }
        }
    }
}