package com.alex_ia.myapplication.data.dto

import com.alex_ia.myapplication.domain.model.Category
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CategoryResponse (val category: List<Category>? = listOf())