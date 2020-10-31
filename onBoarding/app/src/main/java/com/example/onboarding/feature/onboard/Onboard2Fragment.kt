package com.example.onboarding.feature.onboard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onboarding.R
import com.example.onboarding.data.onboard.Onboard
import com.example.onboarding.feature.MainActivity
import kotlinx.android.synthetic.main.fragment_onboard2.view.*

class Onboard2Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_onboard2, container, false)

        onboardFunction(view)
        return view
    }

    private fun onboardFunction(view: View) {
        view.btnStart.setOnClickListener {
            // SharedPreference 값 조정
            Onboard.getInstance(view.context.applicationContext).setFirstLaunchToFalse()

            val intent = Intent(view.context, MainActivity::class.java).putExtra("FromOnBoarding", true)
            startActivity(intent)

            activity?.finish()
        }
    }

}