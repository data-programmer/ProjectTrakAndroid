package com.kingsland.core.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kingsland.core.data.local.dao.ContributorDao
import com.kingsland.core.data.local.dao.TaskDao
import com.kingsland.core.data.local.dao.ProjectDao
import com.kingsland.core.data.local.dto.ContributorDto
import com.kingsland.core.data.local.dto.TaskDto
import com.kingsland.core.data.local.dto.ProjectDto

@Database(
    entities = [
        ProjectDto::class,
        TaskDto::class,
        ContributorDto::class
    ],
    version = 1,
    exportSchema = false
)
abstract class ProjectTrakDatabase : RoomDatabase() {
    abstract fun projectDao(): ProjectDao
    abstract fun taskDao(): TaskDao
    abstract fun contributorDao(): ContributorDao

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