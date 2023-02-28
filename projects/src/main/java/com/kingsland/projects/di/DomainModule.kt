package com.kingsland.projects.di

import com.kingsland.projects.data.repository.ProjectRepository
import com.kingsland.projects.data.repository.TaskRepository
import com.kingsland.projects.data.source.ProjectDataSource
import com.kingsland.projects.data.source.TaskDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Singleton
    @Provides
    fun provideProjectRepository(
        projectDataSource: ProjectDataSource
    ): ProjectRepository = ProjectRepository(projectDataSource)

    @Singleton
    @Provides
    fun provideTaskRepository(
        taskDataSource: TaskDataSource
    ): TaskRepository = TaskRepository(taskDataSource)

}