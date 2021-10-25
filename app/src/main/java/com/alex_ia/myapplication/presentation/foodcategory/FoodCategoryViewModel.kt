package com.alex_ia.myapplication.presentation.foodcategory

import com.alex_ia.myapplication.core.presentation.BaseViewModel
import com.alex_ia.myapplication.domain.model.Category
import com.alex_ia.myapplication.domain.usercase.GetAllCategories
import com.alex_ia.myapplication.domain.usercase.SaveCategories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import java.util.*
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class FoodCategoryViewModel @Inject constructor(
    private val getAllCategories : GetAllCategories,
    private val saveCategories : SaveCategories
): BaseViewModel() {

    fun doGetAllCategories(name: String){
        getAllCategories(name) {
            it.fold(::handleFailure) {
                state.value = CategoryViewState.CategoryReceived(it.categories ?: listOf())

                saveCategories(it.categories ?: listOf())

                true
        }
      }
    }

    private fun saveCategories(meals: List<Category>) {
        saveCategories(meals) {
            it.fold(::handleFailure) {
                it
            }
        }
    }

}