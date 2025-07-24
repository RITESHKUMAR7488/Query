package com.example.query.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SupabaseModule {
    @Provides
    @Singleton
    fun provideSupabaseClient():SupabaseClient{
        return createSupabaseClient(
            supabaseUrl ="https://fsusfzwtvzgliwtsgsps.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImZzdXNmend0dnpnbGl3dHNnc3BzIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTMyODYwMzMsImV4cCI6MjA2ODg2MjAzM30.XyUo-_BEl_B60DZorhkRphJxs6XQGAFlLI3q_-7T2KI"
        ){


        }
    }
}