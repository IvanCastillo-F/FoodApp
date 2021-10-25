package com.alex_ia.myapplication.domain.usercase

import com.alex_ia.myapplication.core.interactor.UseCase
import com.alex_ia.myapplication.domain.model.Food
import com.alex_ia.myapplication.domain.repository.FoodRepository
import javax.inject.Inject

class SaveFood @Inject constructor(private val foodRepository: FoodRepository) :
    UseCase<Boolean, List<Food>>() {

    override suspend fun run(params: List<Food>) = foodRepository.saveFood(params)

}