package com.alex_ia.myapplication.presentation.fooddetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alex_ia.myapplication.R
import com.alex_ia.myapplication.core.presentation.BaseFragment
import com.alex_ia.myapplication.databinding.FoodDetailFragmentBinding

class FoodDetailFragment : BaseFragment(R.layout.food_detail_fragment) {

    private lateinit var binding: FoodDetailFragmentBinding

    override fun setBinding(view: View) {

        binding = FoodDetailFragmentBinding.bind(view)

        binding.apply {
            lifecycleOwner = this@FoodDetailFragment

        }
    }

}