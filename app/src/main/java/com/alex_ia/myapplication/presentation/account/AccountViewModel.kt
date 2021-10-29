package com.alex_ia.myapplication.presentation.account

import com.alex_ia.myapplication.core.exception.Failure
import com.alex_ia.myapplication.core.interactor.UseCase
import com.alex_ia.myapplication.core.presentation.BaseViewModel
import com.alex_ia.myapplication.domain.usercase.GetUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject


@DelicateCoroutinesApi
@HiltViewModel
class AccountViewModel  @Inject constructor(private val getUser: GetUser) :
    BaseViewModel() {

      fun getUser() {
         getUser(UseCase.None()) {
            it.fold(::userNotFound) {
                state.value = AccountViewState.LoggedUser(it)

                true
            }
         }
      }

      private fun userNotFound(failure: Failure) {
        state.value = AccountViewState.UserNotFound
        handleFailure(failure)
      }
    }