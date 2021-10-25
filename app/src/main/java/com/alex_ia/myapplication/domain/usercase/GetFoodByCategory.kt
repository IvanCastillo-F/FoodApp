package com.alex_ia.myapplication.domain.usercase

import com.alex_ia.myapplication.core.interactor.UseCase
import com.alex_ia.myapplication.data.dto.FoodResponse
import com.alex_ia.myapplication.domain.repository.FoodRepository
import javax.inject.Inject

class GetFoodByCategory@Inject constructor(private val foodRepository: FoodRepository) :
    UseCase<FoodResponse, String>() {

    override suspend fun run(params: String) = foodRepository.getFoodByCategory(params)

}