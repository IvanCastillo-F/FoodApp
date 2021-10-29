package com.alex_ia.myapplication.presentation.food

import com.alex_ia.myapplication.core.presentation.BaseViewModel
import com.alex_ia.myapplication.domain.model.Category
import com.alex_ia.myapplication.domain.model.Food
import com.alex_ia.myapplication.domain.usercase.GetFoodByName
import com.alex_ia.myapplication.domain.usercase.GetFoodByCategory
import com.alex_ia.myapplication.domain.usercase.GetRandomFood
import com.alex_ia.myapplication.domain.usercase.SaveFood
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class FoodViewModel @Inject constructor(
    private val getFoodByName: GetFoodByName,
    private val getFoodByCategory : GetFoodByCategory,
    private val saveFood: SaveFood
): BaseViewModel() {


    fun doGetFoodByName(name: String) {
        getFoodByName(name) {
            it.fold(::handleFailure) {
                state.value = FoodViewState.FoodReceived(it.meals ?: listOf())

                saveFood(it.meals ?: listOf())

                true
            }
        }
    }

    fun doGetFoodByCategory(name: String) {
        getFoodByCategory(name) {
            it.fold(::handleFailure) {
                state.value = FoodViewState.FoodReceived(it.meals ?: listOf())

                saveFood(it.meals ?: listOf())

                true
            }
        }
    }

    private fun saveFood(meals: List<Food>) {
        saveFood(meals) {
            it.fold(::handleFailure) {
                it
            }
        }
    }

}