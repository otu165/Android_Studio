package com.example.jetpack.data.room

import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.jetpack.models.user.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll() : MutableLiveData<List<User>>

    @Update
    suspend fun update(user: User)

    @Insert
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)
}