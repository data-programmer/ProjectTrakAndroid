package com.kingsland.projecttrakandroid.di

import android.content.Context
import com.kingsland.core.database.ProjectTrakDatabase
import com.kingsland.core.database.dao.ContributorDao
import com.kingsland.core.database.dao.ProjectDao
import com.kingsland.core.database.dao.StatisticDao
import com.kingsland.core.database.dao.TaskDao
import com.kingsland.home.presentation.model.Statistic
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): ProjectTrakDatabase = ProjectTrakDatabase.getInstance(context)

    @Singleton
    @Provides
    fun provideProjectDao(
        database: ProjectTrakDatabase
    ): ProjectDao = database.projectDao()

    @Singleton
    @Provides
    fun provideTaskDao(
        database: ProjectTrakDatabase
    ): TaskDao = database.taskDao()

    @Singleton
    @Provides
    fun provideContributorDao(
        database: ProjectTrakDatabase
    ): ContributorDao = database.contributorDao()

    @Singleton
    @Provides
    fun provideStatisticDao(
        database: ProjectTrakDatabase
    ): StatisticDao = database.statisticDao()
}
