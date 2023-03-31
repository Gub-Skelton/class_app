package com.example.classapp.di

import com.example.classapp.data.repository.DnDRepository
import com.example.classapp.data.repository.DnDRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindDnDRepository(
        dnDRepositoryImpl: DnDRepositoryImpl
    ): DnDRepository
}