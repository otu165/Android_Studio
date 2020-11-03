package com.example.progressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainFunction()
    }

    private fun mainFunction() {
        // spinner progress bar
        btnMain.setOnClickListener {
            pbMain.visibility = View.INVISIBLE
            imgMain.setImageResource(R.drawable.ic_android_black_24dp)

            btnMain.text = "짠"
        }

        // horizontal progress bar
        btnMain2.setOnClickListener {
            btnMain2.isEnabled = false
            btnMain2.text = "작업중"

            val job = CoroutineScope(Dispatchers.Default).launch {
                var value: Int = 0
                while (progressBar2.progress < 100) {
                    try {
                        value += 10
                        delay(1000)


                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                    progressBar2.progress = value
                }

                try {
                    btnMain2.text = "작업완료" // ERROR
                } catch (e : Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}