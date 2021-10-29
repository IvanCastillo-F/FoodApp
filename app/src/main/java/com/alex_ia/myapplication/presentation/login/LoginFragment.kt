package com.alex_ia.myapplication.presentation.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import com.alex_ia.myapplication.R
import com.alex_ia.myapplication.core.extension.failure
import com.alex_ia.myapplication.core.extension.loadFromURLCircular
import com.alex_ia.myapplication.core.extension.observe
import com.alex_ia.myapplication.core.presentation.BaseFragment
import com.alex_ia.myapplication.databinding.FoodCategoryFragmentBinding
import com.alex_ia.myapplication.databinding.LoginFragmentBinding
import com.alex_ia.myapplication.domain.model.User
import com.alex_ia.myapplication.presentation.foodcategory.FoodCategoryViewModel

class LoginFragment : BaseFragment(R.layout.login_fragment) {

    private lateinit var binding : LoginFragmentBinding
    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }
    }

    override fun setBinding(view: View) {
        binding = LoginFragmentBinding.bind(view)

        binding.btnLogin.setOnClickListener {
            User(
                nameUser = binding.edtUsername.text.toString(),
                token = binding.edtPassword.text.toString()
            ).validateLogin()?.let {
                loggedUser = it
                navController.navigate(LoginFragmentDirections.actionLoginFragmentToAccountFragment2())
            } ?: showMessege("USER NOT FOUND")
        }

        binding.edtUsername.doAfterTextChanged {
            binding.ivUser.loadFromURLCircular(User(nameUser = (it ?: "").toString()).getImage())
        }

        binding.lifecycleOwner = this
    }

    fun showMessege(message: String) =
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}