package com.alex_ia.myapplication.core.di

import android.content.Context
import com.alex_ia.myapplication.core.plataform.AuthManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HelperModule {

    @Provides
    @Singleton
    fun provideAuthManager(@ApplicationContext context: Context) = AuthManager(context)

}