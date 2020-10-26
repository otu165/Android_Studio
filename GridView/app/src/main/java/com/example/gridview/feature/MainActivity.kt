package com.example.gridview.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gridview.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainFunction()
    }

    private fun mainFunction() {
        // 1. GridView
        val gvAdapter = MainGvAdapter(this)
        gvMain.adapter = gvAdapter
    }
}