package com.alex_ia.myapplication.core.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alex_ia.myapplication.core.exception.Failure
import com.alex_ia.myapplication.core.plataform.AuthManager
import com.alex_ia.myapplication.domain.model.User

abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId), OnFailure {

    val navController by lazy { findNavController() }
    val baseActivity by lazy { requireActivity() as BaseActivity }
    private lateinit var authManager: AuthManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authManager = AuthManager(requireContext())
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        baseActivity.setUpNavigation(navController)

        setBinding(view)
    }

    var loggedUser: User
        set(value) {
            authManager.user = value
        }
        get() = authManager.user!!

    abstract fun setBinding(view: View)

    open fun onViewStateChanged(state: BaseViewState?) {
        when(state) {
            BaseViewState.ShowLoading -> showLoader(true)
            BaseViewState.HideLoading -> showLoader(false)
        }
    }

    open fun showLoader(show: Boolean) = baseActivity.showProgress(show)

    fun showMessage(message: String) = Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()

    override fun handleFailure(failure: Failure?) {
        when(failure) {
            is Failure.DatabaseError -> {

            }
            is Failure.FeatureFailure -> {

            }
            is Failure.NetworkConnection -> {

            }
            is Failure.ServerError -> {
                showMessage(failure.serverMessage ?: "")
            }
            is Failure.Unauthorized -> {

            }
            null -> {

            }
        }
    }

}