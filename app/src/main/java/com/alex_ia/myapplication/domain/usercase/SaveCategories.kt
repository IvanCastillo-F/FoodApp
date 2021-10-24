package com.alex_ia.myapplication.domain.usercase

import com.alex_ia.myapplication.core.interactor.UseCase
import com.alex_ia.myapplication.domain.model.Category
import com.alex_ia.myapplication.domain.repository.FoodRepository
import javax.inject.Inject

class SaveCategories @Inject constructor(private val foodRepository: FoodRepository) :
    UseCase<Boolean, List<Category>>() {

    override suspend fun run(params: List<Category>) = foodRepository.saveCategories(params)

}