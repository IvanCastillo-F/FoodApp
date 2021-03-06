package com.alex_ia.myapplication.data.dao

import androidx.room.*
import com.alex_ia.myapplication.domain.model.Category
import com.alex_ia.myapplication.domain.model.Food

@Dao
interface FoodDao {

    @Query("SELECT * FROM Category")
    fun getAllCategories(): List<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCategories(category: List<Category>) : List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveFood(food: List<Food>) : List<Long>

    @Query("SELECT * FROM Food WHERE name LIKE :food")
    fun getFoodByName(food : String) : List<Food>

    @Query("SELECT * FROM Food WHERE category LIKE :food")
    fun getFoodByCategory(food : String) : List<Food>

    @Query("SELECT * FROM Food WHERE idFood = :food")
    fun getFoodByID(food : String): List<Food>

    @Query("SELECT * FROM Food ORDER BY RANDOM() LIMIT 1")
    fun getRandomFood(): List<Food>

}