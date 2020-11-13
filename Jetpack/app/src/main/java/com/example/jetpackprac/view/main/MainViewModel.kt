package com.example.jetpackprac.view.main

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.jetpackprac.data.TextDatabase
import com.example.jetpackprac.model.Text
import com.example.jetpackprac.util.MainRvAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * MainActivity 에서 feature 를 분리하기 위해 존재하는 ViewModel
 */

class MainViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application,
        TextDatabase::class.java,
        "text-db"
    ).build()

    var textList: LiveData<List<Text>>
    var userInput: String? = null // 사용자가 아무 입력을 하지 않았을 때 NPE 생길 것 같았는데, "" 입력이라고 생각하고 입력됨

    init { // 초기화
        textList = getAll()
    }

    // db 의 직접 제어를 막기 위해서 ViewModel 에서 getAll() 메서드를 재정의함 (오버라이딩 X)
    private fun getAll() = db.textDao().getAll()

    fun insert(string: String) {
        viewModelScope.launch(Dispatchers.IO) {
            db.textDao().insert(Text(string)) // suspend 메서드 비동기적으로 처리
        }
    }

    fun delete(text: Text) {
        viewModelScope.launch(Dispatchers.IO) {
            db.textDao().delete(text) // suspend 메서드 비동기적으로 처리
        }
    }
}