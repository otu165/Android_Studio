package com.example.jetpackprac.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.jetpackprac.model.Text

@Dao
interface TextDao {
    @Query("SELECT * FROM Text")
    fun getAll() : LiveData<List<Text>> // 데이터 변경을 감시하기 위해서 LiveData 를 사용함

    @Update
    suspend fun update(text: Text)

    @Insert
    suspend fun insert(text: Text)

    @Delete
    suspend fun delete(text: Text)

    @Query("DELETE FROM Text")
    suspend fun delete()
}