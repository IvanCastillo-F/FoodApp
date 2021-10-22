package com.alex_ia.myapplication.core.presentation

import com.alex_ia.myapplication.core.exception.Failure

interface OnFailure {

    fun handleFailure(failure: Failure?)

}