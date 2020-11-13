package com.example.jetpack.models.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    var string: String
) {
    @PrimaryKey(autoGenerate = true) var key: Int = 0

}