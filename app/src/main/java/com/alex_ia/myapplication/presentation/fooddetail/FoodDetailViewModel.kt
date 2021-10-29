package com.alex_ia.myapplication.presentation.fooddetail

import androidx.lifecycle.ViewModel
import com.alex_ia.myapplication.core.presentation.BaseViewModel
import com.alex_ia.myapplication.domain.model.Food
import com.alex_ia.myapplication.domain.usercase.GetFoodByID
import com.alex_ia.myapplication.domain.usercase.GetRandomFood
import com.alex_ia.myapplication.domain.usercase.SaveFood
import com.alex_ia.myapplication.presentation.food.FoodViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject


@DelicateCoroutinesApi
@HiltViewModel
class FoodDetailViewModel @Inject constructor(
    private val getFoodByID: GetFoodByID,
    private val getRandomFood : GetRandomFood,
    private val saveFood: SaveFood
): BaseViewModel() {

    fun doGetFoodByID(id: String) {
        getFoodByID(id) {
            it.fold(::handleFailure) {
                state.value = FoodViewState.FoodReceived(it.meals ?: listOf())

                saveFood(it.meals ?: listOf())

                true
            }
        }
    }

    fun doGetRandomFood(name: String) {
        getRandomFood(name) {
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