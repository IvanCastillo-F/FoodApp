package com.alex_ia.myapplication.data.dao

import androidx.room.*
import com.alex_ia.myapplication.domain.model.Category

@Dao
interface FoodDao {

    @Query("SELECT * FROM Category")
    fun getAllCategories(): List<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCategories(category: List<Category>): List<Long>

}