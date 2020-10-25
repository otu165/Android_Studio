package com.example.listview.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.listview.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "$TAG created")
        mainFunction()
    }

    private fun mainFunction() {
        // 1. ListView
        val lvAdapter = MainLvAdapter(this)
        lvMain.adapter = lvAdapter
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}