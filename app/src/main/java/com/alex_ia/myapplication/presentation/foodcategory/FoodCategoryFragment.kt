package com.alex_ia.myapplication.presentation.foodcategory

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.alex_ia.myapplication.R
import com.alex_ia.myapplication.core.extension.failure
import com.alex_ia.myapplication.core.extension.observe
import com.alex_ia.myapplication.core.presentation.BaseFragment
import com.alex_ia.myapplication.core.presentation.BaseViewState
import com.alex_ia.myapplication.databinding.FoodCategoryFragmentBinding
import com.alex_ia.myapplication.domain.model.Category
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class FoodCategoryFragment : BaseFragment(R.layout.food_category_fragment) {

    private lateinit var binding: FoodCategoryFragmentBinding
    private  val adapter: CategoryAdapter by lazy { CategoryAdapter() }
    private val categoryViewModel by viewModels<FoodCategoryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
            doGetAllCategories("")
        }
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {
            is CategoryViewState.CategoryReceived -> setUpAdapter(state.category)
        }
    }

    override fun setBinding(view: View) {
        binding = FoodCategoryFragmentBinding.bind(view)

        binding.rcCategoryFood.layoutManager = GridLayoutManager(requireContext() ,2)

        binding.lifecycleOwner = this
    }

    private fun setUpAdapter(category : List<Category>) {

        adapter.addData(category)



        binding.rcCategoryFood.apply {
            adapter = this@FoodCategoryFragment.adapter
        }
    }

}