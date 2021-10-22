package com.alex_ia.myapplication.data.source

import com.alex_ia.myapplication.core.exception.Failure
import com.alex_ia.myapplication.core.functional.Either
import com.alex_ia.myapplication.core.plataform.NetworkHandler
import com.alex_ia.myapplication.data.api.FoodApi
import com.alex_ia.myapplication.data.dto.FoodResponse
import com.alex_ia.myapplication.domain.repository.FoodRepository
import com.alex_ia.myapplication.framework.api.ApiRequest
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val foodApi: FoodApi,
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
}
