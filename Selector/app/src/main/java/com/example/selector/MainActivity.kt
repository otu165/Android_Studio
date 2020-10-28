package com.example.selector

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainFunction()
    }

    private fun mainFunction() {
        // CheckedTextView click event
        ctvOnlyImg.setOnClickListener {
            ctvOnlyImg.toggle()
        }

        ctvTextImg.setOnClickListener {
            ctvTextImg.toggle()
        }

        ctvBtn.setOnClickListener {
            ctvBtn.toggle()

            if(ctvBtn.isChecked)
                ctvBtn.setTextColor(resources.getColor(R.color.yellow))
            else
                ctvBtn.setTextColor(resources.getColor(R.color.gray))
        }
    }
}