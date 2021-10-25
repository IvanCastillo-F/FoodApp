package com.alex_ia.myapplication.presentation.fooddetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.alex_ia.myapplication.R
import com.alex_ia.myapplication.core.extension.failure
import com.alex_ia.myapplication.core.extension.observe
import com.alex_ia.myapplication.core.presentation.BaseFragment
import com.alex_ia.myapplication.core.presentation.BaseViewState
import com.alex_ia.myapplication.databinding.FoodDetailFragmentBinding
import com.alex_ia.myapplication.domain.model.Food
import com.alex_ia.myapplication.presentation.food.FoodFragmentDirections
import com.alex_ia.myapplication.presentation.food.FoodViewState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi


@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class FoodDetailFragment : BaseFragment(R.layout.food_detail_fragment) {

    private lateinit var binding: FoodDetailFragmentBinding
    private val args : FoodDetailFragmentArgs by navArgs()
    private val foodDetailViewModel by viewModels<FoodDetailViewModel>()
    private val adapter: FoodDetailAdapter by lazy { FoodDetailAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        foodDetailViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
            doGetFoodByID(args.food.idFood.toString())
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

        adapter.listener = {
           it
        }

        binding.rcDetailFood.apply {
            adapter = this@FoodDetailFragment.adapter
        }
    }

    override fun setBinding(view: View) {
        binding = FoodDetailFragmentBinding.bind(view)

        binding.lifecycleOwner = this

        binding.fabRandom.setOnClickListener(){

            foodDetailViewModel.doGetRandomFood("")

        }

    }

}