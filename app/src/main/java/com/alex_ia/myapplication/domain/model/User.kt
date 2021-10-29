package com.alex_ia.myapplication.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
@JsonClass(generateAdapter = true)
class User(
    @PrimaryKey(autoGenerate = true)
    val idUser: Int = 0,
    val nameUser: String = "",
    val mail: String = "",
    val img: String = "",
    val token: String? = ""
): Parcelable {
}