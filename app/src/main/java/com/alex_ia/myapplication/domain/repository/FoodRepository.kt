package com.alex_ia.myapplication.domain.repository

import com.alex_ia.myapplication.core.exception.Failure
import com.alex_ia.myapplication.core.functional.Either
import com.alex_ia.myapplication.data.dto.CategoryResponse
import com.alex_ia.myapplication.data.dto.FoodResponse
import com.alex_ia.myapplication.domain.model.Category
import java.util.*

interface FoodRepository {

    fun getFoodByName(name: String): Either<Failure, FoodResponse>

    fun getAllCategories():Either<Failure, CategoryResponse>

    fun saveCategories(meals: List<Category>): Either<Failure, Boolean>

    fun getFoodByCategory(name: String): Either<Failure, FoodResponse>

    fun getFoodByID(id: String): Either<Failure, FoodResponse>

}