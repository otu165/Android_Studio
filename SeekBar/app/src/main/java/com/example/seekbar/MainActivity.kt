package com.example.seekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainFunction()
    }

    private fun mainFunction() {

        // basic seek bar setting
        sbMain.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    p0: SeekBar?,
                    progress: Int,
                    p2: Boolean
                ) { // 조작 도중 호출
                    txtMain.text = progress.toString()
                }

                override fun onStartTrackingTouch(p0: SeekBar?) { // 조작 시작시 호출
                }

                override fun onStopTrackingTouch(p0: SeekBar?) { // 조작 끝날때 호출
                }
            }
        )
    }
}