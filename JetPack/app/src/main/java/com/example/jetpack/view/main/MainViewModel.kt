package com.example.jetpack.view.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.jetpack.data.room.UserDatabase
import com.example.jetpack.models.user.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val db = Room.databaseBuilder(
        application,
        UserDatabase::class.java,
        "user-db"
    ).build()

    lateinit var rvLiveData: MutableLiveData<List<User>>

    init {
        rvLiveData = getAll()
    }

    fun getAll() = db.userDao().getAll()

    fun insert(text: String) {
        viewModelScope.launch(Dispatchers.IO) {
            db.userDao().insert(User(text))
        }
    }
}