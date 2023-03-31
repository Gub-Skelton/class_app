package com.example.classapp.di

import com.example.classapp.data.DnDApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesDnDApi(): DnDApi =
        Retrofit.Builder()
            .baseUrl("https://www.dnd5eapi.co")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
}