package com.example.query.onBoardingModule.di

import com.example.query.onBoardingModule.repositories.OnBoardingRepository
import com.example.query.onBoardingModule.repositories.OnBoardingRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class OnBoardingModule {
    @Provides
    @Singleton
    fun provideOnBoardingRepository(
        supabaseClient: SupabaseClient
    ):OnBoardingRepository{
        return OnBoardingRepositoryImpl(supabaseClient)
    }
}