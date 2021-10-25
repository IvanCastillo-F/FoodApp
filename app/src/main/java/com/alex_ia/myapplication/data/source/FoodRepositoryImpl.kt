package com.alex_ia.myapplication.data.source

import com.alex_ia.myapplication.core.exception.Failure
import com.alex_ia.myapplication.core.functional.Either
import com.alex_ia.myapplication.core.plataform.NetworkHandler
import com.alex_ia.myapplication.data.api.FoodApi
import com.alex_ia.myapplication.data.dao.FoodDao
import com.alex_ia.myapplication.data.dto.CategoryResponse
import com.alex_ia.myapplication.data.dto.FoodResponse
import com.alex_ia.myapplication.domain.model.Category
import com.alex_ia.myapplication.domain.repository.FoodRepository
import com.alex_ia.myapplication.framework.api.ApiRequest
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val foodApi: FoodApi,
    private val foodDao: FoodDao,
    private val networkHandler: NetworkHandler
)  : FoodRepository, ApiRequest {


    override fun getFoodByName(name: String): Either<Failure, FoodResponse> {
        val result = makeRequest(networkHandler, foodApi.getFoodByName(name), { it }, FoodResponse(emptyList()))

        return result/*if (result.isLeft) {

            val localResult = foodDao.getfoodByName("%$name%")

            if (localResult.isEmpty()) result
            else Either.Right(FoodResponse(localResult))

        } else*/ // result

    }

    override fun getAllCategories(): Either<Failure, CategoryResponse> {
        val result = makeRequest(networkHandler, foodApi.getAllCategories(), { it }, CategoryResponse(emptyList()))

        return if (result.isLeft) {

            val localResult = foodDao.getAllCategories()

            if (localResult.isEmpty()) result
            else Either.Right(CategoryResponse(localResult))

        } else result
    }

    override fun saveCategories(meals: List<Category>): Either<Failure, Boolean> {
        val result = foodDao.saveCategories(meals)
        return if (result.size == meals.size) Either.Right(true)
        else Either.Left(Failure.DatabaseError)
    }

    override fun getFoodByCategory(name: String): Either<Failure, FoodResponse> {
        val result = makeRequest(networkHandler, foodApi.getFoodByCategory(name), { it }, FoodResponse(emptyList()))

        return result
    }

    override fun getFoodByID(id: String): Either<Failure, FoodResponse> {
        val result = makeRequest(networkHandler, foodApi.getFoodByID(id), { it }, FoodResponse(emptyList()))

        return result
    }

    override fun getRandomFood(): Either<Failure, FoodResponse> {
        val result = makeRequest(networkHandler, foodApi.getRandomFood(), { it }, FoodResponse(emptyList()))
        return result
    }
}
