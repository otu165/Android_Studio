package com.example.onboarding.feature

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.onboarding.R
import com.example.onboarding.data.onboard.Onboard
import com.example.onboarding.feature.onboard.OnboardingActivity

// 참고 : https://developer.android.com/training/tv/playback/onboarding?hl=ko#kotlin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 어플의 첫 실행이라면 onboarding 페이지 띄워주기
        if(isItFirstLaunch()) {
            val intent = Intent(this@MainActivity, OnboardingActivity::class.java)
            startActivity(intent)
            this.finish()
        }

        mainFunction()
    }

    private fun mainFunction() {
        Log.d("MainActivity", "getBooleanExtra : ${intent.getBooleanExtra("FromOnBoarding", false)}")
        if(intent.getBooleanExtra("FromOnBoarding", false)) {
            Toast.makeText(this, "온보딩은 잘 보셨나요?", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isItFirstLaunch() : Boolean {
        return Onboard.getInstance(applicationContext).isItFirstLaunch()
    }
}