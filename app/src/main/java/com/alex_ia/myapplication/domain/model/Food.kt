package com.alex_ia.myapplication.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
@JsonClass(generateAdapter = true)
class Food (
    @PrimaryKey(autoGenerate = false)
    @Json(name = "idMeal") val idFood: Int = 0,
    @Json(name = "strMeal") val name: String = "",
    @Json(name = "strCategory") val category: String? = "",
    @Json(name = "strMealThumb") val urlThumb: String = "",
    @Json(name = "strImageSource") val url: String? = "",
    @Json(name = "strArea") val area: String? = "",
    @Json(name = "strInstructions") val instructions: String? = ""
) : Parcelable {

    val urlDetail: String
        get() = url ?: urlThumb

}