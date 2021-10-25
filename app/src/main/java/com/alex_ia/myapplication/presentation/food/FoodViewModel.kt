package com.alex_ia.myapplication.presentation.food

import com.alex_ia.myapplication.core.presentation.BaseViewModel
import com.alex_ia.myapplication.domain.usercase.GetFoodByName
import com.alex_ia.myapplication.domain.usercase.GetFoodByCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class FoodViewModel @Inject constructor(
    private val getFoodByName: GetFoodByName,
    private val getFoodByCategory : GetFoodByCategory
): BaseViewModel() {


    fun doGetFoodByName(name: String) {
        getFoodByName(name) {
            it.fold(::handleFailure) {
                state.value = FoodViewState.FoodReceived(it.meals ?: listOf())

                //saveFood(it.meals ?: listOf())

                true
            }
        }
    }

    fun doGetFoodByCategory(name: String) {
        getFoodByCategory(name) {
            it.fold(::handleFailure) {
                state.value = FoodViewState.FoodReceived(it.meals ?: listOf())

                //saveFood(it.meals ?: listOf())

                true
            }
        }
    }

}