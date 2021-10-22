package com.alex_ia.myapplication.presentation.food

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.alex_ia.myapplication.R
import com.alex_ia.myapplication.core.extension.failure
import com.alex_ia.myapplication.core.extension.observe
import com.alex_ia.myapplication.core.presentation.BaseFragment
import com.alex_ia.myapplication.core.presentation.BaseViewState
import com.alex_ia.myapplication.databinding.FoodFragmentBinding
import com.alex_ia.myapplication.domain.model.Food
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class FoodFragment : BaseFragment(R.layout.food_fragment) {

    private lateinit var binding: FoodFragmentBinding

    private val adapter: FoodAdapter by lazy { FoodAdapter() }
    private val cocktailViewModel by viewModels<FoodViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cocktailViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)

            //doGetFoodByName("a")
        }
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {
            is FoodViewState.FoodReceived -> setUpAdapter(state.meals)
        }

    }

    private fun setUpAdapter(food : List<Food>) {
        adapter.addList(food)

        binding.rcFood.apply {
            adapter = this@FoodFragment.adapter
        }
    }

    override fun setBinding(view: View) {
        binding = FoodFragmentBinding.bind(view)

        binding.lifecycleOwner = this


    }

}