package com.kingsland.projects.di

import com.kingsland.projects.data.repository.ProjectRepository
import com.kingsland.projects.data.repository.TaskRepository
import com.kingsland.projects.domain.usecase.ProjectUseCase
import com.kingsland.projects.domain.usecase.TaskUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideProjectUseCase(
        projectRepository: ProjectRepository
    ): ProjectUseCase = ProjectUseCase(projectRepository)

    @Singleton
    @Provides
    fun provideTaskUseCase(
        taskRepository: TaskRepository
    ): TaskUseCase = TaskUseCase(taskRepository)

}
