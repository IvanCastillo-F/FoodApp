package com.alex_ia.myapplication.core.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
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

    private val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("CREATE TABLE IF NOT EXISTS Food(idFood INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT NOT NULL, category TEXT NOT NULL, urlThumb TEXT NOT NULL, url TEXT NOT NULL, area TEXT NOT NULL, instructions TEXT NOT NULL)")
        }
    }

    private val MIGRATION_2_3 = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("CREATE TABLE IF NOT EXISTS User(idUser INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nameUser TEXT NOT NULL, mail TEXT NOT NULL, img TEXT NOT NULL, token TEXT )")
        }
    }

    @Provides
    @Singleton
    fun provideFoodDb(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, FoodDb::class.java, "Category").addMigrations(
            MIGRATION_1_2,
            MIGRATION_2_3
        ).build()
}