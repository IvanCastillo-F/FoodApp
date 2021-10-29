package com.alex_ia.myapplication.presentation.account

import com.alex_ia.myapplication.core.presentation.BaseViewState
import com.alex_ia.myapplication.domain.model.User

abstract class AccountViewState : BaseViewState() {

    data class LoggedUser(val user: User) : BaseViewState()

    object UserNotFound : BaseViewState()
}