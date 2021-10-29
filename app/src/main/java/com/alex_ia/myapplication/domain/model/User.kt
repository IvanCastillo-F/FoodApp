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
    companion object {
        val users = listOf(
            User(1, "alex", "a@gmail.com", "https://ps.w.org/simple-user-avatar/assets/icon-256x256.png?rev=2413146", "123"),
            User(2, "user", "user@hotmail.com", "https://cdn2.iconfinder.com/data/icons/ecommerce-set-1-1/128/user_users_avatar_user_useri_icon-512.png", "123"),
            User(3, "user2", "user2@gmail.com", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBGfoR24g82fsdyUuCCIb672C6sh1hQStEKw&usqp=CAU", "123"),
            User(4, "user3", "user3@yahoo.com", "https://i.imgur.com/JFHjdNr.jpg", "123"),
        )
    }

    fun validateLogin() = users.firstOrNull { it.nameUser == nameUser && it.token == token }

    fun getImage() :String = (users.firstOrNull { it.nameUser == nameUser }?.img ?: 0).toString()
}