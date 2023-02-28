package com.kingsland.contributors.di

import com.kingsland.contributors.data.repository.ContributorRepository
import com.kingsland.contributors.data.source.ContributorDataSource
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
    fun provideContributorRepository(
        contributorDataSource: ContributorDataSource
    ): ContributorRepository = ContributorRepository(contributorDataSource)

}