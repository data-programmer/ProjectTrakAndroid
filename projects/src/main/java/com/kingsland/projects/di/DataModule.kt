package com.kingsland.projects.di

import com.kingsland.core.database.dao.ProjectDao
import com.kingsland.core.database.dao.TaskDao
import com.kingsland.projects.data.source.ProjectDataSource
import com.kingsland.projects.data.source.TaskDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideProjectDataSource(
        projectDao: ProjectDao
    ): ProjectDataSource = ProjectDataSource(projectDao)

    @Singleton
    @Provides
    fun provideTaskDataSource(
        taskDao: TaskDao
    ): TaskDataSource = TaskDataSource(taskDao)

}
