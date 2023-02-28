package com.kingsland.contributors.di

import com.kingsland.contributors.data.source.ContributorDataSource
import com.kingsland.core.database.dao.ContributorDao
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
    fun provideContributorDataSource(
        contributorDao: ContributorDao
    ): ContributorDataSource = ContributorDataSource(contributorDao)

}