package com.alex_ia.myapplication.presentation.account

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.alex_ia.myapplication.R
import com.alex_ia.myapplication.core.extension.failure
import com.alex_ia.myapplication.core.extension.loadFromURLCircular
import com.alex_ia.myapplication.core.extension.observe
import com.alex_ia.myapplication.core.presentation.BaseFragment
import com.alex_ia.myapplication.core.presentation.BaseViewState
import com.alex_ia.myapplication.databinding.AccountFragmentBinding
import com.alex_ia.myapplication.domain.model.User
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
@AndroidEntryPoint
@WithFragmentBindings
class AccountFragment : BaseFragment(R.layout.account_fragment) {

    private val accountViewModel by viewModels<AccountViewModel>()
    private lateinit var binding : AccountFragmentBinding

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
                if(loggedUser.idUser < 0){
                    navController.navigate(AccountFragmentDirections.actionAccountFragment2ToLoginFragment())
                }
            }
            is AccountViewState.UserNotFound -> {
                navController.navigate(AccountFragmentDirections.actionAccountFragment2ToLoginFragment())
            }
        }
    }

    override fun setBinding(view: View) {
        binding = AccountFragmentBinding.bind(view)

        binding.ivAccount.loadFromURLCircular(loggedUser.img)

        binding.txvName.setText("User Name: " + loggedUser.nameUser)

        binding.txvMail.setText("Mail Address: " + loggedUser.mail)

        binding.btnLogout.setOnClickListener{
            loggedUser = User(-1,"","","","")
            navController.navigate(AccountFragmentDirections.actionAccountFragment2ToLoginFragment())
        }

        binding.lifecycleOwner = this
    }


}