package com.example.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

/**
 * <MVC Pattern>
 * Model : MainModel
 * View : TextView
 * Controller : MainActivity
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getAppFromModel() = MainModel(
        "Master Coding App",
        999990,
        4.7F
    )

    fun displayAppInText(view: View) {
        findViewById<TextView>(R.id.txt_main).text = getAppFromModel().toString()
    }
}