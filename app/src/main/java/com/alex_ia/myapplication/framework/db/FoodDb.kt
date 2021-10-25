package com.alex_ia.myapplication.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alex_ia.myapplication.data.dao.FoodDao
import com.alex_ia.myapplication.domain.model.Category
import com.alex_ia.myapplication.domain.model.Food


@Database(entities = [Category::class, Food::class], version = 2)
abstract class FoodDb  : RoomDatabase() {

    abstract fun foodDao(): FoodDao

}