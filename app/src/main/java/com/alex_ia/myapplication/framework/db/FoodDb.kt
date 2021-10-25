package com.alex_ia.myapplication.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alex_ia.myapplication.data.dao.FoodDao
import com.alex_ia.myapplication.domain.model.Category



@Database(entities = [Category::class], version = 1)
abstract class FoodDb  : RoomDatabase() {

    abstract fun foodDao(): FoodDao

}