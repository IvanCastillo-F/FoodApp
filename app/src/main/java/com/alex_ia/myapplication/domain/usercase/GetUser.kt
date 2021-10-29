package com.alex_ia.myapplication.domain.usercase

import com.alex_ia.myapplication.core.exception.Failure
import com.alex_ia.myapplication.core.functional.Either
import com.alex_ia.myapplication.core.interactor.UseCase
import com.alex_ia.myapplication.core.plataform.AuthManager
import com.alex_ia.myapplication.domain.model.User
import javax.inject.Inject



class GetUser @Inject constructor(private val authManager: AuthManager) :
    UseCase<User, UseCase.None>() {

    override suspend fun run(params: None): Either<Failure, User> {
        val result = authManager.user

        return result?.let {
            Either.Right(it)
        } ?: Either.Left(Failure.Unauthorized)
    }

}