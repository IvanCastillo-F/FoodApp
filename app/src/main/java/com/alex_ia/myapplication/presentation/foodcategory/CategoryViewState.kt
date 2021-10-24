package com.alex_ia.myapplication.presentation.foodcategory

import com.alex_ia.myapplication.core.presentation.BaseViewState
import com.alex_ia.myapplication.domain.model.Category
import com.alex_ia.myapplication.domain.model.Food

sealed class CategoryViewState : BaseViewState() {

    data class CategoryReceived(val category: List<Category>): BaseViewState()
}