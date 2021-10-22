package com.alex_ia.myapplication.domain.repository

import com.alex_ia.myapplication.core.exception.Failure
import com.alex_ia.myapplication.core.functional.Either
import com.alex_ia.myapplication.data.dto.FoodResponse

interface FoodRepository {

    fun getFoodByName(name: String): Either<Failure, FoodResponse>

}