package com.alex_ia.myapplication.presentation.food

import com.alex_ia.myapplication.core.presentation.BaseViewState
import com.alex_ia.myapplication.domain.model.Food

sealed class FoodViewState : BaseViewState() {

    data class FoodReceived(val meals: List<Food>): BaseViewState()
}