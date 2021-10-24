package com.alex_ia.myapplication.core.di

import android.content.Context
import androidx.room.Room
import com.alex_ia.myapplication.framework.db.FoodDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideFoodDb(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, FoodDb::class.java, "Category").build()
}