package com.kingsland.contributors.di

import com.kingsland.contributors.data.repository.ContributorRepository
import com.kingsland.contributors.domain.usecase.ContributorUseCase
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
    fun provideContributorUseCase(
        contributorRepository: ContributorRepository
    ): ContributorUseCase = ContributorUseCase(contributorRepository)

}