package com.alex_ia.myapplication.core.di

import com.alex_ia.myapplication.core.plataform.NetworkHandler
import com.alex_ia.myapplication.data.api.FoodApi
import com.alex_ia.myapplication.data.source.FoodRepositoryImpl
import com.alex_ia.myapplication.domain.repository.FoodRepository
import com.alex_ia.myapplication.framework.api.ApiProvider
import com.alex_ia.myapplication.framework.db.FoodDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideFoodRepository(
        apiProvider: ApiProvider,
        foodDb: FoodDb,
        networkHandler: NetworkHandler
    ): FoodRepository =
        FoodRepositoryImpl(apiProvider.getEndpoint(FoodApi::class.java), networkHandler = networkHandler, foodDao = foodDb.foodDao())

}