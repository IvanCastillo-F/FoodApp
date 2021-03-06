package com.alex_ia.myapplication.data.api

import com.alex_ia.myapplication.data.dto.CategoryResponse
import com.alex_ia.myapplication.data.dto.FoodResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApi {

    @GET("json/v1/1/search.php")
    fun getFoodByName(@Query("s") name: String): Call<FoodResponse>

    @GET("json/v1/1/categories.php")
    fun getAllCategories(): Call<CategoryResponse>

    @GET("json/v1/1/filter.php")
    fun getFoodByCategory(@Query("c") name: String): Call<FoodResponse>

    @GET("json/v1/1/lookup.php")
    fun getFoodByID(@Query("i") id: String): Call<FoodResponse>

    @GET("json/v1/1/random.php")
    fun getRandomFood(): Call<FoodResponse>

}