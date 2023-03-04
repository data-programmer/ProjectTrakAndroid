package com.kingsland.projecttrakandroid.di

import com.kingsland.core.model.ScaffoldButtonState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ScaffoldModule {

    @Singleton
    @Provides
    fun provideScaffoldConfig(): ScaffoldButtonState = ScaffoldButtonState.getInstance()

}