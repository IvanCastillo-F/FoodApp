package com.alex_ia.myapplication.presentation.account

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.alex_ia.myapplication.R
import com.alex_ia.myapplication.core.extension.failure
import com.alex_ia.myapplication.core.extension.observe
import com.alex_ia.myapplication.core.presentation.BaseFragment
import com.alex_ia.myapplication.core.presentation.BaseViewState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
@AndroidEntryPoint
@WithFragmentBindings
class AccountFragment : BaseFragment(R.layout.account_fragment) {

    private val accountViewModel by viewModels<AccountViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        accountViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
            getUser()
        }

    }


    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {
            is AccountViewState.LoggedUser -> {
            }
            is AccountViewState.UserNotFound -> {
                navController.navigate(AccountFragmentDirections.actionAccountFragment2ToLoginFragment())
            }
        }
    }

    override fun setBinding(view: View) {

    }


}