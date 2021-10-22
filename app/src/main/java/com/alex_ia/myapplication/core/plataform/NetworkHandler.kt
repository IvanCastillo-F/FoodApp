package com.alex_ia.myapplication.core.plataform

import android.content.Context
import com.alex_ia.myapplication.core.extension.networkInfo
import javax.inject.Inject

class NetworkHandler @Inject constructor(private val context: Context) {

    val isConnected get() = context.networkInfo?.isConnectedOrConnecting == true

}