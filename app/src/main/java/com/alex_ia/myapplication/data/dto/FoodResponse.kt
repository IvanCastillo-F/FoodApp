package com.alex_ia.myapplication.data.dto

import com.alex_ia.myapplication.domain.model.Food
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FoodResponse(val meals: List<Food>? = listOf())
