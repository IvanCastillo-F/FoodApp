package com.alex_ia.myapplication.data.dao

import androidx.room.*
import com.alex_ia.myapplication.domain.model.Category
import com.alex_ia.myapplication.domain.model.Food

@Dao
interface FoodDao {

    @Query("SELECT * FROM Category")
    fun getAllCategories(): List<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCategories(category: List<Category>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveFood(food: List<Food>): List<Long>

}