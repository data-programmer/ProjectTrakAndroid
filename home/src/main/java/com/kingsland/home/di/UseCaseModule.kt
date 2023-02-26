package com.kingsland.home.di

import com.kingsland.home.data.repository.ProjectRepository
import com.kingsland.home.data.repository.TaskRepository
import com.kingsland.home.domain.usecase.ProjectUseCase
import com.kingsland.home.domain.usecase.TaskUseCase
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
    fun provideTaskUseCase(
        taskRepository: TaskRepository
    ): TaskUseCase = TaskUseCase(taskRepository)

    @Singleton
    @Provides
    fun provideProjectUseCase(
        projectRepository: ProjectRepository
    ): ProjectUseCase = ProjectUseCase(projectRepository)

}
