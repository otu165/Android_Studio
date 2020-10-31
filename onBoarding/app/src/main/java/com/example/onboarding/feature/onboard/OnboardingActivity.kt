package com.example.onboarding.feature.onboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.onboarding.R
import com.example.onboarding.data.onboard.Onboard
import com.example.onboarding.feature.MainActivity
import kotlinx.android.synthetic.main.activity_onboarding.*
import kotlinx.android.synthetic.main.fragment_onboard.*

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        onboardFunction()
    }

    private fun onboardFunction() {
        // ViewPager
        val vpAdapter = OnboardVpAdapter(supportFragmentManager)
        setVpAdapterData(vpAdapter)
        vpOnboard.adapter = vpAdapter
    }

    private fun setVpAdapterData(adapter : OnboardVpAdapter) {
        adapter.addFragment(OnboardFragment())

        val frag2 = OnboardFragment()
        frag2.txt = "Onboard\nSecond"

        adapter.addFragment(frag2)
        adapter.addFragment(Onboard2Fragment())
    }
}