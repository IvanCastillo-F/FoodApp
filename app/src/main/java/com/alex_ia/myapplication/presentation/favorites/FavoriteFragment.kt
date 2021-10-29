package com.alex_ia.myapplication.presentation.favorites

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alex_ia.myapplication.R
import com.alex_ia.myapplication.core.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
@AndroidEntryPoint
@WithFragmentBindings
class FavoriteFragment : BaseFragment(R.layout.favorite_fragment) {

    override fun setBinding(view: View) {

    }

}