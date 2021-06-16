package com.example.mvvm

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * <ViewModel>
 */

class MainViewModel : ViewModel() {

    val mutableLiveData = MutableLiveData<String>()

    // ViewModel <--> Model
    private fun getAppFromDB() = MainModel(
        "Master Coding App",
        999990,
        4.7F
    )

    // View <--> ViewModel
    fun getAppName() {
        val appName = getAppFromDB().appName
        mutableLiveData.value = appName
    }
}