package com.kingsland.home.di

import com.kingsland.home.data.repository.ProjectRepository
import com.kingsland.home.data.repository.TaskRepository
import com.kingsland.home.data.source.ProjectDataSource
import com.kingsland.home.data.source.TaskDataSource
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
    fun provideTaskRepository(
        taskDataSource: TaskDataSource
    ): TaskRepository = TaskRepository(taskDataSource)

    @Singleton
    @Provides
    fun provideProjectRepository(
        projectDataSource: ProjectDataSource
    ): ProjectRepository = ProjectRepository(projectDataSource)

}
